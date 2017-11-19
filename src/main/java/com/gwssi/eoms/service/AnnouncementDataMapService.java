package com.gwssi.eoms.service;

import com.gwssi.eoms.model.vo.AllGGDataMapVO;

/**
 * Created by admin on 2017/10/24.
 */
public interface AnnouncementDataMapService {
    /**
     * 获取数据分布状态和详情
     * @param requestID
     * @return
     */
    AllGGDataMapVO getByRequestID(String requestID);

    /**
     * 一键修改案件状态
     * @param requestID
     * @param status
     * @return
     */
    Integer oneKeyFix(String requestID, String status);
}
