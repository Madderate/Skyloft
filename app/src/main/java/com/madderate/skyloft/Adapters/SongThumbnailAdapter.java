package com.madderate.skyloft.Adapters;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.madderate.skyloft.Application.MyApplication;
import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Receivers.BasePlayReceiver;
import com.madderate.skyloft.Services.PlayerService;
import com.madderate.skyloft.Utils.InterfaceManager;
import com.madderate.skyloft.Utils.MusicPlayer;
import com.madderate.skyloft.Utils.PlayerManager;
import com.madderate.skyloft.Utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class SongThumbnailAdapter extends RecyclerView.Adapter<SongThumbnailAdapter.ViewHolder> implements View.OnClickListener {

    private List<MusicInfo> musicList;

    public SongThumbnailAdapter(ArrayList<MusicInfo> songs) {
        if (songs.size() > 10) {
            this.musicList = songs.subList(0, 10);
        } else {
            this.musicList = songs;
        }
        new GetMusicUrlThread().execute();
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
        Glide.with(MyApplication.getContext()).load(song.getPicUrl()).into(holder.cover);
        holder.name.setText(song.getName());
        holder.creator.setVisibility(View.GONE);
        holder.songItem.setOnClickListener(this);
        holder.songItem.setTag(position);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    @Override
    public void onClick(View v) {
        ToastUtil.getInstance().showToast(MyApplication.getContext(), "Clicked", Toast.LENGTH_SHORT);
        int id = v.getId();
        if (R.id.song_list_item == id) {
            PlayerManager manager = PlayerManager.getInstance();
            if (manager.getStatus() == MusicPlayer.Status.STARTED) {
                manager.setIndex((Integer)v.getTag());
            } else {
                manager.setMusicListAndIndex(musicList, (Integer) v.getTag());
            }
            PlayerService.startPlayerService();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout songItem;
        ImageView cover;
        TextView name;
        TextView creator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songItem = itemView.findViewById(R.id.song_list_item);
            cover = itemView.findViewById(R.id.cover);
            name = itemView.findViewById(R.id.name);
            creator = itemView.findViewById(R.id.creator);
        }
    }

    class GetMusicUrlThread extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            boolean isError = false;
            InterfaceManager manager = new InterfaceManager();
            for (int i = 0; i < musicList.size(); i++) {
                musicList.get(i).setSongs(manager.getMusicUrlById(String.valueOf(musicList.get(i).getId())));
                if (musicList.get(i).getSongs() == null) {
                    isError = true;
                }
            }
            if (isError) {
                return 1;
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (integer == 1) {
                ToastUtil.getInstance().showToast(MyApplication.getContext(), "存在无法播放的歌曲", Toast.LENGTH_SHORT);
            }
        }
    }
}
