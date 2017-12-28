package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.FwZlzsFwxx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/18
 * Time: 11:13
 * Description: 证书发文表 DAO
 */
@Mapper
@Component(value = "fwZlzsFwxxDao")
public interface FwZlzsFwxxDao extends BaseDao<FwZlzsFwxx> {
    /**
     * 获取发文出已经发文而一元化数据状态不对的总量
     * @return
     */
    Integer getPostOfficeHaveAnnouncementDataCount(@Param("sendDate") String sendDate);
}
