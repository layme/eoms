package com.gwssi.eoms.service.common.sortNumVersion.impl;

import com.gwssi.eoms.dao.produce.common.FlIPCFlhbDao;
import com.gwssi.eoms.dao.produce.common.GgZlxFlhDao;
import com.gwssi.eoms.model.dto.SortInfoDTO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.service.common.sortNumVersion.SortNumVersionService;
import com.gwssi.eoms.util.LocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 19:22
 * Description: 分类号和版本号修改服务实现
 */
@Service
public class SortNumVersionServiceImpl implements SortNumVersionService {
    @Autowired
    GgZlxFlhDao ggZlxFlhDao;

    @Autowired
    FlIPCFlhbDao flIPCFlhbDao;

    @Autowired
    private ApplicationContext context;  // 注入上下文

    private SortNumVersionService proxySelf;

    @PostConstruct  // 初始化方法
    private void setSelf() {
        //从上下文获取代理对象（如果通过proxySelf=this是不对的，this是目标对象）
        //此种方法不适合于prototype Bean，因为每次getBean返回一个新的Bean
        proxySelf = context.getBean(SortNumVersionService.class);
    }


    /**
     * 错误描述：
     * --版本号与分类号长度不符
     * @param requestID
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public ErrorFixResultVO fixSortNumVersion(List<String> requestID) {
        List<SortInfoDTO> sortInfoDTOList = ggZlxFlhDao.listSortNumByRequestIDList(requestID);  // 获取分类号列表
        int successCount = 0;
        StringBuilder message = new StringBuilder();
        for (SortInfoDTO sortInfoDTO : sortInfoDTOList) {
            sortInfoDTO.setViceSortNum(LocalUtils.stringDistinct(sortInfoDTO.getViceSortNum()));  // 副分类号去重
            sortInfoDTO.setAttachSortNum(LocalUtils.stringDistinct(sortInfoDTO.getAttachSortNum()));  // 附加分类号去重
            sortInfoDTO.setSortVersion(proxySelf.getSortVersion(sortInfoDTO));  // 获取分类号的版本号
            if (sortInfoDTO.isSortNumLengthEqualsVersionLength()) {  // 主分类号的版本号不空
                ggZlxFlhDao.updateViceAndAttachSortNumBySortInfoDTO(sortInfoDTO);
                successCount++;
            } else {
                message.append("存在分类号无版本号的案件 => ").append(sortInfoDTO.getRequestID()).append(". ");
            }
        }
        return new ErrorFixResultVO(successCount, sortInfoDTOList.size() - successCount, message.toString());
    }

    /**
     * 根据分类号获取版本号
     * @param sortInfoDTO
     * @return
     */
    @Override
    public String getSortVersion(SortInfoDTO sortInfoDTO) {
        StringBuilder sb = new StringBuilder(13);

        // 主分类号的版本号
        String mainSortNumVersion = flIPCFlhbDao.getOneBySortNum(sortInfoDTO.getMainSortNum());
        // 判断主分类号的版本号是否为空
        if (mainSortNumVersion == null || "".equals(mainSortNumVersion)) {
            sortInfoDTO.setSortNumLengthEqualsVersionLength(false);
            return null;
        } else {
            sortInfoDTO.setSortNumLengthEqualsVersionLength(true);
            sb.append(mainSortNumVersion).append(",");
        }

        // 副分类号的版本号
        if (sortInfoDTO.getViceSortNum() != null || "".equals(sortInfoDTO.getViceSortNum())) {
            List<String> viceSortNumList = LocalUtils.stringToList(sortInfoDTO.getViceSortNum(), ", ");  // 副分类号转成list
            List<String> viceSortNumVersionList = flIPCFlhbDao.listSortVersionBySortNumList(viceSortNumList);  // 查询版本号

            if (viceSortNumList.size() == viceSortNumVersionList.size()) {
                sortInfoDTO.setSortNumLengthEqualsVersionLength(true);
                sb.append(viceSortNumVersionList.toString()
                        .replaceAll("\\[|\\]", "")  // 去掉首尾的中括号
                        .replace(" ", ""))  // 去掉字符串中的空格
                        .append(",");
            } else {
                sortInfoDTO.setSortNumLengthEqualsVersionLength(false);
                return null;
            }
        }

        // 附加分类号的版本号
        if (sortInfoDTO.getAttachSortNum() != null || "".equals(sortInfoDTO.getAttachSortNum())) {
            List<String> attachSortNumList = LocalUtils.stringToList(sortInfoDTO.getAttachSortNum(), ", ");
            List<String> attachSortNumVersionList = flIPCFlhbDao.listSortVersionBySortNumList(attachSortNumList);
            if (attachSortNumList.size() == attachSortNumVersionList.size()) {
                sb.append(attachSortNumVersionList
                        .toString().replaceAll("\\[|\\]", "")  // 去掉首尾的中括号
                        .replace(" ", ""))  // 去掉字符串中的空格
                        .append(",");
                sortInfoDTO.setSortNumLengthEqualsVersionLength(true);
            } else {
                sortInfoDTO.setSortNumLengthEqualsVersionLength(false);
                return null;
            }
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }

}
