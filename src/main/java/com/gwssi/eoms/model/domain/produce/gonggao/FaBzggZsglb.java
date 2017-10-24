package com.gwssi.eoms.model.domain.produce.gonggao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 证书管理表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaBzggZsglb {
    private Double fa_bzgg_zsglb_id;  // 主键
    private String shenqingh;  // 申请号
    private String zhuanlilx;  // 专利类型
    private String juanqih;  // 卷期号
    private String gonggaor;  // 公告日
    private String bandengfwr;  // 办登发文日
    private String niandengyfjnr;  // 年登印费缴纳日
    private String fenleiwcbj;  // 分类完成标记
    private String shifouwtaj;  // 是否问题案件
    private String zhuanzhengc;  // 转正常
    private String jiaoduizt;  // 校对状态
    private String tidangczy;  // 提档操作员
    private String caozuosj;  // 操作时间
    private String zhengshuh;  // 证书号
    private String fazhengr;  // 发证日
    private String zhuanlih;  // 专利号
    private String zhengshuysmjid;  // 证书页扫描件ID
    private Double zhengshuyys;  // 证书页页数
    private String wenjiancflj;  // 文件存放路径
    private String tuxingwjcflj;  // 图形文件存放路径
    private String zhengshuyscsj;  // 证书页生成时间
    private String fawenxlh;  // 发文序列号
    private String dailijgdm;  // 代理机构代码
    private String shoujianrxm;  // 收件人姓名
    private String shoujianrdz;  // 收件人地址
    private String shoujianryzbm;  // 收件人邮政编码
    private String zhengshuzt;  // 证书状态
    private String shenchaydm;  // 审查员代码
    private String shenchabm;  // 审查员部门
    private String shenchacsdm;  // 审查处室代码
    private String banzhengqrsj;  // 颁证确认时间
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改时间
    private String shouniannd;
    private Double fa_bzgg_ggajztjk_id;  // 公告案件状态监控表主键
    private String shenqingr;  // 申请日
    private String gonggaozt;  // 公告状态
    private String yuguggr;  // 预估公告日
    private String jinruggsj;  // 进入公告时间
    private String shifoutgjy;  // 是否跳过校验
    private String shujuxgbj;  // 数据修改标记
    private String zhuluxmtqsj;  // 著录项目提取时间
    private String gongbaodtqbj;  // 公报袋提取标记
    private String zhuluxmtqbj;  // 著录项目提取标记
    private String gongbaodtqwcsj;  // 公报袋提取完成时间
}
