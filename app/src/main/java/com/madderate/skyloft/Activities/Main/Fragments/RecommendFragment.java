package com.madderate.skyloft.Activities.Main.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madderate.skyloft.Activities.SongListActivity;
import com.madderate.skyloft.Adapters.SongListThumbnailAdapter;
import com.madderate.skyloft.ItemDecorations.SongListThumbnailHorizontalItemDecoration;
import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecommendFragment extends Fragment implements View.OnClickListener {

    private TextView recentPlayedTitle;
    private RecyclerView recentPlayedRecyclerView;
    private Button recentPlayedShowAll;
    private TextView popularTitle;
    private RecyclerView popularRecyclerView;
    private TextView singerRecommend0Title;
    private RecyclerView singerRecommend0RecyclerView;
    private TextView languageRecommendTitle;
    private RecyclerView languageRecommendRecyclerView;
    private TextView singerRecommend1Title;
    private RecyclerView singerRecommend1RecyclerView;

    private SongListThumbnailAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_main_activity_recommend_fragment, container, false);
        initWidgets(view);
        return view;
    }

    private void initWidgets(View view) {
        recentPlayedShowAll = view.findViewById(R.id.recent_played_view_all);
        recentPlayedShowAll.setOnClickListener(this);
    }

    private LinearLayoutManager getHorizontalLinearLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return layoutManager;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recent_played_view_all:
                ActivityUtils.jumpToActivity(getActivity(), SongListActivity.class, Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
    }
}
