package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.bookConcern.TBdFeedBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/27
 * Time: 9:30
 * Description:
 */
@Mapper
@Component(value = "tBdFeedBackDao")
public interface TBdFeedBackDao extends BaseDao<TBdFeedBack> {
    /**
     * 不要使用，没有对应SQL
     * @param requestID
     */
    @Deprecated
    @Override
    void deleteByRequestID(String requestID);

    /**
     * 根据申请号和办登时间查询错误原因
     * @param requestID
     * @return
     */
    String getErrorByRequestIDAndBdDate(@Param("requestID") String requestID, @Param("bdDate") String bdDate);
}
