package com.madderate.skyloft.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class ActivityUtils {

    // 通过BroadcastReceiver来更换Fragment
    // context: 用来获取LocalBroadcastManager的实例
    // action: 用来给Intent对象赋予action
    // bundle: 广播过程中传递的信息
    public static void sendReplaceFragmentBroadcast(Context context, String action, Bundle bundle) {
        Intent intent = new Intent(action);
        intent.putExtras(bundle);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.sendBroadcast(intent);
    }

    // Activity的跳转
    // context: 用来创建Intent对象以及进行跳转
    // activity: 指定要跳转到的Activity
    public static void jumpToActivity(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    // 替换Fragment
    // fragmentManager: 管理Fragment的修改
    // replacedWidget: 被替换的widget对应的id
    // fragment: 要替换上来的Fragment对象
    public static void replaceFragment(FragmentManager fragmentManager, int replacedWidget, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(replacedWidget, fragment);
        transaction.commit();
    }

}
