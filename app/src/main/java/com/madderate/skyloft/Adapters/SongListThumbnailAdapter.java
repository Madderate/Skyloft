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
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongListThumbnailAdapter extends RecyclerView.Adapter<SongListThumbnailAdapter.ViewHolder> {

    private List<PlaylistResult> albums;

    public SongListThumbnailAdapter(ArrayList<PlaylistResult> albums) {
        if (albums.size() > 10) {
            int index = new Random().nextInt(albums.size() - 9) + 10;
            this.albums = albums.subList(index - 10, index);
        } else {
            this.albums = albums;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.thumbnail_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlaylistResult album = albums.get(position);
        Uri coverUri = Uri.parse(album.getPicUrl());
        Glide.with(MyApplication.getContext()).load(coverUri).into(holder.cover);
        holder.name.setText(album.getName());
        holder.creator.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return albums.size();
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