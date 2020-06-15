package com.madderate.skyloft.Utils;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.AccountInfo;
import com.madderate.skyloft.Models.StateCode;

// 需要使用cookie
public class InterfaceManager {
    private String cookie;

    private CommunicationManager c = new CommunicationManager();

    public InterfaceManager(String cookie){
        setCookie(cookie);
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    /*
     * 手机登录接口
     * 返回AccountInfo对象
     * 需要参数：手机号 String，密码 String，国家区号 String
     */
    public AccountInfo loginByPhone(String phone, String password, String countrycode){
        return getAccountInfo("/login/cellphone","phone="+phone+"&password="+password+"&countrycode="+countrycode);
    }

    /*
     * 邮箱登录接口
     * 返回AccountInfo对象
     * 需要参数：邮箱 String，密码 String
     */
    public AccountInfo loginByEmail(String email, String password){
        return getAccountInfo("/login/email","email="+email+"&password="+password);
    }

    /*
     * 发送验证码接口，前端需要做冷却时间60s
     * 返回StateCode对象
     * 需要参数：手机号 String，国家区号 String
     */
    public StateCode sentCaptchaToPhone(String phone,String ctcode){
        return getStateCode("/captcha/sent","phone="+phone+"&ctcode="+ctcode);
    }

    /*
     * 验证验证码接口：调用此接口，传入手机号码和验证码，可校验验证码是否正确
     * 返回StateCode对象
     * 需要参数：手机号 String，验证码 String，国家区号 String
     */
    public StateCode verifyCaptcha(String phone,String captcha,String ctcode){
        return getStateCode("/captcha/verify","phone="+phone+"&captcha="+captcha+"&ctcode="+ctcode);
    }

    /*
     * 注册(修改密码)：调用此接口，传入手机号码和验证码，密码，昵称，可注册网易云音乐账号(同时可修改密码)
     * 返回StateCode对象
     * 需要参数：验证码 String，手机号码 String，密码 String，昵称 String
     */
    public StateCode registerByCaptcha(String captcha,String phone,String password,String nickname){
        return getStateCode("/register/cellphone","captcha="+captcha+"&phone="+phone+"&password="+password+"&nickname="+nickname);
    }

    /*
     * 检测手机号码是否已注册：调用此接口，可检测手机号码是否已注册
     * 返回StateCode对象
     * 需要参数：手机号码 String，国家区号 String
     */
    public StateCode phoneExistenceInter(String phone,String countrycode){
        return getStateCode("/cellphone/existence","phone="+phone+"&countrycode="+countrycode);
    }

    /*
     * 更换绑定手机
     * 返回StateCode对象
     * 需要参数：原手机验证码 String，新手机验证码 String，手机号码 String，国家区号 String
     */
    public StateCode refreshLoginInter(String oldcaptcha,String captcha,String phone,String ctcode){
        return getStateCode("/rebind","phone="+phone+"&oldcaptcha="+oldcaptcha+"&captcha="+captcha+"&ctcode="+ctcode);
    }

    /*
     * 初始化昵称:刚注册的账号(需登录),调用此接口,可初始化昵称
     * 返回StateCode对象
     * 需要参数：昵称 String
     */
    public StateCode initNicknameInter(String nickname){
        return getStateCode("/activate/init/profile","nickname="+nickname+"&cookie="+cookie);
    }

    /*
     * 刷新登录状态
     * 返回StateCode对象
     */
    public StateCode refreshLoginInter(){
        return getStateCode("/login/refresh","");
    }

    /*
     * 退出登录状态
     * 返回StateCode对象
     */
    public StateCode logoutInter(){
        return getStateCode("/login/logout","");
    }

    /*
     * 封装，获取账户信息
     */
    public AccountInfo getAccountInfo(String url,String body){
        AccountInfo accountInfo = new AccountInfo();
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        while (true){
            if(c.getText()!=null){
                try {
                    Gson gson = new Gson();
                    accountInfo = gson.fromJson(c.getText(), AccountInfo.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
        return accountInfo;
    }

    /*
     * 封装，获取状态码信息
     */
    public StateCode getStateCode(String url,String body){
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        StateCode stateCode;
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                Gson gson = new Gson();
                stateCode = gson.fromJson(c.getText(), StateCode.class);
                // System.out.println(stateCode.toString());
                break;
            }
        }
        return stateCode;
    }
}
