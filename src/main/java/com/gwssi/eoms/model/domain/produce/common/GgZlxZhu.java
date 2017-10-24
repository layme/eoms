package com.gwssi.eoms.model.domain.produce.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公告著录项主表
 * Created by admin on 2017/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgZlxZhu {
    private String shenqingh;  // 申请号 主键
    private String zhuanlimc;  // 专利名称
    private String zhuanliywmc;  // 专利英文名称
    private String zhuanlilx;  // 专利类型
    private String pctbj;  // pct标记
    private String shenqinfsbj;  // 申请方式标记
    private String daiyibj;  // 代译标记
    private String shenqingr;  // 申请日
    private String fenantjr;  // 分案提交日
    private String guobie;  // 国别
    private Double shenqingrsl;  // 申请人数量
    private Double famingrensl;  // 发明人数量
    private String lianxirbj;  // 联系人标记
    private String waiguancplb;  // 外观产品类别
    private String fenleihbbh;  // 分类号版本号
    private String zhufenlh;  // 主分类号
    private String dailibj;  // 代理标记
    private String fenanbj;  // 分案标记
    private String weishengwbcbj;  // 微生物保藏标记
    private String xuliebbj;  // 序列表标记
    private String tiqiangkbj;  // 提前公开标记
    private String shishenqqbj;  // 实审请求标记
    private Double youxianqqts;  // 优先权请求条数
    private String zuixiaoyxqr;  // 最小优先权日
    private String busangsxyxkxqsmbj;  // 不丧失新颖性宽限期声明标记
    private String baomiqqbj;  // 保密请求标记
    private String qianzhanghgbj;  // 签章合格标记
    private String tupianhgbj;  // 图片合格标记
    private String feiyongjhbj;  // 费用减缓标记
    private String pctfjbj;  // pct费减标记
    private String muanbj;  // 母案标记
    private String zaixiansqbj;  // 在先申请标记
    private Double quanliyqxs;  // 权利要求项数
    private String baomitxbj;  // 保密挑选标记
    private String guaqibj;  // 挂起标记
    private String zantingbj;  // 暂停标记
    private String zhongzhibj;  // 终止标记
    private String suodingbj;  // 锁定标记
    private String jiakuaibj;  // 加快标记
    private String shishenqqhgr;  // 实审请求合格日
    private String shishensxr;  // 实审生效日
    private String tiqiangkr;  // 提前公开日
    private String faminggbr;  // 发明公布日
    private String gongkaiggr;  // 公开公告日
    private String zhuanlih;  // 专利号
    private String anjianywzt;  // 案件业务状态
    private String chongfusqhbz;  // 重复授权后标志
    private String chongfusqqbz;  // 重复授权前标志
    private String youxiaobj;  // 有效标记
    private String regname;  // 注册人
    private String regtime;  // 注册时间
    private String modname;  // 修改人
    private String modtime;  // 修改标记
    private String shoulizkr;  // 受理转库日
    private String tongydfmczbj;  // 同日申请？
    private String xiangssjbj;  // 相似设计标记
    private String chengtcpbj;  // 成套产品标记
    private Double xiangssjxs;  // 相似设计项数
    private Double chengtcpxs;  // 成套产品项数
    private String yiczybj;  // 遗产资源标记
    private String xiangwsqbj;
    private String xiangwsqspbj;
    private String feizhengcsqysbj;  // 非正常申请疑似标记
    private String yxscfs;  // 优先审查方式
    private String zjzdzsqsxr;
    private String shenqingrenfqzdxgql;
    private String cafbj;  // 共同申请格式(CAF)请求标记
    private String yinanajhsbj;  // 疑难案件缓审标记
    private String dianzisqlx;  // 电子申请类型
    private String dljgnbbh;
    private String shengmingwtsyzbj;  // 声明与委托书一致标记
    private String zhaiyfth;  // 摘要附图号
    private String zhaiyaoftzd;  // 摘要附图
    private String dzzzjsqsxr;
    private String qianzhangnr;
}
