package com.gwssi.eoms.service;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggBfzsb;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */
public interface FaBzggBfzsbService {
    List<FaBzggBfzsb> getByShenqingh(String shenqingh);
}
