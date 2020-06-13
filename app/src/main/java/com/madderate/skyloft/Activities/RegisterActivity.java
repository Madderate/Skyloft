package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.madderate.skyloft.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar registerToolbar = findViewById(R.id.register_toolbar);
        registerToolbar.setTitle(R.string.register);
        setSupportActionBar(registerToolbar);
    }
}