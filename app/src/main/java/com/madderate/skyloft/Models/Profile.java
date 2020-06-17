package com.madderate.skyloft.Models;

import java.util.List;

public class Profile {
    private String detailDescription;
    private String backgroundUrl;
    private String description;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private String avatarUrl;
    private String nickname;
    private String signature;
    private String avatarImgId_str;

    private Boolean defaultAvatar;
    private Boolean followed;
    private Boolean mutual;

    private Object remarkName;
    private Object experts;
    private Object expertTags;

    private long userId;
    private long vipType;
    private long gender;
    private long accountStatus;
    private long city;
    private long province;
    private long djStatus;
    private long followeds;
    private long follows;
    private long eventCount;
    private long playlistCount;
    private long playlistBeSubscribedCount;
    private long authStatus;
    private long authority;

    private long avatarImgId;
    private long birthday;

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatarImgId_str() {
        return avatarImgId_str;
    }

    public void setAvatarImgId_str(String avatarImgId_str) {
        this.avatarImgId_str = avatarImgId_str;
    }

    public Boolean getDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(Boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
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

    public void setRemarkName(Object remarkName) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVipType() {
        return vipType;
    }

    public void setVipType(long vipType) {
        this.vipType = vipType;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public long getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(long accountStatus) {
        this.accountStatus = accountStatus;
    }

    public long getCity() {
        return city;
    }

    public void setCity(long city) {
        this.city = city;
    }

    public long getProvince() {
        return province;
    }

    public void setProvince(long province) {
        this.province = province;
    }

    public long getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(long djStatus) {
        this.djStatus = djStatus;
    }

    public long getFolloweds() {
        return followeds;
    }

    public void setFolloweds(long followeds) {
        this.followeds = followeds;
    }

    public long getFollows() {
        return follows;
    }

    public void setFollows(long follows) {
        this.follows = follows;
    }

    public long getEventCount() {
        return eventCount;
    }

    public void setEventCount(long eventCount) {
        this.eventCount = eventCount;
    }

    public long getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(long playlistCount) {
        this.playlistCount = playlistCount;
    }

    public long getPlaylistBeSubscribedCount() {
        return playlistBeSubscribedCount;
    }

    public void setPlaylistBeSubscribedCount(long playlistBeSubscribedCount) {
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }

    public long getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(long authStatus) {
        this.authStatus = authStatus;
    }

    public long getAuthority() {
        return authority;
    }

    public void setAuthority(long authority) {
        this.authority = authority;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
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
