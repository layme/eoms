package com.gwssi.eoms.exception;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/21
 * Time: 11:15
 * Description:
 */
public class DataMissingException extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;

    public DataMissingException() {
        super();
    }

    public DataMissingException(String s) {
        super(s);
    }

    public DataMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMissingException(Throwable cause) {
        super(cause);
    }
}