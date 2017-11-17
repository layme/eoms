package com.gwssi.eoms.dao.produce.common;

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
public interface WfCurrentstepDao {
    WfCurrentstep getByshenqingh(@Param("shenqingh") String shenqingh);

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
}
