package com.madderate.skyloft.views;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.madderate.skyloft.AccountManager;
import com.madderate.skyloft.CommunicationManager;
import com.madderate.skyloft.R;
import com.madderate.skyloft.models.UserInformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HandlerThread handlerThread;
    private Handler handler;
    private ImageView imageView;
    private TextView tv;

    private UserInformation userInfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StrictMode.setThreadPolicy(
//                new StrictMode.ThreadPolicy.Builder().
//                        detectDiskReads().
//                        detectDiskWrites().
//                        detectNetwork().
//                        penaltyLog().
//                        build()
//        );
//        StrictMode.setVmPolicy(
//                new StrictMode.VmPolicy.Builder().
//                        detectLeakedSqlLiteObjects().
//                        detectLeakedClosableObjects().
//                        penaltyLog().
//                        penaltyDeath().
//                        build()
//        );
        setContentView(R.layout.activity_main);

        // 如果用户没有登录则启动LoginActivity
        // 在该函数之前需要获取用户信息，并初始化UserInformation类对象userInfo
        startLoginActivityIfUserNotLogin();

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    // 当用户信息为空时
    // 跳转登录界面让用户进行登录
    private void startLoginActivityIfUserNotLogin() {
        if (userInfo == null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                onClickLoginButton(v);
                break;
            default:
                break;
        }
    }

    private void onClickLoginButton(View v) {
        CommunicationManager c = new CommunicationManager();
        c.httpGetter(new AccountManager().phoneLoginInter("","","86"));
        tv.setText(c.loginTest());
    }
}