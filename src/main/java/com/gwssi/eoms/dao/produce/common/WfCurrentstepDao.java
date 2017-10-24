package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.model.domain.produce.common.WfCurrentstep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
public interface WfCurrentstepDao {
    WfCurrentstep getByshenqingh(@Param("shenqingh") String shenqingh);
}
