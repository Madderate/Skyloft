package com.madderate.skyloft.ViewModels.MusicPlay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.FileUtils;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayerViewModel extends ViewModel {
    public static final String GET_URL = "http://m7.music.126.net/20200617163101/82fe5cadce3a9ad025dd4829bf36cae6/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3";

    ArrayList<Music> music;

    Long musicId;
    // 变量

    private List<Integer> musics;
    private MediaPlayer player;

    //
    private String downloadUrl;
    InterfaceManager interfaceManager = new InterfaceManager();
    // 播放/暂停模式
    private int playMode;
    // 播放模式
    private int playStatus;

    public final int STATUS_SINGLE = 0;
    public final int STATUS_RANDOM = 1;
    public final int STATUS_SEQUENCE = 2;
    // 记录的暂停时的播放位置
    private int pausePosition;
    // 当前播放的歌曲的索引
    private int currentMusicIndex;
    // 播放上一首/下一首
    private int nextOrPrev;
    public final int MODE_NEXT = 0;
    public final int MODE_PREV = 1;

    public List<Integer> getMusics() {
        return musics;
    }

    public void setMusics(List<Integer> musics) {
        this.musics = musics;
    }

    public MediaPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }

    public int getPlayMode() {
        return playMode;
    }

    public void setPlayMode(int playMode) {
        this.playMode = playMode;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public int getNextOrPrev() {
        return nextOrPrev;
    }

    public void setNextOrPrev(int nextOrPrev) {
        this.nextOrPrev = nextOrPrev;
    }

    // 播放进度
    public int getPausePosition() {
        return pausePosition;
    }

    public void setPausePosition(int pausePosition) {
        this.pausePosition = pausePosition;
    }

    // 播放列表
    // 播放模式列表

    // 是否暂停状态
    //播放音乐

    // 当前播放的歌

    // 切换歌曲
    // 上一首：参数 id，修改当前播放的歌
    // 下一首：参数 id，修改当前播放的歌

    public int getCurrentMusicIndex() {
        return currentMusicIndex;
    }

    public void setCurrentMusicIndex(int currentMusicIndex) {
        this.currentMusicIndex = currentMusicIndex;
    }

    public int getPlayStatus () {
        return playStatus;
    }

    public void setPlayStatus (int playStatus){
        this.playStatus = playStatus;
    }

    // 主动切换歌曲：参数 id，修改当前播放的歌
    // 被动切换歌曲：调用下一首函数
    private void changeIndex() {
        int id = getCurrentMusicIndex();
        switch(playStatus){
            case STATUS_SINGLE:
                single(id);
                break;
            case STATUS_RANDOM:
                random(id);
                break;
            case STATUS_SEQUENCE:
                sequence(id);
                break;
            default:
                break;
        }
    }

    // 切换播放模式：生成新的播放模式列表
    // 播放模式：单曲循环，列表循环，随机播放
    // 单曲循环
    private void single (int id) {
        id++;
        id--;
        setCurrentMusicIndex(id);
        setPausePosition(0);
    }
    //随机播放
    private void random (int id) {
        id = new Random().nextInt(musics.size());
        setCurrentMusicIndex(id);
        setPausePosition(0);
    }
    //列表循环
    private void sequence (int id) {
        //下一首
        if(getNextOrPrev() == MODE_NEXT){
            id++;
        }
        //上一首
        else if(getNextOrPrev() == MODE_PREV){
            id--;
        }
        setCurrentMusicIndex(id);
        if (id >= musics.size()) {
            setCurrentMusicIndex(0);
        }
        setPausePosition(0);
    }
    // 下载：参数 id + 码率，调用下载api
    // 使用示例：downloadMusic("http://m7.music.126.net/20200617163101/82fe5cadce3a9ad025dd4829bf36cae6/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3","Mymusic.mp3")
    //动态获取文件名
        //    String s = GET_URL;
        //    int i = s.lastIndexOf("/");
        //    String FileName= s.substring(i + 1);
    //加载路径
    //String path = Environment.getExternalStorageDirectory().toString() + "/Mydownload";
    public static void downloadMusic(final String path,final String filename){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setReadTimeout(5000);
                    con.setConnectTimeout(5000);
                    con.setRequestProperty("Charset", "UTF-8");
                    con.setRequestMethod("GET");
                    if (con.getResponseCode() == 200) {
                        InputStream is = con.getInputStream();//获取输入流
                        FileOutputStream fileOutputStream = null;//文件输出流
                        if (is != null) {
                            FileUtils fileUtils = new FileUtils();
                            fileOutputStream = new FileOutputStream(fileUtils.createFile(filename));//指定文件保存路径
                            byte[] buf = new byte[1024];
                            int ch;
                            while ((ch = is.read(buf)) != -1) {
                                fileOutputStream.write(buf, 0, ch);//将获取到的流写入文件中
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    // 喜欢：参数 id + 喜欢/取消喜欢，调用喜欢api
    private void likeMusic(String id,boolean like){

    }

    void run(Long musicId){
        this.musicId=musicId;
        GetMusicTask getMusicTask = new GetMusicTask();
        getMusicTask.execute();
    }

    class GetMusicTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
            music = manager.getMusicUrlById(String.valueOf(musicId));
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progresses) {
            ToastUtil.getInstance().showToast(MyApplication.getContext(), "获取中", Toast.LENGTH_SHORT);
        }

        @Override
        protected void onPostExecute(String result) {
            // 任务完成后代码
        }
    }
}



