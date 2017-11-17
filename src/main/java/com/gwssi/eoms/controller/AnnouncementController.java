package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.vo.AllGGDataMapVO;
import com.gwssi.eoms.service.AllDataIMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/10/23.
 */
@RestController
public class AnnouncementController {
    @Autowired
    private AllDataIMapService allDataItemService;

    @RequestMapping(value = "/api/getAllGGDataMap", method = RequestMethod.GET)
    public AllGGDataMapVO getAllGGDataMap(@RequestParam(value = "shenqingh", required = true) String shenqingh) {
        return allDataItemService.getByShenqingh(shenqingh);
    }
}
