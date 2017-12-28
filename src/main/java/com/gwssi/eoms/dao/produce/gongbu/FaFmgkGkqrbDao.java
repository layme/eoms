package com.gwssi.eoms.dao.produce.gongbu;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.gongbu.FaFmgkGkqrb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 15:35
 * Description: 发明公开确认表DAO
 */
@Mapper
@Component(value = "faFmgkGkqrbDao")
public interface FaFmgkGkqrbDao extends BaseDao<FaFmgkGkqrb> {
    /**
     * 查询公布公布及某期应发总数
     * @param pubDate
     * @return
     */
    Integer getPublishNoticeAllCount(@Param("pubDate") String pubDate);

    /**
     * 查询公布公布及某期成功发出的总数
     * @param pubDate
     * @param noticeGenerationDate
     * @return
     */
    Integer getPublishNoticeSuccessCount(@Param("pubDate") String pubDate,
                                         @Param("list") List<String> noticeGenerationDate);

    /**
     * 查询公布公布及某期发送失败的总数
     * @param pubDate
     * @param noticeGenerationDate
     * @return
     */
    Integer getPublishNoticeFailureCount(@Param("pubDate") String pubDate, @Param("list") List<String> noticeGenerationDate);

    /**
     * 查询公布公布及某期发送失败的列表
     * @param pubDate
     * @param noticeGenerationDate
     * @return
     */
    List<String> getPublishNoticeFailureList(@Param("pubDate") String pubDate, @Param("list") List<String> noticeGenerationDate);

    /**
     * 根据申请号从监控和提档表里补数据
     * @param requestID
     */
    void insertOneByRequestIDFrom_JK_TDB(@Param("requestID") String requestID);

    /**
     * 用出版社表里的公布日替换确认表里的
     * @param requestID
     * @param pubDate
     */
    void updatePubDateFromPubList(@Param("requestID") String requestID, @Param("pubDate") String pubDate);
}
