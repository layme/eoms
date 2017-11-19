package com.gwssi.eoms.dao.bookConcern;

import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "tPubListDao")
public interface TPubListDao {
    /**
     * 获取单个申请号的具体信息
     * @param requestID
     * @return
     */
    List<TPubList> getByRequestID(@Param("requestID") String requestID);

    /**
     * 根据申请号获取出版社已经有数据的申请号列表
     * @param requestID
     * @return
     */
    List<String> getBookConcernHaveData(@Param("list") List<String> requestID);
}
