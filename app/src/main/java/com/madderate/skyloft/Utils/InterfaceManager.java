package com.madderate.skyloft.Utils;

// 需要使用cookie
public class InterfaceManager {
    private String cookie;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public InterfaceManager(String cookie){
        setCookie(cookie);
    }

    // 初始化昵称:刚注册的账号(需登录),调用此接口,可初始化昵称
    public String initNicknameInter(String nickname){
        return "/activate/init/profile?nickname="+nickname+"&cookie="+cookie;
    }

    // 获取登录状态
    public String refreshLoginInter(){
        return "/login/refresh?cookie="+cookie;
    }
}
