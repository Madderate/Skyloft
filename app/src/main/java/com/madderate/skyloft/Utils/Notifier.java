package com.madderate.skyloft.Utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Receivers.NotificationReceiver;
import com.madderate.skyloft.Services.PlayerService;

public class Notifier {

    public static final String CHANNEL_ID = "channel_id_audio";
    public static final String CHANNEL_NAME = "channel_name_audio";
    public static final String CHANNEL_ID_DEFAULT = "channel_id_default";
    public static final String EXTRA_NOTIFICATION = "com.madderate.skyloft.NOTIFICATION";
    private static final int NOTIFICATION_ID = 0x123;
    private PlayerService playerService;
    private NotificationManager notificationManager;
    private String packageName;
    private Notification notification;

    private Notifier() {
    }

    private static class SingletonHolder {
        private static Notifier instance = new Notifier();
    }

    public static Notifier getInstance() {
        return SingletonHolder.instance;
    }

    public void init(PlayerService playerService) {
        this.playerService = playerService;
        this.notificationManager =
                (NotificationManager) playerService.getSystemService(Context.NOTIFICATION_SERVICE);
        this.playerService.startForeground(
                NOTIFICATION_ID,
                buildNotification(playerService, PlayerManager.getInstance().getNowPlaying())
        );
        this.packageName = MyApplication.getContext().getPackageName();
    }

    public void stopForeground() {
        this.playerService.stopForeground(true);
    }

    public void showPlayInfo(MusicInfo music) {
        this.notificationManager.notify(
                NOTIFICATION_ID,
                buildNotification(playerService, music)
        );
    }

    private Notification buildNotification(Context context, MusicInfo music) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            channel.enableLights(false);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContent(getRemoteViews(playerService, music));
        notification = builder.build();
        return notification;
    }

    private RemoteViews getRemoteViews(Context context, MusicInfo music) {
        final RemoteViews remoteViews =
                new RemoteViews(context.getPackageName(), R.layout.player_bar_layout);
        if (music == null) {
            remoteViews.setTextViewText(R.id.playing_music_name, "暂无歌曲播放");
            remoteViews.setViewVisibility(R.id.player_bar_play, View.GONE);
            remoteViews.setViewVisibility(R.id.player_bar_next, View.GONE);
            remoteViews.setImageViewResource(R.id.album_thumbnail_small, R.mipmap.thumbnail_placeholder);
        } else {
            remoteViews.setTextViewText(R.id.playing_music_name, music.getName());
            remoteViews.setViewVisibility(R.id.player_bar_play, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.player_bar_next, View.VISIBLE);
            remoteViews.setImageViewResource(R.id.player_bar_play, getPlayIconRes());
            Glide.with(context)
                    .asBitmap()
                    .load(music.getPicUrl())
                    .placeholder(R.mipmap.thumbnail_placeholder)
                    .error(R.mipmap.thumbnail_placeholder)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            remoteViews.setImageViewBitmap(R.id.album_thumbnail_small, resource);
                        }
                    });
            Intent playIntent = new Intent(NotificationReceiver.ACTION_STATUS_BAR);
            playIntent.putExtra(NotificationReceiver.EXTRA, NotificationReceiver.EXTRA_PLAY);
            PendingIntent playPendingIntent = PendingIntent.getBroadcast(context, 1, playIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.player_bar_play, playPendingIntent);

            Intent nextIntent = new Intent(NotificationReceiver.ACTION_STATUS_BAR);
            nextIntent.putExtra(NotificationReceiver.EXTRA, NotificationReceiver.EXTRA_NEXT);
            PendingIntent nextPendingIntent = PendingIntent.getBroadcast(context, 2, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.player_bar_next, nextPendingIntent);
        }
        return remoteViews;
    }

    private int getPlayIconRes() {
        if (PlayerManager.getInstance().getStatus() == MusicPlayer.Status.STARTED) {
            return R.drawable.ic_pause;
        } else {
            return R.drawable.ic_play;
        }
    }
}
