package com.gwssi.eoms.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/12
 * Time: 17:48
 * Description: 分类信息对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortInfoDTO {
    private String requestID;  // 申请号
    private String sortVersion;  // 分类号版本号
    private String mainSortNum;  // 主分类号
    private String viceSortNum;  // 副分类号
    private String attachSortNum;  // 附加分类号
    private boolean sortNumLengthEqualsVersionLength;  // 主分类号版本号是否为空
}
