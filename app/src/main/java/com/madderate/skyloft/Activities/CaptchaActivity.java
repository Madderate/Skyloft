package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.madderate.skyloft.R;
import com.madderate.skyloft.ViewModels.CaptchaViewModel;

public class CaptchaActivity extends BaseActivity implements View.OnClickListener {

    private CaptchaViewModel captchaViewModel;

    private Button sendCaptcha;
    private EditText etCaptcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captcha);

        captchaViewModel = new ViewModelProvider(CaptchaActivity.this).get(CaptchaViewModel.class);

        sendCaptcha = findViewById(R.id.send_captcha);
        sendCaptcha.setOnClickListener(this);

        etCaptcha = findViewById(R.id.et_captcha);
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