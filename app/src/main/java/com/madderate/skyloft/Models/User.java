package com.madderate.skyloft.Models;

import java.util.ArrayList;

public class User {
    private int loginType;
    private int loginState;
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
                '}';
    }
}
