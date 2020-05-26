package com.madderate.skyloft.models;

import java.util.List;

public class Song extends Information {
    private List<Artist> artists;
    private Album album;
    private long duration;
    private Information copyright; // 未来可能会有Copyright类
    private Information mv; // 未来有机会的话还会推出MV类
    private List<PlayList> belongingPlayList;

    public List<PlayList> getBelongingPlayList() {
        return belongingPlayList;
    }

    public void setBelongingPlayList(List<PlayList> belongingPlayList) {
        this.belongingPlayList = belongingPlayList;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Information getCopyright() {
        return copyright;
    }

    public void setCopyright(Information copyright) {
        this.copyright = copyright;
    }

    public Information getMv() {
        return mv;
    }

    public void setMv(Information mv) {
        this.mv = mv;
    }
}
