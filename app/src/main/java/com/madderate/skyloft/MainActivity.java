package com.madderate.skyloft;
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
    private Button loginButton;
    private TextView tv;

    String ip = "192.168.31.81";
    String ipAddress = "http://" + ip + ":3000";

    private final int DOWNDLOAD = 1;
    private final int REGISTER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
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
    String refreshLoginStatusInter = "/login/cellphone";
    String getLoginStatusInter = "/login/status";

    private void onClickLoginButton(View v) {
        tv.setText(PhoneLoginTest());
    }

    private String PhoneLoginTest() {
        final StringBuilder str = new StringBuilder();
        HttpURLConnection connection = HttpGetter(phoneLoginInter+testAccount);
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

    private HttpURLConnection HttpGetter(String interUrl){
        String registerUrl = ipAddress + interUrl;
        Log.d(TAG,registerUrl);
        try {
            URL url = new URL(registerUrl);
            HttpURLConnection getC = (HttpURLConnection) url.openConnection();
            getC.setRequestMethod("GET");
            getC.setConnectTimeout(1000*5);
            getC.setReadTimeout(1000*5);
            getC.setDoInput(true);//允许从服务端读取数据
            return getC;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}