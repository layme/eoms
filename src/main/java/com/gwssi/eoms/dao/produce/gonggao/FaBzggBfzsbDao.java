package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggBfzsb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
public interface FaBzggBfzsbDao {
    FaBzggBfzsb getByShenqingh(@Param("shenqingh") String shenqingh);
}
