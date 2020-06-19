package com.madderate.skyloft.Activities;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.R;

public class PlayerActivity extends BaseActivity {

//    private MusicInfo info;
    private String url = "";

    ExoPlayer mPlayer;
    MyApplication myApplication;
    HttpProxyCacheServer proxy;
    String proxyUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);

        RenderersFactory renderersFactory = new DefaultRenderersFactory(this);
        DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);
        LoadControl loadControl = new DefaultLoadControl();

    }

//    static class MyThread extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected String doInBackground(Void... voids) {
//            return null;
//        }
//    }
}
