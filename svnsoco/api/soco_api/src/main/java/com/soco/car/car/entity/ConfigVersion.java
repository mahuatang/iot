package com.soco.car.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class ConfigVersion implements Serializable {
    /**
     * 配置ID
     */
    private Long configid;

    /**
     * 配置类型(0表示App版本信息，1表示固件升级信息)
     */
    private Integer conftype;

    /**
     * 适用对象（1：旧中控/旧APP，2：新中控/新APP）
     */
    private Integer objecttype;

    /**
     * 版本号
     */
    private Integer versionno;

    /**
     * 版本展示号
     */
    private String versionshow;

    /**
     * 版本描述
     */
    private String versiondesc;

    /**
     * 安装包下载地址
     */
    private String downurl;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 0正常，-1禁止，默认0
     */
    private Integer status;

    /**
     * 0无需升级，1推荐升级，2强制升级
     */
    private Integer isupgradeversion;

    private static final long serialVersionUID = 1L;

    public Long getConfigid() {
        return configid;
    }

    public void setConfigid(Long configid) {
        this.configid = configid;
    }

    public Integer getConftype() {
        return conftype;
    }

    public void setConftype(Integer conftype) {
        this.conftype = conftype;
    }

    public Integer getObjecttype() {
        return objecttype;
    }

    public void setObjecttype(Integer objecttype) {
        this.objecttype = objecttype;
    }

    public Integer getVersionno() {
        return versionno;
    }

    public void setVersionno(Integer versionno) {
        this.versionno = versionno;
    }

    public String getVersionshow() {
        return versionshow;
    }

    public void setVersionshow(String versionshow) {
        this.versionshow = versionshow;
    }

    public String getVersiondesc() {
        return versiondesc;
    }

    public void setVersiondesc(String versiondesc) {
        this.versiondesc = versiondesc;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
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

    public Integer getIsupgradeversion() {
        return isupgradeversion;
    }

    public void setIsupgradeversion(Integer isupgradeversion) {
        this.isupgradeversion = isupgradeversion;
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
        ConfigVersion other = (ConfigVersion) that;
        return (this.getConfigid() == null ? other.getConfigid() == null : this.getConfigid().equals(other.getConfigid()))
            && (this.getConftype() == null ? other.getConftype() == null : this.getConftype().equals(other.getConftype()))
            && (this.getObjecttype() == null ? other.getObjecttype() == null : this.getObjecttype().equals(other.getObjecttype()))
            && (this.getVersionno() == null ? other.getVersionno() == null : this.getVersionno().equals(other.getVersionno()))
            && (this.getVersionshow() == null ? other.getVersionshow() == null : this.getVersionshow().equals(other.getVersionshow()))
            && (this.getVersiondesc() == null ? other.getVersiondesc() == null : this.getVersiondesc().equals(other.getVersiondesc()))
            && (this.getDownurl() == null ? other.getDownurl() == null : this.getDownurl().equals(other.getDownurl()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsupgradeversion() == null ? other.getIsupgradeversion() == null : this.getIsupgradeversion().equals(other.getIsupgradeversion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConfigid() == null) ? 0 : getConfigid().hashCode());
        result = prime * result + ((getConftype() == null) ? 0 : getConftype().hashCode());
        result = prime * result + ((getObjecttype() == null) ? 0 : getObjecttype().hashCode());
        result = prime * result + ((getVersionno() == null) ? 0 : getVersionno().hashCode());
        result = prime * result + ((getVersionshow() == null) ? 0 : getVersionshow().hashCode());
        result = prime * result + ((getVersiondesc() == null) ? 0 : getVersiondesc().hashCode());
        result = prime * result + ((getDownurl() == null) ? 0 : getDownurl().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsupgradeversion() == null) ? 0 : getIsupgradeversion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configid=").append(configid);
        sb.append(", conftype=").append(conftype);
        sb.append(", objecttype=").append(objecttype);
        sb.append(", versionno=").append(versionno);
        sb.append(", versionshow=").append(versionshow);
        sb.append(", versiondesc=").append(versiondesc);
        sb.append(", downurl=").append(downurl);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", status=").append(status);
        sb.append(", isupgradeversion=").append(isupgradeversion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}