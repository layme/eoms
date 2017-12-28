package com.gwssi.eoms.exception;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/21
 * Time: 11:15
 * Description:
 */
public class DataMoreException extends RuntimeException {
    private static final long serialVersionUID = -536563012885608008L;

    public DataMoreException() {
        super();
    }

    public DataMoreException(String s) {
        super(s);
    }

    public DataMoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMoreException(Throwable cause) {
        super(cause);
    }
}