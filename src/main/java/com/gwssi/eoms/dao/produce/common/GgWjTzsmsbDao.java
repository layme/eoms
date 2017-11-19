package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.model.domain.produce.common.GgWjTzsmsb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
@Component(value = "ggWjTzsmsbDao")
public interface GgWjTzsmsbDao {
    GgWjTzsmsb getByRequestID(@Param("requestID") String requestID);
}
