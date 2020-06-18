package com.madderate.skyloft.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.R;

import java.util.List;

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {

    private List<Playlist> albums;
    private Context context;

    public ThumbnailAdapter(List<Playlist> albums, Context context) {
        this.albums = albums;
        this.context = context;
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
        Playlist album = albums.get(position);
        Uri coverUri = Uri.parse(album.getCoverImgUrl());
        Glide.with(context).load(coverUri).into(holder.cover);
        holder.name.setText(album.getName());
//        holder.creator.setText();
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