package com.gwssi.eoms.model.domain.produce.gonggao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误案件处理表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaBzggCwajclb {
    private Double fa_bzgg_cwajclb_id;  // 主键
    private Double fa_bzgg_ggajztjk_id;  // 公告案件状态监控表主键
    private String shenqingh;  // 申请号
    private String shenqingr;  // 申请日
    private String zhuanlilx;  // 专利类型
    private String gonggaozt;  // 公告状态
    private String zhufenleih;  // 主分类号
    private String yuguggr;  // 预估公告日
    private String gonggaor;  // 公告日
    private String bandengfwr;  // 办登发问日
    private String jinrujycsj;  // 进入校验处时间
    private String jinruggsj;  // 进入公告时间
    private String cuowujrsj;  // 错误进入时间
    private String cuowumx;  // 错误描述
    private String cuowuzl;  // 错误种类
    private String chushenyxm;  // 初审员姓名
    private String shishenyxm;  // 实审员姓名
    private String chushenybm;  // 初审员部门
    private String shushenybm;  // 实审员部门
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改时间
    private String chulizt;  // 处理状态
    private String renlingr;  // 认领人
}
