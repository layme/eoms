package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.model.domain.produce.common.WfWfentry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
public interface WfWfentryDao {
    WfWfentry getByShenqingh(@Param("shenqingh") String shenqingh);
}
