package com.gwssi.eoms.model.vo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/8
 * Time: 11:16
 * Description: 池异常数据分类计数视图类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCountVO {
    private String error;
    private Integer count;
}
