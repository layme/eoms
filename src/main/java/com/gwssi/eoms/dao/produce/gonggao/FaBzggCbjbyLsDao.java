package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjbyLs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faBzggCbjbyLsDao")
public interface FaBzggCbjbyLsDao {
    List<FaBzggCbjbyLs> getByShenqingh(@Param("shenqingh") String shenqingh);
}
