package com.madderate.skyloft.Activities.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.madderate.skyloft.Activities.BaseActivity;
import com.madderate.skyloft.Activities.Login.LoginActivity;
import com.madderate.skyloft.Activities.Main.Fragments.RecommendFragment;
import com.madderate.skyloft.Models.Account;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mainToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private View navHeader;

    private CircleImageView avatar;
    private TextView userName;
    private TextView userIntro;

    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initWidgets();

        // 获取一个账号实例
        account = Account.getInstance();

        try {
            if (account.getUserInfo() != null) {
                setAvatar();        // 设置头像
                setUserName();      // 设置用户名
                setUserIntro();     // 设置签名
            } else {
                Glide.with(MainActivity.this)
                        .load(R.mipmap.avatar)
                        .into((ImageView) avatar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAvatar() throws NullPointerException {
        if (account.getUserInfo().getProfile() == null
                || account.getUserInfo().getProfile().getAvatarUrl() == null)
            throw new NullPointerException();
        String userAvatarUrl = account.getUserInfo().getProfile().getAvatarUrl();
        Uri userAvatarUri = Uri.parse(userAvatarUrl);
        // 使用Glide给avatar区域添加占位图
        Glide.with(MainActivity.this)
                .load(userAvatarUri)
                .placeholder(R.mipmap.avatar)
                .error(R.mipmap.avatar)
                .into((ImageView) avatar);
    }

    private void setUserName() throws NullPointerException {
        if (account.getUserInfo().getProfile() == null
                || account.getUserInfo().getProfile().getNickname() == null)
            throw new NullPointerException();
        String name = account.getUserInfo().getProfile().getNickname();
        userName.setText(name);
    }

    private void setUserIntro() {
        if (account.getUserInfo().getProfile() == null
                || account.getUserInfo().getProfile().getSignature() == null)
            throw new NullPointerException();
        String signature = account.getUserInfo().getProfile().getSignature();
        userIntro.setText(signature);
    }

    private void initWidgets() {
        navView = findViewById(R.id.main_activity_nav_view);
        // 得到NavigationView的头部
        navHeader = navView.getHeaderView(0);
        avatar = (CircleImageView) navHeader.getRootView().findViewById(R.id.avatar);
        userName = (TextView) navHeader.getRootView().findViewById(R.id.user_name);
        userIntro = (TextView) navHeader.getRootView().findViewById(R.id.user_intro);

        navView.setCheckedItem(R.id.nav_recommend);
        navView.setNavigationItemSelectedListener(this);

        navHeader.setOnClickListener(this);
    }

    private void initLayout() {
        setContentView(R.layout.main_main_activity);

        drawerLayout = findViewById(R.id.main_activity_drawer_layout);

        mainToolbar = findViewById(R.id.main_toolbar);
        // 暂时给这个Activity的标题设为"为你推荐"
        mainToolbar.setTitle(R.string.main_nav_recommend);
        setSupportActionBar(mainToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        RecommendFragment fragment = new RecommendFragment();
        ActivityUtils.replaceFragment(getSupportFragmentManager(), R.id.main_activity_fragment_container, fragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav_header:
                account = Account.getInstance();
                if (account.getAccountInfo() == null)
                    ActivityUtils.jumpToActivity(MainActivity.this, LoginActivity.class, Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // 不同菜单项的操作
        drawerLayout.closeDrawers();
        return true;
    }
}