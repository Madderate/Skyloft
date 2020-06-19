package com.madderate.skyloft.ViewModels.Login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class PlayerViewModel extends ViewModel {
    ArrayList<Music> music;

    Long musicId;

    void run(Long musicId){
        this.musicId=musicId;
        GetMusicTask getMusicTask = new GetMusicTask();
        getMusicTask.execute();
    }

    class GetMusicTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
            music = manager.getMusicUrlById(String.valueOf(musicId));
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
