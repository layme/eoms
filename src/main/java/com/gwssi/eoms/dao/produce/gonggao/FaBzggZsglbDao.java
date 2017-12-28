package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggZsglb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggZsglbDao")
public interface FaBzggZsglbDao extends BaseDao<FaBzggZsglb> {
    /**
     * 根据申请号补入证书管理表数据
     * @param requestID
     */
    void insertOneByRequestID(@Param("requestID") String requestID);

    /**
     * 修改公告状态和证书状态
     * @param requestID
     * @param status
     * @param pubDate
     * @param noticeStatus
     */
    void updatePubStatusAndPubDateAndNoticeStatusByRequestID(@Param("requestID") String requestID,
                                              @Param("pubStatus") String status,
                                              @Param("pubDate") String pubDate,
                                              @Param("noticeStatus") String noticeStatus);

}
