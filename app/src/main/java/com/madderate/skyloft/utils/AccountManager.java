package com.madderate.skyloft.utils;

// 不需要使用cookie
public class AccountManager {
    // 手机登录
    // 参数：手机，密码，国家区号*
    public String phoneLoginInter(String phone,String password,String countryCode){
        return "/login/cellphone?phone="+phone+"&password="+password+"&countrycode="+countryCode;
    }

    // 邮箱登录
    // 参数：邮箱，密码
    public String emailLoginInter(String email,String password){
        return "/login/email?email="+email+"&password="+password;
    }

    // 发送验证码，冷却时间60s
    // 参数：手机，国家区号*
    public String captchaInter(String phone,String ctcode){
        return "/captcha?phone="+phone+"&ctcode="+ctcode;
    }

    // 验证验证码：调用此接口，传入手机号码和验证码，可校验验证码是否正确
    // 参数：手机，验证码，国家区号*
    public String captchaInter(String phone,String captcha,String ctcode){
        return "/captcha?phone="+phone+"&captcha="+captcha+"&ctcode="+ctcode;
    }

    // 注册(修改密码)：调用此接口，传入手机号码和验证码，密码，昵称，可注册网易云音乐账号(同时可修改密码)
    // 参数：验证码，手机号码，密码，昵称
    public String registerInter(String captcha,String phone,String password,String nickname){
        return "/register/cellphone?captcha="+captcha+"&phone="+phone+"&password="+password+"&nickname="+nickname;
    }

    // 检测手机号码是否已注册：调用此接口，可检测手机号码是否已注册
    // 参数：手机号码，国家区号*
    public String phoneExistenceInter(String phone,String countrycode){
        return "/cellphone/existence?phone="+phone+"&countrycode="+countrycode;
    }

    // 更换绑定手机
    // 原手机验证码，新手机验证码，手机号码，国家区号,默认86即中国
    public String refreshLoginInter(String oldcaptcha,String captcha,String phone,String ctcode){
        return "/rebind?phone="+phone+"&oldcaptcha="+oldcaptcha+"&captcha="+captcha+"&ctcode="+ctcode;
    }

}
