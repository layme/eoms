package com.gwssi.eoms.service.common.sortNumVersion;

import com.gwssi.eoms.model.dto.SortInfoDTO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 19:19
 * Description: 分类号和版本号修改服务
 */
public interface SortNumVersionService {
    /**
     * 具体修改方法
     * @param requestID
     * @return
     */
    ErrorFixResultVO fixSortNumVersion(List<String> requestID);

    /**
     * 获取分号的版本号
     * @param sortInfoDTO
     * @return
     */
    String getSortVersion(SortInfoDTO sortInfoDTO);
}
