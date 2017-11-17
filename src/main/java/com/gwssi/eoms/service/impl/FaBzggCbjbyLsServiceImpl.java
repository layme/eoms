package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.produce.gonggao.FaBzggCbjbyLsDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjbyLs;
import com.gwssi.eoms.service.FaBzggCbjbyLsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */
@Service
public class FaBzggCbjbyLsServiceImpl implements FaBzggCbjbyLsService {
    @Autowired
    FaBzggCbjbyLsDao faBzggCbjbyLsDao;

    @Override
    public List<FaBzggCbjbyLs> getByShenqingh(String Shenqingh) {
        return faBzggCbjbyLsDao.getByShenqingh(Shenqingh);
    }
}
