package com.soco.car.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserRunPoint implements Serializable {
    /**
     * 主键ID
     */
    private Long pointId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 设备ID（冗余）
     */
    private Long deviceId;

    /**
     * 骑行开始时间
     */
    private Date beginTime;

    /**
     * 开始纬度
     */
    private Double beginLatitude;

    /**
     * 开始经度
     */
    private Double beginLongitude;

    /**
     * 骑行结束时间
     */
    private Date endTime;

    /**
     * 结束纬度
     */
    private Double endLatitude;

    /**
     * 结束经度
     */
    private Double endLongitude;

    /**
     * 此次骑行的距离（KM）
     */
    private Double mileage;

    /**
     * 骑行时长（分钟）
     */
    private Double minutes;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 删除标识1:已删除 0:未删除
     */
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Double getBeginLatitude() {
        return beginLatitude;
    }

    public void setBeginLatitude(Double beginLatitude) {
        this.beginLatitude = beginLatitude;
    }

    public Double getBeginLongitude() {
        return beginLongitude;
    }

    public void setBeginLongitude(Double beginLongitude) {
        this.beginLongitude = beginLongitude;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
        UserRunPoint other = (UserRunPoint) that;
        return (this.getPointId() == null ? other.getPointId() == null : this.getPointId().equals(other.getPointId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getBeginLatitude() == null ? other.getBeginLatitude() == null : this.getBeginLatitude().equals(other.getBeginLatitude()))
            && (this.getBeginLongitude() == null ? other.getBeginLongitude() == null : this.getBeginLongitude().equals(other.getBeginLongitude()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getEndLatitude() == null ? other.getEndLatitude() == null : this.getEndLatitude().equals(other.getEndLatitude()))
            && (this.getEndLongitude() == null ? other.getEndLongitude() == null : this.getEndLongitude().equals(other.getEndLongitude()))
            && (this.getMileage() == null ? other.getMileage() == null : this.getMileage().equals(other.getMileage()))
            && (this.getMinutes() == null ? other.getMinutes() == null : this.getMinutes().equals(other.getMinutes()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPointId() == null) ? 0 : getPointId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getBeginLatitude() == null) ? 0 : getBeginLatitude().hashCode());
        result = prime * result + ((getBeginLongitude() == null) ? 0 : getBeginLongitude().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getEndLatitude() == null) ? 0 : getEndLatitude().hashCode());
        result = prime * result + ((getEndLongitude() == null) ? 0 : getEndLongitude().hashCode());
        result = prime * result + ((getMileage() == null) ? 0 : getMileage().hashCode());
        result = prime * result + ((getMinutes() == null) ? 0 : getMinutes().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointId=").append(pointId);
        sb.append(", userId=").append(userId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", beginLatitude=").append(beginLatitude);
        sb.append(", beginLongitude=").append(beginLongitude);
        sb.append(", endTime=").append(endTime);
        sb.append(", endLatitude=").append(endLatitude);
        sb.append(", endLongitude=").append(endLongitude);
        sb.append(", mileage=").append(mileage);
        sb.append(", minutes=").append(minutes);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}