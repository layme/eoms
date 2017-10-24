package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggDggajb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
public interface FaBzggDggajbDao {
    FaBzggDggajb getByShenqingh(@Param("shenqingh") String shenqingh);
}