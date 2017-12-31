package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.model.vo.publish.PublishDataMapVO;
import com.gwssi.eoms.service.publish.PublishCheckErrorFixService;
import com.gwssi.eoms.service.publish.PublishDataMapService;
import com.gwssi.eoms.service.publish.PublishMonitorFixService;
import com.gwssi.eoms.util.RestResult;
import com.gwssi.eoms.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 16:16
 * Description: 公布控制器
 */
@RestController
@RequestMapping(value = "/api/publish")
public class PublishController {
    /*******************************************************************************************************************
     * 1 以下为【数据分布图】功能区
     ******************************************************************************************************************/
    @Autowired
    PublishDataMapService publishDataMapService;

    @RequestMapping("/getPublishDataMap")
    public RestResult<PublishDataMapVO> getPublishDataMap(@RequestParam(value = "requestID", required = false) String requestID) {
        return RestResultGenerator.genSuccessResult(
                publishDataMapService.getDataMapByRequestID(requestID)
        );
    }

    @RequestMapping("/oneKeyFix")
    public RestResult oneKeyFix(@RequestParam(value = "requestID", required = false) String requestID,
                                @RequestParam(value = "status", required = false) String status) throws Exception {
        if (requestID == null) {
            throw new IllegalArgumentException("申请号不能为空");
        }
        if (requestID.length() != 13) {
            throw new IllegalArgumentException("申请号长度不对");
        }
        publishDataMapService.fixDistribution(requestID, status);
        return RestResultGenerator.genSuccessResult(null);
    }


    /*******************************************************************************************************************
     * 2 以下为【公布校验池】功能区
     ******************************************************************************************************************/
    @Autowired
    PublishCheckErrorFixService publishCheckPoolErrorService;

    @RequestMapping(value = "/listPublishCheckPoolErrorGroup", method = RequestMethod.GET)
    public RestResult<List<ErrorCountVO>> listPublishCheckPoolErrorGroup() {
        return RestResultGenerator.genSuccessResult(
                publishCheckPoolErrorService.listErrorGroup());
    }

    @RequestMapping(value = "/fixError", method = RequestMethod.GET)
    public RestResult<ErrorFixResultVO> fixError(@RequestParam(value = "error", required = false) String error,
                                                 @RequestParam(value = "status", required = false) int status) {
        return RestResultGenerator.genSuccessResult(publishCheckPoolErrorService.fixDistribution(error, status));
    }


    /*******************************************************************************************************************
     * 3 以下为【公布待审核】功能区
     ******************************************************************************************************************/
    @Autowired
    PublishMonitorFixService publishMonitorFixService;

    @RequestMapping(value = "/batchFixCheckSuccess", method = RequestMethod.GET)
    public RestResult<ErrorFixResultVO> batchFixCheckSuccess() {
        return RestResultGenerator.genSuccessResult(publishMonitorFixService.batchFixCheckSuccess());
    }


    /*******************************************************************************************************************
     * 4 以下为【公布池异常】功能区
     ******************************************************************************************************************/




}
