package com.madderate.skyloft.Models;

public class Account {
    private long id;
    private String userName;
    private long type;
    private long status;
    private long whitelistAuthority;
    private long createTime;
    private String salt;
    private long tokenVersion;
    private long ban;
    private long baoyueVersion;
    private long donateVersion;
    private long vipType;
    private long viptypeVersion;
    private boolean anonimousUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getWhitelistAuthority() {
        return whitelistAuthority;
    }

    public void setWhitelistAuthority(long whitelistAuthority) {
        this.whitelistAuthority = whitelistAuthority;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public long getTokenVersion() {
        return tokenVersion;
    }

    public void setTokenVersion(long tokenVersion) {
        this.tokenVersion = tokenVersion;
    }

    public long getBan() {
        return ban;
    }

    public void setBan(long ban) {
        this.ban = ban;
    }

    public long getBaoyueVersion() {
        return baoyueVersion;
    }

    public void setBaoyueVersion(long baoyueVersion) {
        this.baoyueVersion = baoyueVersion;
    }

    public long getDonateVersion() {
        return donateVersion;
    }

    public void setDonateVersion(long donateVersion) {
        this.donateVersion = donateVersion;
    }

    public long getVipType() {
        return vipType;
    }

    public void setVipType(long vipType) {
        this.vipType = vipType;
    }

    public long getViptypeVersion() {
        return viptypeVersion;
    }

    public void setViptypeVersion(long viptypeVersion) {
        this.viptypeVersion = viptypeVersion;
    }

    public boolean isAnonimousUser() {
        return anonimousUser;
    }

    public void setAnonimousUser(boolean anonimousUser) {
        this.anonimousUser = anonimousUser;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", whitelistAuthority=" + whitelistAuthority +
                ", createTime=" + createTime +
                ", salt='" + salt + '\'' +
                ", tokenVersion=" + tokenVersion +
                ", ban=" + ban +
                ", baoyueVersion=" + baoyueVersion +
                ", donateVersion=" + donateVersion +
                ", vipType=" + vipType +
                ", viptypeVersion=" + viptypeVersion +
                ", anonimousUser=" + anonimousUser +
                '}';
    }
}
