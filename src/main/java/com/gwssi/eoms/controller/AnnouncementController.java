package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.vo.announcement.AnnouncementDataMapVO;
import com.gwssi.eoms.service.announcement.AnnouncementDataMapService;
import com.gwssi.eoms.service.announcement.AnnouncementErrorFixService;
import com.gwssi.eoms.util.RestResult;
import com.gwssi.eoms.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 16:16
 * Description: 公告控制器
 */
@RestController
@RequestMapping(value = "/api/announcement")
public class AnnouncementController {
    /*******************************************************************************************************************
     * 1 以下为【公告数据分布图】功能区
     ******************************************************************************************************************/
    @Autowired
    private AnnouncementDataMapService announcementDataMapService;

    @RequestMapping(value = "/getAnnouncementDataMap", method = RequestMethod.GET)
    public RestResult<AnnouncementDataMapVO> getAnnouncementDataMap(@RequestParam(value = "requestID", required = true) String requestID) {
        return RestResultGenerator.genSuccessResult(
                announcementDataMapService.getDataMapByRequestID(requestID)
        );
    }

    @RequestMapping(value = "/oneKeyFix", method = RequestMethod.GET)
    public RestResult oneKeyFix(@RequestParam(value = "requestID", required = true) String requestID,
                                @RequestParam(value = "status", required = true) String status) throws Exception {
        announcementDataMapService.fixDistribution(requestID, status);
        return RestResultGenerator.genSuccessResult(null);
    }



    /*******************************************************************************************************************
     * 2 以下为【公告校验池】功能区
     ******************************************************************************************************************/



    /*******************************************************************************************************************
     * 3 以下为【公告待审核】功能区
     ******************************************************************************************************************/



    /*******************************************************************************************************************
     * 4 以下为【公告池异常】功能区
     ******************************************************************************************************************/



    /*******************************************************************************************************************
     * $ 以下为【批量修改公告状态11的案件】功能区
     ******************************************************************************************************************/
    @Autowired
    AnnouncementErrorFixService announcementPoolErrorService;

    @RequestMapping(value = "/batchUpdate11To9", method = RequestMethod.GET)
    public RestResult batchUpdate11To9() throws Exception {
        announcementPoolErrorService.batchUpdate11To9();
        return RestResultGenerator.genSuccessResult(null);
    }
}
