package com.madderate.skyloft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.madderate.skyloft.Models.Album;
import com.madderate.skyloft.R;

import java.util.List;

public class SongListThumbnailAdapter extends RecyclerView.Adapter<SongListThumbnailAdapter.ViewHolder> {

    private List<Album> albums;
    private Context context;

    public SongListThumbnailAdapter(List<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_song_list_thumbnail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albums.get(position);
        Glide.with(context).load(album.getAvatar().getBitmap()).into(holder.cover);
        holder.name.setText(album.getName());
        holder.creator.setText(album.getArtists().get(0).getName());
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
