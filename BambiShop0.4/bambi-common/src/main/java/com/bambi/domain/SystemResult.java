package com.bambi.domain;

/**
 * 描述： 系统级系统返回的值对象
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/3 3:55    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public class SystemResult {
    //如果成功返回200 如果201表示失败
    private Integer status;
    private String msg;
    private Object data;

    public SystemResult() {
    }

    public SystemResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static SystemResult fail() {
        return new SystemResult(201, "服务器调用失败", null);
    }

    public static SystemResult fail(String msg) {
        return new SystemResult(201, msg, null);
    }

    public static SystemResult success() {
        return new SystemResult(200, "服务器调用成功", null);
    }

    public static SystemResult success(Object data) {
        return new SystemResult(200, "服务器调用成功", data);
    }

    public static SystemResult success(String msg, Object data) {
        return new SystemResult(200, msg, data);
    }
}
