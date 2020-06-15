package com.madderate.skyloft.Models;

public class Binding {
    private String url;
    private int userId;
    private int expiresIn;
    private int refreshTime;
    private int bindingTime;
    private String tokenJsonStr;
    private boolean expired;
    private int id;
    private int type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    public int getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(int bindingTime) {
        this.bindingTime = bindingTime;
    }

    public String getTokenJsonStr() {
        return tokenJsonStr;
    }

    public void setTokenJsonStr(String tokenJsonStr) {
        this.tokenJsonStr = tokenJsonStr;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Binding{" +
                "url='" + url + '\'' +
                ", userId=" + userId +
                ", expiresIn=" + expiresIn +
                ", refreshTime=" + refreshTime +
                ", bindingTime=" + bindingTime +
                ", tokenJsonStr='" + tokenJsonStr + '\'' +
                ", expired=" + expired +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
