package com.gwssi.eoms.service.publish;

import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;
import com.gwssi.eoms.service.common.BaseErrorFixService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/8
 * Time: 11:31
 * Description: 公布校验池异常服务接口
 */
public interface PublishCheckErrorFixService extends BaseErrorFixService {
    /**
     * 错误描述：
     * --著录项目提取错误
     * @param requestID
     */
    ErrorFixResultVO fixType_1(List<String> requestID);

    /**
     * 错误描述：
     * --取公布数据时错误
     * @param requestID
     */
    ErrorFixResultVO fixType_2(List<String> requestID);

    /**
     * 错误描述：
     * --公报袋提取错误
     * @param requestID
     */
    ErrorFixResultVO fixType_3(List<String> requestID);

    /**
     * 错误描述：
     * --公报袋提取失败
     * @param requestID
     */
    ErrorFixResultVO fixType_4(List<String> requestID);
}
