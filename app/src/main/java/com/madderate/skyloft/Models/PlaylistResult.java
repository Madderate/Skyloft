package com.madderate.skyloft.Models;

public class PlaylistResult {
    private long id;
    private String name;
    private String picUrl;
    private String copywriter;
    private long playCount;
    private String trackCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getCopywriter() {
        return copywriter;
    }

    public void setCopywriter(String copywriter) {
        this.copywriter = copywriter;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    @Override
    public String toString() {
        return "PlaylistResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", copywriter='" + copywriter + '\'' +
                ", playCount=" + playCount +
                ", trackCount='" + trackCount + '\'' +
                '}';
    }
}

