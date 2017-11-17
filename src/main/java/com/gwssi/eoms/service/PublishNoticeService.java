package com.gwssi.eoms.service;

import com.gwssi.eoms.model.vo.PublishNoticeDataVO;
import com.gwssi.eoms.model.vo.PublishNoticeRepairResultVO;
import com.gwssi.eoms.model.vo.PublishNoticeSuccessAndLoseVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/10
 * Time: 12:50
 * Description: 公布公布及通知书服务
 */
public interface PublishNoticeService {
    /**
     * 获取公布公布及通知书的数据项总数
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    PublishNoticeDataVO getPublishNoticeData(String publishDate, String noticeGenerationDate);

    /**
     * 获取发送成功且失效的案件列表
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    List<PublishNoticeSuccessAndLoseVO> getPublishNoticeSuccessAndLoseList(String publishDate, String noticeGenerationDate);

    /**
     * 一件修复公布公布及通知书问题
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    PublishNoticeRepairResultVO oneKeyRepairPublishNotice(String publishDate, String noticeGenerationDate);

    /**
     * 导出公布和公布及失效案件xls文件
     */
    void getPublishNoticeLoseXls(String publishDate, HttpServletResponse httpServletResponse);
}
