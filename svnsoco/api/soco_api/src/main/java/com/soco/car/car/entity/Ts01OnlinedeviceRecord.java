package com.soco.car.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Ts01OnlinedeviceRecord implements Serializable {
    /**
     * 记录id
     */
    private Long recordid;

    /**
     * 设备ID
     */
    private String deviceno;

    /**
     * 最后一次的通讯通道Id
     */
    private String channelid;

    /**
     * 是否在线（0：不在线，1：在线）
     */
    private Integer isonline;

    /**
     * 当前设备最后一次使用的时间
     */
    private Date lasttime;

    /**
     * 该条记录初始创建时间
     */
    private Date createtime;

    /**
     * 是否删除（0：未删除，1：已删除）
     */
    private Integer delflag;

    private static final long serialVersionUID = 1L;

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
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
        Ts01OnlinedeviceRecord other = (Ts01OnlinedeviceRecord) that;
        return (this.getRecordid() == null ? other.getRecordid() == null : this.getRecordid().equals(other.getRecordid()))
            && (this.getDeviceno() == null ? other.getDeviceno() == null : this.getDeviceno().equals(other.getDeviceno()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getIsonline() == null ? other.getIsonline() == null : this.getIsonline().equals(other.getIsonline()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDelflag() == null ? other.getDelflag() == null : this.getDelflag().equals(other.getDelflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordid() == null) ? 0 : getRecordid().hashCode());
        result = prime * result + ((getDeviceno() == null) ? 0 : getDeviceno().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getIsonline() == null) ? 0 : getIsonline().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDelflag() == null) ? 0 : getDelflag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordid=").append(recordid);
        sb.append(", deviceno=").append(deviceno);
        sb.append(", channelid=").append(channelid);
        sb.append(", isonline=").append(isonline);
        sb.append(", lasttime=").append(lasttime);
        sb.append(", createtime=").append(createtime);
        sb.append(", delflag=").append(delflag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}