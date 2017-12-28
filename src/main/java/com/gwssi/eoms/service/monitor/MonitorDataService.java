package com.gwssi.eoms.service.monitor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 15:10
 * Description: 监控数据全刷新服务接口
 */
public interface MonitorDataService {
    /**
     * 获取公告监控数据项的各个总数
     * @return
     */
    void getAnnouncementMonitorData();

    /**
     * 获取公布监控数据项的各个总数
     * @return
     */
    void getPublishMonitorData();
}
