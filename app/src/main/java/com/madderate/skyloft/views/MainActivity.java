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

import com.madderate.skyloft.R;
import com.madderate.skyloft.models.UserInformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String ip = "121.37.168.191";
    public String ipAddress = "http://" + ip + ":3000";

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

        tv = findViewById(R.id.text);
    }

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

    String TAG = "MAIN";
    String testAccount = "?phone=15070922393&password=";

    String phoneLoginInter = "/login/cellphone";

    private void onClickLoginButton(View v) {
        tv.setText(PhoneLoginTest());
    }

    private String PhoneLoginTest() {
        final StringBuilder str = new StringBuilder();
        HttpURLConnection connection = HttpGetter(phoneLoginInter + testAccount);
        try {
            int httpCode = connection.getResponseCode();
            if (httpCode == 200) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;//一行一行的读取
                while ((line = bufferedReader.readLine()) != null) {
                    str.append(line);//把一行数据拼接到buffer里
                }
                return str.toString();
            } else {
                return String.valueOf(httpCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpURLConnection HttpGetter(String interUrl) {
        String registerUrl = ipAddress + interUrl;
        Log.d(TAG, registerUrl);
        try {
            URL url = new URL(registerUrl);
            HttpURLConnection getC = (HttpURLConnection) url.openConnection();
            getC.setRequestMethod("GET");
            getC.setConnectTimeout(1000 * 5);
            getC.setReadTimeout(1000 * 5);
            getC.setDoInput(true);//允许从服务端读取数据
            return getC;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}