package com.madderate.skyloft.Models;

import java.util.List;

public class Profile {
    private String detailDescription;
    private Boolean followed;
    private String backgroundUrl;
    private String description;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private int userId;
    private Boolean defaultAvatar;
    private int vipType;
    private int gender;
    private int accountStatus;
    private long avatarImgId;
    private String nickname;
    private long birthday;
    private int city;
    private String avatarUrl;
    private int province;
    private int djStatus;
    private Boolean mutual;
    private Object remarkName;
    private Object experts;
    private Object expertTags;
    private int authStatus;
    private String signature;
    private int authority;
    private String avatarImgId_str;
    private int followeds;
    private int follows;
    private int eventCount;
    private int playlistCount;
    private int playlistBeSubscribedCount;

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarImgIdStr() {
        return avatarImgIdStr;
    }

    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }

    public String getBackgroundImgIdStr() {
        return backgroundImgIdStr;
    }

    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(Boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public Boolean getMutual() {
        return mutual;
    }

    public void setMutual(Boolean mutual) {
        this.mutual = mutual;
    }

    public Object getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(Boolean remarkName) {
        this.remarkName = remarkName;
    }

    public Object getExperts() {
        return experts;
    }

    public void setExperts(Object experts) {
        this.experts = experts;
    }

    public Object getExpertTags() {
        return expertTags;
    }

    public void setExpertTags(Object expertTags) {
        this.expertTags = expertTags;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getAvatarImgId_str() {
        return avatarImgId_str;
    }

    public void setAvatarImgId_str(String avatarImgId_str) {
        this.avatarImgId_str = avatarImgId_str;
    }

    public int getFolloweds() {
        return followeds;
    }

    public void setFolloweds(int followeds) {
        this.followeds = followeds;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(int playlistCount) {
        this.playlistCount = playlistCount;
    }

    public int getPlaylistBeSubscribedCount() {
        return playlistBeSubscribedCount;
    }

    public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "detailDescription='" + detailDescription + '\'' +
                ", followed=" + followed +
                ", backgroundUrl='" + backgroundUrl + '\'' +
                ", description='" + description + '\'' +
                ", avatarImgIdStr='" + avatarImgIdStr + '\'' +
                ", backgroundImgIdStr='" + backgroundImgIdStr + '\'' +
                ", userId=" + userId +
                ", defaultAvatar=" + defaultAvatar +
                ", vipType=" + vipType +
                ", gender=" + gender +
                ", accountStatus=" + accountStatus +
                ", avatarImgId=" + avatarImgId +
                ", nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", city=" + city +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", province=" + province +
                ", djStatus=" + djStatus +
                ", mutual=" + mutual +
                ", remarkName=" + remarkName +
                ", experts=" + experts +
                ", expertTags=" + expertTags +
                ", authStatus=" + authStatus +
                ", signature='" + signature + '\'' +
                ", authority=" + authority +
                ", avatarImgId_str='" + avatarImgId_str + '\'' +
                ", followeds=" + followeds +
                ", follows=" + follows +
                ", eventCount=" + eventCount +
                ", playlistCount=" + playlistCount +
                ", playlistBeSubscribedCount=" + playlistBeSubscribedCount +
                '}';
    }
}
