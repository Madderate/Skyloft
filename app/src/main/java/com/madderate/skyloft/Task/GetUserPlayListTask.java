package com.madderate.skyloft.Task;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.UserPlayRecord;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class GetUserPlayListTask extends AsyncTask<String, Integer, String> {
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ArrayList<UserPlayRecord> recentPlayed;
    public ArrayList<MusicInfo> popular;
    public ArrayList<PlaylistResult> recommendPlaylist;
    public ArrayList<PlaylistResult> latestAlbum;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<UserPlayRecord> getRecentPlayed() {
        return recentPlayed;
    }

    public void setRecentPlayed(ArrayList<UserPlayRecord> recentPlayed) {
        this.recentPlayed = recentPlayed;
    }

    public ArrayList<MusicInfo> getPopular() {
        return popular;
    }

    public void setPopular(ArrayList<MusicInfo> popular) {
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

    @Override
    protected String doInBackground(String... params) {
        InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
        recentPlayed = manager.getUserPlayRecord(String.valueOf(User.getInstance().getAccount().getId()),1);
        recommendPlaylist = manager.getPersonalizedPlaylist("50");
        latestAlbum = manager.getNewestAlbum();
        popular = manager.getNewestMusic();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progresses) {
        ToastUtil.getInstance().showToast(context, "获取中", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPostExecute(String result) {
        // 任务完成后代码
    }
}
