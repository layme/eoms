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
    List<FaBzggCbjyb> getByShenqingh(@Param("shenqingh") String shenqingh);
}
