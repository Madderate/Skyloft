package com.madderate.skyloft.Result;


import com.madderate.skyloft.Models.MusicInfo;

import java.util.ArrayList;

public class MusicResult {
    ArrayList<MusicInfo> data;

    public ArrayList<MusicInfo> getResult() {
        return data;
    }

    public void setResult(ArrayList<MusicInfo> data) {
        this.data = data;
    }
}
