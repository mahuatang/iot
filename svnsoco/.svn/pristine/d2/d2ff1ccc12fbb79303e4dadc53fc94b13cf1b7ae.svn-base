package com.soco.car.device.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Devicestate implements Serializable {
    /**
     * 状态ID
     */
    private Long stateid;

    /**
     * 设备ID
     */
    private Long deviceid;

    /**
     * 开始时候累计里程
     */
    private Double startMileage;

    /**
     * 开始时电量
     */
    private Double startPower;

    /**
     * 结束时累计里程
     */
    private Double endMileage;

    /**
     * 结束时电量
     */
    private Double endPower;

    /**
     * 开始时间
     */
    private Date starttime;

    /**
     * 结束时间
     */
    private Date endtime;

    private static final long serialVersionUID = 1L;

    public Long getStateid() {
        return stateid;
    }

    public void setStateid(Long stateid) {
        this.stateid = stateid;
    }

    public Long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Long deviceid) {
        this.deviceid = deviceid;
    }

    public Double getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(Double startMileage) {
        this.startMileage = startMileage;
    }

    public Double getStartPower() {
        return startPower;
    }

    public void setStartPower(Double startPower) {
        this.startPower = startPower;
    }

    public Double getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(Double endMileage) {
        this.endMileage = endMileage;
    }

    public Double getEndPower() {
        return endPower;
    }

    public void setEndPower(Double endPower) {
        this.endPower = endPower;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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
        Devicestate other = (Devicestate) that;
        return (this.getStateid() == null ? other.getStateid() == null : this.getStateid().equals(other.getStateid()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getStartMileage() == null ? other.getStartMileage() == null : this.getStartMileage().equals(other.getStartMileage()))
            && (this.getStartPower() == null ? other.getStartPower() == null : this.getStartPower().equals(other.getStartPower()))
            && (this.getEndMileage() == null ? other.getEndMileage() == null : this.getEndMileage().equals(other.getEndMileage()))
            && (this.getEndPower() == null ? other.getEndPower() == null : this.getEndPower().equals(other.getEndPower()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStateid() == null) ? 0 : getStateid().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getStartMileage() == null) ? 0 : getStartMileage().hashCode());
        result = prime * result + ((getStartPower() == null) ? 0 : getStartPower().hashCode());
        result = prime * result + ((getEndMileage() == null) ? 0 : getEndMileage().hashCode());
        result = prime * result + ((getEndPower() == null) ? 0 : getEndPower().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stateid=").append(stateid);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", startMileage=").append(startMileage);
        sb.append(", startPower=").append(startPower);
        sb.append(", endMileage=").append(endMileage);
        sb.append(", endPower=").append(endPower);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}