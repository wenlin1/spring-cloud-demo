package com.wl.comm;

import java.io.Serializable;

public class ResBody<T extends Object> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3468560134846477959L;
    private String retCode;
    private String retDesc;
    private T rspBody;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public T getRspBody() {
        return rspBody;
    }

    public void setRspBody(T rspBody) {
        this.rspBody = rspBody;
    }

    @Override
    public String toString() {
        return "ResBody{" +
                "retCode='" + retCode + '\'' +
                ", retDesc='" + retDesc + '\'' +
                ", rspBody=" + rspBody +
                '}';
    }
}
