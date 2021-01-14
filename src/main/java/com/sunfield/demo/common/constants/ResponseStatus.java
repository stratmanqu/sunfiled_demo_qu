package com.sunfield.demo.common.constants;

/**
 * 通用状态码
 */
public enum ResponseStatus {
    /**
     * 请求成功
     */
    SUCCESS(0, "success"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1, "unknown.error"),
    /**
     * 请求熔断
     */
    BREAKING_ERROR(-2, "breaking.error"),
    /**
     * 系统警告
     */
    SYSTEM_WARNING(99996, "system.warning"),
    /**
     * 自定义异常
     */
    CUSTOMIZE_ERROR(99998, "system.error"),
    /**
     * 服务器繁忙server.error
     */
    SERVER_ERROR(99999, "服务器繁忙");

    private Integer code;

    private String msg;

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static String getMessage(int code) {
        for (ResponseStatus status : values()) {
            if (status.code().equals(code)) {
                return status.msg();
            }
        }
        return null;
    }
}
