package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.madderate.skyloft.Activities.Fragments.EmailLoginFragment;
import com.madderate.skyloft.Activities.Fragments.PhoneLoginFragment;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.ViewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    private static LoginViewModel loginViewModel;

    private LoginBroadcastReceiver broadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getSupportFragmentManager();

        // 初始化LoginViewModel
        // ViewModel总是由一个ViewModelProvider来管理
        // ViewModelProvider接收一个Fragment或FragmentActivity对象
        // 如果传入相同的对象以及相同的ViewModel class，就能获得相同的ViewModel实例
        loginViewModel = new ViewModelProvider(LoginActivity.this).get(LoginViewModel.class);
        // 初始化一个Fragment对象
        // 以PhoneLoginFragment为初始对象
        if (loginViewModel.getPhoneLoginFragment() == null) {
            PhoneLoginFragment fragment = new PhoneLoginFragment();
            fragment.setContext(LoginActivity.this);
            loginViewModel.setPhoneLoginFragment(fragment);
        }

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
        // 当没有EmailLoginFragment实例同时有PhoneLoginFragment的实例时
        // 将PhoneLoginFragment加载到Activity布局中
        if (loginViewModel.getEmailLoginFragment() == null && loginViewModel.getPhoneLoginFragment() != null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.login_fragment, loginViewModel.getPhoneLoginFragment());
            transaction.commit();
        }
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
                    // 切换Fragment时，记得将上一个Fragment对象置为空
                    // 防止数据因为对象残留而在Fragment切换过程中被保留
                    if (destFragment == R.string.phone_login_fragment) {
                        PhoneLoginFragment fragment = new PhoneLoginFragment();
                        fragment.setContext(context);
                        loginViewModel.setPhoneLoginFragment(fragment);
                        loginViewModel.setEmailLoginFragment(null);
                        ActivityUtils.replaceFragment(fragmentManager, R.id.login_fragment, loginViewModel.getPhoneLoginFragment());
                    } else if (destFragment == R.string.email_login_fragment) {
                        EmailLoginFragment fragment = new EmailLoginFragment();
                        fragment.setContext(context);
                        loginViewModel.setEmailLoginFragment(fragment);
                        loginViewModel.setPhoneLoginFragment(null);
                        ActivityUtils.replaceFragment(fragmentManager, R.id.login_fragment, loginViewModel.getEmailLoginFragment());
                    }

                    int destActivity = bundle.getInt(context.getString(R.string.jump_to), 0);
                    if (destActivity == R.string.register_activity) {
                        ActivityUtils.jumpToActivity(context, RegisterActivity.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}