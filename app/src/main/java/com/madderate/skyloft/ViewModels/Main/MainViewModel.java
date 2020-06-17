package com.madderate.skyloft.ViewModels.Main;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private ArrayList<PlaylistResult> recentPlayed;
    private ArrayList<PlaylistResult> popular;
    private ArrayList<PlaylistResult> recommendPlaylist;
    private ArrayList<PlaylistResult> latestAlbum;

//    private Runnable

    public void getMainData(){
        InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
        recommendPlaylist = manager.getPersonalizedPlaylist("50");
        latestAlbum = manager.getNewestAlbum();
        popular = manager.getNewestAlbum();
    }

    public ArrayList<PlaylistResult> getRecentPlayed() {
        return recentPlayed;
    }

    public void setRecentPlayed(ArrayList<PlaylistResult> recentPlayed) {
        this.recentPlayed = recentPlayed;
    }

    public ArrayList<PlaylistResult> getPopular() {
        return popular;
    }

    public void setPopular(ArrayList<PlaylistResult> popular) {
        this.popular = popular;
    }

    public ArrayList<PlaylistResult> getRecommendPlaylist() {
        return recommendPlaylist;
    }

    public void setRecommendPlaylist(ArrayList<PlaylistResult> recommendPlaylist) {
        this.recommendPlaylist = recommendPlaylist;
    }

    public ArrayList<PlaylistResult> getLatestAlbum() {
        return latestAlbum;
    }

    public void setLatestAlbum(ArrayList<PlaylistResult> latestAlbum) {
        this.latestAlbum = latestAlbum;
    }
}
