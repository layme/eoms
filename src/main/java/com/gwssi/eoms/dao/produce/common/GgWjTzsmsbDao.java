package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.model.domain.produce.common.GgWjTzsmsb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
public interface GgWjTzsmsbDao {
    GgWjTzsmsb getByShenqingh(@Param("shenqingh") String Shenqingh);
}
