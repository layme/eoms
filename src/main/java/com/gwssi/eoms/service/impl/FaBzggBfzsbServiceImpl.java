package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.FaBzggBfzsbDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggBfzsb;
import com.gwssi.eoms.service.FaBzggBfzsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/10/23.
 */
@Service
public class FaBzggBfzsbServiceImpl implements FaBzggBfzsbService {
    @Autowired
    FaBzggBfzsbDao faBzggBfzsbDao;

    @Autowired
    TPubListDao tPubListDao;

    @Override
    public FaBzggBfzsb getFaBzggBfzsbByShenqingh(String shenqingh) {
        System.out.println(tPubListDao.getTPubListByShenqingh(shenqingh).toString());
        return faBzggBfzsbDao.getFaBzggBfzsbByShenqingh(shenqingh);
    }
}
