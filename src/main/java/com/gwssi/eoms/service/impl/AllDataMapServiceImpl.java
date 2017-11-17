package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.GgZlxZhuDao;
import com.gwssi.eoms.dao.produce.gonggao.*;
import com.gwssi.eoms.model.vo.AllGGDataMapVO;
import com.gwssi.eoms.service.AllDataIMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/10/24.
 */
@Service
public class AllDataMapServiceImpl implements AllDataIMapService {
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

    @Override
    public AllGGDataMapVO getByShenqingh(String shenqingh) {
        return new AllGGDataMapVO(
                ggZlxZhuDao.getByShenqingh(shenqingh),
                faBzggGgajztjkDao.getByShenqingh(shenqingh),
                faBzggCbjybDao.getByShenqingh(shenqingh),
                faBzggCbjbyLsDao.getByShenqingh(shenqingh),
                faBzggDggajbDao.getByShenqingh(shenqingh),
                faBzggCwajclbDao.getByShenqingh(shenqingh),
                faBzggZsglbDao.getByShenqingh(shenqingh),
                faBzggBfzsbDao.getByShenqingh(shenqingh),
                tBdListDao.getByShenqingh(shenqingh),
                tPubListDao.getByShenqingh(shenqingh)
        );
    }
}