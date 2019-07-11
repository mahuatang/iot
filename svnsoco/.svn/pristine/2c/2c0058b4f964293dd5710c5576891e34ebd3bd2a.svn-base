package com.soco.car.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CarType implements Serializable {
    /**
     * 车型分类代码
     */
    private String carTypeCode;

    /**
     * 车型名称
     */
    private String carTypeName;

    /**
     * 操作符+,-,*,%
     */
    private String opt;

    /**
     * 操作的值
     */
    private Double value;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        CarType other = (CarType) that;
        return (this.getCarTypeCode() == null ? other.getCarTypeCode() == null : this.getCarTypeCode().equals(other.getCarTypeCode()))
            && (this.getCarTypeName() == null ? other.getCarTypeName() == null : this.getCarTypeName().equals(other.getCarTypeName()))
            && (this.getOpt() == null ? other.getOpt() == null : this.getOpt().equals(other.getOpt()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarTypeCode() == null) ? 0 : getCarTypeCode().hashCode());
        result = prime * result + ((getCarTypeName() == null) ? 0 : getCarTypeName().hashCode());
        result = prime * result + ((getOpt() == null) ? 0 : getOpt().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carTypeCode=").append(carTypeCode);
        sb.append(", carTypeName=").append(carTypeName);
        sb.append(", opt=").append(opt);
        sb.append(", value=").append(value);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}