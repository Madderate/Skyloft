package com.madderate.skyloft.ViewModels.Main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private ArrayList<PlaylistResult> recentPlayed;
    private ArrayList<MusicInfo> popular;
    private ArrayList<PlaylistResult> recommendPlaylist;
    private ArrayList<PlaylistResult> latestAlbum;

    private GetMainPageInfoTask mainPageInfoTask;

    public void getSongListInfo() {
        mainPageInfoTask = new GetMainPageInfoTask();
    }

    class GetMainPageInfoTask extends AsyncTask<String, Integer, String> {

        public GetMainPageInfoTask() {
        }

        @Override
        protected String doInBackground(String... params) {
            InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
            recommendPlaylist = manager.getPersonalizedPlaylist("50");
            latestAlbum = manager.getNewestAlbum();
            popular = manager.getNewestMusic();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progresses) {
            ToastUtil.getInstance().showToast(MyApplication.getContext(), "获取中", Toast.LENGTH_SHORT);
        }

        @Override
        protected void onPostExecute(String result) {
            // 任务完成后代码
        }
    }
}
