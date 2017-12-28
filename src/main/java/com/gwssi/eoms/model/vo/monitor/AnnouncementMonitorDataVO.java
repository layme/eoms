package com.gwssi.eoms.model.vo.monitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 数据监控页面视图对象
 * by Lanym 2017年10月27日20:31:28
 */
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementMonitorDataVO {
    private Integer announcementCheckPoolError;  // 公告校验池异常
    private Integer announcementWaitAudit;  // 公告待审核
    private Integer announcementPoolError;  // 公告池异常

    private Integer checkSuccessError;  // 校验成功错误
    private Integer checkFailureError;  // 校验失败错误
    private Integer checkBackError;  // 校验反馈错误

    private Integer waitFee;  // 等年登印费，实际已缴费
    private Integer waitAnnouncement;  // 已用费待公告超过2周
    private Integer postOfficeHaveAnnouncementData;  // 出版社已经接收数据，但E系统数据不对
}
