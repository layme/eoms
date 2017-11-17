package com.gwssi.eoms.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/17
 * Time: 12:50
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishNoticeLoseDTO {
    private String requestID;
    private String publishDate;
    private String step;
    private String status;
}
