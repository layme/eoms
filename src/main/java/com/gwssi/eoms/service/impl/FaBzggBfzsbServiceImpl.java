package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.gonggao.FaBzggBfzsbDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggBfzsb;
import com.gwssi.eoms.service.FaBzggBfzsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<FaBzggBfzsb> getByShenqingh(String shenqingh) {
        return faBzggBfzsbDao.getByShenqingh (shenqingh);
    }
}
