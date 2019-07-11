package com.soco.car.device.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Device implements Serializable {
    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 设备编号，系统自动生成，硬件需要进行对应
     */
    private String deviceNo;

    /**
     * 生产日期
     */
    private Date proDate;

    /**
     * 设备版本
     */
    private Integer deviceVersion;

    /**
     * iccid用于充值
     */
    private String iccid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public Integer getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(Integer deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
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
        Device other = (Device) that;
        return (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getDeviceNo() == null ? other.getDeviceNo() == null : this.getDeviceNo().equals(other.getDeviceNo()))
            && (this.getProDate() == null ? other.getProDate() == null : this.getProDate().equals(other.getProDate()))
            && (this.getDeviceVersion() == null ? other.getDeviceVersion() == null : this.getDeviceVersion().equals(other.getDeviceVersion()))
            && (this.getIccid() == null ? other.getIccid() == null : this.getIccid().equals(other.getIccid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getDeviceNo() == null) ? 0 : getDeviceNo().hashCode());
        result = prime * result + ((getProDate() == null) ? 0 : getProDate().hashCode());
        result = prime * result + ((getDeviceVersion() == null) ? 0 : getDeviceVersion().hashCode());
        result = prime * result + ((getIccid() == null) ? 0 : getIccid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceNo=").append(deviceNo);
        sb.append(", proDate=").append(proDate);
        sb.append(", deviceVersion=").append(deviceVersion);
        sb.append(", iccid=").append(iccid);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}