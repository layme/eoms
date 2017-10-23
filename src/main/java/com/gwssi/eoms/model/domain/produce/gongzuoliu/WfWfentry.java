package com.gwssi.eoms.model.domain.produce.gongzuoliu;

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
    private String id;  // 主键
    private String name;  // 流程名称
    private String state;  // 状态
    private String parent_id;  // 父节点ID
    private String sub_workflow_id;  // 子流程ID
    private String instance_id;  // 实例号
    private String main_id;  // 申请号
}
