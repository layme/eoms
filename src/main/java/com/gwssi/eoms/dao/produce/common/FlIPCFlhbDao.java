package com.gwssi.eoms.dao.produce.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/13
 * Time: 17:45
 * Description:
 */
@Mapper
@Component(value = "flIPCFlhbDao")
public interface FlIPCFlhbDao {
    /**
     * 根据批量的分类号获取版本号
     * @param sortNum
     * @return
     */
    List<String> listSortVersionBySortNumList(@Param("list") List<String> sortNum);

    /**
     * 根据分类号查询对应的版本号
     * @param sortNum
     * @return
     */
    String getOneBySortNum(@Param("sortNum") String sortNum);
}
