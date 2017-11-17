package com.gwssi.eoms.dao.produce.procedure;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/11
 * Time: 17:44
 * Description: 存储过程执行DAO
 */
@Mapper
@Component(value = "procedureDao")
public interface ProcedureDao {
    /**
     * 公布数据备份
     * @param shenqingh
     */
    void invokePublishBackupProcedure(@Param("shenqingh") String shenqingh);

    /**
     * 公布数据撤件
     * @param shenqingh
     */
    void invokePublishRecallProcedure(@Param("shenqingh") String shenqingh);
}
