package com.gwssi.eoms.model.vo.announcement;

import com.gwssi.eoms.model.domain.bookConcern.TBdList;
import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import com.gwssi.eoms.model.domain.produce.common.GgZlxZhu;
import com.gwssi.eoms.model.domain.produce.gonggao.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 视图对象，包含各个表的数据
 * Created by admin on 2017/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDataMapVO {
    private List<GgZlxZhu> ggZlxZhu;  // 公共著录项主表
    private List<FaBzggGgajztjk> faBzggGgajztjk;  // 公告案件状态监控表
    private List<FaBzggCbjyb> faBzggCbjyb;  // 出版检验表
    private List<FaBzggCbjbyLs> faBzggCbjbyLs;  // 出版校验历史表
    private List<FaBzggDggajb> faBzggDggajb;  // 待公告案件表
    private List<FaBzggCwajclb> faBzggCwajclb;  // 错误案件处理表
    private List<FaBzggZsglb> faBzggZsglb;  // 证书管理表
    private List<FaBzggBfzsb> faBzggBfzsb;  // 颁发证书表
    private List<TBdList> tBdList;  // 办登校验表
    private List<TPubList> tPubList;  // 出版社公告表
}
