package com.madderate.skyloft.Models;

public class StateCode {
    private String mag;
    private int code;
    private String message;
    private boolean success;

    public int getCode() {
        return code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "StateCode{" +
                "mag='" + mag + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
