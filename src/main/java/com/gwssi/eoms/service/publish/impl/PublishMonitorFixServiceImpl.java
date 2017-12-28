package com.gwssi.eoms.service.publish.impl;

import com.gwssi.eoms.dao.produce.gongbu.FaFmgkCwajclbDao;
import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.service.common.publich.PublishDataFixService;
import com.gwssi.eoms.service.monitor.MonitorDataUpdateService;
import com.gwssi.eoms.service.publish.PublishMonitorFixService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/22
 * Time: 14:22
 * Description: 公布监控数据修改服务实现
 */
@Slf4j
@Service
public class PublishMonitorFixServiceImpl implements PublishMonitorFixService {
    @Autowired
    FaFmgkCwajclbDao faFmgkCwajclbDao;

    @Autowired
    PublishDataFixService publishDataFixService;

    @Autowired
    MonitorDataUpdateService monitorDataUpdateService;


    @Override
    public ErrorFixResultVO batchFixCheckSuccess() {
        log.debug("清理任务【batchFixCheckSuccess】开始运行");
        int failureCount = 0;
        List<String> requestIDs = faFmgkCwajclbDao.listPublishCheckNotPassCountByError("校验成功错误");
        if (!CollectionUtils.isEmpty(requestIDs)) {
            for (String requestID : requestIDs) {
                try {
                    publishDataFixService.getDataMapByRequestID(requestID);  // 获取数据分布图
                    publishDataFixService.updateStatus_20(requestID);  // 修改状态为20
                } catch (RuntimeException e) {
                    failureCount++;
                }
            }
            monitorDataUpdateService.updatePublishCheckSuccess();  // 更新公布校验成功错误数量
        }
        log.debug("清理任务【batchFixCheckSuccess】运行结束");
        return new ErrorFixResultVO(requestIDs.size() - failureCount, failureCount, "处理结束");
    }

    @Override
    public ErrorFixResultVO batchFixCheckFailure() {
        return null;
    }
}
