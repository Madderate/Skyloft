package com.madderate.skyloft.ViewModels.Login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class CaptchaViewModel extends ViewModel {

    private String captcha;
    private boolean isCaptchaValid = false;

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
        isCaptchaValid = this.captcha.length() == 4;
        Log.d("LoginViewModel", "is captcha valid: " + isCaptchaValid);
    }

    public boolean isCaptchaValid() {
        return isCaptchaValid;
    }

    public void sendCaptcha() {

    }
}
