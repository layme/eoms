package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.GgZlxZhuDao;
import com.gwssi.eoms.dao.produce.gonggao.*;
import com.gwssi.eoms.model.vo.AllGGDataMapVO;
import com.gwssi.eoms.service.AnnouncementDataMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/10/24.
 */
@Service
public class AnnouncementDataMapServiceImpl implements AnnouncementDataMapService {
    @Autowired
    FaBzggBfzsbDao faBzggBfzsbDao;

    @Autowired
    FaBzggCbjbyLsDao faBzggCbjbyLsDao;

    @Autowired
    FaBzggCbjybDao faBzggCbjybDao;

    @Autowired
    FaBzggCwajclbDao faBzggCwajclbDao;

    @Autowired
    FaBzggDggajbDao faBzggDggajbDao;

    @Autowired
    FaBzggGgajztjkDao faBzggGgajztjkDao;

    @Autowired
    FaBzggZsglbDao faBzggZsglbDao;

    @Autowired
    GgZlxZhuDao ggZlxZhuDao;

    @Autowired
    TBdListDao tBdListDao;

    @Autowired
    TPubListDao tPubListDao;

    private AllGGDataMapVO allGGDataMapVO = null;

    /**
     * 获取案件的数据分布状态和详情
     *
     * @param requestID
     * @return
     */
    @Override
    public AllGGDataMapVO getByRequestID(String requestID) {
        this.allGGDataMapVO =  new AllGGDataMapVO(
                ggZlxZhuDao.getByRequestID(requestID),
                faBzggGgajztjkDao.getByRequestID(requestID),
                faBzggCbjybDao.getByRequestID(requestID),
                faBzggCbjbyLsDao.getByRequestID(requestID),
                faBzggDggajbDao.getByRequestID(requestID),
                faBzggCwajclbDao.getByRequestID(requestID),
                faBzggZsglbDao.getByRequestID(requestID),
                faBzggBfzsbDao.getByRequestID(requestID),
                tBdListDao.getByRequestID(requestID),
                tPubListDao.getByRequestID(requestID)
        );
        return this.allGGDataMapVO;
    }

    /**
     * 一键修改案件状态
     *
     * @param requestID
     * @param status
     * @return
     */
    @Override
    public Integer oneKeyFix(String requestID, String status) {
        // TODO
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    Integer updateStatus_6(String requestId) throws Exception {
        // TODO

        // 修改监控表数据
        if (this.allGGDataMapVO.getFaBzggGgajztjk() != null) {
            faBzggGgajztjkDao.updateStatusByRequestID(requestId, "6", "");
        } else {
            throw new Exception("监控表无记录");
        }

        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    Integer updateStatus_8(String requestId, AllGGDataMapVO allGGDataMapVO) throws Exception {
        // TODO

        // 修改监控表数据
        if (this.allGGDataMapVO.getFaBzggGgajztjk() != null) {
            faBzggGgajztjkDao.updateStatusByRequestID(requestId, "8", "");
        } else {
            throw new Exception("监控表无记录");
        }

        // 修改出版社校验表数据
        if (this.allGGDataMapVO.getFaBzggCbjyb() == null) {
            if (this.allGGDataMapVO.getFaBzggCbjbyLs() == null) {
                throw new Exception("出版社校验表和历史表都无记录");
            } else {
                // TODO 恢复历史数据 删除历史
            }
        } else {
            faBzggCbjybDao.updateStatusAndConclusion(requestId, "8", "1");
        }

        // 删除出版社校验历史数据
        if (this.allGGDataMapVO.getFaBzggCbjbyLs() != null) {
            faBzggCbjbyLsDao.deleteByRequestID(requestId);
        }

        // 补入待公告案件数据
        if (this.allGGDataMapVO.getFaBzggDggajb() == null) {
            faBzggDggajbDao.insertOneByRequestID(requestId);
        }

        if (this.allGGDataMapVO.getFaBzggCwajclb() != null) {
            faBzggCwajclbDao.deleteByRequest(requestId);
        }

        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    Integer updateStatus_9(String requestId) throws Exception {
        // TODO

        // 修改监控表数据
        if (this.allGGDataMapVO.getFaBzggGgajztjk() != null) {
            faBzggGgajztjkDao.updateStatusByRequestID(requestId, "9", "");  // TODO
        } else {
            throw new Exception("监控表无记录");
        }

        return 0;
    }
}
