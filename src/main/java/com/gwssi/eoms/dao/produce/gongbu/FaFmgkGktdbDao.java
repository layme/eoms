package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkGktdb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 15:38
 * Description:
 */
@Mapper
@Component(value = "faFmgkGktdbDao")
public interface FaFmgkGktdbDao {
    /**
     *
     * @param shenqingh
     * @return
     */
    List<FaFmgkGktdb> getByRequestID(@Param("requestID") String requestID);
}
