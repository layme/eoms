package com.gwssi.eoms.model.domain.produce.gonggao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公告案件状态监控表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaBzggGgajztjk {
    private Double fa_bzgg_ggajztjk_id;  // 主键
    private String shenqingh;  // 申请号
    private String zhuanlilx;  // 专利类型
    private String shenqingr;  // 申请日
    private String gonggaozt;  // 公告状态
    private String yuguggr;  // 预估公告日
    private String gonggaor;  // 公告日
    private String zhufenleih;  // 主分类好
    private String bandengfwr;  // 办登发文日
    private String jinrujycsj;  // 进入校验池时间
    private String jiaoyanwcsj;  // 检验完成时间
    private String jiaoyanwcbj;  // 校验完成标记
    private String jinruggcsj;  // 进入公告池时间
    private String gonggaowcsj;  // 公告完成时间
    private String gonggaowcbj;  // 公告完成标记
    private String fenleiwcsj;  // 分类完成时间
    private String fenleiwcbj;  // 公告完成标记
    private String niandengyfjnr;  // 年登印费缴纳日
    private String shifangtzsfwr;  // 视放通知书发文日
    private String chushenyxm;  // 初审员姓名
    private String shishenyxm;  // 实审员姓名
    private String chushenybm;  // 初审员部门
    private String shishenybm;  // 实审员部门
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改时间
}
