package com.madderate.skyloft.Result;

import com.madderate.skyloft.Models.Playlist;

import java.util.ArrayList;

public class RecommendPlayListResult {
    private ArrayList<Playlist> recommend;

    public ArrayList<Playlist> getRecommend() {
        return recommend;
    }

    public void setRecommend(ArrayList<Playlist> recommend) {
        this.recommend = recommend;
    }
}
