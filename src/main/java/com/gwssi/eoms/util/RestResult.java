package com.gwssi.eoms.util;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/21
 * Time: 11:34
 * Description:
 */
@Data
public class RestResult<T> {
    private boolean result;
    private String message;
    private T data;

    private RestResult() {}

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }
}
