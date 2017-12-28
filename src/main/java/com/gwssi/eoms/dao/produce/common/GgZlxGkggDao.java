package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.GgZlxGkgg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/29
 * Time: 11:30
 * Description:
 */
@Mapper
@Component(value = "ggZlxGkggDao")
public interface GgZlxGkggDao extends BaseDao<GgZlxGkgg> {
    /**
     * 删除指定类型的记录
     * @param requestID
     */
    void deleteByRequestIDAndCode(@Param("requestID") String requestID, @Param("code") String code);
}
