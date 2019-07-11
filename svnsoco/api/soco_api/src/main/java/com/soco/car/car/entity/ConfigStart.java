package com.soco.car.car.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ConfigStart implements Serializable {
    /**
     * 配置ID
     */
    private Long startid;

    /**
     * 排序序号
     */
    private Integer indexs;

    /**
     * 启动图片类型，0为新手指引，-1为启动图片，默认0
     */
    private Integer starttype;

    /**
     * 启动图片版本
     */
    private Integer imgversion;

    /**
     * 启动图片地址
     */
    private String imgurl;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 更新时间
     */
    private String updatetime;

    /**
     * 状态，0正常，-1禁止，默认0
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getStartid() {
        return startid;
    }

    public void setStartid(Long startid) {
        this.startid = startid;
    }

    public Integer getIndexs() {
        return indexs;
    }

    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

    public Integer getStarttype() {
        return starttype;
    }

    public void setStarttype(Integer starttype) {
        this.starttype = starttype;
    }

    public Integer getImgversion() {
        return imgversion;
    }

    public void setImgversion(Integer imgversion) {
        this.imgversion = imgversion;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        ConfigStart other = (ConfigStart) that;
        return (this.getStartid() == null ? other.getStartid() == null : this.getStartid().equals(other.getStartid()))
            && (this.getIndexs() == null ? other.getIndexs() == null : this.getIndexs().equals(other.getIndexs()))
            && (this.getStarttype() == null ? other.getStarttype() == null : this.getStarttype().equals(other.getStarttype()))
            && (this.getImgversion() == null ? other.getImgversion() == null : this.getImgversion().equals(other.getImgversion()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStartid() == null) ? 0 : getStartid().hashCode());
        result = prime * result + ((getIndexs() == null) ? 0 : getIndexs().hashCode());
        result = prime * result + ((getStarttype() == null) ? 0 : getStarttype().hashCode());
        result = prime * result + ((getImgversion() == null) ? 0 : getImgversion().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
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
        sb.append(", startid=").append(startid);
        sb.append(", indexs=").append(indexs);
        sb.append(", starttype=").append(starttype);
        sb.append(", imgversion=").append(imgversion);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}