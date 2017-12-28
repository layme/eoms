package com.gwssi.eoms.service.publish;

import com.gwssi.eoms.model.vo.publish.PublishDataMapVO;
import com.gwssi.eoms.service.common.BaseDataFixService;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/28
 * Time: 15:29
 * Description: 公布数据图服务接口
 */
public interface PublishDataMapService {
    /**
     * 获取案件的数据分布状态和详情
     * @param requestID
     * @return
     */
    PublishDataMapVO getDataMapByRequestID(String requestID);

    /**
     * 修改分发中心
     * @param requestID
     * @param status
     */
    void fixDistribution(String requestID, String status);
}
