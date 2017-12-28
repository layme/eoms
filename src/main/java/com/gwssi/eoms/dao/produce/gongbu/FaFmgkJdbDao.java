package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkJdb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 15:39
 * Description:
 */
@Mapper
@Component(value = "faFmgkJdbDao")
public interface FaFmgkJdbDao extends BaseDao<FaFmgkJdb> {
    /**
     * 修改校对结论
     * @param requestID
     * @param conclusion
     */
    void updateConclusionByRequestID(@Param("requestID") String requestID, @Param("conclusion") String conclusion);

    /**
     * 从历史恢复数据
     * @param requestID
     */
    void insertOneFrom_FAFMGKJDBLS_ByRequestID(@Param("requestID") String requestID);
}
