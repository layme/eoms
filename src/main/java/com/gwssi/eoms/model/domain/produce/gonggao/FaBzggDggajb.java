package com.gwssi.eoms.model.domain.produce.gonggao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 待公告案件表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaBzggDggajb {
    private Double fa_bzgg_dggajb_id;  // 主键
    private Double fa_bzgg_ggajztjk_id;  // 公告案件状态监控表主键
    private String shenqingr;  // 申请日
    private String shenqingh;  // 申请号
    private String zhuanlilx;  // 专利类型
    private String yuguggr;  // 预估公告日
    private String gonggaozt;  // 公告状态
    private String zhufenleih;  // 主分类号
    private String shifoutgjy;  // 是否跳过校验
    private String bandengfwr;  // 办登发文日
    private String jinrujycsj;  // 进入检验处时间
    private String jiaoduijlwcsj;  // 校对结论完成时间
    private String songfenlsj;  // 送分类时间
    private String fenleiwcsj;  // 分类完成时间
    private String fenleiwcbj;  // 分类完成标记
    private String weiyongwjxx;  // 未用文件信息
    private String weiyongfyxx;  // 未用费用信息
    private String qitaycxx;  // 其他异常信息
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改时间
}
