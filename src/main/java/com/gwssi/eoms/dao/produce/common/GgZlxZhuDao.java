package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.GgZlxZhu;
import com.gwssi.eoms.model.dto.PublishNoticeLoseDTO;
import com.gwssi.eoms.model.vo.publish.PublishNoticeSuccessAndLoseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */
@Mapper
@Component(value = "ggZlxZhuDao")
public interface GgZlxZhuDao extends BaseDao<GgZlxZhu> {
    /**
     * 查询公布公布及某期失效案件总数
     * @param pubDate
     * @return
     */
    Integer getPublishNoticeLoseCount(@Param("pubDate") String pubDate);

    /**
     * 查询失效案件列表
     * @param pubDate
     * @return
     */
    List<PublishNoticeLoseDTO> getPublishNoticeLoseList(@Param("pubDate") String pubDate);

    /**
     * 查询公布公布及某期发送成功且失效的案件列表
     * @param pubDate
     * @param noticeGenerationDate
     * @return
     */
    List<PublishNoticeSuccessAndLoseVO> getPublishNoticeSuccessAndLoseList(@Param("pubDate") String pubDate, @Param("list") List<String> noticeGenerationDate);
}
