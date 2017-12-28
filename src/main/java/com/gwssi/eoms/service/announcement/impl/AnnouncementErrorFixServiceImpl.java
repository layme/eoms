package com.gwssi.eoms.service.announcement.impl;

import com.gwssi.eoms.dao.produce.gonggao.FaBzggCwajclbDao;
import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.service.announcement.AnnouncementErrorFixService;
import com.gwssi.eoms.service.common.Announcement.AnnouncementDataFixService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/11
 * Time: 16:49
 * Description:
 */
@Slf4j
@Service
public class AnnouncementErrorFixServiceImpl implements AnnouncementErrorFixService {
    @Autowired
    FaBzggCwajclbDao faBzggCwajclbDao;

    @Autowired
    AnnouncementDataFixService announcementDataFixService;

    /**
     * 批量处理公告池异常案件
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void batchUpdate11To9() {
        List<String> errorList = faBzggCwajclbDao.listAnnouncementPoolErrorRequestID();
        log.debug("errorList = " + errorList);
        if (!CollectionUtils.isEmpty(errorList)) {
            for (int i = 0; i < errorList.size(); i++) {
                announcementDataFixService.getDataMapByRequestID(errorList.get(i));  // 获取数据分布图
                announcementDataFixService.updateStatus_9(errorList.get(i));  // 修改状态为 9 已用费待公告
            }
        } else {
            log.debug("暂无公告池异常案件需要处理");
        }
    }
}
