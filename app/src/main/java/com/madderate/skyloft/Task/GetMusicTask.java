package com.madderate.skyloft.Task;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;

public class GetMusicTask extends AsyncTask<String, Integer, String> {
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ArrayList<Music> music;

    public String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected String doInBackground(String... params) {
        InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());
        music = manager.getMusicUrlById(id);
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
