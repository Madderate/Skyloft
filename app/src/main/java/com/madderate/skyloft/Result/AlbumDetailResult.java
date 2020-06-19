package com.madderate.skyloft.Result;

import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.PlaylistResult;

import java.util.ArrayList;

public class AlbumDetailResult {
    private ArrayList<PlaylistResult> albums;

    public ArrayList<PlaylistResult> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<PlaylistResult> albums) {
        this.albums = albums;
    }
}
