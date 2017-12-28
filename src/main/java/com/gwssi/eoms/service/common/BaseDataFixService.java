package com.gwssi.eoms.service.common;

import com.gwssi.eoms.model.vo.announcement.AnnouncementDataMapVO;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/14
 * Time: 11:36
 * Description: 基本修改数据服务父接口
 */
public interface BaseDataFixService<T> {
    /**
     * 获取数据分布状态和详情
     * @param requestID
     * @return
     */
    T getDataMapByRequestID(String requestID);

    /**
     * 公告状态改为6
     * @param requestId
     */
    void updateStatus_6(String requestId);

    /**
     * 公告状态改为8
     * @param requestId
     */
    void updateStatus_8(String requestId);

    /**
     * 公告状态改为9
     * @param requestId
     */
    void updateStatus_9(String requestId);

    /**
     * 公告状态改为10
     * @param requestId
     */
    void updateStatus_10(String requestId);

    /**
     * 公告状态改为20
     * @param requestId
     */
    void updateStatus_20(String requestId);
}
