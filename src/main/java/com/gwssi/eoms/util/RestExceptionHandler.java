package com.gwssi.eoms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/21
 * Time: 13:48
 * Description:
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)  // 501
    private <T> RestResult<T> runtimeExceptionHandler(RuntimeException e) {
        return RestResultGenerator.genErrorResult(e.getMessage());
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    private <T> RestResult<T> ioExceptionHandler(IOException e) {
        return RestResultGenerator.genErrorResult(e.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)  // 408
    private <T> RestResult<T> sqlExceptionHandler(IOException e) {
        return RestResultGenerator.genErrorResult(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    private <T> RestResult<T> exceptionHandler(IOException e) {
        return RestResultGenerator.genErrorResult(e.getMessage());
    }
}
