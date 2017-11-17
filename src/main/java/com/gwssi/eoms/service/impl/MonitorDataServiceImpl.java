package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.cache.CachePool;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkCwajclbDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkDggajbDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggCwajclbDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggDggajbDao;
import com.gwssi.eoms.model.vo.MonitorDataVO;
import com.gwssi.eoms.service.MonitorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorDataServiceImpl implements MonitorDataService {
    @Autowired
    FaBzggCwajclbDao faBzggCwajclbDao;

    @Autowired
    FaBzggDggajbDao faBzggDggajbDao;

    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    FaFmgkDggajbDao faFmgkDggajbDao;

    @Override
//    @Scheduled(fixedRate = 1000 * 60 * 60 * 2)
    public void getMonitorData() {
        MonitorDataVO monitorDataVo = (MonitorDataVO) CachePool.getValue("monitorDataVo");
        if (null == monitorDataVo) {
            CachePool.setValue("monitorDataVo",
            new MonitorDataVO(
                    faFmgkCwajclbDao.getPublishCheckPoolExceptionCount(),
                    String.valueOf(faFmgkDggajbDao.getPublishWaitAuditIn5Count()) + " / "
                            + String.valueOf(faFmgkDggajbDao.getPublishWaitAuditOut5Count()),
                    faFmgkCwajclbDao.getPublishPoolExceptionCount(),
                    faBzggCwajclbDao.getAnnouncementCheckPoolExceptionCount(),
                    faBzggDggajbDao.getAnnouncementWaitAuditCount(),
                    faBzggCwajclbDao.getAnnouncementPoolExceptionCount()
            ));
        } else {
            monitorDataVo.setPublishCheckPoolException(faFmgkCwajclbDao.getPublishCheckPoolExceptionCount());
            monitorDataVo.setPublishWaitAudit(String.valueOf(faFmgkDggajbDao.getPublishWaitAuditIn5Count()) + " / " + String.valueOf(faFmgkDggajbDao.getPublishWaitAuditOut5Count()));
            monitorDataVo.setPublishPoolException(faFmgkCwajclbDao.getPublishPoolExceptionCount());
            monitorDataVo.setAnnouncementCheckPoolException(faBzggCwajclbDao.getAnnouncementCheckPoolExceptionCount());
            monitorDataVo.setAnnouncementWaitAudit(faBzggDggajbDao.getAnnouncementWaitAuditCount());
            monitorDataVo.setAnnouncementPoolException(faBzggCwajclbDao.getAnnouncementPoolExceptionCount());
        }
    }
}
