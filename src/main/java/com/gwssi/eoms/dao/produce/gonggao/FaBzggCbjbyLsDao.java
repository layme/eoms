package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjbyLs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggCbjbyLsDao")
public interface FaBzggCbjbyLsDao {
    /**
     * 根据申请号查询案件列表
     * @param requestID
     * @return
     */
    List<FaBzggCbjbyLs> getByRequestID(@Param("requestID") String requestID);

    void deleteByRequestID(@Param("requestID") String requestID);
}
