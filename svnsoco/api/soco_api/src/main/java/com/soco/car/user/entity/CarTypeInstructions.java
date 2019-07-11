package com.soco.car.user.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class CarTypeInstructions implements Serializable {
    private String carType;

    private String instructionsUrl;

    private static final long serialVersionUID = 1L;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getInstructionsUrl() {
        return instructionsUrl;
    }

    public void setInstructionsUrl(String instructionsUrl) {
        this.instructionsUrl = instructionsUrl;
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
        CarTypeInstructions other = (CarTypeInstructions) that;
        return (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getInstructionsUrl() == null ? other.getInstructionsUrl() == null : this.getInstructionsUrl().equals(other.getInstructionsUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getInstructionsUrl() == null) ? 0 : getInstructionsUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carType=").append(carType);
        sb.append(", instructionsUrl=").append(instructionsUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}