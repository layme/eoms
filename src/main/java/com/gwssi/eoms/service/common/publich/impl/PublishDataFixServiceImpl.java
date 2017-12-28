package com.gwssi.eoms.service.common.publich.impl;

import com.gwssi.eoms.dao.bookConcern.TBdFeedBackDao;
import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubDateDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.*;
import com.gwssi.eoms.dao.produce.gongbu.*;
import com.gwssi.eoms.exception.DataMissingException;
import com.gwssi.eoms.exception.DataMoreException;
import com.gwssi.eoms.model.vo.publish.PublishDataMapVO;
import com.gwssi.eoms.service.common.publich.PublishDataFixService;
import com.gwssi.eoms.service.publish.PublishDataMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/15
 * Time: 18:46
 * Description: 公布数据修改服务实现
 */
@Service
public class PublishDataFixServiceImpl implements PublishDataFixService {
    @Autowired
    GgZlxZhuDao ggZlxZhuDao;

    @Autowired
    FaFmgkGkajztjkDao faFmgkGkajztjkDao;

    @Autowired
    FaFmgkCbjybDao faFmgkCbjybDao;

    @Autowired
    FaFmgkCbjybLsDao faFmgkCbjybLsDao;

    @Autowired
    FaFmgkDggajbDao faFmgkDggajbDao;

    @Autowired
    FaFmgkJdbDao faFmgkJdbDao;

    @Autowired
    FaFmgkJdbLsDao faFmgkJdbLsDao;

    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    FaFmgkGktdbDao faFmgkGktdbDao;

    @Autowired
    TBdListDao tBdListDao;

    @Autowired
    FaFmgkGkqrbDao faFmgkGkqrbDao;

    @Autowired
    TPubListDao tPubListDao;

    @Autowired
    TBdFeedBackDao tBdFeedBackDao;

    @Autowired
    TPubDateDao tPubDateDao;

    @Autowired
    WfCurrentstepDao wfCurrentstepDao;

    @Autowired
    GgZlxGkggDao ggZlxGkggDao;

    @Autowired
    GkGbsqhpwjDao gkGbsqhpwjDao;

    @Autowired
    GkZlxZhuDao gkZlxZhuDao;

    // 公布数据图
    private PublishDataMapVO publishDataMapVO;

    /**
     * 获取数据分布状态和详情
     * @param requestID
     * @return
     */
    @Override
    public PublishDataMapVO getDataMapByRequestID(String requestID) {
        this.publishDataMapVO =  new PublishDataMapVO(
                ggZlxZhuDao.listByRequestID(requestID),
                faFmgkGkajztjkDao.listByRequestID(requestID),
                faFmgkCbjybDao.listByRequestID(requestID),
                faFmgkCbjybLsDao.listByRequestID(requestID),
                faFmgkDggajbDao.listByRequestID(requestID),
                faFmgkJdbDao.listByRequestID(requestID),
                faFmgkJdbLsDao.listByRequestID(requestID),
                faFmgkCwajclbDao.listByRequestID(requestID),
                faFmgkGktdbDao.listByRequestID(requestID),
                tBdListDao.listByRequestID(requestID),
                faFmgkGkqrbDao.listByRequestID(requestID),
                tPubListDao.getGBByRequestID(requestID)
        );
        return this.publishDataMapVO;
    }



    /**
     * 修改状态为6 -校验未通过
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_6(String requestId) {
        // 判断出版记录表有无数据
        if (this.publishDataMapVO.getTPubList().size() > 0) {
            throw new DataMoreException("出版记录表已有记录");
        }

        // 判断公开确认表有无数据
        if (this.publishDataMapVO.getFaFmgkGkqrb().size() > 0) {
            faFmgkGkqrbDao.deleteByRequestID(requestId);
        }

        // 修改监控表数据
        if (this.publishDataMapVO.getFaFmgkGkajztjk().size() > 0) {
            faFmgkGkajztjkDao.updateStatusAndPubDateByRequestID(requestId, "6", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改校验结论
        if (this.publishDataMapVO.getFaFmgkCbjyb().size() > 0) {
            faFmgkCbjybDao.updateStatusAndConclusionByRequestID(requestId, "6", "2");
        } else {
            throw new DataMissingException("校验表无记录");
        }

        // 修改校对结论
        if (this.publishDataMapVO.getFaFmgkJdb().size() > 0) {
            faFmgkJdbDao.updateConclusionByRequestID(requestId, "2");
        } else {
            throw new DataMissingException("校对表无记录");
        }

        // 插入校验错误原因
        if (this.publishDataMapVO.getFaFmgkCwajclb().size() > 0) {
            faFmgkCwajclbDao.deleteByRequestID(requestId);
        } else {
            faFmgkCwajclbDao.insertOneByRequestID(requestId,
                    tBdFeedBackDao.getErrorByRequestIDAndBdDate(requestId, this.publishDataMapVO.getTBdList().get(0).getBddate()), "1");
        }
    }

    /**
     * 修改状态为8 -公开待审核
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_8(String requestId) {
        // 判断出版记录表有无数据
        if (this.publishDataMapVO.getTPubList().size() > 0) {
            throw new DataMoreException("出版记录表已有记录");
        }

        // 修改监控表
        if (this.publishDataMapVO.getFaFmgkGkajztjk().size() > 0) {
            faFmgkGkajztjkDao.updateStatusAndPubDateByRequestID(requestId, "8", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改出版社校验表数据
        if (this.publishDataMapVO.getFaFmgkCbjyb().size() == 0) {
            if (this.publishDataMapVO.getFaFmgkCbjybLs().size() == 0) {
                throw new DataMissingException("出版社校验表和历史表都无记录");
            } else {
                // 恢复历史数据后删除历史
                faFmgkCbjybDao.insertOneFrom_FAFMGKCBJYBLS_ByRequestID(requestId);
                faFmgkCbjybLsDao.deleteByRequestID(requestId);
            }
        } else {
            faFmgkCbjybDao.updateStatusAndConclusionByRequestID(requestId, "8", "1");
        }

        // 修改校对结论
        if (this.publishDataMapVO.getFaFmgkJdb().size() == 0) {
            if (this.publishDataMapVO.getFaFmgkJdbLs().size() == 0) {
                throw new DataMissingException("校对表和历史表都无记录");
            } else {
                // 恢复历史数据后删除历史
                faFmgkJdbDao.insertOneFrom_FAFMGKJDBLS_ByRequestID(requestId);
                faFmgkJdbLsDao.deleteByRequestID(requestId);
            }
        } else {
            faFmgkJdbDao.updateConclusionByRequestID(requestId, "2");  // 2-校对通过
        }

        // 补入待公告案件数据
        if (this.publishDataMapVO.getFaFmgkDggajb().size() == 0) {
            faFmgkDggajbDao.insertOneByRequestID(requestId);
        } else {
            faFmgkDggajbDao.updatePubStatusByRequestID(requestId, "8");
        }

        // 删除错误表的数据
        if (this.publishDataMapVO.getFaFmgkCwajclb().size() > 0) {
            faFmgkCwajclbDao.deleteByRequestID(requestId);
        }

        // 删除公开提档表的数据
        if (this.publishDataMapVO.getFaFmgkGktdb().size() > 0) {
            faFmgkGktdbDao.deleteByRequestID(requestId);
        }
    }

    /**
     * 修改状态为9 -公开期限已到 待公开
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_9(String requestId) {
        // 判断出版记录表有无数据
        if (this.publishDataMapVO.getTPubList().size() > 0) {
            throw new DataMoreException("出版记录表已有记录");
        }

        // 修改监控表
        if (this.publishDataMapVO.getFaFmgkGkajztjk().size() > 0) {
            faFmgkGkajztjkDao.updateStatusAndPubDateByRequestID(requestId, "9", tPubDateDao.getPubDate());
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 插入公开提档表
        if (this.publishDataMapVO.getFaFmgkGktdb().size() == 0) {
            faFmgkGktdbDao.insertOneByRequestID(requestId);
        }

        // 删除公开确认表
        if (this.publishDataMapVO.getFaFmgkGkqrb().size() > 0) {
            faFmgkGkqrbDao.deleteByRequestID(requestId);
        }

        // 错误表补一条记录
        if (this.publishDataMapVO.getFaFmgkCwajclb().size() == 0) {
            faFmgkCwajclbDao.insertOneByRequestID(requestId, "", "5");
        }

        // 修改工作流
        wfCurrentstepDao.updateStepIDAndStatusByRequestAndName(requestId, "19", "1901", "1901S00");

        // 删除主公开表 1601-发明公布
        ggZlxGkggDao.deleteByRequestIDAndCode(requestId, "1601");

        // 删除号牌文件表 1601-发明公布
        gkGbsqhpwjDao.deleteByRequestIDAndCode(requestId, "1601");

        // 删除公开主表 1601-发明公布
        gkZlxZhuDao.deleteByRequestIDAndCode(requestId, "1601");
    }

    /**
     * 修改状态为10 -公开数据已提取
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_10(String requestId) {
        // 判断出版社是否接收到数据
        if (this.publishDataMapVO.getTPubList().size() == 0) {
            throw new DataMissingException("出版记录表无记录");
        }

        // 修改监控表数据
        if (this.publishDataMapVO.getFaFmgkGkajztjk().size() > 0) {
            faFmgkGkajztjkDao.updateStatusAndPubDateByRequestID(requestId,
                    "10",
                    this.publishDataMapVO.getTPubList().get(0).getPubdate());
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 插入或修改公开确认表
        if (this.publishDataMapVO.getFaFmgkGkqrb().size() == 0) {
            faFmgkGkqrbDao.insertOneByRequestIDFrom_JK_TDB(requestId);
        } else if (!this.publishDataMapVO.getTPubList().get(0).getPubdate().equals(this.publishDataMapVO.getFaFmgkGkqrb().get(0).getGongkair())) {
            faFmgkGkqrbDao.updatePubDateFromPubList(requestId, this.publishDataMapVO.getTPubList().get(0).getPubdate());
        }

        // 删除公开提档表数据
        faFmgkGktdbDao.deleteByRequestID(requestId);

        // 删除错误表
        faFmgkCwajclbDao.deleteByRequestID(requestId);

        // 删除待公布案件
        if (this.publishDataMapVO.getFaFmgkDggajb().size() > 0) {
            faFmgkDggajbDao.deleteByRequestID(requestId);
        }
    }

    /**
     * 修改状态为20 -等公开期限
     * @param requestId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateStatus_20(String requestId) {
        // 判断出版记录表有无数据
        if (this.publishDataMapVO.getTPubList().size() > 0) {
            throw new DataMoreException("出版记录表已有记录");
        }

        // 修改监控表
        if (this.publishDataMapVO.getFaFmgkGkajztjk().size() > 0) {
            faFmgkGkajztjkDao.updateStatusAndPubDateByRequestID(requestId, "20", "");
        } else {
            throw new DataMissingException("监控表无记录");
        }

        // 修改出版社校验表数据
        if (this.publishDataMapVO.getFaFmgkCbjyb().size() == 0) {
            if (this.publishDataMapVO.getFaFmgkCbjybLs().size() == 0) {
                throw new DataMissingException("出版社校验表和历史表都无记录");
            } else {
                // 恢复历史数据后删除历史
                faFmgkCbjybDao.insertOneFrom_FAFMGKCBJYBLS_ByRequestID(requestId);
                faFmgkCbjybLsDao.deleteByRequestID(requestId);
            }
        } else {
            faFmgkCbjybDao.updateStatusAndConclusionByRequestID(requestId, "20", "1");
        }

        // 修改校对结论
        if (this.publishDataMapVO.getFaFmgkJdb().size() == 0) {
            if (this.publishDataMapVO.getFaFmgkJdbLs().size() != 0) {
                // 恢复历史数据后删除历史
                faFmgkJdbDao.insertOneFrom_FAFMGKJDBLS_ByRequestID(requestId);
                faFmgkJdbLsDao.deleteByRequestID(requestId);
            } else {
                throw new DataMissingException("校对表和历史表都无记录");
            }
        } else {
            faFmgkJdbDao.updateConclusionByRequestID(requestId, "2");  // 2-校对通过
        }

        // 补入待公告案件数据
        if (this.publishDataMapVO.getFaFmgkDggajb().size() == 0) {
            faFmgkDggajbDao.insertOneByRequestID(requestId);
        } else {
            faFmgkDggajbDao.updatePubStatusByRequestID(requestId, "20");
        }

        // 删除错误表的数据
        if (this.publishDataMapVO.getFaFmgkCwajclb().size() > 0) {
            faFmgkCwajclbDao.deleteByRequestID(requestId);
        }

        // 删除公开提档表的数据
        if (this.publishDataMapVO.getFaFmgkGktdb().size() > 0) {
            faFmgkGktdbDao.deleteByRequestID(requestId);
        }
    }
}
