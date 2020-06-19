package com.madderate.skyloft.ViewModels.Main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Activities.Main.Fragments.RecommendFragment;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public ArrayList<PlaylistResult> recentPlayed;
    public ArrayList<MusicInfo> popular;
    public ArrayList<PlaylistResult> recommendPlaylist;
    public ArrayList<PlaylistResult> latestAlbum;

//    private GetMainPageInfoTask mainPageInfoTask;

    public void getSongListInfo() {
//        mainPageInfoTask = new GetMainPageInfoTask();
//        mainPageInfoTask.execute();
        new GetMainPageInfoTask().execute();
    }

    class GetMainPageInfoTask extends AsyncTask<String, Integer, String> {

        public static final String FINISHED = "finished";

        public GetMainPageInfoTask() {
        }

        @Override
        protected String doInBackground(String... params) {
            InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
            recommendPlaylist = manager.getPersonalizedPlaylist("50");
            latestAlbum = manager.getNewestAlbum();
            popular = manager.getNewestMusic();
            return FINISHED;
        }

//        @Override
//        protected void onProgressUpdate(Integer... progresses) {
//            ToastUtil.getInstance().showToast(MyApplication.getContext(), "获取中", Toast.LENGTH_SHORT);
//        }


        @Override
        protected void onPostExecute(String result) {
            if (FINISHED.equals(result)) {
                RecommendFragment.sendSongListLoadedBroadcast();
            } else
                RecommendFragment.sendSongListLoadedFailedBroadcast();
        }
    }
}
