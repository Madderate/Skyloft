package com.madderate.skyloft.Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.Settings;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.StateCode;
import com.madderate.skyloft.Models.UserInfo;

import java.util.ArrayList;

// 需要使用cookie
public class InterfaceManager {
    private String cookie;
    private JsonToClass jsonToClass = new JsonToClass();

    public String getCookie() {
        return cookie;
    }
    public InterfaceManager(){

    }

    public InterfaceManager(String cookie){
        this.cookie = cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    /*
     * 手机登录接口
     * 返回AccountInfo对象
     * 需要参数：手机号 String，密码 String，国家区号 String
     */
    public void loginByPhone(String phone, String password, String countrycode){
        jsonToClass.getUser("/login/cellphone","phone="+phone+"&password="+password+"&countrycode="+countrycode);
    }

    /*
     * 邮箱登录接口
     * 返回AccountInfo对象
     * 需要参数：邮箱 String，密码 String
     */
    public void loginByEmail(String email, String password){
        jsonToClass.getUser("/login/email","email="+email+"&password="+password);
    }

    /*
     * 发送验证码接口，前端需要做冷却时间60s
     * 返回StateCode对象
     * 需要参数：手机号 String，国家区号 String
     */
    public StateCode sentCaptchaToPhone(String phone,String ctcode){
        return jsonToClass.getStateCode("/captcha/sent","phone="+phone+"&ctcode="+ctcode);
    }

    /*
     * 验证验证码接口：调用此接口，传入手机号码和验证码，可校验验证码是否正确
     * 返回StateCode对象
     * 需要参数：手机号 String，验证码 String，国家区号 String
     */
    public StateCode verifyCaptcha(String phone,String captcha,String ctcode){
        return jsonToClass.getStateCode("/captcha/verify","phone="+phone+"&captcha="+captcha+"&ctcode="+ctcode);
    }

    /*
     * 注册(修改密码)：调用此接口，传入手机号码和验证码，密码，昵称，可注册网易云音乐账号(同时可修改密码)
     * 返回StateCode对象
     * 需要参数：验证码 String，手机号码 String，密码 String，昵称 String
     */
    public StateCode registerByCaptcha(String captcha,String phone,String password,String nickname){
        return jsonToClass.getStateCode("/register/cellphone","captcha="+captcha+"&phone="+phone+"&password="+password+"&nickname="+nickname);
    }

    /*
     * 检测手机号码是否已注册：调用此接口，可检测手机号码是否已注册
     * 返回StateCode对象
     * 需要参数：手机号码 String，国家区号 String
     */
    public StateCode phoneExistenceInter(String phone,String countrycode){
        return jsonToClass.getStateCode("/cellphone/existence","phone="+phone+"&countrycode="+countrycode);
    }

    /*
     * 更换绑定手机
     * 返回StateCode对象
     * 需要参数：原手机验证码 String，新手机验证码 String，手机号码 String，国家区号 String
     */
    public StateCode refreshLoginInter(String oldcaptcha,String captcha,String phone,String ctcode){
        return jsonToClass.getStateCode("/rebind","phone="+phone+"&oldcaptcha="+oldcaptcha+"&captcha="+captcha+"&ctcode="+ctcode);
    }

    /*
     * 初始化昵称:刚注册的账号(需登录),调用此接口,可初始化昵称
     * 返回StateCode对象
     * 需要参数：昵称 String
     */
    public StateCode initNicknameInter(String nickname){
        return jsonToClass.getStateCode("/activate/init/profile","nickname="+nickname+"&cookie="+cookie);
    }

    /*
     * 获取用户歌单，收藏，mv, dj 数量:登陆后调用此接口 , 可以获取用户信息
     * 返回StateCode对象
     */
    // TODO

    /*
     * 获取用户详情:登陆后调用此接口 , 可以获取用户信息
     * 返回StateCode对象
     */
    public UserInfo getUserMessage(String uid){
        Log.d("INTER",uid);
        return jsonToClass.getUserInfo("/user/detail","uid="+uid);
    }

    /*
     * 获取用户歌单:登陆后调用此接口 , 传入用户 id, 可以获取用户歌单
     * 返回StateCode对象
     * 需要参数：用户id String
     */
    public ArrayList<Playlist> getPlayList(String uid){
        return jsonToClass.getPlayList("/user/playlist","uid="+uid);
    }

    /*
     * 获取用户播放记录:登陆后调用此接口 , 传入用户 id, 可获取用户播放记录
     * 返回StateCode对象
     * 需要参数：用户uid String,记录类型type String
     * TODO
     */
    public StateCode getUserPlayrecord(String uid,String type){
        return jsonToClass.getStateCode("/user/record","uid="+uid+"&type="+type);
    }

    /*
     * 获取歌单详情:歌单能看到歌单名字, 但看不到具体歌单内容 , 调用此接口 , 传入歌单 id,
     * 可以获取对应歌单内的所有的音乐(未登录状态只能获取不完整的歌单,登录后是完整的)
     * 但是返回的trackIds是完整的，tracks 则是不完整的，可拿全部 trackIds 请求一次 song/detail 接口获取所有歌曲的详情
     * 返回StateCode对象
     * 需要参数：歌单id String
     * TODO
     */
    public Playlist getPlaylistDetail(String id){
        return jsonToClass.getPlayListDetail("/playlist/detail","id="+id+"&cookie"+cookie);
    }

    /*
     * 搜索:调用此接口 , 传入搜索关键词可以搜索该音乐 / 专辑 / 歌手 / 歌单 / 用户 , 关键词可以多个
     *  以空格隔开 , 如 " 周杰伦 搁浅 "( 不需要登录 ), 搜索获取的 mp3url 不能直接用 ,
     * 可通过 /song/url 接口传入歌曲 id 获取具体的播放链接
     * 返回StateCode对象
     * 需要参数：关键词keywords String,返回数量limit String, 默认为 30,偏移数量offset String ,用于分页 , 默认为 0
     * 搜索类型type String,默认为 1 即单曲 ,
     * 取值意义 : 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单, 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台, 1014: 视频, 1018:综合
     * TODO
     */
    public StateCode Search(String keywords,String limit,String offset,String type){
        return jsonToClass.getStateCode("/search","keywords="+keywords+"&limi=t"+limit+"&offset="+offset+"&type="+type);
    }

    /*
     * 搜索建议:调用此接口 , 传入搜索关键词可获得搜索建议 , 搜索结果同时包含单曲 , 歌手 , 歌单 ,mv 信息 , 传 'mobile' 返回移动端数据
     * 返回StateCode对象
     * 需要参数：关键词keywords String，type String
     * TODO
     */
    public StateCode searchSuggestion(String keywords,String type){
        return jsonToClass.getStateCode("/search/suggest","keywords="+keywords+"&type="+type);
    }

    /*
     * 获取歌词:调用此接口 , 传入音乐 id 可获得对应音乐的歌词 ( 不需要登录 )
     * 返回StateCode对象
     * 需要参数：音乐id String，移动端mobile String
     * TODO
     */
    public StateCode getlyric(String id){
        return jsonToClass.getStateCode("/lyric","id="+id);
    }

    /*
     * 获取歌曲详情:调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     * 返回StateCode对象
     * 需要参数：音乐ids String
     */
    public MusicInfo getSongDetail(String ids){
        return jsonToClass.getMusicInfo("/song/detail","ids="+ids);
    }

    /*
     * 获取专辑内容:调用此接口 , 传入专辑 id, 可获得专辑内容
     * 返回StateCode对象
     * 需要参数：专辑 id String
     * TODO
     */
    public StateCode getAlbumDetail(String id){
        return jsonToClass.getStateCode("/album","id="+id);
    }

    /*
     * 获取歌手单曲:调用此接口 , 传入歌手 id, 可获得歌手部分信息和热门歌曲
     * 返回StateCode对象
     * 需要参数：歌手 id String
     * TODO
     */
    public StateCode getArtistSong(String id){
        return jsonToClass.getStateCode("/artists","id="+id);
    }

    /*
     * 获取歌手专辑:调用此接口 , 传入歌手 id, 可获得歌手专辑内容
     * 返回StateCode对象
     * 需要参数：歌手 id String,取出数量limit String, 默认为 5s,偏移数量offset String,默认为 0
     * TODO
     */
    public StateCode getArtistAlbum(String id,String limit,String offset){
        return jsonToClass.getStateCode("/artists","id="+id+"&limit="+limit+"&offset="+offset);
    }

    /*
     * 获取歌手描述:调用此接口 , 传入歌手 id, 可获得歌手描述
     * 返回StateCode对象
     * 需要参数：歌手 id String
     * TODO
     */
    public StateCode getArtistDesc(String id){
        return jsonToClass.getStateCode("/artist/desc","id="+id);
    }

    /*
     * 获取每日推荐歌单:调用此接口 , 可获得每日推荐歌单 ( 需要登录 )
     * 返回StateCode对象
     * TODO
     */
    public StateCode getRecommendResource(){
        return jsonToClass.getStateCode("/recommend/resource","");
    }

    /*
     * 获取每日推荐歌曲:调用此接口 , 可获得每日推荐歌曲 ( 需要登录 )
     * 返回StateCode对象
     * TODO
     */
    public StateCode getRecommendSongs(){
        return jsonToClass.getStateCode("/recommend/songs","");
    }

    /*
     * 私人 FM:私人 FM( 需要登录 )
     * 返回StateCode对象
     * TODO
     */
    public StateCode getPersonalFM(){
        return jsonToClass.getStateCode("/personal_fm","");
    }

    /*
     * 签到:调用此接口 , 传入签到类型 ( 可不传 , 默认安卓端签到 ),
     * 可签到 ( 需要登录 ), 其中安卓端签到可获得 3 点经验 , web/PC 端签到可获得 2 点经验
     * 返回StateCode对象
     * 需要参数：签到类型type String， 默认 0, 其中 0 为安卓端签到 ,1 为 web/PC 签到
     */
    public StateCode dailySignin(String type){
        return jsonToClass.getStateCode("/daily_signin","type="+type);
    }

    /*
     * 喜欢音乐:调用此接口 , 传入音乐 id, 可喜欢该音乐
     * 返回StateCode对象
     * 需要参数：歌曲id String， 是否喜欢like boolean 默认为 true 即喜欢 , 若传 false, 则取消喜欢
     */
    public StateCode likeSong(String id,boolean like){
        return jsonToClass.getStateCode("/like","id="+id+"&like="+like);
    }

    /*
     * 热门歌手:调用此接口 , 可获取热门歌手数据
     * 返回StateCode对象
     * 需要参数：取出数量limit String, 默认为 50偏移数量，offset String, 用于分页 默认 为 0
     * TODO
     */
    public StateCode topArtists(String limit,String offset){
        return jsonToClass.getStateCode("/top/artists","limit="+limit+"&offset="+offset);
    }

    /*
     * 推荐歌单:调用此接口 , 可获取推荐歌单
     * 返回StateCode对象
     * 需要参数：取出数量limit String, 默认为 50
     */
    public ArrayList<PlaylistResult> getPersonalizedPlaylist(String limit){
        return jsonToClass.getPlaylistResult("/personalized","limit="+limit+"&cookie="+cookie);
    }

    /*
     * 推荐新音乐:调用此接口 , 可获取推荐新音乐
     * 返回StateCode对象
     * TODO
     */
    public StateCode personalizedNewsong(){
        return jsonToClass.getStateCode("/personalized/newsong","");
    }

    /*
     * 新建歌单:调用此接口 , 传入歌单名字可新建歌单,privacy : 是否设置为隐私歌单，默认否，传'10'则设置成隐私歌单
     * 返回StateCode对象
     * 需要参数：歌单名name String,隐私歌单设置privacy String
     */
    public StateCode playlistCreate(String name,String privacy){
        return jsonToClass.getStateCode("/playlist/create","name="+name+"&privacy="+privacy);
    }

    /*
     * 收藏/取消收藏歌单:调用此接口 , 传入类型和歌单 id 可收藏歌单或者取消收藏歌单
     * 返回StateCode对象
     * 需要参数：类型t String，歌单id String
     */
    public StateCode platlistSubscribe(String t,String id){
        return jsonToClass.getStateCode("/playlist/subscribe","t="+t+"&id="+id);
    }

    /*
     * 歌单分类:调用此接口,可获取歌单分类,包含 category 信息
     * 返回StateCode对象
     * TODO
     */
    public StateCode playlistCatlist(){
        return jsonToClass.getStateCode("/playlist/catlist","");
    }

    /*
     * 收藏的歌手列表:调用此接口,可获取收藏的歌手列表
     * 返回StateCode对象
     * TODO
     */
    public StateCode artistSublist(){
        return jsonToClass.getStateCode("/artist/sublist","");
    }

    /*
     * 音乐是否可用:调用此接口,传入歌曲 id, 可获取音乐是否可用,返回 { success: true, message: 'ok' } 或者 { success: false, message: '亲爱的,暂无版权' }
     * TODO
     * 需要参数：歌单id String,码率br String
     */
    public StateCode checkMusic(String br,String id){
        return jsonToClass.getStateCode("/check/music","id="+id+"&br="+br);
    }

    /*
     * 新歌速递:调用此接口 , 可获取新歌速递
     * TODO
     * 需要参数：地区类型type String 全部:0 华语:7 欧美:96 日本:8 韩国:16
     */
    public StateCode topSong(String type){
        return jsonToClass.getStateCode("/top/song","type="+type);
    }

    /*
     * 喜欢音乐列表:调用此接口 , 传入用户 id, 可获取已喜欢音乐id列表(id数组)
     * 需要参数：用户uid String
     * TODO
     */
    public StateCode likeList(String uid){
        return jsonToClass.getStateCode("/likelist","uid="+uid);
    }

    /*
     * 已收藏专辑列表:调用此接口 , 可获得已收藏专辑列表
     * 需要参数：取出数量limit String, 默认为 25 偏移数量，offset String, 用于分页 默认 为 0
     * TODO
     */
    public StateCode albumSublist(String limit,String offset){
        return jsonToClass.getStateCode("/album/sublist","limit="+limit+"&offset="+offset);
    }

    /*
     * 收藏/取消收藏专辑:调用此接口,可收藏/取消收藏专辑
     * 返回StateCode对象
     * 需要参数：专辑id id String,是否收藏t String,1 为收藏,其他为取消收藏
     */
    public StateCode albumSubscribe(String id,String t){
        return jsonToClass.getStateCode("/album/sub","id="+id+"&t="+t);
    }

    /*
     * 获取最新专辑
     */
    public ArrayList<PlaylistResult> getNewestAlbum(){
        return jsonToClass.getPlaylistResult("/album/newest","cookie="+cookie);
    }

    /*
     * 专辑动态信息:调用此接口, 传入专辑 id, 可获得专辑动态信息,如是否收藏,收藏数,评论数,分享数
     * 需要参数：专辑id id String
     * TODO
     */
    public StateCode albumDetail(String id){
        return jsonToClass.getStateCode("/album/detail/dynamic","id="+id);
    }

    /*
     * 更新歌单描述:登陆后调用此接口,可以单独更新用户歌单描述
     * 返回StateCode对象
     * 需要参数：歌单id id String,歌单描述desc String
     */
    public StateCode updatePlaylistDesc(String id,String desc){
        return jsonToClass.getStateCode("/playlist/desc/update","id="+id+"&desc="+desc);
    }

    /*
     * 更新歌单名:登陆后调用此接口,可以单独更新用户歌单描述
     * 返回StateCode对象
     * 需要参数：歌单id id String,歌单名name String
     */
    public StateCode updatePlaylistName(String id,String name){
        return jsonToClass.getStateCode("/playlist/desc/update","id="+id+"&name="+name);
    }

    /*
     * 更新歌单标签:登陆后调用此接口,可以单独更新用户歌单描述
     * 返回StateCode对象
     * 需要参数：歌单id id String,歌单标签tags String
     */
    public StateCode updatePlaylistTags(String id,String tags){
        return jsonToClass.getStateCode("/playlist/desc/update","id="+id+"&tags="+tags);
    }

    /*
     * 删除歌单:调用此接口 , 传入歌单id可删除歌单
     * 返回StateCode对象
     * 需要参数：歌单id String ,可多个,用逗号隔开
     */
    public StateCode deletePlaylist(String id){
        return jsonToClass.getStateCode("/playlist/delete","id="+id);
    }

    /*
     * 歌手热门50首歌曲:调用此接口,可获取歌手热门50首歌曲
     * 需要参数：歌单id Sring ,可多个,用逗号隔开
     * TODO
     */
    public StateCode artistTopSong(String id){
        return jsonToClass.getStateCode("/artist/top/song","id="+id);
    }

    /*
     * 调整歌单顺序:登陆后调用此接口,可以根据歌单id顺序调整歌单顺序
     * 返回StateCode对象
     * 需要参数：歌单列表ids String
     */
    public StateCode updatePlaylistOrder(String ids){
        return jsonToClass.getStateCode("/playlist/order/update","ids="+ids);
    }

    /*
     * 调整歌曲顺序:登陆后调用此接口,可以根据歌曲id顺序调整歌曲顺序
     * 返回StateCode对象
     * 需要参数：歌曲列表ids String，歌单id pid String
     */
    public StateCode updateSongOrder(String ids,String pid){
        return jsonToClass.getStateCode("/song/order/update","pid="+pid+"&ids="+ids);
    }

    /*
     * 需要登录
     * 设置:登陆后调用此接口 ,可获取用户设置
     * 返回StateCode对象
     */
    public Settings getSetting(){
        return jsonToClass.getSettings("/setting","");
    }

    /*
     * 需要登录
     * 登录状态:调用此接口,可获取登录状态
     * 返回StateCode对象
     */
    public UserInfo loginStatus(){
        return jsonToClass.getUserInfo("/login/status","");
    }

    /*
     * 需要登录
     * 刷新登录状态
     * 返回StateCode对象
     */
    public StateCode refreshLoginInter(){
        return jsonToClass.getStateCode("/login/refresh","");
    }

    /*
     * 需要登录
     * 退出登录状态
     * 返回StateCode对象
     */
    public StateCode logoutInter(){
        return jsonToClass.getStateCode("/logout","");
    }

}
