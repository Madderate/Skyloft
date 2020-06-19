package com.madderate.skyloft.ViewModels.Main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class UserPlayListViewModel extends ViewModel {
    ArrayList<Playlist> userPlaylist;

    void run(){
        GetUserPlaylistTask getMusicTask = new GetUserPlaylistTask();
        getMusicTask.execute();
    }

    class GetUserPlaylistTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
            userPlaylist = manager.getPlayList(String.valueOf(User.getInstance().getAccount().getId()));
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
