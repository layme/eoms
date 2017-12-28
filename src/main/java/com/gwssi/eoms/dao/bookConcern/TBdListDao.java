package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.bookConcern.TBdList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/20
 * Time: 19:59
 * Description:
 */
@Mapper
@Component(value = "tBdListDao")
public interface TBdListDao extends BaseDao<TBdList> {
    /**
     * 不要使用，没有对应SQL
     * @param requestID
     */
    @Deprecated
    @Override
    void deleteByRequestID(@Param("requestID") String requestID);
}
