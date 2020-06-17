package com.madderate.skyloft.Activities.Login;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.madderate.skyloft.Activities.BaseActivity;
import com.madderate.skyloft.R;
import com.madderate.skyloft.ViewModels.Login.CaptchaViewModel;

public class CaptchaActivity extends BaseActivity implements View.OnClickListener {

    private CaptchaViewModel captchaViewModel;

    private Toolbar captchaToolbar;

    private Button sendCaptcha;
    private TextInputLayout etCaptchaLayout;
    private TextInputEditText etCaptcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_captcha_activity);

        captchaViewModel = new ViewModelProvider(CaptchaActivity.this).get(CaptchaViewModel.class);

        initWidgets();
        initToolbar();
    }

    private void initWidgets() {
        captchaToolbar = findViewById(R.id.captcha_toolbar);
        sendCaptcha = findViewById(R.id.send_captcha);
        etCaptchaLayout = findViewById(R.id.et_captcha_layout);
        etCaptcha = findViewById(R.id.et_captcha);

        sendCaptcha.setOnClickListener(this);
        setTextWatchers();
    }

    private void initToolbar() {
        captchaToolbar.setTitle(R.string.input_captcha);
        setSupportActionBar(captchaToolbar);
    }

    private void setTextWatchers() {
        etCaptcha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                captchaViewModel.setCaptcha(s.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_captcha:
                captchaViewModel.sendCaptcha();
                break;
        }
    }
}