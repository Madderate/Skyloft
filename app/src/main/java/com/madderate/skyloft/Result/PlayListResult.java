package com.madderate.skyloft.Result;


import com.madderate.skyloft.Models.Playlist;

import java.util.ArrayList;

public class PlayListResult {
    boolean more;
    ArrayList<Playlist> playlist;

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }
}
