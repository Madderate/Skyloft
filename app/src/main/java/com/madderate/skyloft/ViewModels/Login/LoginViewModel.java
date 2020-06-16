package com.madderate.skyloft.ViewModels.Login;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Models.Account;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Utils.InterfaceManager;

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
        Log.d("LoginViewModel", "phone number: " + isPhoneValid);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        // password不能为空
        // password长度在6到16字符之间
        isPasswordValid = this.password != null && this.password.length() >= 6 && this.password.length() <= 16;
        Log.d("LoginViewModel", "password: " + isPasswordValid);
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

        /* 测试代码
        Log.d("LoginViewModel", "phone login");
*/
        InterfaceManager interfaceManager = new InterfaceManager();

        interfaceManager.loginByPhone("15070922393","bushengtao16b","86");

        Log.d("LoginViewModel",String.valueOf(User.getInstance().getAccount().getUserName()));
        //interfaceManager.setCookie(User.getInstance().getAccount().getCookie());

        System.out.println(interfaceManager.getUserMessage(String.valueOf(User.getInstance().getAccount().getId())));

/*
        InterfaceManager manager = new InterfaceManager();

        if (isPhoneValid && isPasswordValid) {

            AccountInfo accountInfo = manager.loginByPhone(phoneNumber, EncodeUtil.replaceURLSpecialChar(password), "86");

            Account user = Account.getInstance();
            user.setAccountInfo(accountInfo);

            ActivityUtils.jumpToActivity(
                    context,
                    MainActivity.class,
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_NO_HISTORY
            );
        }

 */
    }

    public void emailLogin() {

        // 测试代码
        Log.d("LoginViewModel", "email login");
    }
}
