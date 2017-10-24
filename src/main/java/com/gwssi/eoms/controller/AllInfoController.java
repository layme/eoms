package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggBfzsb;
import com.gwssi.eoms.model.vo.AllDataItem;
import com.gwssi.eoms.service.AllDataItemService;
import com.gwssi.eoms.service.FaBzggBfzsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/10/23.
 */
@Controller
public class AllInfoController {
    @Autowired
    private AllDataItemService allDataItemService;

    @RequestMapping(value = "/getAllInfo", method = RequestMethod.GET)
    @ResponseBody
    public AllDataItem getAllInfo(@RequestParam(value = "shenqingh", required = true) String shenqingh) {
        return allDataItemService.getByShenqingh(shenqingh);
    }
}
