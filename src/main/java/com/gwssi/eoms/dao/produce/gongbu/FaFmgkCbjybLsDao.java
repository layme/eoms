package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkCbjybLs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkCbjybLsDao")
public interface FaFmgkCbjybLsDao {
    /**
     * 获取单条记录
     * @param requestID
     * @return
     */
    List<FaFmgkCbjybLs> getByRequestID(@Param("requestID") String requestID);
}
