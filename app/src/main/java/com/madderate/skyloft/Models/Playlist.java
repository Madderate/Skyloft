package com.madderate.skyloft.Models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Profile> subscribers;
    private Profile creator;
    private long id;

    private Object artists;
    private ArrayList<MusicInfo> tracks;
    private Object updateFrequency;

    private String backgroundCoverUrl;
    private String titleImageUrl;
    private String coverImgUrl;
    private String recommendInfo;
    private String englishTitle;
    private String commentThreadId;
    private String description;
    private String name;
    private ArrayList<String> tags;

    private long backgroundCoverId;
    private long titleImage;
    private long trackNumberUpdateTime;
    private long createTime;
    private long updateTime;
    private long coverImgId;
    private long trackUpdateTime;

    private boolean subscribed;
    private boolean highQuality;
    private boolean newImported;
    private boolean anonimous;
    private boolean ordered;

    private long adType;
    private long subscribedCount;
    private long cloudTrackCount;
    private long userId;
    private long totalDuration;
    private long specialType;
    private long privacy;
    private long trackCount;
    private long playCount;
    private long status;

    public List<Profile> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Profile> subscribers) {
        this.subscribers = subscribers;
    }

    public Profile getCreator() {
        return creator;
    }

    public void setCreator(Profile creator) {
        this.creator = creator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getArtists() {
        return artists;
    }

    public void setArtists(Object artists) {
        this.artists = artists;
    }

    public ArrayList<MusicInfo> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<MusicInfo> tracks) {
        this.tracks = tracks;
    }

    public Object getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(Object updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public String getBackgroundCoverUrl() {
        return backgroundCoverUrl;
    }

    public void setBackgroundCoverUrl(String backgroundCoverUrl) {
        this.backgroundCoverUrl = backgroundCoverUrl;
    }

    public String getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(String recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public long getBackgroundCoverId() {
        return backgroundCoverId;
    }

    public void setBackgroundCoverId(long backgroundCoverId) {
        this.backgroundCoverId = backgroundCoverId;
    }

    public long getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(long titleImage) {
        this.titleImage = titleImage;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public long getAdType() {
        return adType;
    }

    public void setAdType(long adType) {
        this.adType = adType;
    }

    public long getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(long subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public long getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(long cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getSpecialType() {
        return specialType;
    }

    public void setSpecialType(long specialType) {
        this.specialType = specialType;
    }

    public long getPrivacy() {
        return privacy;
    }

    public void setPrivacy(long privacy) {
        this.privacy = privacy;
    }

    public long getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(long trackCount) {
        this.trackCount = trackCount;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "subscribers=" + subscribers +
                ", creator=" + creator +
                ", id=" + id +
                ", artists=" + artists +
                ", tracks=" + tracks +
                ", updateFrequency=" + updateFrequency +
                ", backgroundCoverUrl='" + backgroundCoverUrl + '\'' +
                ", titleImageUrl='" + titleImageUrl + '\'' +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", recommendInfo='" + recommendInfo + '\'' +
                ", englishTitle='" + englishTitle + '\'' +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                ", backgroundCoverId=" + backgroundCoverId +
                ", titleImage=" + titleImage +
                ", trackNumberUpdateTime=" + trackNumberUpdateTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", coverImgId=" + coverImgId +
                ", trackUpdateTime=" + trackUpdateTime +
                ", subscribed=" + subscribed +
                ", highQuality=" + highQuality +
                ", newImported=" + newImported +
                ", anonimous=" + anonimous +
                ", ordered=" + ordered +
                ", adType=" + adType +
                ", subscribedCount=" + subscribedCount +
                ", cloudTrackCount=" + cloudTrackCount +
                ", userId=" + userId +
                ", totalDuration=" + totalDuration +
                ", specialType=" + specialType +
                ", privacy=" + privacy +
                ", trackCount=" + trackCount +
                ", playCount=" + playCount +
                ", status=" + status +
                '}';
    }
}
