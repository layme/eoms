package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.WfCurrentstep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
@Component(value = "wfCurrentstepDao")
public interface WfCurrentstepDao extends BaseDao<WfCurrentstep> {
    /**
     * 批量删除申请号指定的当前工作流
     * @param list
     * @param name
     */
    void deleteByRequestIdListAndName(@Param("list") List<String> list, @Param("name") String name);

    /**
     * 批量插入申请号指定的当前工作流
     * @param list
     * @param name
     */
    void insertByRequestIdListAndName(@Param("list") List<String> list, @Param("name") String name,
                                      @Param("step_id") String step_id, @Param("status") String status);

    /**
     * 修改工作流
     * @param requestID
     * @param name
     * @param stepID
     * @param status
     */
    void updateStepIDAndStatusByRequestAndName(@Param("requestID") String requestID,
                                               @Param("name") String name,
                                               @Param("stepID") String stepID,
                                               @Param("status") String status);
}
