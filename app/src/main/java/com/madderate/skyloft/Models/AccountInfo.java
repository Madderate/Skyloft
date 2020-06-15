package com.madderate.skyloft.Models;

public class AccountInfo {
    private int loginType;
    private int code;

    private Account account;
    private Profile profile;

    private String token;
    private String cookie;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "loginType=" + loginType +
                ", code=" + code +
                ", account=" + account +
                ", profile=" + profile +
                ", token='" + token + '\'' +
                ", cookie='" + cookie + '\'' +
                '}';
    }
}
