package com.soco.car.device.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class DeviceCourseUrl implements Serializable {
    private Long id;

    private String deviceProtype;

    private String deviceUrl;

    private Integer del;

    private String createTime;

    private String updateTime;

    private String deviceTitle;

    private String imagePath;

    private String simpleDesc;

    private String deviceDesc;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceProtype() {
        return deviceProtype;
    }

    public void setDeviceProtype(String deviceProtype) {
        this.deviceProtype = deviceProtype;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeviceTitle() {
        return deviceTitle;
    }

    public void setDeviceTitle(String deviceTitle) {
        this.deviceTitle = deviceTitle;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
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
        DeviceCourseUrl other = (DeviceCourseUrl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceProtype() == null ? other.getDeviceProtype() == null : this.getDeviceProtype().equals(other.getDeviceProtype()))
            && (this.getDeviceUrl() == null ? other.getDeviceUrl() == null : this.getDeviceUrl().equals(other.getDeviceUrl()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeviceTitle() == null ? other.getDeviceTitle() == null : this.getDeviceTitle().equals(other.getDeviceTitle()))
            && (this.getImagePath() == null ? other.getImagePath() == null : this.getImagePath().equals(other.getImagePath()))
            && (this.getSimpleDesc() == null ? other.getSimpleDesc() == null : this.getSimpleDesc().equals(other.getSimpleDesc()))
            && (this.getDeviceDesc() == null ? other.getDeviceDesc() == null : this.getDeviceDesc().equals(other.getDeviceDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceProtype() == null) ? 0 : getDeviceProtype().hashCode());
        result = prime * result + ((getDeviceUrl() == null) ? 0 : getDeviceUrl().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeviceTitle() == null) ? 0 : getDeviceTitle().hashCode());
        result = prime * result + ((getImagePath() == null) ? 0 : getImagePath().hashCode());
        result = prime * result + ((getSimpleDesc() == null) ? 0 : getSimpleDesc().hashCode());
        result = prime * result + ((getDeviceDesc() == null) ? 0 : getDeviceDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceProtype=").append(deviceProtype);
        sb.append(", deviceUrl=").append(deviceUrl);
        sb.append(", del=").append(del);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deviceTitle=").append(deviceTitle);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", simpleDesc=").append(simpleDesc);
        sb.append(", deviceDesc=").append(deviceDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}