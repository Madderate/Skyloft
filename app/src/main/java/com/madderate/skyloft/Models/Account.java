package com.madderate.skyloft.Models;

import java.util.ArrayList;

public class Account {
    private int loginType;
    private int loginState;

    // 账号信息
    private AccountInfo accountInfo;
    // 用户信息
    private UserInfo userInfo;
    // 用户各种数量
    private UserSubCount userSubCount;
    // 用户歌单信息
    private ArrayList<UserPlaylist> playlist;
    // 本周播放记录
    private ArrayList<Integer> weekData;

    private String token;
    private String cookie;

    public ArrayList<UserPlaylist> getUserPlaylist() {
        return playlist;
    }

    public void setUserPlaylist(ArrayList<UserPlaylist> playlist) {
        this.playlist = playlist;
    }


    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserSubCount getUserSubCount() {
        return userSubCount;
    }

    public void setUserSubCount(UserSubCount userSubCount) {
        this.userSubCount = userSubCount;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getLoginState() {
        return loginState;
    }

    public void setLoginState(int loginState) {
        this.loginState = loginState;
    }

    public AccountInfo getAccount() {
        return accountInfo;
    }

    public void setAccount(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
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

}
