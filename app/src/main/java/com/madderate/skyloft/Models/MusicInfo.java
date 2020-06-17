package com.madderate.skyloft.Models;

import java.util.ArrayList;
import java.util.List;

public class MusicInfo {
    private String name;
    private int id;
    // 艺术家
    private ArrayList<Artist> artist;
    // 歌曲封面
    private SongPic al;
    // 持续时间
    private int dt;
    // 可用性
    private int available;
    // 歌词:/lyric?id=33894312
    private String lrc;
    // 不同码率的歌
    private ArrayList<Song> songs;

    // 选择不同码率的歌
    private int chooseCodeRate = 320000;

    public void setChooseCodeRate(int chooseCodeRate){
        this.chooseCodeRate = chooseCodeRate;
    }

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

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getAvailable() {
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

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public int getChooseCodeRate() {
        return chooseCodeRate;
    }

    static class Song{
        private int id;
        // 相应码率的歌曲url:/song/url?id=33894312&br=320000
        private String url;
        private int br;
        private int size;
        private String level;
        private String encodeType;

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

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEncodeType() {
            return encodeType;
        }

        public void setEncodeType(String encodeType) {
            this.encodeType = encodeType;
        }
    }
    static class SongPic{
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
