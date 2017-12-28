package com.gwssi.eoms.service.monitor.impl;

import com.gwssi.eoms.cache.CachePool;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkCwajclbDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkGkajztjkDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggCwajclbDao;
import com.gwssi.eoms.model.vo.monitor.AnnouncementMonitorDataVO;
import com.gwssi.eoms.model.vo.monitor.PublishMonitorDataVO;
import com.gwssi.eoms.service.monitor.MonitorDataUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 17:50
 * Description: 手动单项刷新缓存数据服务
 */
@Service
public class MonitorDataUpdateServiceImpl implements MonitorDataUpdateService {
    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    FaFmgkGkajztjkDao faFmgkGkajztjkDao;

    @Autowired
    FaBzggCwajclbDao faBzggCwajclbDao;

    @Override
    public void updatePublishCheckSuccess() {
        PublishMonitorDataVO publishMonitorDataVO = (PublishMonitorDataVO) CachePool.getValue("publishMonitorDataVO");
        publishMonitorDataVO.setCheckSuccessError(faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验成功错误"));
    }

    @Override
    public void updatePublishCheckFailure() {
        PublishMonitorDataVO publishMonitorDataVO = (PublishMonitorDataVO) CachePool.getValue("publishMonitorDataVO");
        publishMonitorDataVO.setCheckFailureError(faFmgkCwajclbDao.getPublishCheckNotPassCountByError("校验失败错误"));
    }

    @Override
    public void updateWaitPublishIsNull() {
        PublishMonitorDataVO publishMonitorDataVO = (PublishMonitorDataVO) CachePool.getValue("publishMonitorDataVO");
        publishMonitorDataVO.setWaitPublishIsNull(faFmgkGkajztjkDao.getWaitPublishIsNullCount());
    }

    @Override
    public void updateAnnouncementCheckSuccess() {
        AnnouncementMonitorDataVO announcementMonitorDataVO = (AnnouncementMonitorDataVO) CachePool.getValue("announcementMonitorDataVO");
        announcementMonitorDataVO.setCheckSuccessError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验成功错误"));
    }

    @Override
    public void updateAnnouncementCheckFailure() {
        AnnouncementMonitorDataVO announcementMonitorDataVO = (AnnouncementMonitorDataVO) CachePool.getValue("announcementMonitorDataVO");
        announcementMonitorDataVO.setCheckFailureError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("校验失败错误"));
    }

    @Override
    public void updateAnnouncementCheckBackError() {
        AnnouncementMonitorDataVO announcementMonitorDataVO = (AnnouncementMonitorDataVO) CachePool.getValue("announcementMonitorDataVO");
        announcementMonitorDataVO.setCheckBackError(faBzggCwajclbDao.getAnnouncementCheckNotPassCountByError("接收出版社校验结果更新E系统时错误"));
    }
}
