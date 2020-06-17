package com.madderate.skyloft.ViewModels.Main;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.Playlist;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    // 变量

    // 日推

    // 推荐
    // 最近播放

    private ArrayList<Playlist> recentPlayed;
    private ArrayList<Playlist> popular;
    private ArrayList<Playlist> recommendPlaylist;
    private ArrayList<Playlist> latestAlbum;

    public ArrayList<Playlist> getRecentPlayed() {
        return recentPlayed;
    }

    public void setRecentPlayed(ArrayList<Playlist> recentPlayed) {
        this.recentPlayed = recentPlayed;
    }

    public ArrayList<Playlist> getPopular() {
        return popular;
    }

    public void setPopular(ArrayList<Playlist> popular) {
        this.popular = popular;
    }

    public ArrayList<Playlist> getRecommendPlaylist() {
        return recommendPlaylist;
    }

    public void setRecommendPlaylist(ArrayList<Playlist> recommendPlaylist) {
        this.recommendPlaylist = recommendPlaylist;
    }

    public ArrayList<Playlist> getLatestAlbum() {
        return latestAlbum;
    }

    public void setLatestAlbum(ArrayList<Playlist> latestAlbum) {
        this.latestAlbum = latestAlbum;
    }
}
