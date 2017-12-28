package com.gwssi.eoms.service.publish;

import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 14:03
 * Description: 公布监控数据修改接口
 */
public interface PublishMonitorFixService {
    /**
     * 批量处理校验成功错误
     * @return
     */
    ErrorFixResultVO batchFixCheckSuccess();

    /**
     * 批量处理校验失败错误
     * @return
     */
    ErrorFixResultVO batchFixCheckFailure();
}
