package com.gwssi.eoms.service.publish.impl;

import com.gwssi.eoms.dao.produce.common.FlIPCFlhbDao;
import com.gwssi.eoms.dao.produce.common.GgZlxFlhDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkCwajclbDao;
import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.service.common.sortNumVersion.SortNumVersionService;
import com.gwssi.eoms.service.publish.PublishCheckErrorFixService;
import lombok.extern.slf4j.Slf4j;
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
 * Date: 2017/12/8
 * Time: 11:42
 * Description: 公布校验池异常处理服务实现
 */
@Slf4j
@Service
public class PublishCheckErrorFixServiceImpl implements PublishCheckErrorFixService {
    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    GgZlxFlhDao ggZlxFlhDao;

    @Autowired
    FlIPCFlhbDao flIPCFlhbDao;

    @Autowired
    SortNumVersionService sortNumVersionService;

    @Autowired
    private ApplicationContext context;  // 注入上下文

    private PublishCheckErrorFixService proxySelf;

    @PostConstruct  // 初始化方法
    private void setSelf() {
        //从上下文获取代理对象（如果通过proxySelf=this是不对的，this是目标对象）
        //此种方法不适合于prototype Bean，因为每次getBean返回一个新的Bean
        proxySelf = context.getBean(PublishCheckErrorFixService.class);
    }

    /**
     * 返回池异常错误分组明细和对应数量
     * @return
     */
    @Override
    public List<ErrorCountVO> listErrorGroup() {
        return faFmgkCwajclbDao.listErrorCountVO();
    }

    /**
     * 处理方式分散中心
     * @param error
     */
    @Override
    public ErrorFixResultVO fixDistribution(String error, int status) {
        ErrorFixResultVO errorFixResultVO = null;
        List<String> errorList = faFmgkCwajclbDao.listRequestIDByError(error);
        switch (status) {
            case 1:
                errorFixResultVO = proxySelf.fixType_1(errorList);
                break;
            case 2:
                errorFixResultVO = proxySelf.fixType_2(errorList);
                break;
            case 3:
                errorFixResultVO = proxySelf.fixType_3(errorList);
                break;
            case 4:
                errorFixResultVO = proxySelf.fixType_4(errorList);
                break;
            case 5:
                errorFixResultVO = proxySelf.fixSortNumVersion(errorList);
                break;
            default:
                throw new UnsupportedOperationException("暂不支持此操作");
        }
        return errorFixResultVO;
    }

    /**
     * 错误描述：
     * --著录项目提取错误
     * @param requestID
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public ErrorFixResultVO fixType_1(List<String> requestID) {

        return null;
    }

    /**
     * 错误描述：
     * --取公布数据时错误
     * @param requestID
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public ErrorFixResultVO fixType_2(List<String> requestID) {

        return null;
    }

    /**
     * 错误描述：
     * --公报袋提取错误
     * @param requestID
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public ErrorFixResultVO fixType_3(List<String> requestID) {

        return null;
    }

    /**
     * 错误描述：
     * --公报袋提取失败
     * @param requestID
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public ErrorFixResultVO fixType_4(List<String> requestID) {

        return null;
    }

    /**
     * 错误描述：
     * --版本号与分类号长度不符
     * @param requestID
     */
    @Override
    public ErrorFixResultVO fixSortNumVersion(List<String> requestID) {
        return sortNumVersionService.fixSortNumVersion(requestID);
    }

}
