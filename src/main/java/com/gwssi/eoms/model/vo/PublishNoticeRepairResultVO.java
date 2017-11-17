package com.gwssi.eoms.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/11
 * Time: 18:06
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishNoticeRepairResultVO {
    private int inBookConcern;
    private int outBookConcern;
    private Boolean inRepairResult;
    private Boolean outRepairResult;
}
