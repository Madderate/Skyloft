package com.madderate.skyloft.ViewModels.Main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.UserPlayRecord;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    ArrayList<UserPlayRecord> recentPlayed;
    ArrayList<MusicInfo> popular;
    ArrayList<PlaylistResult> recommendPlaylist;
    ArrayList<PlaylistResult> latestAlbum;


    public void run(){
        GetMainPageInfoTask mainPageInfoTask = new GetMainPageInfoTask();
        mainPageInfoTask.execute();
    }



    class GetMainPageInfoTask extends AsyncTask<String, Integer, String> {
        @SuppressLint("StaticFieldLeak")

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
}
