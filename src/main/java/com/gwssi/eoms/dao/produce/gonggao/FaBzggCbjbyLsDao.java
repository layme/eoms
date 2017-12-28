package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.dao.produce.BaseDao;
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
public interface FaBzggCbjbyLsDao extends BaseDao<FaBzggCbjbyLs> {
    /**
     * 出版社校验表转历史
     * @param requestID
     */
    void insertOneFrom_FABZGGCBJYB_ByRequestID(@Param("requestID") String requestID);
}
