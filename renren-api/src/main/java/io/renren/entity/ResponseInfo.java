package io.renren.entity;

/**
 * @program: shop
 * @description: 返回Json信息
 * @author: dinggc
 * @create: 2019-01-29 17:01
 **/
public class ResponseInfo {

    /**是否成功*/
    private boolean success;
    /**返回码*/
    private String code;
    /**返回信息*/
    private String msg;
    /**返回数据*/
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
