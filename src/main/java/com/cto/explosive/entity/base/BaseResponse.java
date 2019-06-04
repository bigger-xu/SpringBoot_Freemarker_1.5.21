package com.cto.explosive.entity.base;

public class BaseResponse<T> {
    private String retCode;
    private String retMsg;
    private String sOperTime;
    private T data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getsOperTime() {
        return sOperTime;
    }

    public void setsOperTime(String sOperTime) {
        this.sOperTime = sOperTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
