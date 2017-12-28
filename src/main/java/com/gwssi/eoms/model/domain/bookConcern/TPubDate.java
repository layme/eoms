package com.gwssi.eoms.model.domain.bookConcern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/20
 * Time: 19:58
 * Description: 出版社公布日期表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPubDate {
    private String pubdate;
    private Double isvalid;
    private Double readno;
    private String readtime;
    private String rectime;
    private String rectype;
}
