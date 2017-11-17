package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.model.domain.bookConcern.TBdList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "tBdListDao")
public interface TBdListDao {
    List<TBdList> getByShenqingh(@Param("shenqingh") String shenqingh);
}
