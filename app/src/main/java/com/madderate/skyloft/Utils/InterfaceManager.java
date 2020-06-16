package com.madderate.skyloft.Utils;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.AccountInfo;
import com.madderate.skyloft.Models.SongInfo;
import com.madderate.skyloft.Models.StateCode;
import com.madderate.skyloft.Models.UserInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.UserSubCount;

// 需要使用cookie
public class InterfaceManager {
    private CommunicationManager c = new CommunicationManager();

    public InterfaceManager(String cookie){
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
     * 需登录
     * 初始化昵称，刚注册的账号,调用此接口,可初始化昵称
     * 返回StateCode对象
     * 需要参数：昵称 String
     */
    public StateCode initNicknameInter(String nickname,String cookie){
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
     * 需登录
     * 获取id对应的歌单
     * 参数：id String，cookie String
     * 返回Playlist对象
     */
    public Playlist getPlayListById(String id, String cookie){

        return getPlayList("/playlist/detail","id="+id);
    }

    /*
     * 需登录
     * 获取id对应的专辑
     * 参数：id String，cookie String
     * 返回Playlist对象
     */
    public Playlist getAlbumById(String id, String cookie){

        return getPlayList("/album","id="+id);
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

    /*
     * 封装获取歌单信息，需要确保url+body正确
     */
    public Playlist getPlayList(String url, String body){
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        Playlist userPlaylist;
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                Gson gson = new Gson();
                userPlaylist = gson.fromJson(c.getText(), Playlist.class);
                System.out.println(userPlaylist.toString());
                break;
            }
        }
        return userPlaylist;
    }

    /*
     * 封装获取用户信息，需要确保url+body正确
     */
    public UserInfo getUserInfo(String url, String body){
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        UserInfo userInfo;
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                Gson gson = new Gson();
                userInfo = gson.fromJson(c.getText(), UserInfo.class);
                System.out.println(userInfo.toString());
                break;
            }
        }
        return userInfo;
    }

    /*
     * 封装获取用户各种数量，需要确保url+body正确
     */
    public UserSubCount getUserSubCount(String url, String body){
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        UserSubCount userSubCount;
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                Gson gson = new Gson();
                userSubCount = gson.fromJson(c.getText(), UserSubCount.class);
                System.out.println(userSubCount.toString());
                break;
            }
        }
        return userSubCount;
    }

    /*
     * 封装获取歌曲信息，需要确保url+body正确
     */
    public SongInfo getSongInfo(String url,String body){
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
        SongInfo songInfo;
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                Gson gson = new Gson();
                songInfo = gson.fromJson(c.getText(), SongInfo.class);
                System.out.println(songInfo.toString());
                break;
            }
        }
        return songInfo;
    }
}
