package com.gwssi.eoms.service.monitor.impl;

import com.gwssi.eoms.cache.CachePool;
import com.gwssi.eoms.dao.produce.common.FwZlzsFwxxDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkCwajclbDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkDggajbDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkGkajztjkDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkGkqrbDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggCwajclbDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggDggajbDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggGgajztjkDao;
import com.gwssi.eoms.model.vo.monitor.AnnouncementMonitorDataVO;
import com.gwssi.eoms.model.vo.monitor.PublishMonitorDataVO;
import com.gwssi.eoms.service.monitor.MonitorDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 17:50
 * Description: 定时全刷新缓存数据服务
 */
@Slf4j
@Service
public class MonitorDataServiceImpl implements MonitorDataService {
    @Autowired
    FaBzggCwajclbDao faBzggCwajclbDao;

    @Autowired
    FaBzggDggajbDao faBzggDggajbDao;

    @Autowired
    FaBzggGgajztjkDao faBzggGgajztjkDao;

    @Autowired
    FwZlzsFwxxDao fwZlzsFwxxDao;

    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    FaFmgkDggajbDao faFmgkDggajbDao;

    @Autowired
    FaFmgkGkajztjkDao faFmgkGkajztjkDao;

    /**
     * 定时获取公告的监控数据，并存入缓存
     */
    @Override
//    @Scheduled(fixedRate = 1000 * 60 * 60 * 2)
    public void getAnnouncementMonitorData() {
        AnnouncementMonitorDataVO announcementMonitorDataVO = (AnnouncementMonitorDataVO) CachePool.getValue("announcementMonitorDataVO");

        if (null == announcementMonitorDataVO) {
            CachePool.setValue("announcementMonitorDataVO",
                    new AnnouncementMonitorDataVO(
                            faBzggCwajclbDao.getAnnouncementCheckPoolErrorCount(),
                            faBzggDggajbDao.getAnnouncementWaitAuditCount(),
                            faBzggCwajclbDao.getAnnouncementPoolErrorCount(),

                            faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验成功错误"),
                            faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验失败错误"),
                            faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("接收出版社校验结果更新E系统时错误"),

                            faBzggGgajztjkDao.getWaitFeeCount(),
                            faBzggGgajztjkDao.getWaitAnnouncementCount(),
                            fwZlzsFwxxDao.getPostOfficeHaveAnnouncementDataCount("20171001")
                    ));
        } else {
            announcementMonitorDataVO.setAnnouncementCheckPoolError(faBzggCwajclbDao.getAnnouncementCheckPoolErrorCount());
            announcementMonitorDataVO.setAnnouncementWaitAudit(faBzggDggajbDao.getAnnouncementWaitAuditCount());
            announcementMonitorDataVO.setAnnouncementPoolError(faBzggCwajclbDao.getAnnouncementPoolErrorCount());

            announcementMonitorDataVO.setCheckSuccessError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验成功错误"));
            announcementMonitorDataVO.setCheckFailureError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验失败错误"));
            announcementMonitorDataVO.setCheckBackError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("接收出版社校验结果更新E系统时错误"));

            announcementMonitorDataVO.setWaitFee(faBzggGgajztjkDao.getWaitFeeCount());
            announcementMonitorDataVO.setWaitAnnouncement(faBzggGgajztjkDao.getWaitAnnouncementCount());
            announcementMonitorDataVO.setPostOfficeHaveAnnouncementData(fwZlzsFwxxDao.getPostOfficeHaveAnnouncementDataCount("20171001"));
        }
    }

    /**
     * 定时获取公布的监控数据，并存入缓存
     */
    @Override
//    @Scheduled(fixedRate = 1000 * 60 * 60 * 2)
    public void getPublishMonitorData() {
        PublishMonitorDataVO publishMonitorDataVO = (PublishMonitorDataVO) CachePool.getValue("publishMonitorDataVO");

        if (null == publishMonitorDataVO) {
            CachePool.setValue("publishMonitorDataVO",
                    new PublishMonitorDataVO(
                            faFmgkCwajclbDao.getPublishCheckPoolErrorCount(),
                            String.valueOf(faFmgkDggajbDao.getPublishWaitAuditIn5Count()) + " / "
                                    + String.valueOf(faFmgkDggajbDao.getPublishWaitAuditOut5Count()),
                            faFmgkCwajclbDao.getPublishPoolErrorCount(),

                            faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验成功错误"),
                            faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验失败错误"),
                            faFmgkGkajztjkDao.getWaitPublishIsNullCount(),

                            faFmgkGkajztjkDao.getOnlyAdvanceMarkCount(),
                            faFmgkGkajztjkDao.getAdvanceDatePassedCount(),
                            faFmgkGkajztjkDao.getBookConcernHavePubDataCount()
                    ));
        } else {
            publishMonitorDataVO.setPublishCheckPoolError(faFmgkCwajclbDao.getPublishCheckPoolErrorCount());
            publishMonitorDataVO.setPublishWaitAudit(String.valueOf(faFmgkDggajbDao.getPublishWaitAuditIn5Count()) + " / " + String.valueOf(faFmgkDggajbDao.getPublishWaitAuditOut5Count()));
            publishMonitorDataVO.setPublishPoolError(faFmgkCwajclbDao.getPublishPoolErrorCount());

            publishMonitorDataVO.setCheckSuccessError(faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验成功错误"));
            publishMonitorDataVO.setCheckFailureError(faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验失败错误"));
            publishMonitorDataVO.setWaitPublishIsNull(faFmgkGkajztjkDao.getWaitPublishIsNullCount());

            publishMonitorDataVO.setOnlyAdvanceMark(faFmgkGkajztjkDao.getOnlyAdvanceMarkCount());
            publishMonitorDataVO.setAdvanceDatePassed(faFmgkGkajztjkDao.getAdvanceDatePassedCount());
            publishMonitorDataVO.setBookConcernHavePublishData(faFmgkGkajztjkDao.getBookConcernHavePubDataCount());
        }
    }
}
