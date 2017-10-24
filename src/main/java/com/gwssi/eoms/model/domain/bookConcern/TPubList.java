package com.gwssi.eoms.model.domain.bookConcern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 出版社公告列表 对应主表“公告封卷”案件
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPubList {
    private String pubdate;  // 公告日
    private String pubtype;  // 数据类型[FMGB,FMGZ,FMJM,FMSQ,WGGZ,WGSQ,XXGZ,XXJM,XXSQ]
    private String an;  // 申请号
    private Double zlxmmodify;  // 著录项目是否修改的标记【更正，解密类型不用标记此字段】
    private Double xmlmodify;  // 全文是否修改的标记【更正，解密类型不用标记此字段】
    private Double predo;  // 办登合格为1,办登不合格为0，未经过办登为-1. 解密和更正此字段总是-1.
    private String gbdsendtime;  // 公报袋发送时间
    private String gbdgettime;  // 公报袋接收时间
    private String zlxmsendtime;  // 著录项目发送时间
    private String zlxmgettime;  // 著录项目接收时间
    private Double zlxmgetresult;  // 著录项目接收是否成功，1是成功，-1是失败
    private Double gbdgetresult;  // 公报袋接收是否成功，1是成功，-1是失败
    private String sendername;  // 发送方人员姓名
    private Double istesting;  // 是否为测试记录
    private Double issingle;  // 是否是单件数据(对应t_pub_info_single表),和批量数据(对应t_pub_info表)进行区分.
}
