package com.madderate.skyloft.Models;

import java.util.ArrayList;

public class User {
    private long loginType;
    private long loginState;
    private volatile static User user;

    private User() {}

    public static User getInstance() {
        if (user == null) {
            synchronized (Account.class) {
                if (user == null) {
                    user = new User();
                }
            }
        }
        return user;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User u) {
        user = u;
    }

    // 账号信息
    private Account account;
    // 用户信息
    private UserInfo userInfo;
    // 用户各种数量
    private UserSubCount userSubCount;
    // 用户歌单信息
    private ArrayList<Playlist> playlist;
    // 本周播放记录
    private ArrayList<Integer> weekData;

    private String token;
    private String cookie;

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }

    public ArrayList<Integer> getWeekData() {
        return weekData;
    }

    public void setWeekData(ArrayList<Integer> weekData) {
        this.weekData = weekData;
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

    public ArrayList<Playlist> getUserPlaylist() {
        return playlist;
    }

    public void setUserPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
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

    public long getLoginType() {
        return loginType;
    }

    public void setLoginType(long loginType) {
        this.loginType = loginType;
    }

    public long getLoginState() {
        return loginState;
    }

    public void setLoginState(long loginState) {
        this.loginState = loginState;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountInfo) {
        this.account = accountInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginType=" + loginType +
                ", loginState=" + loginState +
                ", account=" + account +
                ", userInfo=" + userInfo +
                ", userSubCount=" + userSubCount +
                ", playlist=" + playlist +
                ", weekData=" + weekData +
                ", token='" + token + '\'' +
                ", cookie='" + cookie + '\'' +
                '}';
    }
}
