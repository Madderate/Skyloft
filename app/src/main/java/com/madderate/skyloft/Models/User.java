package com.madderate.skyloft.Models;

import java.util.List;

public class User extends Information {
    private String nickname;
    private byte gender;
    private long createTime;
    private byte vipType;
    private int province;
    private int city;
    private long birthday;
    private long followerNum; // 粉丝数
    private long followedNum; // 关注数
    private Illustration avatar;
    private Illustration background;
    private String school;
    private List<PlayList> playLists;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public byte getVipType() {
        return vipType;
    }

    public void setVipType(byte vipType) {
        this.vipType = vipType;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getFollowerNum() {
        return followerNum;
    }

    public void setFollowerNum(long followerNum) {
        this.followerNum = followerNum;
    }

    public long getFollowedNum() {
        return followedNum;
    }

    public void setFollowedNum(long followedNum) {
        this.followedNum = followedNum;
    }

    public Illustration getAvatar() {
        return avatar;
    }

    public void setAvatar(Illustration avatar) {
        this.avatar = avatar;
    }

    public Illustration getBackground() {
        return background;
    }

    public void setBackground(Illustration background) {
        this.background = background;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }
}
