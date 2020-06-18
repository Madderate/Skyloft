package com.madderate.skyloft.Result;

import java.util.ArrayList;

public class LikeListResult {
    private ArrayList<Long> ids;
    private long checkPoint;

    public ArrayList<Long> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Long> ids) {
        this.ids = ids;
    }

    public long getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(long checkPoint) {
        this.checkPoint = checkPoint;
    }
}
