package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCwajclb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
public interface FaBzggCwajclbDao {
    FaBzggCwajclb getByShenqingh(@Param("shenqingh") String shenqingh);
}
