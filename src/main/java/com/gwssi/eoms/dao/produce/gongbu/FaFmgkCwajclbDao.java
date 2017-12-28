package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkCwajclb;
import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */
@Mapper
@Component(value = "faFmgkCwajclbDao")
public interface FaFmgkCwajclbDao extends BaseDao<FaFmgkCwajclb> {
    /**
     * 获取公布校验池异常总数
     * @return
     */
    Integer getPublishCheckPoolErrorCount();

    /**
     * 获取公布池异常总数
     * @return
     */
    Integer getPublishPoolErrorCount();

    /**
     * 插入一条错误数据
     * @param requestID
     */
    void insertOneByRequestID(@Param("requestID") String requestID,
                              @Param("content") String content,
                              @Param("errorType") String errorType);

    /**
     * 获取异常数据的分组详情和描述
     * @return
     */
    List<ErrorCountVO> listErrorCountVO();

    /**
     * 根据错误描述查询申请号列表
     * @param error
     * @return
     */
    List<String> listRequestIDByError(@Param("error") String error);

    /**
     * 根据错误描述查询公布校验未通过总数
     * @param error
     * @return
     */
    Integer getPublishCheckNotPassCountByError(@Param("error") String error);

    /**
     * 根据错误描述查询申请号列表
     * @param error
     * @return
     */
    List<String> listPublishCheckNotPassCountByError(@Param("error") String error);
}
