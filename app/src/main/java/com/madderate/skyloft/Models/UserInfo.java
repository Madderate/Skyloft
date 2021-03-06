package com.madderate.skyloft.Models;

import java.util.ArrayList;

public class UserInfo {
    private long level;
    private long listenSongs;
    private UserPoint userPoint;
    private boolean mobileSign;
    private boolean pcSign;
    private boolean peopleCanSeeMyPlayRecord;
    private boolean adValid;

    private long createTime;
    private int createDays;

    private Profile profile;
    private ArrayList<Binding> bindings;

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getListenSongs() {
        return listenSongs;
    }

    public void setListenSongs(long listenSongs) {
        this.listenSongs = listenSongs;
    }

    public UserPoint getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(UserPoint userPoint) {
        this.userPoint = userPoint;
    }

    public boolean isMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(boolean mobileSign) {
        this.mobileSign = mobileSign;
    }

    public boolean isPcSign() {
        return pcSign;
    }

    public void setPcSign(boolean pcSign) {
        this.pcSign = pcSign;
    }

    public boolean isPeopleCanSeeMyPlayRecord() {
        return peopleCanSeeMyPlayRecord;
    }

    public void setPeopleCanSeeMyPlayRecord(boolean peopleCanSeeMyPlayRecord) {
        this.peopleCanSeeMyPlayRecord = peopleCanSeeMyPlayRecord;
    }

    public boolean isAdValid() {
        return adValid;
    }

    public void setAdValid(boolean adValid) {
        this.adValid = adValid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getCreateDays() {
        return createDays;
    }

    public void setCreateDays(int createDays) {
        this.createDays = createDays;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ArrayList<Binding> getBindings() {
        return bindings;
    }

    public void setBindings(ArrayList<Binding> bindings) {
        this.bindings = bindings;
    }

    static class UserPoint{
        private long userId;
        private long balance;
        // private long updateTime;
        private long version;
        private long status;
        private long blockBalance;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public long getVersion() {
            return version;
        }

        public void setVersion(long version) {
            this.version = version;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public long getBlockBalance() {
            return blockBalance;
        }

        public void setBlockBalance(long blockBalance) {
            this.blockBalance = blockBalance;
        }
    }
}
