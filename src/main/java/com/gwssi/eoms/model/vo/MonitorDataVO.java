package com.gwssi.eoms.model.vo;

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
public class MonitorDataVO {
    private Integer publishCheckPoolException;
    private String publishWaitAudit;
    private Integer publishPoolException;
    private Integer announcementCheckPoolException;
    private Integer announcementWaitAudit;
    private Integer announcementPoolException;
}
