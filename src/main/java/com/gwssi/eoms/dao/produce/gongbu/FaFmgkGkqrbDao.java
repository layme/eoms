package com.gwssi.eoms.dao.produce.gongbu;

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
public interface FaFmgkGkqrbDao {
    /**
     * 获取列表
     * @param shenqingh
     * @return
     */
    List<FaFmgkGkqrb> getByShenqingh(@Param("shenqingh") String shenqingh);

    /**
     * 查询公布公布及某期应发总数
     * @param gongkair
     * @return
     */
    Integer getPublishNoticeAllCount(@Param("gongkair") String gongkair);

    /**
     * 查询公布公布及某期成功发出的总数
     * @param gongkair
     * @param tongzhisscrq
     * @return
     */
    Integer getPublishNoticeSuccessCount(@Param("gongkair") String gongkair, @Param("tongzhisscrq") String tongzhisscrq);

    /**
     * 查询公布公布及某期发送失败的总数
     * @param gongkair
     * @param tongzhisscrq
     * @return
     */
    Integer getPublishNoticeFailureCount(@Param("gongkair") String gongkair, @Param("tongzhisscrq") String tongzhisscrq);

    /**
     * 查询公布公布及某期发送失败的列表
     * @param gongkair
     * @param tongzhisscrq
     * @return
     */
    List<String> getPublishNoticeFailureList(@Param("gongkair") String gongkair, @Param("tongzhisscrq") String tongzhisscrq);
}
