package com.gwssi.eoms.dao.produce.gonggao;

import com.gwssi.eoms.dao.produce.BaseDao;
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
public interface FaBzggCwajclbDao extends BaseDao<FaBzggCwajclb> {
    /**
     * 获取公告校验池异常总数
     * @return
     */
    Integer getAnnouncementCheckPoolErrorCount();

    /**
     * 获取公告池异常总数
     * @return
     */
    Integer getAnnouncementPoolErrorCount();

    /**
     * 获取公告池异常申请号序列
     * @return
     */
    List<String> listAnnouncementPoolErrorRequestID();

    /**
     * 插入一条错误数据
     * @param requestID
     */
    void insertOneByRequestID(@Param("requestID") String requestID,
                              @Param("content") String content,
                              @Param("errorType") String errorType);

    /**
     * 根据错误描述查询案件总量
     * @param error
     * @return
     */
    Integer getAnnouncementCheckNotPassCountByError(@Param("error") String error);
}
