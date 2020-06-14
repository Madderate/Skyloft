package com.madderate.skyloft.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class LoginActivity extends BaseActivity {

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
        loginViewModel =
                new ViewModelProvider(LoginActivity.this)
                        .get(LoginViewModel.class);

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 当标志isFirstStart为true时
        // 尝试加载一个新Fragment到布局中
        if (loginViewModel.isFirstStart()) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // 如果isPhoneLoginFragment标志位true
            // 则加载一个PhoneLoginFragment对象
            // 否则加载一个EmailLoginFragment对象
            if (loginViewModel.isPhoneLoginFragment())
                transaction.replace(R.id.login_fragment, new PhoneLoginFragment());
            else
                transaction.replace(R.id.login_fragment, new EmailLoginFragment());

            transaction.commit();
        }
        loginViewModel.setFirstStart(false);
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
                    // 切换Fragment时，就是创建一个新的对象
                    if (destFragment == R.string.phone_login_fragment) {
                        PhoneLoginFragment fragment = new PhoneLoginFragment();
                        loginViewModel.setPhoneLoginFragment(true);
                        ActivityUtils.replaceFragment(fragmentManager, R.id.login_fragment, fragment);
                    } else if (destFragment == R.string.email_login_fragment) {
                        EmailLoginFragment fragment = new EmailLoginFragment();
                        loginViewModel.setPhoneLoginFragment(false);
                        ActivityUtils.replaceFragment(fragmentManager, R.id.login_fragment, fragment);
                    }

                    int destActivity = bundle.getInt(context.getString(R.string.jump_to), 0);
                    if (destActivity == R.string.register_activity) {
                        loginViewModel.setFirstStart(true);
                        ActivityUtils.jumpToActivity(context, RegisterActivity.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}