package com.gwssi.eoms.model.vo.monitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/15
 * Time: 19:03
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishMonitorDataVO {
    private Integer publishCheckPoolError;  // 公布校验池异常
    private String publishWaitAudit;  // 公布待审核
    private Integer publishPoolError;  // 公布池异常

    private Integer checkSuccessError;  // 校验成功错误
    private Integer checkFailureError;  // 校验失败错误
    private Integer waitPublishIsNull;  // 待公开表没有数据

    private Integer onlyAdvanceMark;  // 仅有提前公开标记
    private Integer AdvanceDatePassed;  // 已过提前公开日却未公开
    private Integer bookConcernHavePublishData;  // 出版社已经接收数据，但E系统数据不对
}
