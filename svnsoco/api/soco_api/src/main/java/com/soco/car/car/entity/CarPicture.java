package com.soco.car.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CarPicture implements Serializable {
    /**
     * 车辆展示图片id
     */
    private Long showpictureid;

    /**
     * 车型名称
     */
    private String carmodelname;

    /**
     * 颜色代码
     */
    private String colorcode;

    /**
     * 图片路径
     */
    private String imgurl;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Long getShowpictureid() {
        return showpictureid;
    }

    public void setShowpictureid(Long showpictureid) {
        this.showpictureid = showpictureid;
    }

    public String getCarmodelname() {
        return carmodelname;
    }

    public void setCarmodelname(String carmodelname) {
        this.carmodelname = carmodelname;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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
        CarPicture other = (CarPicture) that;
        return (this.getShowpictureid() == null ? other.getShowpictureid() == null : this.getShowpictureid().equals(other.getShowpictureid()))
            && (this.getCarmodelname() == null ? other.getCarmodelname() == null : this.getCarmodelname().equals(other.getCarmodelname()))
            && (this.getColorcode() == null ? other.getColorcode() == null : this.getColorcode().equals(other.getColorcode()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShowpictureid() == null) ? 0 : getShowpictureid().hashCode());
        result = prime * result + ((getCarmodelname() == null) ? 0 : getCarmodelname().hashCode());
        result = prime * result + ((getColorcode() == null) ? 0 : getColorcode().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", showpictureid=").append(showpictureid);
        sb.append(", carmodelname=").append(carmodelname);
        sb.append(", colorcode=").append(colorcode);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}