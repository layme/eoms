package com.gwssi.eoms.model.domain.bookConcern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 出版社办登校验表
 * Created by admin on 2017/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBdList {
    private String pubtype;  // 数据类型[FMGB,FMGZ,FMJM,FMSQ,WGGZ,WGSQ,XXGZ,XXJM,XXSQ]
    private String an;  // 申请号
    private String gbdsendtime;  // 公报袋发送时间
    private String gbdgettime;  // 公报袋接收时间
    private String zlxmsendtime;  // 著录项目发送时间
    private String zlxmgettime;  // 著录项目接收时间
    private Double bdresult;  // 办登校验结果
    private Double zlxmgetresult;  // 著录项接收结果
    private Double gbdgetresult;  // 公报袋接收结果
    private Double isfast;  // 加急标记
    private String bddate;  // 发送日
    private String sendername;  // 发送人员姓名
    private Double istesting;  // 本记录是否是测试数据，重要！
    private Double pflag;  // 0-E系统未扫描 1- E系统1次扫描   2-E系统2次扫描  3-历史数据  4-表示公布失效，公告视为放弃
    private Double islunxun;  // 轮询标记
}
