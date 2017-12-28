package com.gwssi.eoms.controller;

import com.gwssi.eoms.cache.CachePool;
import com.gwssi.eoms.exception.DataMissingException;
import com.gwssi.eoms.model.vo.monitor.AnnouncementMonitorDataVO;
import com.gwssi.eoms.model.vo.monitor.PublishMonitorDataVO;
import com.gwssi.eoms.util.RestResult;
import com.gwssi.eoms.util.RestResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 16:16
 * Description: 监控数据控制器
 */
@RestController
@RequestMapping(value = "/api/monitorData")
public class MonitorDataController {
    /**
     * 从缓存里获取公告监控数据
     * @return
     */
    @RequestMapping(value = "/getAnnouncementMonitorData", method = RequestMethod.GET)
    public RestResult<AnnouncementMonitorDataVO> getMonitorData() {
        if ((AnnouncementMonitorDataVO)CachePool.getValue("announcementMonitorDataVO") != null) {
            return RestResultGenerator.genSuccessResult((AnnouncementMonitorDataVO)CachePool.getValue("announcementMonitorDataVO"));
        } else {
            throw new DataMissingException("缓存暂无公告监控数据，请稍后再试");
        }
    }

    /**
     * 从缓存里获取公布监控数据
     * @return
     */
    @RequestMapping(value = "/getPublishMonitorData", method = RequestMethod.GET)
    public RestResult<PublishMonitorDataVO> getPublishMonitorData() {
        if ((PublishMonitorDataVO)CachePool.getValue("publishMonitorDataVO") != null) {
            return RestResultGenerator.genSuccessResult((PublishMonitorDataVO)CachePool.getValue("publishMonitorDataVO"));
        } else {
            throw new DataMissingException("缓存暂无公布监控数据，请稍后再试");
        }
    }
}
