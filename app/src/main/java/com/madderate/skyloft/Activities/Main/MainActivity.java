package com.madderate.skyloft.Activities.Main;

import android.os.Bundle;
import android.view.View;

import com.madderate.skyloft.Activities.BaseActivity;
import com.madderate.skyloft.R;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 如果用户没有登录则启动LoginActivity
        // 在该函数之前需要获取用户信息，并初始化UserInformation类对象userInfo
        // startLoginActivityIfUserNotLogin();

    }

    // 当用户信息为空时
    // 跳转登录界面让用户进行登录
    private void startLoginActivityIfUserNotLogin() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {/*
            case R.id.phone_login_button:
                onClickTestButton();
                break;*/
        }
    }
    private void onClickTestButton(){}
}