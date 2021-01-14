package com.sunfield.demo.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sunfield.demo.common.constants.ResponseStatus;

import java.io.Serializable;

/**
 * 通用数据传输对象
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer code) {
        super();
        this.code = code;
    }

    public ResponseResult(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, Throwable throwable) {
        super();
        this.code = code;
        this.msg = throwable.getMessage();
    }

    public ResponseResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(ResponseStatus responseStatus) {
        super();
        this.code = responseStatus.code();
        this.msg = responseStatus.msg();
    }

    public ResponseResult(ResponseStatus responseStatus, T data) {
        super();
        this.code = responseStatus.code();
        this.msg = responseStatus.msg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult<T> breaking() {
        return getResult(ResponseStatus.BREAKING_ERROR, null);
    }

    public static <T> ResponseResult<T> success() {
        return getResult(ResponseStatus.SUCCESS, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return getResult(ResponseStatus.SUCCESS, data);
    }

    public static <T> ResponseResult<T> success(String msg, T data) {
        return getResult(ResponseStatus.SUCCESS.code(), msg, data);
    }

    public static <T> ResponseResult<T> busy() {
        return getResult(ResponseStatus.SERVER_ERROR, null);
    }

    public static <T> ResponseResult<T> failure() {
        return getResult(ResponseStatus.UNKNOWN_ERROR, null);
    }

    public static <T> ResponseResult<T> failure(String msg) {
        return getResult(ResponseStatus.UNKNOWN_ERROR.code(), msg, null);
    }

    public static <T> ResponseResult<T> failure(T data) {
        return getResult(ResponseStatus.UNKNOWN_ERROR, data);
    }

    public static <T> ResponseResult<T> failure(String msg, T data) {
        return getResult(ResponseStatus.UNKNOWN_ERROR.code(), msg, data);
    }

    public static <T> ResponseResult<T> response(ResponseStatus responseStatus) {
        return getResult(responseStatus, null);
    }

    public static <T> ResponseResult<T> response(ResponseStatus responseStatus, T data) {
        return getResult(responseStatus, data);
    }

    public static <T> ResponseResult<T> response(Integer code, String msg, T data) {
        return getResult(code, msg, data);
    }

    private static <T> ResponseResult<T> getResult(ResponseStatus responseStatus, T data) {
        return new ResponseResult<>(responseStatus, data);
    }

    private static <T> ResponseResult<T> getResult(Integer code, String msg, T data) {
        return new ResponseResult<>(code, msg, data);
    }

}
