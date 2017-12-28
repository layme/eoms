package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/20
 * Time: 19:59
 * Description:
 */
@Mapper
@Component(value = "tPubListDao")
public interface TPubListDao extends BaseDao<TPubList> {
    /**
     * 不要使用，没有对应SQL
     * @param requestID
     */
    @Deprecated
    @Override
    void deleteByRequestID(@Param("requestID")String requestID);

    /**
     * 获取授权信息
     * @param requestID
     * @return
     */
    List<TPubList> getSQByRequestID(@Param("requestID") String requestID);

    /**
     * 获取公布信息
     * @param requestID
     * @return
     */
    List<TPubList> getGBByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号获取出版社已经有数据的申请号列表
     * @param requestID
     * @return
     */
    List<String> getBookConcernHaveData(@Param("list") List<String> requestID);
}
