package com.soco.car.bean.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:BaseCache <br/>
 * Reason: 与设备人相关的基础类 <br/>
 * Date: 2018年7月12日 下午5:22:06 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public abstract class BaseCachePOJO implements Serializable {

	private static final long serialVersionUID = 1634079477691658107L;

	/**
	 * 设备号
	 */
	private String deviceNo;
	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 缓存的创建时间
	 */
	private Date createTime;
	/**
	 * 缓存的修改时间
	 */
	private Date modifyTime;

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseCachePOJO [");
		if (deviceNo != null) {
			builder.append("deviceNo=");
			builder.append(deviceNo);
			builder.append(", ");
		}
		if (mobile != null) {
			builder.append("mobile=");
			builder.append(mobile);
			builder.append(", ");
		}
		if (createTime != null) {
			builder.append("createTime=");
			builder.append(createTime);
			builder.append(", ");
		}
		if (modifyTime != null) {
			builder.append("modifyTime=");
			builder.append(modifyTime);
		}
		builder.append("]");
		return builder.toString();
	}

}
