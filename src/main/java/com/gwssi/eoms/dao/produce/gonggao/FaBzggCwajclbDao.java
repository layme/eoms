package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCwajclb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggCwajclbDao")
public interface FaBzggCwajclbDao {
    /**
     * 获取单条记录
     * @param shenqingh
     * @return
     */
    List<FaBzggCwajclb> getByShenqingh(@Param("shenqingh") String shenqingh);

    /**
     * 获取公告校验池异常总数
     * @return
     */
    Integer getAnnouncementCheckPoolExceptionCount();

    /**
     * 获取公告池异常总数
     * @return
     */
    Integer getAnnouncementPoolExceptionCount();
}
