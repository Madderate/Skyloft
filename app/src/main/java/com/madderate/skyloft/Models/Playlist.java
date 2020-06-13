package com.madderate.skyloft.Models;

import java.util.List;

public class Playlist extends Information {
    private Information owner;
    private List<Song> songs;
    private Illustration avatar;

    public Information getOwner() {
        return owner;
    }

    public void setOwner(Information owner) {
        this.owner = owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Illustration getAvatar() {
        return avatar;
    }

    public void setAvatar(Illustration avatar) {
        this.avatar = avatar;
    }
}
