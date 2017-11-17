package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkDggajb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkDggajbDao")
public interface FaFmgkDggajbDao {
    /**
     * 获取单条记录
     * @param shenqingh
     * @return
     */
    FaFmgkDggajb getByShenqingh(@Param("shenqingh") String shenqingh);

    /**
     * 获取公布待审核异常总数 改版分类5天外
     * @return
     */
    Integer getPublishWaitAuditOut5Count();

    /**
     * 获取公布待审核异常总数 改版分类5天内
     * @return
     */
    Integer getPublishWaitAuditIn5Count();
}
