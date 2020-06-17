package com.madderate.skyloft.ViewModels.Login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Activities.Main.MainActivity;
import com.madderate.skyloft.Models.Account;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.Utils.EncodeUtil;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.regex.Pattern;

public class LoginViewModel extends ViewModel {

    private final String PHONE_REGEX_PATTERN = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$";
    private final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    private String phoneNumber;
    private String password;
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        // phoneNumber不能为空
        // phoneNumber只能为11位
        // phoneNumber要能匹配对应的正则表达式
        isPhoneValid = this.phoneNumber != null && this.phoneNumber.length() == 11 && Pattern.matches(PHONE_REGEX_PATTERN, this.phoneNumber);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        // password不能为空
        // password长度在6到16字符之间
        isPasswordValid = this.password != null && this.password.length() >= 6 && this.password.length() <= 16;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        // email不为空
        // email能够匹配对应的正则表达式
        isEmailValid = this.email != null && Pattern.matches(EMAIL_REGEX_PATTERN, this.email);
        Log.d("LoginViewModel", "email: " + isEmailValid);
    }

    private boolean isPhoneValid = false;
    private boolean isEmailValid = false;
    private boolean isPasswordValid = false;

    public boolean isPhoneValid() {
        return isPhoneValid;
    }

    public boolean isEmailValid() {
        return isEmailValid;
    }

    public boolean isPasswordValid() {
        return isPasswordValid;
    }

    // 管理首次加载的Fragment
    private boolean isFirstStart = true;
    private boolean isPhoneLoginFragment = true;

    public boolean isPhoneLoginFragment() {
        return isPhoneLoginFragment;
    }

    public void setPhoneLoginFragment(boolean phoneLoginFragment) {
        isPhoneLoginFragment = phoneLoginFragment;
    }

    public boolean isFirstStart() {
        return isFirstStart;
    }

    public void setFirstStart(boolean firstStart) {
        isFirstStart = firstStart;
    }

    public void phoneLogin(Context context) {

        if (isPhoneValid && isPasswordValid) {
            InterfaceManager manager = new InterfaceManager();
            manager.loginByPhone(phoneNumber, EncodeUtil.replaceURLSpecialChar(password), "86");

            Log.d("LoginViewModel",User.getInstance().toString());

            User.getInstance().setUserInfo(manager.getUserMessage(String.valueOf(User.getInstance().getAccount().getId())));

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
                return;
            }
        }
        ToastUtil.getInstance().showToast(context, R.string.login_phone_login_failed, Toast.LENGTH_SHORT);
        isPhoneValid = false;
        isPasswordValid = false;
    }

    public void emailLogin() {

        // 测试代码
        Log.d("LoginViewModel", "email login");
    }
}