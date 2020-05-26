package com.madderate.skyloft.models;

import java.util.List;

public class Album extends Information {
    private List<Artist> artists;
    private long publishTime; // 毫秒计时
    private long size; // 歌曲数量
    private Information copyright; // 未来可能会有Copyright类
    private Illustration avatar;
    private List<Song> songs;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Information getCopyright() {
        return copyright;
    }

    public void setCopyright(Information copyright) {
        this.copyright = copyright;
    }

    public Illustration getAvatar() {
        return avatar;
    }

    public void setAvatar(Illustration avatar) {
        this.avatar = avatar;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
