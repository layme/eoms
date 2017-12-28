package com.gwssi.eoms.model.vo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/14
 * Time: 11:19
 * Description: 处理结果视图类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorFixResultVO {
    private Integer successCount;
    private Integer failureCount;
    private String message;
}
