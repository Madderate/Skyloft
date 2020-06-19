package com.madderate.skyloft.Activities.Main.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.madderate.skyloft.Activities.PlayerActivity;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Receivers.BasePlayReceiver;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.Utils.MusicPlayer;
import com.madderate.skyloft.Utils.PlayerManager;

import java.util.Objects;

public class PlayerBarFragment extends Fragment implements View.OnClickListener {

    public static final String ACTION = "com.madderate.skyloft.Activities.Main.Fragments.PlayerBarFragment";
    public static final String EXTRA_TYPE = "extra_type";

    private LinearLayout playerBar;
    private ImageView albumThumbnailSmall;
    private TextView playingMusicName;
    private ImageView playerBarPlay;
    private ImageView playerBarNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_bar_layout, container, false);
        try {
            initWidgets(view);
            setAlbumThumbnailSmall();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void setAlbumThumbnailSmall() throws NullPointerException {
        if (getActivity() == null)
            throw new NullPointerException();
        Glide.with(getActivity()).load(R.mipmap.thumbnail_placeholder).into(albumThumbnailSmall);
    }

    private void initWidgets(View view) throws NullPointerException {
        if (view == null) {
            throw new NullPointerException();
        }
        playerBar = view.findViewById(R.id.player_bar);
        playerBar.setOnClickListener(this);

        albumThumbnailSmall = view.findViewById(R.id.album_thumbnail_small);
        playingMusicName = view.findViewById(R.id.playing_music_name);

        playerBarPlay = view.findViewById(R.id.player_bar_play);
        playerBarNext = view.findViewById(R.id.player_bar_next);
        playerBarPlay.setOnClickListener(this);
        playerBarNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.player_bar == id) {
            ActivityUtils.jumpToActivity(MyApplication.getContext(), PlayerActivity.class, Intent.FLAG_ACTIVITY_NEW_TASK);
        } else if (R.id.player_bar_play == id) {

        } else if (R.id.player_bar_next == id) {

        }
    }

//    class PlayerBarReceiver extends BasePlayReceiver {
//
//        private PlayerManager manager = PlayerManager.getInstance();
//
//        @Override
//        protected void onInitSource(MusicInfo music) {
//            playingMusicName.setText(music.getName());
//            Glide.with(MyApplication.getContext())
//                    .load(music.getPicUrl())
//                    .into(albumThumbnailSmall);
//        }
//
//        @Override
//        protected void onPrepared() {
//
//        }
//
//        @Override
//        protected void onCompletion() {
//            if (manager.getStatus() == MusicPlayer.Status.STARTED) {
//                Glide.with(MyApplication.getContext()).load(R.drawable.ic_pause).into(playerBarPlay);
//            } else if (manager.getStatus() == MusicPlayer.Status.STOPPED) {
//                Glide.with(MyApplication.getContext()).load(R.drawable.ic_play).into(playerBarPlay);
//            }
//        }
//
//        @Override
//        protected void onPlayStatus() {
//
//        }
//
//        @Override
//        protected void onBufferingUpdate(int percent) {
//
//        }
//
//        @Override
//        protected void onError(int what, int extra) {
//
//        }
//    }
}
