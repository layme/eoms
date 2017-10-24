package com.gwssi.eoms.model.vo;

import com.gwssi.eoms.model.domain.bookConcern.TBdList;
import com.gwssi.eoms.model.domain.bookConcern.TPubList;
import com.gwssi.eoms.model.domain.produce.common.GgZlxZhu;
import com.gwssi.eoms.model.domain.produce.gonggao.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 视图对象，包含各个表的数据
 * Created by admin on 2017/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllDataItem {
    private GgZlxZhu ggZlxZhu;  // 公共著录项主表
    private FaBzggGgajztjk faBzggGgajztjk;  // 公告案件状态监控表
    private FaBzggCbjyb faBzggCbjyb;  // 出版检验表
    private FaBzggCbjbyLs faBzggCbjbyLs;  // 出版校验历史表
    private FaBzggDggajb faBzggDggajb;  // 待公告案件表
    private FaBzggCwajclb faBzggCwajclb;  // 错误案件处理表
    private FaBzggZsglb faBzggZsglb;  // 证书管理表
    private FaBzggBfzsb faBzggBfzsb;  // 颁发证书表
    private TBdList tBdList;  // 办登校验表
    private TPubList tPubList;  // 出版社公告表

    public AllDataItem(
            GgZlxZhu ggZlxZhu,
            FaBzggGgajztjk faBzggGgajztjk,
            FaBzggCbjyb faBzggCbjyb,
            FaBzggCbjbyLs faBzggCbjbyLs,
            FaBzggDggajb faBzggDggajb,
            FaBzggCwajclb faBzggCwajclb,
            FaBzggZsglb faBzggZsglb,
            FaBzggBfzsb faBzggBfzsb,
            TBdList tBdList,
            TPubList tPubList
    ) {
        this.ggZlxZhu = ggZlxZhu;
        this.faBzggGgajztjk = faBzggGgajztjk;
        this.faBzggCbjyb = faBzggCbjyb;
        this.faBzggCbjbyLs = faBzggCbjbyLs;
        this.faBzggDggajb = faBzggDggajb;
        this.faBzggCwajclb = faBzggCwajclb;
        this.faBzggZsglb = faBzggZsglb;
        this.faBzggBfzsb = faBzggBfzsb;
        this.tBdList = tBdList;
        this.tPubList = tPubList;
    }
}
