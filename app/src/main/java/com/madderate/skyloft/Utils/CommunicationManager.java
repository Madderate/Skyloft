package com.madderate.skyloft.Utils;

/*
* 网络通信类，使用api时请先声明此类
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CommunicationManager {
    private final String TAG = "CommunicationManager";
    private String ip = "121.37.168.191";
    private int port = 3000 ;
    private String ipAddress;

    private HttpURLConnection httpURLC;

    private String interUrl;
    private String body;

    public void setInterUrl(String interUrl) {
        this.interUrl = interUrl;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getHttpCode() {
        return httpCode;
    }

    private int httpCode = -1;

    private String text = null;

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

    public HttpURLConnection getHttpURLC() {
        return httpURLC;
    }

    public void setHttpURLC(HttpURLConnection httpURLC) {
        this.httpURLC = httpURLC;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIpAndPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.ipAddress = "http://" + this.ip + ":" + this.port;
    }

    public void httpGetter(){
        final String registerUrl = ipAddress + interUrl;
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(registerUrl);
                    httpURLC = (HttpURLConnection) url.openConnection();
                    httpURLC.setRequestMethod("POST");
                    httpURLC.setDoInput(true);
                    httpURLC.setDoOutput(true);
                    httpURLC.setUseCaches(false);
                    httpURLC.connect();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpURLC.getOutputStream(), StandardCharsets.UTF_8));
                    writer.write(body);
                    writer.close();
                    httpCode = httpURLC.getResponseCode();
                    test();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void test() {
        final StringBuilder str = new StringBuilder();
        try {
            if (httpCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLC.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    str.append(line);
                }
                text = str.toString();
            } else {
                text = String.valueOf(httpCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        text = "异常-"+httpCode;
    }
}
