package com.gwssi.eoms.dao.produce.gonggao;

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
public interface FaBzggGgajztjkDao {
    /**
     * 根据申请号查询案件列表
     * @param requestID
     * @return
     */
    List<FaBzggGgajztjk> getByRequestID(@Param("requestID") String requestID);

    /**
     * 修改案件状态
     * @param requestID
     * @param status
     * @param pubDate
     */
    void updateStatusByRequestID(@Param("requestID") String requestID, @Param("Status") String status, @Param("pubDate") String pubDate);
}
