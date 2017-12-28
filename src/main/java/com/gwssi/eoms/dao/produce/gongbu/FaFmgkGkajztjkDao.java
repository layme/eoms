package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkGkajztjk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkGkajztjkDao")
public interface FaFmgkGkajztjkDao extends BaseDao<FaFmgkGkajztjk> {
    /**
     * 修改案件状态
     * @param requestID
     * @param status
     * @param pubDate
     */
    void updateStatusAndPubDateByRequestID(@Param("requestID") String requestID,
                                           @Param("status") String status,
                                           @Param("pubDate") String pubDate);

    /**
     * 获取状态为20，而待公开表里没记录
     * @return
     */
    Integer getWaitPublishIsNullCount();

    /**
     * 获取仅有提前公开标记的总数
     * @return
     */
    Integer getOnlyAdvanceMarkCount();

    /**
     * 获取出版社已有公布记录而E系统数据不对的总量
     * @return
     */
    Integer getBookConcernHavePubDataCount();

    /**
     * 获取提前公开日已过却未公开的案件总量
     * @return
     */
    Integer getAdvanceDatePassedCount();
}
