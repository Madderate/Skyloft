package com.madderate.skyloft.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.R;

import java.util.ArrayList;
import java.util.List;

public class SongThumbnailAdapter extends RecyclerView.Adapter<SongThumbnailAdapter.ViewHolder> {

    private List<MusicInfo> musicList;

    public SongThumbnailAdapter(ArrayList<MusicInfo> songs) {
        if (songs.size() > 10) {
            this.musicList = songs.subList(0, 10);
        } else {
            this.musicList = songs;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.thumbnail_layout, parent, false);
        return new SongThumbnailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MusicInfo song = musicList.get(position);
        MusicInfo.SongPic album = song.getAl();
        List<Artist> artists = song.getAr();
        Uri coverUri = Uri.parse(album.getUrl());
        Glide.with(MyApplication.getContext()).load(coverUri).into(holder.cover);
        holder.name.setText(album.getName());
        holder.creator.setText(artists.toString());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView name;
        TextView creator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.cover);
            name = itemView.findViewById(R.id.name);
            creator = itemView.findViewById(R.id.creator);
        }
    }
}
