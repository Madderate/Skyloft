package com.madderate.skyloft.Activities.Main.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madderate.skyloft.Adapters.SongListThumbnailAdapter;
import com.madderate.skyloft.ItemDecorations.SongListThumbnailHorizontalItemDecoration;
import com.madderate.skyloft.Models.Album;
import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.Models.Illustration;
import com.madderate.skyloft.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecommendFragment extends Fragment {

    private TextView recentPlayedTitle;
    private RecyclerView recentPlayedRecyclerView;
    private TextView popularTitle;
    private RecyclerView popularRecyclerView;
    private TextView singerRecommend0Title;
    private RecyclerView singerRecommend0RecyclerView;
    private TextView languageRecommendTitle;
    private RecyclerView languageRecommendRecyclerView;
    private TextView singerRecommend1Title;
    private RecyclerView singerRecommend1RecyclerView;

    private SongListThumbnailAdapter adapter;

    private List<Album> albums = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_main_activity_recommend_fragment, container, false);

        recentPlayedTitle = view.findViewById(R.id.recent_played_title);
        popularTitle = view.findViewById(R.id.popular_title);
        singerRecommend0Title = view.findViewById(R.id.singer_recommend_0_title);
        languageRecommendTitle = view.findViewById(R.id.language_recommend_title);
        singerRecommend1Title = view.findViewById(R.id.singer_recommend_1_title);

        recentPlayedRecyclerView = view.findViewById(R.id.recent_played_recycler_view);
        popularRecyclerView = view.findViewById(R.id.popular_recycler_view);
        singerRecommend0RecyclerView = view.findViewById(R.id.singer_recommend_0_recycler_view);
        languageRecommendRecyclerView = view.findViewById(R.id.language_recommend_recycler_view);
        singerRecommend1RecyclerView = view.findViewById(R.id.singer_recommend_1_recycler_view);

        // 初始一个album列表进行测试
        initAlbums();

        recentPlayedRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
        popularRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
        singerRecommend0RecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
        languageRecommendRecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());
        singerRecommend1RecyclerView.setLayoutManager(getHorizontalLinearLayoutManager());

        SongListThumbnailHorizontalItemDecoration itemDecoration = new SongListThumbnailHorizontalItemDecoration(
                getActivity().getResources().getDisplayMetrics().density);
        recentPlayedRecyclerView.addItemDecoration(itemDecoration);
        popularRecyclerView.addItemDecoration(itemDecoration);
        singerRecommend0RecyclerView.addItemDecoration(itemDecoration);
        languageRecommendRecyclerView.addItemDecoration(itemDecoration);
        singerRecommend1RecyclerView.addItemDecoration(itemDecoration);

        SongListThumbnailAdapter adapter = new SongListThumbnailAdapter(albums, getActivity());
        recentPlayedRecyclerView.setAdapter(adapter);
        popularRecyclerView.setAdapter(adapter);
        singerRecommend0RecyclerView.setAdapter(adapter);
        languageRecommendRecyclerView.setAdapter(adapter);
        singerRecommend1RecyclerView.setAdapter(adapter);

        recentPlayedTitle.setText(R.string.main_recommend_fragment_recent_played);
        popularTitle.setText(R.string.main_recommend_fragment_popular);
        singerRecommend0Title.setText(R.string.main_recommend_fragment_singer_recommend_0);
        languageRecommendTitle.setText(R.string.main_recommend_fragment_language_recommend);
        singerRecommend1Title.setText(R.string.main_recommend_fragment_singer_recommend_1);

        return view;
    }

    private LinearLayoutManager getHorizontalLinearLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return layoutManager;
    }

    private void initAlbums() {
        for (int i = 0; i < 5; i++) {
            Album album = new Album();

            album.setName("Changes Changes Changes Changes Changes");

            Artist artist = new Artist();
            artist.setName("Justin Bieber Justin Bieber Justin Bieber Justin Bieber");
            List<Artist> artists = new ArrayList<>();
            artists.add(artist);
            album.setArtists(artists);

            Bitmap bitmap = BitmapFactory.decodeResource(Objects.requireNonNull(getActivity()).getResources(), R.mipmap.song_list_thumbnail_placeholder);
            Illustration cover = new Illustration();
            cover.setBitmap(bitmap);
            album.setAvatar(cover);

            albums.add(album);
        }
    }
}
