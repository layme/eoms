package com.gwssi.eoms.dao.produce.common;

import com.gwssi.eoms.dao.produce.BaseDao;
import com.gwssi.eoms.model.domain.produce.common.GgZlxFlh;
import com.gwssi.eoms.model.dto.SortInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/12
 * Time: 17:44
 * Description:
 */
@Mapper
@Component(value = "ggZlxFlhDao")
public interface GgZlxFlhDao extends BaseDao<GgZlxFlh> {
    /**
     * 根据申请号列表批量查询
     * @param requestID
     * @return
     */
    List<SortInfoDTO> listSortNumByRequestIDList(@Param("list") List<String> requestID);

    /**
     * 更新去重后的案件分类号
     * @param sortInfoDTO
     */
    void updateViceAndAttachSortNumBySortInfoDTO(@Param("sortInfoDTO") SortInfoDTO sortInfoDTO);
}
