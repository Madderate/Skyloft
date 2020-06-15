package com.madderate.skyloft.Utils;

import android.content.Context;
import android.widget.Toast;

// Toast单例类
// 存储Toast与SimplifiedToast类对象
// 通过getInstance()方法获得对象
public class ToastUtil {

    private volatile static ToastUtil simpleToast;
    private static Toast toast;

    private ToastUtil() {
        // 在获取该单例对象时
        // 需要保证toast为null
        if (toast != null) {
            toast.cancel();
        }
        toast = null;
    }

    // 获取该类的单例
    public static ToastUtil getInstance() {
        if (simpleToast == null) {
            synchronized (ToastUtil.class) {
                if (simpleToast == null) {
                    simpleToast = new ToastUtil();
                }
            }
        }
        return simpleToast;
    }

    // 传入resource id显示Toast消息
    public void showToast(Context context, int resId, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, resId, duration);
        toast.show();

    }

    // 传入text显示Toast消息
    public void showToast(Context context, String text, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
