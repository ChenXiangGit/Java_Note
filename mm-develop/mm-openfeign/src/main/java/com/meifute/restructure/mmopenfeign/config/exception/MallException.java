package com.meifute.restructure.mmopenfeign.config.exception;

import lombok.Setter;

import java.util.Arrays;

public class MallException extends RuntimeException{

    private static final long serialVersionUID = -1L;

    @Setter
    protected String code;
    @Setter
    protected Object[] args;
    @Setter
    protected String msg;

    public MallException(String code) {
        this(code, null, null, null);
    }

    public MallException(String code, Object[] args) {
        this(code, args, null, null);
    }

    public MallException(String code, String message) {
        this(code, null, message, null);
    }

    public MallException(String code, Object[] args, String message) {
        this(code, args, message, null);
    }

    public MallException(String code, Throwable cause) {
        this(code, null, null, cause);
    }

    public MallException(String code, Object[] args, Throwable cause) {
        this(code, args, null, cause);
    }

    public MallException(String code, String message, Throwable cause) {
        this(code, null, message, cause);
    }

    public MallException(String code, Object[] args, String message, Throwable cause) {
        super(message,cause);
        this.code = code;
        this.args = args;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getSimpleName());
        buf.append("[code='" + getCode() + "'");
        buf.append(", args=" + Arrays.toString(args));
        buf.append(", msg='" + msg + "']");
        String message = getLocalizedMessage();
        buf.append((message != null) ? ": " + message : "");
        StackTraceElement[] traces = getStackTrace();
        buf.append(traces.length == 0 ? "" : ": at " + traces[0]);
        return buf.toString();
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
