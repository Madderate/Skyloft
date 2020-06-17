package com.madderate.skyloft.ViewModels.MusicPlay;

import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class PlayerViewModel extends ViewModel {

    // 变量
    private List<Integer> musics;
    private MediaPlayer player;

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
    private void downloadMusic(int id,int br){

    }
    // 喜欢：参数 id + 喜欢/取消喜欢，调用喜欢api
    private void likeMusic(int id,int br){

    }

}



