package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.madderate.skyloft.R;
import com.madderate.skyloft.ViewModels.RegisterViewModel;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private RegisterViewModel registerViewModel;
    private Toolbar registerToolbar;

    private Button registerButton;
    private EditText etPhone;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerViewModel =
                new ViewModelProvider(RegisterActivity.this)
                        .get(RegisterViewModel.class);

        registerToolbar = findViewById(R.id.register_toolbar);
        registerToolbar.setTitle(R.string.register);
        setSupportActionBar(registerToolbar);

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        etPhone = findViewById(R.id.et_phone);
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
            }
        });

        etPassword = findViewById(R.id.et_password);
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
}