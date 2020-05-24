package com.madderate.skyloft.utils;

/*
* 网络通信类，使用api时请先声明此类
*/

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {
    private final String TAG = "CommunicationManager";
    private String ip = "121.37.168.191";
    private int port = 3000 ;
    private String ipAddress;
    public HttpURLConnection httpURLC;

    public CommunicationManager(){
        setIpAndPort(ip,port);
    }
    public CommunicationManager(String ip ,int port){
        setIpAndPort(ip,port);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setIpAndPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.ipAddress = "http://" + this.ip + ":" + this.port;
    }

    public void httpGetter(String interUrl){
        String registerUrl = ipAddress + interUrl;
        // Log.d(TAG,registerUrl);
        try {
            URL url = new URL(registerUrl);
            httpURLC = (HttpURLConnection) url.openConnection();
            httpURLC.setRequestMethod("POST");
            httpURLC.setConnectTimeout(1000*5);
            httpURLC.setReadTimeout(1000*5);
            httpURLC.setDoInput(true);
            httpURLC.setDoOutput(true);
            httpURLC.setRequestProperty("phone", "");
            httpURLC.setRequestProperty("password", "");
            httpURLC.connect();//连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String loginTest() {
        final StringBuilder str = new StringBuilder();
        try {
            int httpCode = httpURLC.getResponseCode();
            if (httpCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLC.getInputStream();
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
        return "";
    }
}
