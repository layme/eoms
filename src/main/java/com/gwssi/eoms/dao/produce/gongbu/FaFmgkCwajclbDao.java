package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkCwajclb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkCwajclbDao")
public interface FaFmgkCwajclbDao {
    /**
     * 获取单条记录
     * @param requestID
     * @return
     */
    FaFmgkCwajclb getByRequestID(@Param("requestID") String v);

    /**
     * 获取公布校验池异常总数
     * @return
     */
    Integer getPublishCheckPoolExceptionCount();

    /**
     * 获取公布池异常总数
     * @return
     */
    Integer getPublishPoolExceptionCount();
}
