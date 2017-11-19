package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjyb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggCbjybDao")
public interface FaBzggCbjybDao {
    /**
     * 根据申请号获取案件列表
     * @param requestID
     * @return
     */
    List<FaBzggCbjyb> getByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号修改案件状态和校对结论
     * @param requestID
     * @param status
     * @param conclusion
     */
    void updateStatusAndConclusion(@Param("requestID") String requestID,
                                   @Param("status") String status,
                                   @Param("conclusion") String conclusion);
}
