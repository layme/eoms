package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.GkGbsqhpwj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/29
 * Time: 14:13
 * Description:
 */
@Mapper
@Component(value = "gkGbsqhpwjDao")
public interface GkGbsqhpwjDao extends BaseDao<GkGbsqhpwj> {
    /**
     * 删除指定类型的记录
     * @param requestID
     */
    void deleteByRequestIDAndCode(@Param("requestID") String requestID, @Param("code") String code);
}
