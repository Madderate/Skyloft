package com.madderate.skyloft.Models;

import com.madderate.skyloft.Models.MusicInfo;

public class UserPlayRecord {
    private MusicInfo musicInfo;
    private long playCount;
    private long score;

    public MusicInfo getMusicInfo() {
        return musicInfo;
    }

    public void setMusicInfo(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
