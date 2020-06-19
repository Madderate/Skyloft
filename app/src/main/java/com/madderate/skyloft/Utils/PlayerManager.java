package com.madderate.skyloft.Utils;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.util.Log;

import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Receivers.BasePlayReceiver;

import java.util.List;
import java.util.Random;

public class PlayerManager implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener {

    public static final String TAG = "PlayerManager";

    public enum PlayMode {
        ORDER,  // 顺序
        LOOP,   // 循环
        RANDOM, // 随机
        REPEAT  // 单曲
    }

    private MusicPlayer mMusicPlayer;
    private List<MusicInfo> musicList;
    private int index;
    private PlayMode mPlayMode = PlayMode.ORDER;
    private MusicInfo nowPlaying;
    private AudioFocusManager audioFocusManager;

    // -----------------------
    // 获取实例
    private PlayerManager() {
    }

    private static class SingletonHolder {
        private static PlayerManager instance = new PlayerManager();
    }

    public static PlayerManager getInstance() {
        return SingletonHolder.instance;
    }
    // -----------------------

    // -----------------------
    // 重写的方法
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        BasePlayReceiver.sendBroadcastPrepared(MyApplication.getContext());
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        BasePlayReceiver.sendBroadcastCompletion(MyApplication.getContext());
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.e(TAG, "MusicPlayer onError what " + what + " extra " + extra);
        release();
        next();
        BasePlayReceiver.sendBroadcastError(MyApplication.getContext(), what, extra);
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        start();
        BasePlayReceiver.sendBroadcastPrepared(MyApplication.getContext());
    }
    // ------------------------


    public void init() {
        mMusicPlayer = new MusicPlayer();

        // 使用唤醒锁
        mMusicPlayer.setWakeMode(MyApplication.getContext(), PowerManager.PARTIAL_WAKE_LOCK);
        mMusicPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMusicPlayer.setOnCompletionListener(this);
        mMusicPlayer.setOnPreparedListener(this);
        mMusicPlayer.setOnBufferingUpdateListener(this);
        mMusicPlayer.setOnErrorListener(this);

        audioFocusManager = new AudioFocusManager();
    }

    // --------------------------
    // setters
    public void setIndex(int index) {
        this.index = index;
    }

    public void setMusicList(List<MusicInfo> musicList) {
        this.musicList = musicList;
    }

    public void setMusicListAndIndex(List<MusicInfo> musicList, int index) {
        this.musicList = musicList;
        this.index = index;
    }
    // --------------------------

    private void play(MusicInfo music) {
        if (music == null) {
            Log.e(TAG, "没有可用资源");
            return;
        }
        if (mMusicPlayer == null) {
            init();
        }
        if (getStatus() == MusicPlayer.Status.INITIALIZED) {
            Log.e(TAG, "正在准备上一个资源，请稍后");
            return;
        }
        mMusicPlayer.reset();
        nowPlaying = music;

        // 更新Notification

        BasePlayReceiver.sendBroadcastInitSource(MyApplication.getContext(), music);
    }

    private void play(String dataSource) {
        try {
            mMusicPlayer.setDataSource(dataSource);
            mMusicPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "该资源无法播放");
            BasePlayReceiver.sendBroadcastPrepared(MyApplication.getContext());
        }
    }

    private void start() {
        if (!audioFocusManager.requestAudioFocus()) {
            Log.e(TAG, "获取音频焦点失败");
        }
        mMusicPlayer.start();

        // 更新Notification

        BasePlayReceiver.sendBroadcastPlayStatus(MyApplication.getContext());
    }


    public void pause() {
        if (getStatus() == MusicPlayer.Status.STARTED) {
            mMusicPlayer.pause();
            BasePlayReceiver.sendBroadcastPlayStatus(MyApplication.getContext());

            // 更新Notification

            // 取消音频焦点
            if (audioFocusManager != null) {
                audioFocusManager.abandonAudioFocus();
            }
        }
    }

    public void resume() {
        if (getStatus() == MusicPlayer.Status.PAUSED) {
            start();
        }
    }

    public void stop() {
        if (getStatus() == MusicPlayer.Status.STARTED
                || getStatus() == MusicPlayer.Status.PAUSED
                || getStatus() == MusicPlayer.Status.COMPLETED) {
            mMusicPlayer.stop();
            BasePlayReceiver.sendBroadcastPlayStatus(MyApplication.getContext());

            // 更新Notification

            if (audioFocusManager != null) {
                audioFocusManager.abandonAudioFocus();
            }
        }
    }

    public void release() {
        if (mMusicPlayer == null) {
            return;
        }
        nowPlaying = null;
        Log.d(TAG, "release");
        mMusicPlayer.release();
        mMusicPlayer = null;
        if (audioFocusManager != null) {
            audioFocusManager.abandonAudioFocus();
        }
        audioFocusManager = null;
    }

    public void seekTo(int mSec) {
        if (getStatus() == MusicPlayer.Status.STARTED
                || getStatus() == MusicPlayer.Status.PAUSED
                || getStatus() == MusicPlayer.Status.COMPLETED) {
            mMusicPlayer.seekTo(mSec);
        }
    }

    public void play() {
        MusicInfo music = getPlaying();
        play(music);
    }

    public void next() {
        MusicInfo data = getNextPlaying();
        play(data);
    }

    public void previous() {
        MusicInfo music = getPreviousPlaying();
        play(music);
    }

    public MusicInfo getNowPlaying() {
        if (nowPlaying != null) {
            return nowPlaying;
        } else {
            return getPlaying();
        }
    }

    public int getCurrentPosition() {
        if (getStatus() == MusicPlayer.Status.STARTED
                || getStatus() == MusicPlayer.Status.PAUSED) {
            return mMusicPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (getStatus() == MusicPlayer.Status.STARTED
                || getStatus() == MusicPlayer.Status.PAUSED) {
            return mMusicPlayer.getDuration();
        }
        return 0;
    }

    public MusicPlayer.Status getStatus() {
        if (mMusicPlayer != null) {
            return mMusicPlayer.getState();
        } else {
            return MusicPlayer.Status.STOPPED;
        }
    }

    public MusicPlayer getMusicPlayer() {
        return mMusicPlayer;
    }

    public PlayMode getPlayMode() {
        return mPlayMode;
    }

    public int getIndex() {
        return index;
    }

    public List<MusicInfo> getMusicList() {
        return musicList;
    }

    private MusicInfo getNextPlaying() {
        switch (mPlayMode) {
            case ORDER:
                index = index + 1;
                return getPlaying();
            case LOOP:
                index = (index + musicList.size() - 1) % musicList.size();
                return getPlaying();
            case RANDOM:
                index = new Random().nextInt(musicList.size()) % musicList.size();
                return getPlaying();
            case REPEAT:
                return getPlaying();
            default:
                break;
        }
        return null;
    }

    private MusicInfo getPreviousPlaying() {
        switch (mPlayMode) {
            case ORDER:
                index -= 1;
                return getPlaying();
            case LOOP:
                index = (index + musicList.size() - 1) % musicList.size();
                return getPlaying();
            case RANDOM:
                index = new Random().nextInt(musicList.size()) % musicList.size();
                return getPlaying();
            case REPEAT:
                return getPlaying();
            default:
                break;
        }
        return null;
    }

    private MusicInfo getPlaying() {
        if (musicList != null && !musicList.isEmpty() && index >= 0 && index < musicList.size()) {
            return musicList.get(index);
        } else
            return null;
    }


}
