package com.madderate.skyloft.Activities.Main.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madderate.skyloft.Activities.SongListActivity;
import com.madderate.skyloft.Adapters.ThumbnailAdapter;
import com.madderate.skyloft.ItemDecorations.ThumbnailHorizontalItemDecoration;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.ViewModels.Main.MainViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecommendFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mainViewModel;
    // temp list
    List<Playlist> tempList;

    private TextView recentPlayedTitle;
    private RecyclerView recentPlayedRecyclerView;
    private Button recentPlayedShowAll;
    private TextView popularTitle;
    private RecyclerView popularRecyclerView;
    private TextView recommendPlaylistTitle;
    private RecyclerView recommendPlaylistRecyclerView;
    private TextView latestAlbumTitle;
    private RecyclerView latestAlbumRecyclerView;

    private ThumbnailAdapter adapter;
    private ThumbnailHorizontalItemDecoration decoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_main_activity_recommend_fragment, container, false);

        try {
            mainViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(MainViewModel.class);

            initWidgets(view);
            setRecyclerViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initWidgets(View view) {
        recentPlayedTitle = view.findViewById(R.id.recent_played_title);
        recentPlayedShowAll = view.findViewById(R.id.recent_played_view_all);
        recentPlayedRecyclerView = view.findViewById(R.id.recent_played_recycler_view);
        popularTitle = view.findViewById(R.id.popular_title);
        popularRecyclerView = view.findViewById(R.id.popular_recycler_view);
        recommendPlaylistTitle = view.findViewById(R.id.recommend_playlist_title);
        recommendPlaylistRecyclerView = view.findViewById(R.id.recommend_playlist_recycler_view);
        latestAlbumTitle = view.findViewById(R.id.latest_albums_title);
        latestAlbumRecyclerView = view.findViewById(R.id.latest_album_recycler_view);

        recentPlayedShowAll.setOnClickListener(this);
    }

    private void setRecyclerViews() {

        adapter = new ThumbnailAdapter(tempList, getActivity());


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
