package com.gwssi.eoms.model.domain.bookConcern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/27
 * Time: 9:28
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBdFeedBack {
    private String pubType;
    private String bdDate;
    private String errorID;
    private String an;
    private String content;
    private String informed;
    private String flag;
    private String temp;
    private String feedBackTime;
}
