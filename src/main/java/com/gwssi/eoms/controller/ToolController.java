package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.vo.publish.PublishNoticeDataVO;
import com.gwssi.eoms.model.vo.publish.PublishNoticeRepairResultVO;
import com.gwssi.eoms.model.vo.publish.PublishNoticeSuccessAndLoseVO;
import com.gwssi.eoms.service.publish.PublishNoticeService;
import com.gwssi.eoms.util.LocalUtils;
import com.gwssi.eoms.util.RestResult;
import com.gwssi.eoms.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/28
 * Time: 15:31
 * Description: 相关工具控制器
 */
@RestController
@RequestMapping(value = "/api/tool")
public class ToolController {
    /*******************************************************************************************************************
     * 1 以下为【公布公布及】功能区
     ******************************************************************************************************************/
    @Autowired
    PublishNoticeService publishNoticeService;

    /**
     * 获取公布公布及的应发总数，成功数，失败数，失效数
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/getPublishNoticeData", method = RequestMethod.GET)
    public RestResult<PublishNoticeDataVO> getPublishNoticeData(@RequestParam(value = "publishDate", required = false) String publishDate, @RequestParam(value = "noticeGenerationDate", required = false) String noticeGenerationDate) {
        return RestResultGenerator.genSuccessResult(
                publishNoticeService.getPublishNoticeData(publishDate, LocalUtils.stringToList(noticeGenerationDate, " ")));
    }

    /**
     * 获取发送成功且失效案件列表
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/getPublishNoticeSuccessAndLoseList", method = RequestMethod.GET)
    public RestResult<List<PublishNoticeSuccessAndLoseVO>> getPublishNoticeSuccessAndLoseList(@RequestParam(value = "publishDate", required = false) String publishDate, @RequestParam(value = "noticeGenerationDate", required = true) String noticeGenerationDate) {
        return RestResultGenerator.genSuccessResult(
                publishNoticeService.getPublishNoticeSuccessAndLoseList(publishDate, LocalUtils.stringToList(noticeGenerationDate, " ")));
    }

    /**
     * 一键修改公布公布及发送失败的数据
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/oneKeyRepairPublishNotice", method = RequestMethod.GET)
    public RestResult<PublishNoticeRepairResultVO> oneKeyRepairPublishNotice(@RequestParam(value = "publishDate", required = false) String publishDate, @RequestParam(value = "noticeGenerationDate", required = true) String noticeGenerationDate) {
        return RestResultGenerator.genSuccessResult(
                publishNoticeService.oneKeyRepairPublishNotice(publishDate, LocalUtils.stringToList(noticeGenerationDate, " ")));
    }

    /**
     * 获取失效案件列表的输出流
     * @param publishDate
     * @param httpServletResponse
     */
    @RequestMapping(value = "/getPublishNoticeLoseXls", method = RequestMethod.GET)
    public void getPublishNoticeLoseXls(@RequestParam(value = "publishDate", required = false) String publishDate, HttpServletResponse httpServletResponse) {
        publishNoticeService.getPublishNoticeLoseXls(publishDate, httpServletResponse);
    }
}
