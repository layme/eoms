package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.vo.AllGGDataMapVO;
import com.gwssi.eoms.service.AnnouncementDataMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/10/23.
 */
@RestController
public class AnnouncementController {
    @Autowired
    private AnnouncementDataMapService allDataItemService;

    @RequestMapping(value = "/api/getAllGGDataMap", method = RequestMethod.GET)
    public AllGGDataMapVO getAllGGDataMap(@RequestParam(value = "requestID", required = true) String requestID) {
        return allDataItemService.getByRequestID(requestID);
    }

    @RequestMapping(value = "/api/oneKeyFix", method = RequestMethod.POST)
    public Integer oneKeyFix(@RequestParam(value = "requestID", required = true) String requestID,
                             @RequestParam(value = "status", required = true) String status) {
        return 0;
    }
}
