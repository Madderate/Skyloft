package com.madderate.skyloft.Utils;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.madderate.skyloft.Application.MyApplication;

public class AudioFocusManager implements AudioManager.OnAudioFocusChangeListener {

    public static final String TAG = "AudioFocusManager";
    private AudioManager audioManager;

    private boolean isPausedByFocusLossTransient;

    public AudioFocusManager() {
        audioManager = (AudioManager) MyApplication.getContext()
                .getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean requestAudioFocus() {
        return audioManager
                .requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN)
                == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }

    public void abandonAudioFocus() {
        audioManager.abandonAudioFocus(this);
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            // 重新获得焦点
            case AudioManager.AUDIOFOCUS_GAIN:
                if (isPausedByFocusLossTransient) {
                    PlayerManager.getInstance().resume();
                }
                PlayerManager.getInstance()
                        .getMusicPlayer()
                        .setVolume(1f, 1f);
                isPausedByFocusLossTransient = false;
                Log.d(TAG, "onAudioFocusChange: 重新获得焦点");
                break;
            // 永久失去焦点
            case AudioManager.AUDIOFOCUS_LOSS:

                break;
            // 短暂丢失焦点
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                PlayerManager.getInstance().pause();
                isPausedByFocusLossTransient = true;
                Log.d(TAG, "onAudioFocusChange: 短暂失去焦点");
                break;
            // 瞬间丢失焦点
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                PlayerManager.getInstance()
                        .getMusicPlayer()
                        .setVolume(0.5f, 0.5f);
                Log.d(TAG, "onAudioFocusChange: 瞬间失去焦点");
                break;
        }
    }
}
