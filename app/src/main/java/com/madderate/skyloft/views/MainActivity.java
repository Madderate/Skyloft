package com.madderate.skyloft.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.madderate.skyloft.R;
import com.madderate.skyloft.models.UserInformation;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    }

    // 当用户信息为空时
    // 跳转登录界面让用户进行登录
    private void startLoginActivityIfUserNotLogin() {
        if (userInfo == null) {
            userInfo = new UserInformation();
            Intent intent = new Intent(getString(R.string.before_login_action));
            intent.addCategory(getString(R.string.before_login_phone_number_login_category));
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
//        CommunicationManager c = new CommunicationManager();
//        c.httpGetter(new AccountManager().phoneLoginInter("","","86"));
//        tv.setText(c.loginTest());
    }
}