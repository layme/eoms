package com.gwssi.eoms.model.domain.bookConcern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by admin on 2017/10/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPubList {
    private String pubdate;
    private String pubtype;
    private String an;
    private String zlxmmodify;
    private String xmlmodify;
    private String predo;
    private String gbdsendtime;
    private String gbdgettime;
    private String zlxmsendtime;
    private String zlxmgettime;
    private String zlxmgetresult;
    private String gbdgetresult;
    private String sendername;
    private String istesting;
    private String issingle;
}
