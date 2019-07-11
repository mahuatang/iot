package com.soco.car.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户数据ID
     */
    private Long userId;

    /**
     * 国家代码
     */
    private String countryCode;

    /**
     * 手机号/邮箱 2选1 必填
     */
    private String account;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户密码，MD5 32位大写加密
     */
    private String password;

    /**
     * 用户头像地址
     */
    private String userAvatar;

    /**
     * 0:女生, 1:男生
     */
    private Integer sex;

    private Date birthday;

    private String address;

    private String userDesc;

    /**
     * 行业
     */
    private String industry;

    /**
     * 是否公开自己的资料
     */
    private Integer isOpen;

    /**
     * 开启警告推送1:推送，0:不推送
     */
    private Integer isWarnPush;

    /**
     * 记录轨迹隐私开关1:开,0:关闭
     */
    private Integer historyLocusSwitch;

    /**
     * 用户等级
     */
    private Integer level;

    /**
     * 用户积分
     */
    private Integer score;

    /**
     * 注册时间
     */
    private Date rgsTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 用户登录标识，用于单点登录
     */
    private String signLoginMark;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 状态（-1禁止，0为正常）
     */
    private Integer status;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 是否公开地理位置（0：公开，1：不公开）
     */
    private Integer openPosition;

    /**
     * 骑行的总路程（KM）
     */
    private Double totalMileage;

    /**
     * 骑行的总时间（分钟）
     */
    private Double totalMinutes;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getIsWarnPush() {
        return isWarnPush;
    }

    public void setIsWarnPush(Integer isWarnPush) {
        this.isWarnPush = isWarnPush;
    }

    public Integer getHistoryLocusSwitch() {
        return historyLocusSwitch;
    }

    public void setHistoryLocusSwitch(Integer historyLocusSwitch) {
        this.historyLocusSwitch = historyLocusSwitch;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getRgsTime() {
        return rgsTime;
    }

    public void setRgsTime(Date rgsTime) {
        this.rgsTime = rgsTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSignLoginMark() {
        return signLoginMark;
    }

    public void setSignLoginMark(String signLoginMark) {
        this.signLoginMark = signLoginMark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(Integer openPosition) {
        this.openPosition = openPosition;
    }

    public Double getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Double totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Double getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Double totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserAvatar() == null ? other.getUserAvatar() == null : this.getUserAvatar().equals(other.getUserAvatar()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUserDesc() == null ? other.getUserDesc() == null : this.getUserDesc().equals(other.getUserDesc()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getIsOpen() == null ? other.getIsOpen() == null : this.getIsOpen().equals(other.getIsOpen()))
            && (this.getIsWarnPush() == null ? other.getIsWarnPush() == null : this.getIsWarnPush().equals(other.getIsWarnPush()))
            && (this.getHistoryLocusSwitch() == null ? other.getHistoryLocusSwitch() == null : this.getHistoryLocusSwitch().equals(other.getHistoryLocusSwitch()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getRgsTime() == null ? other.getRgsTime() == null : this.getRgsTime().equals(other.getRgsTime()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getSignLoginMark() == null ? other.getSignLoginMark() == null : this.getSignLoginMark().equals(other.getSignLoginMark()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getOpenPosition() == null ? other.getOpenPosition() == null : this.getOpenPosition().equals(other.getOpenPosition()))
            && (this.getTotalMileage() == null ? other.getTotalMileage() == null : this.getTotalMileage().equals(other.getTotalMileage()))
            && (this.getTotalMinutes() == null ? other.getTotalMinutes() == null : this.getTotalMinutes().equals(other.getTotalMinutes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserAvatar() == null) ? 0 : getUserAvatar().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUserDesc() == null) ? 0 : getUserDesc().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getIsOpen() == null) ? 0 : getIsOpen().hashCode());
        result = prime * result + ((getIsWarnPush() == null) ? 0 : getIsWarnPush().hashCode());
        result = prime * result + ((getHistoryLocusSwitch() == null) ? 0 : getHistoryLocusSwitch().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getRgsTime() == null) ? 0 : getRgsTime().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getSignLoginMark() == null) ? 0 : getSignLoginMark().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getOpenPosition() == null) ? 0 : getOpenPosition().hashCode());
        result = prime * result + ((getTotalMileage() == null) ? 0 : getTotalMileage().hashCode());
        result = prime * result + ((getTotalMinutes() == null) ? 0 : getTotalMinutes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", account=").append(account);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", userAvatar=").append(userAvatar);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", industry=").append(industry);
        sb.append(", isOpen=").append(isOpen);
        sb.append(", isWarnPush=").append(isWarnPush);
        sb.append(", historyLocusSwitch=").append(historyLocusSwitch);
        sb.append(", level=").append(level);
        sb.append(", score=").append(score);
        sb.append(", rgsTime=").append(rgsTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", signLoginMark=").append(signLoginMark);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", openPosition=").append(openPosition);
        sb.append(", totalMileage=").append(totalMileage);
        sb.append(", totalMinutes=").append(totalMinutes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}