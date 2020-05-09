package com.example.dynamic.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -4048012845416446084L;
    private Log log =      LogFactory.getLog(ServiceException.class);
    private Integer           code;
    private String            message;
    private Throwable throwable;

    public ServiceException(String message) {
        super(message);
        this.setCode(ResponseCodeConstant.RESPONSE_ERROR_CODE);
        this.setMessage(message);
        log.error(this.getMessage(), this);
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.setCode(code);
        this.setMessage(message);
        log.error(this.getMessage(), this);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        this.message = throwable.getMessage();
        this.setCode(ResponseCodeConstant.RESPONSE_ERROR_CODE);
        throwable.printStackTrace();
        log.error(throwable.getMessage(), throwable);
    }
    public ServiceException(Integer code, Throwable throwable) {
        super(throwable);
        this.setCode(code);
        this.throwable = throwable;
        this.message = throwable.getMessage();
        throwable.printStackTrace();
        log.error(throwable.getMessage(), throwable);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
        this.setCode(ResponseCodeConstant.RESPONSE_ERROR_CODE);
        throwable.printStackTrace();
        log.error(message, throwable);
    }

    public ServiceException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.setCode(code);
        this.setMessage(message);
        throwable.printStackTrace();
        log.error(message, throwable);
    }

    /**
     * 从Exception实例中获取异常信息
     * 
     * @param ex Exception实例
     */
    public static String getErrorMsg(Exception ex) {
        LogFactory.getLog(ServiceException.class).error(ex);
        StringWriter writer = new StringWriter();
        ex.printStackTrace(new PrintWriter(writer, true));
        return writer.toString();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}