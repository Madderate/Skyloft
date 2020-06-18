package com.madderate.skyloft.Result;

import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.Models.MusicInfo;

import java.util.ArrayList;

public class ArtistResult {
    private Artist artist;
    private ArrayList<MusicInfo> hotSongs;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArrayList<MusicInfo> getHotSongs() {
        return hotSongs;
    }

    public void setHotSongs(ArrayList<MusicInfo> hotSongs) {
        this.hotSongs = hotSongs;
    }
}
