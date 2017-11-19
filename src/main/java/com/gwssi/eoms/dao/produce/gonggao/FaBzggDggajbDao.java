package com.gwssi.eoms.dao.produce.gonggao;

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
public interface FaBzggDggajbDao {
    /**
     * 获取单条记录
     * @param requestID
     * @return
     */
    List<FaBzggDggajb> getByRequestID(@Param("requestID") String requestID);

    /**
     * 获取公告待审核异常总数
     * @return
     */
    Integer getAnnouncementWaitAuditCount();

    /**
     * 根据申请号删除案件
     * @param requestID
     */
    void deleteByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号插入单条数据
     * @param requestID
     */
    void insertOneByRequestID(@Param("requestID") String requestID);
}