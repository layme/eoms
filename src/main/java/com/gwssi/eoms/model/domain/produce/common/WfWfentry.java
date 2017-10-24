package com.gwssi.eoms.model.domain.produce.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工作流引擎表
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WfWfentry {
    private Double id;  // 主键
    private String name;  // 流程名称
    private Double state;  // 状态
    private Double parent_id;  // 父节点ID
    private String sub_workflow_id;  // 子流程ID
    private Double instance_id;  // 实例号
    private String main_id;  // 申请号
}
