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

    /**
     * 重载方法，简化用户的调用
     */
    public static SystemResult fail(){
        return new SystemResult(201,"服务器异常",null);
    }

    public static SystemResult success(){
        return new SystemResult(200,"业务调用成功",null);
    }
    public static SystemResult success(Object o){
        return new SystemResult(200,"业务调用成功",o);
    }

    /**
     * 如果只返回字符串，因为object包含字符串，所以会产生歧义
     * @param obj
     * @param msg 如果想要传入消息信息，需要再传入一个标记对象obj
     * @return
     */
    public static SystemResult success(Object obj , String msg){
        return new SystemResult(200,msg,obj);
    }


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

}
