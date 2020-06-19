package com.madderate.skyloft.Activities.Main.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madderate.skyloft.Activities.SongListActivity;
import com.madderate.skyloft.Adapters.SongListThumbnailAdapter;
import com.madderate.skyloft.Adapters.SongThumbnailAdapter;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.ItemDecorations.ThumbnailHorizontalItemDecoration;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.Utils.ToastUtil;
import com.madderate.skyloft.ViewModels.Main.MainViewModel;

import java.util.Objects;

public class RecommendFragment extends Fragment implements View.OnClickListener {

    public static final String ACTION = "com.madderate.skyloft.Main.Fragments.RECOMMEND";
    public static final String EXTRA_TYPE = "extra_type";

    public static final String EXTRA_GET_SONG_LIST_FINISHED = "get_song_list_finished";
    public static final String EXTRA_GET_SONG_LIST_FAILED = "get_song_list_failed";

    private MainViewModel mainViewModel;

    private TextView recentPlayedTitle;
    private RecyclerView recentPlayedRecyclerView;
    private Button recentPlayedShowAll;
    private TextView popularTitle;
    private RecyclerView popularRecyclerView;
    private TextView recommendPlaylistTitle;
    private RecyclerView recommendPlaylistRecyclerView;
    private TextView latestAlbumTitle;
    private RecyclerView latestAlbumRecyclerView;

    private SongListThumbnailAdapter songListThumbnailAdapter;
    private SongThumbnailAdapter songThumbnailAdapter;
    private ThumbnailHorizontalItemDecoration decoration;

    private RecommendReceiver receiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        registerReceiver();

        View view = inflater.inflate(R.layout.main_main_activity_recommend_fragment, container, false);

        try {
            mainViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(MainViewModel.class);
            mainViewModel.getSongListInfo();
            initWidgets(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION);
        receiver = new RecommendReceiver();
        MyApplication.getContext().registerReceiver(receiver, filter);
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApplication.getContext().unregisterReceiver(receiver);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recent_played_view_all:
                ActivityUtils.jumpToActivity(getActivity(), SongListActivity.class, Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
    }

    class RecommendReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!ACTION.equals(intent.getAction()) || intent.getExtras() == null) {
                return;
            }
            String extra = intent.getStringExtra(EXTRA_TYPE);
            if (EXTRA_GET_SONG_LIST_FINISHED.equals(extra)) {
//                ToastUtil.getInstance().showToast(MyApplication.getContext(), "Things are all done", Toast.LENGTH_SHORT);
                try {
                    setRecyclerViews();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (EXTRA_GET_SONG_LIST_FAILED.equals(extra)) {
                ToastUtil.getInstance().showToast(MyApplication.getContext(), "FAILED!", Toast.LENGTH_SHORT);
            }
        }
    }

    private void setRecyclerViews() {
        decoration = new ThumbnailHorizontalItemDecoration(
                MyApplication.getContext()
                        .getResources()
                        .getDisplayMetrics()
                        .density
        );

        try {
            // popular
            songThumbnailAdapter = new SongThumbnailAdapter(mainViewModel.popular);
            popularRecyclerView.setAdapter(songThumbnailAdapter);
            popularRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
            popularRecyclerView.addItemDecoration(decoration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // recommend playlist
            songListThumbnailAdapter = new SongListThumbnailAdapter(mainViewModel.recommendPlaylist);
            recommendPlaylistRecyclerView.setAdapter(songListThumbnailAdapter);
            recommendPlaylistRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
            recommendPlaylistRecyclerView.addItemDecoration(decoration);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // latest album
            songListThumbnailAdapter = new SongListThumbnailAdapter(mainViewModel.latestAlbum);
            latestAlbumRecyclerView.setAdapter(songListThumbnailAdapter);
            recommendPlaylistRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
            recommendPlaylistRecyclerView.addItemDecoration(decoration);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LinearLayoutManager getHorizontalLinearLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return layoutManager;
    }

    public static void sendSongListLoadedBroadcast() {
        Intent intent = new Intent(ACTION);
        intent.putExtra(EXTRA_TYPE, EXTRA_GET_SONG_LIST_FINISHED);
        MyApplication.getContext().sendBroadcast(intent);
    }

    public static void sendSongListLoadedFailedBroadcast() {
        Intent intent = new Intent(ACTION);
        intent.putExtra(EXTRA_TYPE, EXTRA_GET_SONG_LIST_FAILED);
        MyApplication.getContext().sendBroadcast(intent);
    }
}
