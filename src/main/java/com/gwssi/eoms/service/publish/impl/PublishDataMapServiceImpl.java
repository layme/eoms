package com.gwssi.eoms.service.publish.impl;

import com.gwssi.eoms.dao.bookConcern.TBdFeedBackDao;
import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubDateDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.*;
import com.gwssi.eoms.dao.produce.gongbu.*;
import com.gwssi.eoms.exception.DataMissingException;
import com.gwssi.eoms.exception.DataMoreException;
import com.gwssi.eoms.model.vo.publish.PublishDataMapVO;
import com.gwssi.eoms.service.common.publich.PublishDataFixService;
import com.gwssi.eoms.service.publish.PublishDataMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/28
 * Time: 15:35
 * Description: 公布数据分布图及数据修分发实现
 */
@Slf4j
@Service
public class PublishDataMapServiceImpl implements PublishDataMapService {
    @Autowired
    PublishDataFixService publishDataFixService;

    @Override
    public PublishDataMapVO getDataMapByRequestID(String requestID) {
        return publishDataFixService.getDataMapByRequestID(requestID);
    }

    @Override
    public void fixDistribution(String requestID, String status) {
        switch (status) {
            case "6":
                publishDataFixService.updateStatus_6(requestID);  // 修改状态为6 -校验未通过
                break;
            case "8":
                publishDataFixService.updateStatus_8(requestID);  // 修改状态为8 -公告待审核
                break;
            case "9":
                publishDataFixService.updateStatus_9(requestID);  // 修改状态为9 -已用费待公告
                break;
            case "10":
                publishDataFixService.updateStatus_10(requestID);  // 修改状态为10 -公告数据已提取
                break;
            case "20":
                publishDataFixService.updateStatus_20(requestID);  // 修改状态为20 -等公开期限
                break;
            default:
                throw new IllegalArgumentException("未知的目标公布状态");
        }
    }
}
