package com.madderate.skyloft.Models;

import java.util.ArrayList;

public class Account {
    private int loginType;
    private int loginState;
    private volatile static Account account;

    private Account() {}

    public static Account getInstance() {
        if (account == null) {
            synchronized (Account.class) {
                if (account == null) {
                    account = new Account();
                }
            }
        }
        return account;
    }

    // 账号信息
    private AccountInfo accountInfo;
    // 用户信息
    private UserInfo userInfo;
    // 用户各种数量
    private UserSubCount userSubCount;
    // 用户歌单信息
    private ArrayList<Playlist> playlist;
    // 本周播放记录
    private ArrayList<Integer> weekData;


    public ArrayList<Playlist> getUserPlaylist() {
        return playlist;
    }

    public void setUserPlaylist(ArrayList<Playlist> playlist) {
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

}
