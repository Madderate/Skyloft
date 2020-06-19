package com.madderate.skyloft.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.madderate.skyloft.Utils.MusicPlayer;
import com.madderate.skyloft.Utils.PlayerManager;

public class NotificationReceiver extends BroadcastReceiver {

    public static final String ACTION_STATUS_BAR = "com.madderate.skyloft.NOTIFICATION_ACTIONS";
    public static final String EXTRA = "extra";
    public static final String EXTRA_PLAY = "play_pause";
    public static final String EXTRA_NEXT = "play_next";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String extra = intent.getStringExtra(EXTRA);
        if (EXTRA_PLAY.equals(extra)) {

            if (PlayerManager.getInstance().getStatus() == MusicPlayer.Status.STARTED) {
                PlayerManager.getInstance().pause();
            } else if (PlayerManager.getInstance().getStatus() == MusicPlayer.Status.PAUSED) {
                PlayerManager.getInstance().resume();
            }
        } else if (EXTRA_NEXT.equals(extra)) {
            PlayerManager.getInstance().next();
        }
    }
}
