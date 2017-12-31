package com.gwssi.eoms.service.announcement.impl;

import com.gwssi.eoms.dao.bookConcern.TBdFeedBackDao;
import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import com.gwssi.eoms.dao.bookConcern.TPubDateDao;
import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.GgZlxZhuDao;
import com.gwssi.eoms.dao.produce.common.WfCurrentstepDao;
import com.gwssi.eoms.dao.produce.gonggao.*;
import com.gwssi.eoms.exception.DataMissingException;
import com.gwssi.eoms.exception.DataMoreException;
import com.gwssi.eoms.model.vo.announcement.AnnouncementDataMapVO;
import com.gwssi.eoms.service.announcement.AnnouncementDataMapService;
import com.gwssi.eoms.service.common.Announcement.AnnouncementDataFixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by admin on 2017/10/24.
 */
@Slf4j
@Service
public class AnnouncementDataMapServiceImpl implements AnnouncementDataMapService {
    @Autowired
    AnnouncementDataFixService announcementDataFixService;

    @Override
    public AnnouncementDataMapVO getDataMapByRequestID(String requestID) {
        return announcementDataFixService.getDataMapByRequestID(requestID);
    }

    /**
     * 一键修改案件状态
     *
     * @param requestID
     * @param status
     * @return
     */
    @Override
    public void fixDistribution(String requestID, String status) {
        switch (status) {
            case "6":
                announcementDataFixService.updateStatus_6(requestID);  // 修改状态为6 -校验未通过
                break;
            case "8":
                announcementDataFixService.updateStatus_8(requestID);  // 修改状态为8 -公告待审核
                break;
            case "9":
                announcementDataFixService.updateStatus_9(requestID);  // 修改状态为9 -已用费待公告
                break;
            case "10":
                announcementDataFixService.updateStatus_10(requestID);  // 修改状态为10 -公告数据已提取
                break;
            case "20":
                announcementDataFixService.updateStatus_20(requestID);  // 修改状态为20 -等年登印费
                break;
            default:
                throw new IllegalArgumentException("未知的目标公告状态");
        }
    }
}
