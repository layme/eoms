package com.gwssi.eoms.model.domain.produce.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工作流当前步骤表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WfCurrentstep {
    private Double id;  // 主键
    private Double entry_id;  // 工作流ID
    private String step_id;  // 步骤ID
    private String action_id;  // 动作ID
    private String owner;  // 所有者
    private String start_date;  // 开始时间
    private String finish_date;  // 结束时间
    private String due_date;
    private String status;  // 有效标志
    private String caller;  // 调用者
    private String previous_id;
}
