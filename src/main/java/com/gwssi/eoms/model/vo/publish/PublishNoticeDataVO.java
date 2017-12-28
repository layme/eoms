package com.gwssi.eoms.model.vo.publish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/8
 * Time: 16:44
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishNoticeDataVO {
    private Integer allCount;
    private Integer successCount;
    private Integer failureCount;
    private Integer loseCount;
}
