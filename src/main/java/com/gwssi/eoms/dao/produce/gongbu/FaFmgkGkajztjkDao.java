package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkGkajztjk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkGkajztjkDao")
public interface FaFmgkGkajztjkDao {
    /**
     * 获取单条记录
     * @param requestID
     * @return
     */
    FaFmgkGkajztjk getByRequestID(@Param("requestID") String requestID);
}
