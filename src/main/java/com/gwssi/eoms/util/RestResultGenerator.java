package com.gwssi.eoms.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/21
 * Time: 11:37
 * Description:
 */
@Slf4j
public class RestResultGenerator {
    /**
     * 一般格式
     * @param result
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genResult(boolean result, T data, String message) {
        RestResult<T> restResult = RestResult.newInstance();
        restResult.setResult(result);
        restResult.setData(data);
        restResult.setMessage(message);
        return restResult;
    }

    /**
     * 请求成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T data) {
        return genResult(true, data, null);
    }

    /**
     * 请求失败
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(String message) {
        return genResult(false, null, message);
    }
}
