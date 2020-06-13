package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import com.madderate.skyloft.Activities.Fragments.EmailLoginFragment;
import com.madderate.skyloft.Activities.Fragments.PhoneLoginFragment;
import com.madderate.skyloft.R;

public class LoginActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    private LoginBroadcastReceiver broadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();

        // 获取本地广播管理员的实例
        localBroadcastManager = LocalBroadcastManager.getInstance(LoginActivity.this);
        broadcastReceiver = new LoginBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(getString(R.string.login_action));
        // 注册这个receiver为本地广播监听器
        localBroadcastManager.registerReceiver(broadcastReceiver, filter);

        // 初始化Toolbar
        Toolbar loginToolbar = findViewById(R.id.login_toolbar);
        loginToolbar.setTitle(R.string.login);
        setSupportActionBar(loginToolbar);

        // 初始fragment
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();
        transaction.replace(R.id.login_fragment, new PhoneLoginFragment(LoginActivity.this));
        transaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    static private class LoginBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                try {
                    int destFragment = bundle.getInt(context.getString(R.string.replace_to), 0);
                    if (destFragment == R.string.phone_login_fragment) {
                        replaceFragment(new PhoneLoginFragment(context));
                    } else if (destFragment == R.string.email_login_fragment) {
                        replaceFragment(new EmailLoginFragment(context));
                    }
                    int destActivity = bundle.getInt(context.getString(R.string.jump_to), 0);
                    if (destActivity == R.string.register_activity) {
                        jumpToActivity(context, RegisterActivity.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void jumpToActivity(Context context, Class activity) {
            Intent intent = new Intent(context, activity);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        private void replaceFragment(Fragment fragment) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.login_fragment, fragment);
            transaction.commit();
        }
    }
}