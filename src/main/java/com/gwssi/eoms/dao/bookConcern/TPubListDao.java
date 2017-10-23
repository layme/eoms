package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
public interface TPubListDao {
    TPubList getTPubListByShenqingh(@Param("shenqingh") String shenqingh);
}
