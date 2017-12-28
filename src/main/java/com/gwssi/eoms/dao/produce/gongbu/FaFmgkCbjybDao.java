package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkCbjyb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkCbjybDao")
public interface  FaFmgkCbjybDao extends BaseDao<FaFmgkCbjyb> {
    /**
     * 根据申请号修改案件状态和校对结论
     * @param requestID
     * @param status
     * @param conclusion
     */
    void updateStatusAndConclusionByRequestID(@Param("requestID") String requestID,
                                   @Param("status") String status,
                                   @Param("conclusion") String conclusion);

    /**
     * 从历史恢复数据
     * @param requestID
     */
    void insertOneFrom_FAFMGKCBJYBLS_ByRequestID(@Param("requestID") String requestID);
}
