package com.gwssi.eoms.model.vo.publish;

import com.gwssi.eoms.model.domain.bookConcern.TBdList;
import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import com.gwssi.eoms.model.domain.produce.common.GgZlxZhu;
import com.gwssi.eoms.model.domain.produce.gongbu.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/28
 * Time: 15:18
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishDataMapVO {
    private List<GgZlxZhu> ggZlxZhu;  // 公共著录项主表
    private List<FaFmgkGkajztjk> faFmgkGkajztjk;  // 公开监控表
    private List<FaFmgkCbjyb> faFmgkCbjyb;  // 校验表
    private List<FaFmgkCbjybLs> faFmgkCbjybLs;  // 检验历史表
    private List<FaFmgkDggajb> faFmgkDggajb;  // 待公布案件表
    private List<FaFmgkJdb> faFmgkJdb;  // 校对表
    private List<FaFmgkJdbLs> faFmgkJdbLs;  // 校对历史表
    private List<FaFmgkCwajclb> faFmgkCwajclb;  // 错误记录表
    private List<FaFmgkGktdb> faFmgkGktdb;  // 公开提档表
    private List<TBdList> tBdList;  // 出版社办登校验记录表
    private List<FaFmgkGkqrb> faFmgkGkqrb;  // 公开确认表
    private List<TPubList> tPubList;  // 出版社记录表
}
