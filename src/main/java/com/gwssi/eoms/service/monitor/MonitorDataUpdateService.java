package com.gwssi.eoms.service.monitor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 15:10
 * Description: 监控数据单项更新服务接口
 */
public interface MonitorDataUpdateService {
    /**
     * 更新缓存中的公布校验成功错误数量
     */
    void updatePublishCheckSuccess();

    /**
     * 更新缓存中的公布校验失败错误数量
     */
    void updatePublishCheckFailure();

    /**
     * 更新缓存中的待公布案件表为空的数量
     */
    void updateWaitPublishIsNull();

    /**
     * 更新缓存中的公告校验成功错误数量
     */
    void updateAnnouncementCheckSuccess();

    /**
     * 更新缓存中的公告校验失败错误数量
     */
    void updateAnnouncementCheckFailure();

    /**
     * 更新缓存中的公告校验返回失败数量
     */
    void updateAnnouncementCheckBackError();
}
