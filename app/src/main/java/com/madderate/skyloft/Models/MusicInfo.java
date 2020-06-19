package com.madderate.skyloft.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicInfo implements Serializable {
    private String name;
    private long id;
    // 艺术家
    private ArrayList<Artist> artist;
    // 专辑
    private SongPic al;
    // 持续时间
    private long dt;
    // 可用性
    private long available;
    // 歌词:/lyric?id=33894312
    private String lrc;
    // 不同码率的歌
    private ArrayList<Music> songs;

    // 专辑封面
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    // 选择不同码率的歌
    private long chooseCodeRate = 320000;

    public void setChooseCodeRate(int chooseCodeRate){
        this.chooseCodeRate = chooseCodeRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Artist> getAr() {
        return artist;
    }

    public void setAr(ArrayList<Artist> artist) {
        this.artist = artist;
    }

    public SongPic getAl() {
        return al;
    }

    public void setAl(SongPic al) {
        this.al = al;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public ArrayList<Music> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Music> songs) {
        this.songs = songs;
    }

    public long getChooseCodeRate() {
        return chooseCodeRate;
    }

    static public class SongPic{
        private String name;
        private int id;
        private String url;
        private SongPic al;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public SongPic getAl() {
            return al;
        }

        public void setAl(SongPic al) {
            this.al = al;
        }
    }
}
