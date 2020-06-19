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

public class GetMusicInfoTask extends AsyncTask<String, Integer, String> {
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ArrayList<MusicInfo> musicInfo;

    public ArrayList<String> ids;

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<MusicInfo> getMusicInfo() {
        return musicInfo;
    }

    public void setMusicInfo(ArrayList<MusicInfo> musicInfo) {
        this.musicInfo = musicInfo;
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    @Override
    protected String doInBackground(String... params) {
        InterfaceManager manager = new InterfaceManager(User.getInstance().getCookie());

        StringBuilder body = new StringBuilder();
        for (String i:ids) {
            body.append(i);
        }

        musicInfo = manager.getMusicDetail(body.toString());
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
