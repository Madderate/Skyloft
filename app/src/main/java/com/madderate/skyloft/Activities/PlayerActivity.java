package com.madderate.skyloft.Activities;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.R;

public class PlayerActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);


    }

//    static class MyThread extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected String doInBackground(Void... voids) {
//            return null;
//        }
//    }
}
