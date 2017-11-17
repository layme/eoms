package com.gwssi.eoms.service.impl;

import com.gwssi.eoms.dao.bookConcern.TPubListDao;
import com.gwssi.eoms.dao.produce.common.GgZlxZhuDao;
import com.gwssi.eoms.dao.produce.common.WfCurrentstepDao;
import com.gwssi.eoms.dao.produce.common.WfWfentryDao;
import com.gwssi.eoms.dao.produce.gongbu.FaFmgkGkqrbDao;
import com.gwssi.eoms.dao.produce.procedure.ProcedureDao;
import com.gwssi.eoms.model.dto.PublishNoticeLoseDTO;
import com.gwssi.eoms.model.vo.PublishNoticeDataVO;
import com.gwssi.eoms.model.vo.PublishNoticeRepairResultVO;
import com.gwssi.eoms.model.vo.PublishNoticeSuccessAndLoseVO;
import com.gwssi.eoms.service.PublishNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/10
 * Time: 18:01
 * Description:
 */
@Slf4j
@Service
public class PublishNoticeServiceImpl implements PublishNoticeService {
    @Autowired
    FaFmgkGkqrbDao faFmgkGkqrbDao;

    @Autowired
    GgZlxZhuDao ggZlxZhuDao;

    @Autowired
    TPubListDao tPubListDao;

    @Autowired
    WfWfentryDao wfWfentryDao;

    @Autowired
    WfCurrentstepDao wfCurrentstepDao;

    @Autowired
    ProcedureDao procedureDao;

    /**
     * 获取公布公布及通知书的各个数据项
     *
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @Override
    public PublishNoticeDataVO getPublishNoticeData(String publishDate, String noticeGenerationDate) {
        return new PublishNoticeDataVO(faFmgkGkqrbDao.getPublishNoticeAllCount(publishDate),
                faFmgkGkqrbDao.getPublishNoticeSuccessCount(publishDate, noticeGenerationDate),
                faFmgkGkqrbDao.getPublishNoticeFailureCount(publishDate, noticeGenerationDate),
                ggZlxZhuDao.getPublishNoticeLoseCount(publishDate));
    }

    /**
     * 获取发送成功且失效的案件列表
     *
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @Override
    public List<PublishNoticeSuccessAndLoseVO> getPublishNoticeSuccessAndLoseList(String publishDate, String noticeGenerationDate) {
        return ggZlxZhuDao.getPublishNoticeSuccessAndLoseList(publishDate, noticeGenerationDate);
    }

    /**
     * 未成功发送公布公布及的实际处理过程
     * --出版社已接收到数据的，修改工作流为1906S01
     * --出版社未接收到数据的，备份后撤件，且修改工作流为1901S00
     *
     * @param publishDate
     * @param noticeGenerationDate
     * @return
     */
    @Override
    public PublishNoticeRepairResultVO oneKeyRepairPublishNotice(String publishDate, String noticeGenerationDate) {
        List<String> failureList = null;  // 未能成功发出公布公布及的列表
        List<String> inBookConcernList = null;  // 出版社已经接收数据的列表
        List<String> outBookConcernList = null;  // 出版社没接收到数据的列表

        // 拆分出出版社接收到数据和未接收到数据的列表
        failureList = faFmgkGkqrbDao.getPublishNoticeFailureList(publishDate, noticeGenerationDate);
        log.debug("公布和公布及通知书发送失败的案件 = " + failureList.toString());

        PublishNoticeRepairResultVO publishNoticeRepairResultVo = new PublishNoticeRepairResultVO(0, 0, false, false);

        if (!CollectionUtils.isEmpty(failureList)) {
            inBookConcernList = tPubListDao.getBookConcernHaveData(failureList);
            try {
                log.debug("出版社收到数据 = " + inBookConcernList.toString());
                publishNoticeRepairResultVo.setInBookConcern(inBookConcernList.size());
            } catch (NullPointerException e) {
                publishNoticeRepairResultVo.setInBookConcern(0);
                e.printStackTrace();
            }
            if (!CollectionUtils.isEmpty(inBookConcernList)) {
                outBookConcernList = (List<String>) CollectionUtils.subtract(failureList, inBookConcernList);
                try {
                    log.debug("出版社未收到数据 = " + outBookConcernList.toString());
                    publishNoticeRepairResultVo.setOutBookConcern(outBookConcernList.size());
                } catch (NullPointerException e) {
                    publishNoticeRepairResultVo.setOutBookConcern(0);
                    e.printStackTrace();
                }
            }
        }

        return repairPublishNoticeTransactional(publishNoticeRepairResultVo, inBookConcernList, outBookConcernList);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public PublishNoticeRepairResultVO repairPublishNoticeTransactional(PublishNoticeRepairResultVO publishNoticeRepairResultVo,
                                                                        List<String> inBookConcernList,
                                                                        List<String> outBookConcernList) {
        // 处理出版社有数据的
        if (!CollectionUtils.isEmpty(inBookConcernList)) {
            this.repairInBookConcernList(inBookConcernList);
            publishNoticeRepairResultVo.setInRepairResult(true);
        }

        // 处理出版社没有数据的
        if (!CollectionUtils.isEmpty(outBookConcernList)) {
            this.repairOutBookConcernList(outBookConcernList);
            publishNoticeRepairResultVo.setOutRepairResult(true);
        }

        log.debug("publishNoticeRepairResultVo = " + publishNoticeRepairResultVo.toString());
        return publishNoticeRepairResultVo;
    }

    /**
     * 出版社有数据案件直接修改工作流为1906S01
     *
     * @param list
     */
    private void repairInBookConcernList(List<String> list) {
        // 先删后插，确保19段数据唯一
        wfWfentryDao.deleteByRequestIdListAndName(list, "19");
        wfWfentryDao.insertByRequestIdListAndName(list, "19");
        // 先删后插，确保数据唯一
        wfCurrentstepDao.deleteByRequestIdListAndName(list, "19");
        wfCurrentstepDao.insertByRequestIdListAndName(list, "19", "1906", "1906S01");
    }

    /**
     * 出版社没有数据的，执行备份然后撤件，再修改工作流为1901S00
     *
     * @param list
     */
    private void repairOutBookConcernList(List<String> list) {
        for (String id : list) {
            procedureDao.invokePublishBackupProcedure(id);  // 执行备份存储过程
            procedureDao.invokePublishRecallProcedure(id);  // 执行撤件存储过程
        }

        // 先删后插，确保19段数据唯一
        wfWfentryDao.deleteByRequestIdListAndName(list, "19");
        wfWfentryDao.insertByRequestIdListAndName(list, "19");

        // 先删后插，确保数据唯一
        wfCurrentstepDao.deleteByRequestIdListAndName(list, "19");
        wfCurrentstepDao.insertByRequestIdListAndName(list, "19", "1901", "1901S00");
    }

    /**
     * 导出公布和公布及失效案件xls文件
     */
    @Override
    public void getPublishNoticeLoseXls(String publishDate, HttpServletResponse httpServletResponse) {
        List<PublishNoticeLoseDTO> loseList = ggZlxZhuDao.getPublishNoticeLoseList(publishDate);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet();
        HSSFRow row = sheet.createRow(0);

        // 制作表头
        HSSFCell cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("申请号");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("发明公布日");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("审查阶段");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("审查状态");

        // 遍历list，写入xls
        for (int i = 1; i <= loseList.size(); i++) {
            row = sheet.createRow(i);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(loseList.get(i-1).getRequestID());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(loseList.get(i-1).getPublishDate());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(loseList.get(i-1).getStep());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(loseList.get(i-1).getStatus());

        }

        OutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();
            String fileName = publishDate + "公布和公布及通知书失效案件.xls";
            httpServletResponse.setContentType("application/vnd..ms-excel");
            httpServletResponse.setHeader("content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            hssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
