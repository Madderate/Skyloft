package com.madderate.skyloft.Activities.Main.Fragments;

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
import com.madderate.skyloft.R;

public class PlayerBarFragment extends Fragment {

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
        }catch (Exception e) {
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
        albumThumbnailSmall = view.findViewById(R.id.album_thumbnail_small);
        playingMusicName = view.findViewById(R.id.playing_music_name);
        playerBarPlay = view.findViewById(R.id.player_bar_play);
        playerBarNext = view.findViewById(R.id.player_bar_next);
    }
}
