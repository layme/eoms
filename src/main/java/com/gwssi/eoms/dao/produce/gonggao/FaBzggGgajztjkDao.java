package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggGgajztjk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggGgajztjkDao")
public interface FaBzggGgajztjkDao extends BaseDao<FaBzggGgajztjk> {
    /**
     * 修改案件状态
     * @param requestID
     * @param status
     * @param conclusion
     * @param pubDate
     */
    void updateStatusAndPubDateByRequestID(@Param("requestID") String requestID,
                                           @Param("status") String status,
                                           @Param("conclusion") String conclusion,
                                           @Param("pubDate") String pubDate);

    /**
     * 获取等年登印费（实际已缴费）的案件总量
     * @return
     */
    Integer getWaitFeeCount();

    /**
     * 获取已用费待公告案件总量，公告状态为9
     * @return
     */
    Integer getWaitAnnouncementCount();
}
