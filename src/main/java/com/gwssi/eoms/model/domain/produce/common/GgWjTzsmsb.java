package com.gwssi.eoms.model.domain.produce.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通知书描述表
 * Created by admin on 2017/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgWjTzsmsb {
    private Double rid;  // 主键
    private String zhutilx;  // 主体类型
    private String yewuztbh;  // 业务主体编号
    private String weineibh;  // 委内编号
    private String tongzhislx;  // 通知书类型
    private String tongzhisscrq;  // 通知书生成日期
    private String wenjiancflj;  // 文件存放路径
    private String tuxingwjcflj;  // 图形文件存放路径
    private String tongzhiszwsmjid;  // 通知书正文扫描件ID
    private Double tongzhiszwys;  // 通知书正文页数
    private Double tongzhisfjsl;  // 通知书附件数量
    private String fawenr;  // 发文日
    private String shenchay;  // 审查员
    private String shenchabm;  // 审查部门
    private String shenchacsdm;  // 审查处室代码
    private String zixtdm;  // 子系统代码
    private String fawendybm;  // 发文打印部门
    private String dailijgdm;  // 代理机构代码
    private String shoujianrjs;  // 收件人js
    private String shoujianrxm;  // 收件人姓名
    private String shoujianrdz;  // 收件人地址
    private String shoujianryb;  // 收件人邮编
    private String fawenlx;  // 发文类型
    private String fawenxlh;  // 发文序列号
    private String tongzhiszt;  // 通知书状态
    private String bendirsbj;  // 本地软扫标记
    private String chejianbj;  // 撤件标记
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改时间
    private String dianzisqsjrid;
    private String rukuzt;  // 入库状态
    private String shujujrfs;  // 数据进入方式
    private String fasongr;  // 发送日
    private String xmlwenjiancflj;  // XML文件存放路径
}
