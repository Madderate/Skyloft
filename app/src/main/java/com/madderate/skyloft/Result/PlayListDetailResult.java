package com.madderate.skyloft.Result;


import com.madderate.skyloft.Models.Playlist;

public class PlayListDetailResult {
    boolean relatedVideos;
    Playlist playlist;
    String urls;

    public boolean isRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(boolean relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
