package com.gwssi.eoms.controller;

import com.gwssi.eoms.model.dto.PublishNoticeLoseDTO;
import com.gwssi.eoms.model.vo.PublishNoticeDataVO;
import com.gwssi.eoms.model.vo.PublishNoticeRepairResultVO;
import com.gwssi.eoms.model.vo.PublishNoticeSuccessAndLoseVO;
import com.gwssi.eoms.service.PublishNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 16:16
 * Description: 公布控制器
 */
@RestController
public class PublishController {
    @Autowired
    PublishNoticeService publishNoticeService;

    /**
     * 获取公布公布及的应发总数，成功数，失败数，失效数
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/api/getPublishNoticeData", method = RequestMethod.GET)
    public PublishNoticeDataVO getPublishNoticeData(@RequestParam(value = "publishDate", required = true) String publishDate, @RequestParam(value = "noticeGenerationDate", required = true) String noticeGenerationDate) {
        return publishNoticeService.getPublishNoticeData(publishDate, noticeGenerationDate.replaceAll(" ", "','"));
    }

    /**
     * 获取发送成功且失效案件列表
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/api/getPublishNoticeSuccessAndLoseList", method = RequestMethod.GET)
    public List<PublishNoticeSuccessAndLoseVO> getPublishNoticeSuccessAndLoseList(@RequestParam(value = "publishDate", required = true) String publishDate, @RequestParam(value = "noticeGenerationDate", required = true) String noticeGenerationDate) {
        return publishNoticeService.getPublishNoticeSuccessAndLoseList(publishDate, noticeGenerationDate.replaceAll(" ", "','"));
    }

    /**
     * 一键修改公布公布及发送失败的数据
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @RequestMapping(value = "/api/oneKeyRepairPublishNotice", method = RequestMethod.POST)
    public PublishNoticeRepairResultVO oneKeyRepairPublishNotice(@RequestParam(value = "publishDate", required = true) String publishDate, @RequestParam(value = "noticeGenerationDate", required = true) String noticeGenerationDate) {
        return publishNoticeService.oneKeyRepairPublishNotice(publishDate, noticeGenerationDate.replaceAll(" ", "','"));
    }

    @RequestMapping(value = "/api/getPublishNoticeLoseXls", method = RequestMethod.GET)
    public void getPublishNoticeLoseXls(@RequestParam(value = "publishDate", required = true) String publishDate, HttpServletResponse httpServletResponse) {
        publishNoticeService.getPublishNoticeLoseXls(publishDate, httpServletResponse);
    }
}
