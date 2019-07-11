package com.soco.car.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CarTypeMapping implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 车型大类代码
     */
    private String carTypeCode;

    /**
     * 车型代码
     */
    private String carModelName;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        CarTypeMapping other = (CarTypeMapping) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarTypeCode() == null ? other.getCarTypeCode() == null : this.getCarTypeCode().equals(other.getCarTypeCode()))
            && (this.getCarModelName() == null ? other.getCarModelName() == null : this.getCarModelName().equals(other.getCarModelName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarTypeCode() == null) ? 0 : getCarTypeCode().hashCode());
        result = prime * result + ((getCarModelName() == null) ? 0 : getCarModelName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carTypeCode=").append(carTypeCode);
        sb.append(", carModelName=").append(carModelName);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}