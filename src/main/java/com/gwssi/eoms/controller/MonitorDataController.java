package com.gwssi.eoms.controller;

import com.gwssi.eoms.cache.CachePool;
import com.gwssi.eoms.model.vo.MonitorDataVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/10/23.
 */
@RestController
public class MonitorDataController {
    /**
     * 从缓存里获取监控数据
     * @return
     */
    @RequestMapping(value = "/api/getMonitorData", method = RequestMethod.GET)
    public MonitorDataVO getMonitorData() {
        return (MonitorDataVO)CachePool.getValue("monitorDataVo");
    }
}
