package com.madderate.skyloft.Activities.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.madderate.skyloft.Activities.BaseActivity;
import com.madderate.skyloft.R;
import com.madderate.skyloft.ViewModels.Login.RegisterViewModel;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private RegisterViewModel registerViewModel;
    private Toolbar registerToolbar;

    private Button registerButton;

    private TextInputLayout etPhoneLayout;
    private TextInputLayout etPasswordLayout;
    private TextInputEditText etPhone;
    private TextInputEditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.login_register_activity);

            registerViewModel = new ViewModelProvider(RegisterActivity.this)
                    .get(RegisterViewModel.class);
            initToolbar();
            initWidgets();
            setTextWatcher();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initToolbar() throws NullPointerException {
        registerToolbar = findViewById(R.id.register_toolbar);
        registerToolbar.setTitle(R.string.login_register_title);
        setSupportActionBar(registerToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initWidgets() {
        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        etPhoneLayout = findViewById(R.id.et_register_phone_layout);
        etPasswordLayout = findViewById(R.id.et_register_password_layout);
        etPhone = findViewById(R.id.et_register_phone);
        etPassword = findViewById(R.id.et_register_password);

    }

    private void setTextWatcher() {
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                registerViewModel.setPhoneNumber(s.toString());
                if (!registerViewModel.isPhoneValid()) {
                    etPhoneLayout.setError("请输入正确的手机号！");
                } else {
                    etPhoneLayout.setError(null);
                }
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                registerViewModel.setPassword(s.toString());
                if (!registerViewModel.isPasswordValid()) {
                    etPasswordLayout.setError("密码长度应在6-16位");
                } else {
                    etPasswordLayout.setError(null);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                registerViewModel.setFinished(true);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}