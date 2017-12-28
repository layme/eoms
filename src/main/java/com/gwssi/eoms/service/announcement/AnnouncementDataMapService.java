package com.gwssi.eoms.service.announcement;

import com.gwssi.eoms.model.vo.announcement.AnnouncementDataMapVO;
import com.gwssi.eoms.service.common.BaseDataFixService;

/**
 * Created by admin on 2017/10/24.
 */
public interface AnnouncementDataMapService {
    /**
     * 获取案件的数据分布状态和详情
     * @param requestID
     * @return
     */
    AnnouncementDataMapVO getDataMapByRequestID(String requestID);

    /**
     * 修改分发中心
     * @param requestID
     * @param status
     */
    void fixDistribution(String requestID, String status);
}
