package com.gwssi.eoms.dao.produce;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjbyLs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/29
 * Time: 11:32
 * Description: Dao类的父接口
 */
public interface BaseDao<T> {
    /**
     * 根据申请号查询案件列表
     * @param requestID
     * @return
     */
    List<T> listByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号删除全部记录，慎用！
     * @param requestID
     */
    void deleteByRequestID(@Param("requestID") String requestID);
}
