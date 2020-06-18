package com.madderate.skyloft.Result;


import com.madderate.skyloft.Models.PlaylistResult;

import java.util.ArrayList;

public class PlaylistResultJson{
    private boolean hasTaste;
    private int category;
    private ArrayList<PlaylistResult> result;

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public ArrayList<PlaylistResult> getResult() {
        return result;
    }

    public void setResult(ArrayList<PlaylistResult> result) {
        this.result = result;
    }
}
