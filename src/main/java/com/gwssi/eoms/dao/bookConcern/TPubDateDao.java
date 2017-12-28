package com.gwssi.eoms.dao.bookConcern;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/20
 * Time: 19:59
 * Description:
 */
@Mapper
@Component(value = "tPubDate")
public interface TPubDateDao {
    /**
     * 获取当前最新的公布日
     * @return
     */
    String getPubDate();
}
