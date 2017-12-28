package com.gwssi.eoms.service.common;

import com.gwssi.eoms.model.vo.common.ErrorCountVO;
import com.gwssi.eoms.model.vo.common.ErrorFixResultVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/12/8
 * Time: 11:35
 * Description: 池异常服务接口
 */
public interface BaseErrorFixService {
    /**
     * 返回池异常错误分组明细和对应数量
     * @return
     */
    List<ErrorCountVO> listErrorGroup();

    /**
     * 处理方式分发中心
     * @param error
     */
    ErrorFixResultVO fixDistribution(String error, int status);

    /**
     * 错误描述：
     * --版本号与分类号长度不符
     * @param requestID
     */
    ErrorFixResultVO fixSortNumVersion(List<String> requestID);
}
