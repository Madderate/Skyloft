package com.madderate.skyloft.Models;

public class Binding {
    private String url;
    private int userId;
    private int expiresIn;
    private long refreshTime;
    private long bindingTime;
    private String tokenJsonStr;
    private boolean expired;
    private long id;
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

    public long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(long refreshTime) {
        this.refreshTime = refreshTime;
    }

    public long getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(long bindingTime) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
