package com.soco.car.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class Repairstation implements Serializable {
    /**
     * 站点Id
     */
    private Long stationid;

    /**
     * 站点名称
     */
    private String stationname;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phoneno;

    /**
     * 维度
     */
    private Double pointlat;

    /**
     * 经度
     */
    private Double pointlng;

    /**
     * 地址文本
     */
    private String address;

    private Integer areaid;

    private String worktime;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 状态(0正常,-1禁止)
     */
    private Integer status;

    private Double distance;

    private static final long serialVersionUID = 1L;

    public Long getStationid() {
        return stationid;
    }

    public void setStationid(Long stationid) {
        this.stationid = stationid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Double getPointlat() {
        return pointlat;
    }

    public void setPointlat(Double pointlat) {
        this.pointlat = pointlat;
    }

    public Double getPointlng() {
        return pointlng;
    }

    public void setPointlng(Double pointlng) {
        this.pointlng = pointlng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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
        Repairstation other = (Repairstation) that;
        return (this.getStationid() == null ? other.getStationid() == null : this.getStationid().equals(other.getStationid()))
            && (this.getStationname() == null ? other.getStationname() == null : this.getStationname().equals(other.getStationname()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getPhoneno() == null ? other.getPhoneno() == null : this.getPhoneno().equals(other.getPhoneno()))
            && (this.getPointlat() == null ? other.getPointlat() == null : this.getPointlat().equals(other.getPointlat()))
            && (this.getPointlng() == null ? other.getPointlng() == null : this.getPointlng().equals(other.getPointlng()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAreaid() == null ? other.getAreaid() == null : this.getAreaid().equals(other.getAreaid()))
            && (this.getWorktime() == null ? other.getWorktime() == null : this.getWorktime().equals(other.getWorktime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStationid() == null) ? 0 : getStationid().hashCode());
        result = prime * result + ((getStationname() == null) ? 0 : getStationname().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getPhoneno() == null) ? 0 : getPhoneno().hashCode());
        result = prime * result + ((getPointlat() == null) ? 0 : getPointlat().hashCode());
        result = prime * result + ((getPointlng() == null) ? 0 : getPointlng().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAreaid() == null) ? 0 : getAreaid().hashCode());
        result = prime * result + ((getWorktime() == null) ? 0 : getWorktime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stationid=").append(stationid);
        sb.append(", stationname=").append(stationname);
        sb.append(", contacts=").append(contacts);
        sb.append(", phoneno=").append(phoneno);
        sb.append(", pointlat=").append(pointlat);
        sb.append(", pointlng=").append(pointlng);
        sb.append(", address=").append(address);
        sb.append(", areaid=").append(areaid);
        sb.append(", worktime=").append(worktime);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}