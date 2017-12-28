package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkDggajb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkDggajbDao")
public interface FaFmgkDggajbDao extends BaseDao<FaFmgkDggajb> {
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

    /**
     * 根据申请号插入单条数据
     * @param requestID
     */
    void insertOneByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号修改公告状态
     * @param requestID
     */
    void updatePubStatusByRequestID(@Param("requestID") String requestID, @Param("pubStatus") String pubStatus);
}
