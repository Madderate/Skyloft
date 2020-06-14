package com.madderate.skyloft.ViewModels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.regex.Pattern;

public class RegisterViewModel extends ViewModel {

    private final String PHONE_REGEX_PATTERN = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$";

    private String phoneNumber;
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        // phoneNumber不能为空
        // phoneNumber只能为11位
        // phoneNumber要能匹配对应的正则表达式
        isPhoneValid = this.phoneNumber != null && this.phoneNumber.length() == 11 && Pattern.matches(PHONE_REGEX_PATTERN, this.phoneNumber);
        Log.d("LoginViewModel", "phone number: " + isPhoneValid);
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private boolean isPhoneValid = false;
    private boolean isFinished = false;

    public boolean isPhoneValid() {
        return isPhoneValid;
    }

    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
        // 测试代码
        if (isFinished) {
            Log.d("RegisterViewModel", "send register message");
            isFinished = false;
        }
    }
}
