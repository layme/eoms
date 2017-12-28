package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggDggajb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggDggajbDao")
public interface FaBzggDggajbDao extends BaseDao<FaBzggDggajb> {
    /**
     * 获取公告待审核异常总数
     * @return
     */
    Integer getAnnouncementWaitAuditCount();

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