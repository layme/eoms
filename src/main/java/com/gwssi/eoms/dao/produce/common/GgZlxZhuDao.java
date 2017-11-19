package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.model.domain.produce.common.GgZlxZhu;
import com.gwssi.eoms.model.dto.PublishNoticeLoseDTO;
import com.gwssi.eoms.model.vo.PublishNoticeSuccessAndLoseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
@Component(value = "ggZlxZhuDao")
public interface GgZlxZhuDao {
    /**
     * 获取列表
     * @param requestID
     * @return
     */
    List<GgZlxZhu> getByRequestID(@Param("requestID") String requestID);

    /**
     * 查询公布公布及某期失效案件总数
     * @param gongkair
     * @return
     */
    Integer getPublishNoticeLoseCount(@Param("gongkair") String gongkair);

    /**
     * 查询失效案件列表
     * @param gongkair
     * @return
     */
    List<PublishNoticeLoseDTO> getPublishNoticeLoseList(@Param("gongkair") String gongkair);

    /**
     * 查询公布公布及某期发送成功且失效的案件列表
     * @param gongkair
     * @param tongzhisscrq
     * @return
     */
    List<PublishNoticeSuccessAndLoseVO> getPublishNoticeSuccessAndLoseList(@Param("gongkair") String gongkair, @Param("tongzhisscrq") String tongzhisscrq);
}
