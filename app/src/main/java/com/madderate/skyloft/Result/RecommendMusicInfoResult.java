package com.madderate.skyloft.Result;

import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.MusicInfo;

import java.util.ArrayList;

public class RecommendMusicInfoResult {
    private ArrayList<MusicInfo> recommend;

    public ArrayList<MusicInfo> getRecommend() {
        return recommend;
    }

    public void setRecommend(ArrayList<MusicInfo> recommend) {
        this.recommend = recommend;
    }
}
