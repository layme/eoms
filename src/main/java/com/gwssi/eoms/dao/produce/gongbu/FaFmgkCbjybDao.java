package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkCbjyb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkCbjybDao")
public interface FaFmgkCbjybDao {
    /**
     * 获取单条记录
     * @param shenqingh
     * @return
     */
    FaFmgkCbjyb getByShenqingh(@Param("shenqingh") String shenqingh);
}