package com.gwssi.eoms.service.common.Announcement.impl;

import com.gwssi.eoms.dao.bookConcern.TBdFeedBackDao;
import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubDateDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.GgZlxZhuDao;
import com.gwssi.eoms.dao.produce.common.WfCurrentstepDao;
import com.gwssi.eoms.dao.produce.gonggao.*;
import com.gwssi.eoms.exception.DataMissingException;
import com.gwssi.eoms.exception.DataMoreException;
import com.gwssi.eoms.model.vo.announcement.AnnouncementDataMapVO;
import com.gwssi.eoms.service.common.Announcement.AnnouncementDataFixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/14
 * Time: 11:36
 * Description: 公告数据修改服务实现
 */
@Service
public class AnnouncementDataFixServiceImpl implements AnnouncementDataFixService {
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

    @Autowired
    WfCurrentstepDao wfCurrentstepDao;

    @Autowired
    TPubDateDao tPubDateDao;

    @Autowired
    TBdFeedBackDao tBdFeedBackDao;

    // 公告数据图
    private AnnouncementDataMapVO announcementDataMapVO = null;

    /**
     * 获取案件的数据分布状态和详情
     *
     * @param requestID
     * @return
     */
    @Override
    public AnnouncementDataMapVO getDataMapByRequestID(String requestID) {
        this.announcementDataMapVO = new AnnouncementDataMapVO(
                ggZlxZhuDao.listByRequestID(requestID),
                faBzggGgajztjkDao.listByRequestID(requestID),
                faBzggCbjybDao.listByRequestID(requestID),
                faBzggCbjbyLsDao.listByRequestID(requestID),
                faBzggDggajbDao.listByRequestID(requestID),
                faBzggCwajclbDao.listByRequestID(requestID),
                faBzggZsglbDao.listByRequestID(requestID),
                faBzggBfzsbDao.listByRequestID(requestID),
                tBdListDao.listByRequestID(requestID),
                tPubListDao.getSQByRequestID(requestID)
        );
        return this.announcementDataMapVO;
    }


    /**
     * 修改状态为6 -校验未通过
     *
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_6(String requestId) {
        // 判断颁发证书表有无数据
        if (this.announcementDataMapVO.getFaBzggBfzsb().size() > 0) {
            throw new DataMoreException("颁发证书表已有记录");
        }

        // 修改监控表数据
        if (this.announcementDataMapVO.getFaBzggGgajztjk().size() > 0) {
            faBzggGgajztjkDao.updateStatusAndPubDateByRequestID(requestId, "6", "1", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改校验结论
        if (this.announcementDataMapVO.getFaBzggCbjyb().size() > 0) {
            faBzggCbjybDao.updateStatusAndConclusionByRequestID(requestId, "6", "2");
        } else {
            throw new DataMissingException("校验表无记录");
        }

        // 插入校验错误原因
        if (this.announcementDataMapVO.getFaBzggCwajclb().size() > 0) {
            faBzggCwajclbDao.deleteByRequestID(requestId);
        }
        faBzggCwajclbDao.insertOneByRequestID(requestId,
                tBdFeedBackDao.getErrorByRequestIDAndBdDate(requestId,
                        this.announcementDataMapVO.getTBdList().get(0).getBddate()),
                "1");

    }

    /**
     * 修改状态为8 -公告待审核
     *
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_8(String requestId) {
        // 判断颁发证书表有无数据
        if (this.announcementDataMapVO.getFaBzggBfzsb().size() > 0) {
            throw new DataMoreException("颁发证书表已有记录");
        }

        // 修改监控表数据
        if (this.announcementDataMapVO.getFaBzggGgajztjk().size() > 0) {
            faBzggGgajztjkDao.updateStatusAndPubDateByRequestID(requestId, "8", "1", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改出版社校验表数据
        if (this.announcementDataMapVO.getFaBzggCbjyb().size() == 0) {
            if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() == 0) {
                throw new DataMissingException("出版社校验表和历史表都无记录");
            } else {
                // 恢复历史数据后删除历史
                faBzggCbjybDao.insertOneFrom_FABZGGCBJBYLS_ByRequestID(requestId);
                faBzggCbjbyLsDao.deleteByRequestID(requestId);
            }
        } else {
            faBzggCbjybDao.updateStatusAndConclusionByRequestID(requestId, "8", "1");
        }

        // 删除出版社校验历史数据
        if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() > 0) {
            faBzggCbjbyLsDao.deleteByRequestID(requestId);
        }

        // 补入待公告案件数据
        if (this.announcementDataMapVO.getFaBzggDggajb().size() == 0) {
            faBzggDggajbDao.insertOneByRequestID(requestId);
        } else {
            faBzggDggajbDao.updatePubStatusByRequestID(requestId, "8");
        }

        // 删除错误表数据
        if (this.announcementDataMapVO.getFaBzggCwajclb().size() > 0) {
            faBzggCwajclbDao.deleteByRequestID(requestId);
        }

        // 修改工作流为1503S01
        wfCurrentstepDao.updateStepIDAndStatusByRequestAndName(requestId, "15", "1503", "1503S01");
    }

    /**
     * 修改状态为9 -已用费待公告
     *
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_9(String requestId) {
        // 判断颁发证书表有无数据
        if (this.announcementDataMapVO.getFaBzggBfzsb().size() > 0) {
            throw new DataMoreException("颁发证书表已有记录");
        }

        // 修改监控表数据
        if (this.announcementDataMapVO.getFaBzggGgajztjk().size() > 0) {
            faBzggGgajztjkDao.updateStatusAndPubDateByRequestID(requestId, "9", "1", tPubDateDao.getPubDate());
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 校验数据进历史
        if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() == 0) {
            if (this.announcementDataMapVO.getFaBzggCbjyb().size() == 0) {
                throw new DataMissingException("出版社校验表和历史表都无记录");
            } else {
                // 校验表送历史后删除
                faBzggCbjbyLsDao.insertOneFrom_FABZGGCBJYB_ByRequestID(requestId);
                faBzggCbjybDao.deleteByRequestID(requestId);
            }
        }

        if (this.announcementDataMapVO.getFaBzggCbjyb().size() > 0) {
            faBzggCbjybDao.deleteByRequestID(requestId);
        }

        // 错误表补一条数据
        if (this.announcementDataMapVO.getFaBzggCwajclb().size() == 0) {
            faBzggCwajclbDao.insertOneByRequestID(requestId, "", "5");
        }

        // 证书管理表补一条数据
        //
        if (this.announcementDataMapVO.getFaBzggZsglb().size() > 0) {
            faBzggZsglbDao.updatePubStatusAndPubDateAndNoticeStatusByRequestID(requestId,
                    "9",
                    tPubDateDao.getPubDate(),
                    "00");
        } else {
            faBzggZsglbDao.insertOneByRequestID(requestId);
        }

        // 修改工作流为1504S01
        wfCurrentstepDao.updateStepIDAndStatusByRequestAndName(requestId, "15", "1504", "1504S01");
    }

    /**
     * 修改状态为10 -公告数据已提取
     *
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_10(String requestId) {
        // 判断出版记录表有无数据
        if (this.announcementDataMapVO.getTPubList().size() == 0) {
            throw new DataMissingException("出版记录表无记录");
        }

        // 修改监控表数据
        if (this.announcementDataMapVO.getFaBzggGgajztjk().size() > 0) {
            faBzggGgajztjkDao.updateStatusAndPubDateByRequestID(requestId, "10", "1",
                    this.announcementDataMapVO.getTPubList().get(0).getPubdate());
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 校验数据进历史
        if (this.announcementDataMapVO.getFaBzggCbjyb().size() > 0) {
            if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() == 0) {
                faBzggCbjbyLsDao.insertOneFrom_FABZGGCBJYB_ByRequestID(requestId);
            }
            faBzggCbjybDao.deleteByRequestID(requestId);
        }

        // 删除错误表
        if (this.announcementDataMapVO.getFaBzggCwajclb().size() > 0) {
            faBzggCwajclbDao.deleteByRequestID(requestId);
        }

        // 删除待公告
        if (this.announcementDataMapVO.getFaBzggDggajb().size() > 0) {
            faBzggDggajbDao.deleteByRequestID(requestId);
        }

        // 删除证书管理
        if (this.announcementDataMapVO.getFaBzggZsglb().size() > 0) {
            faBzggZsglbDao.deleteByRequestID(requestId);
        }
    }

    /**
     * 修改状态为20 -等年登印费
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_20(String requestId) {
        // 判断颁发证书表有无数据
        if (this.announcementDataMapVO.getFaBzggBfzsb().size() > 0) {
            throw new DataMoreException("颁发证书表已有记录");
        }

        // 修改监控表数据
        if (this.announcementDataMapVO.getFaBzggGgajztjk().size() > 0) {
            faBzggGgajztjkDao.updateStatusAndPubDateByRequestID(requestId, "20", "1", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改出版社校验表数据
        if (this.announcementDataMapVO.getFaBzggCbjyb().size() == 0) {
            if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() == 0) {
                throw new DataMissingException("出版社校验表和历史表都无记录");
            } else {
                // 恢复历史数据后删除历史
                faBzggCbjybDao.insertOneFrom_FABZGGCBJBYLS_ByRequestID(requestId);
                faBzggCbjbyLsDao.deleteByRequestID(requestId);
            }
        } else {
            faBzggCbjybDao.updateStatusAndConclusionByRequestID(requestId, "20", "1");
        }

        // 删除出版社校验历史数据
        if (this.announcementDataMapVO.getFaBzggCbjbyLs().size() > 0) {
            faBzggCbjbyLsDao.deleteByRequestID(requestId);
        }

        // 补入待公告案件数据
        if (this.announcementDataMapVO.getFaBzggDggajb().size() == 0) {
            faBzggDggajbDao.insertOneByRequestID(requestId);
        } else {
            faBzggDggajbDao.updatePubStatusByRequestID(requestId, "8");
        }

        // 删除错误表数据
        if (this.announcementDataMapVO.getFaBzggCwajclb().size() > 0) {
            faBzggCwajclbDao.deleteByRequestID(requestId);
        }
    }
}
