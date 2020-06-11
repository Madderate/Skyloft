package com.madderate.skyloft.Models;

import java.util.List;

public class Artist extends Information {
    private Illustration background;
    private Illustration avatar;
    private List<Album> albums;
    private List<Song> songs;

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Illustration getBackground() {
        return background;
    }

    public void setBackground(Illustration background) {
        this.background = background;
    }

    public Illustration getAvatar() {
        return avatar;
    }

    public void setAvatar(Illustration avatar) {
        this.avatar = avatar;
    }
}
