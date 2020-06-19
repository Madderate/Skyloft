package com.madderate.skyloft.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.madderate.skyloft.Models.MusicInfo;

public abstract class BasePlayReceiver extends BroadcastReceiver {

    public static final String ACTION = "com.madderate.skyloft.myapplication.PLAY_RECEIVER";
    public static final String EXTRA_TYPE = "type";

    public static final String TYPE_ON_INIT_SOURCE = "onInitSource";
    public static final String EXTRA_SOURCE = "source";

    public static final String TYPE_ON_PREPARED = "onPrepared";

    public static final String TYPE_ON_COMPLETION = "onCompletion";

    public static final String TYPE_ON_PLAY_STATUS = "onPlayStatus";

    public static final String TYPE_ON_BUFFERING_UPDATE = "onBufferingUpdate";
    public static final String EXTRA_PERCENT = "percent";

    public static final String TYPE_ON_ERROR = "onError";
    public static final String EXTRA_WHAT = "what";
    public static final String EXTRA_EXTRA = "extra";

    public static void registerReceiver(Context context, BasePlayReceiver basePlayReceiver) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(BasePlayReceiver.ACTION);
        context.registerReceiver(basePlayReceiver, filter);
    }

    public static void unregisterReceiver(Context context, BasePlayReceiver basePlayReceiver) {
        if (basePlayReceiver != null) {
            context.unregisterReceiver(basePlayReceiver);
        }
    }

    public static void sendBroadcastInitSource(Context context, MusicInfo music) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_INIT_SOURCE);
        intent.putExtra(BasePlayReceiver.EXTRA_SOURCE, music);
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastPrepared(Context context) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_PREPARED);
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastCompletion(Context context) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_COMPLETION);
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastPlayStatus(Context context) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_PLAY_STATUS);
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastBufferingUpdate(Context context, int percent) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_BUFFERING_UPDATE);
        intent.putExtra(BasePlayReceiver.EXTRA_PERCENT, percent);
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastError(Context context, int what, int extra) {
        Intent intent = new Intent();
        intent.setAction(BasePlayReceiver.ACTION);
        intent.putExtra(BasePlayReceiver.EXTRA_TYPE, BasePlayReceiver.TYPE_ON_ERROR);
        intent.putExtra(BasePlayReceiver.EXTRA_WHAT, what);
        intent.putExtra(BasePlayReceiver.EXTRA_EXTRA, extra);
        context.sendBroadcast(intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!BasePlayReceiver.ACTION.equals(intent.getAction()) || intent.getExtras() == null) {
            return;
        }
        Bundle bundle = intent.getExtras();
        String type = bundle.getString(BasePlayReceiver.EXTRA_TYPE);
        if (TYPE_ON_INIT_SOURCE.equals(type)) {
            onInitSource((MusicInfo) bundle.getSerializable(EXTRA_SOURCE));
        } else if (TYPE_ON_PREPARED.equals(type)) {
            onPrepared();
        } else if (TYPE_ON_COMPLETION.equals(type)) {
            onCompletion();
        } else if (TYPE_ON_PLAY_STATUS.equals(type)) {
            onPlayStatus();
        } else if (TYPE_ON_BUFFERING_UPDATE.equals(type)) {
            onBufferingUpdate(bundle.getInt(EXTRA_PERCENT));
        } else if (TYPE_ON_ERROR.equals(type)) {
            onError(bundle.getInt(EXTRA_WHAT), bundle.getInt(EXTRA_EXTRA));
        }
    }

    protected abstract void onInitSource(MusicInfo music);

    protected abstract void onPrepared();

    protected abstract void onCompletion(); // 资源播放完成

    protected abstract void onPlayStatus();

    protected abstract void onBufferingUpdate(int percent);

    protected abstract void onError(int what, int extra);
}
