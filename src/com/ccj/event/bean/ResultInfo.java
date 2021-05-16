package com.ccj.event.bean;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private boolean isReg;
    private String msg;
    private Object data;
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ResultInfo() {
    }

    public ResultInfo(boolean isReg) {
        this.isReg = isReg;
    }

    public ResultInfo(boolean isReg, String msg) {
        this.isReg = isReg;
        this.msg = msg;
    }

    public ResultInfo(boolean isReg, String msg, Object data) {
        this.isReg = isReg;
        this.msg = msg;
        this.data = data;
    }

    public boolean isReg() {
        return isReg;
    }

    public void setReg(boolean reg) {
        isReg = reg;
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
