package com.madderate.skyloft.Task;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.madderate.skyloft.Activities.Main.MainActivity;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.Utils.EncodeUtil;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

public class LoginByPhoneTask extends AsyncTask<String, Integer, String> {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private String phoneNumber;
    private String password;

    InterfaceManager manager = new InterfaceManager();

    public LoginByPhoneTask(String phoneNumber, String password, Context context) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        manager.loginByPhone(phoneNumber, EncodeUtil.replaceURLSpecialChar(password), "86");
        User.getInstance().setUserInfo(manager.getUserMessage(String.valueOf(User.getInstance().getAccount().getId())));
        manager.setCookie(User.getInstance().getCookie());
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progresses) {
        ToastUtil.getInstance().showToast(context, "登录中", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPostExecute(String result) {
        if (User.getInstance().getUserInfo() != null) {
            ToastUtil.getInstance().showToast(context, R.string.login_success, Toast.LENGTH_SHORT);
            ActivityUtils.jumpToActivity(
                    context,
                    MainActivity.class,
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_NO_HISTORY
            );
        } else
            ToastUtil.getInstance().showToast(context, "登录失败！", Toast.LENGTH_SHORT);
    }
}
