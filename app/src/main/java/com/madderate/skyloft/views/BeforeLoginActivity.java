package com.madderate.skyloft.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.madderate.skyloft.R;
import com.madderate.skyloft.utils.AccountManager;
import com.madderate.skyloft.utils.CommunicationManager;
import com.madderate.skyloft.utils.SimplifiedToast;
import com.madderate.skyloft.views.fragments.before_login.LoginFragment;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeforeLoginActivity extends AppCompatActivity {

    private Toolbar loginToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_login);

        loginToolbar = findViewById(R.id.loginToolbar); // 将登录页的toolbar和Activity绑定起来
        loadFragment(); // 加载传递过来的Intent对应的fragment

        setSupportActionBar(loginToolbar);
    }

    private void loadFragment() {
        Set<String> categories = getIntent().getCategories();
        if (categories.contains(getString(R.string.before_login_phone_number_login_category))) {
            loginToolbar.setTitle(getString(R.string.login));
            replaceFragment(new LoginFragment(BeforeLoginActivity.this));
        } else if (categories.contains(getString(R.string.before_login_email_login_category))) {

        } else if (categories.contains(getString(R.string.before_login_register_category))) {

        }
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragmentContainer, fragment).
                commit();
    }
}
