/**
 * Project Name:soco_iot
 * File Name:StartEndMsg.java
 * Package Name:com.soco.car.iot.message.car.msg
 * Date:2018年8月4日上午11:42:09
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import com.soco.car.iot.server.car.message.Base7979Msg;

/**
 * ClassName:StartEndMsg <br/>
 * Reason: 车俩启动或结束报文. <br/>
 * Date: 2018年8月4日 上午11:42:09 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class StartEndMsg extends Base7979Msg {

	private static final long serialVersionUID = 7446606969151951584L;

	/**
	 * 0x00表示启动 0x01表示关闭
	 */
	private byte start;
	/**
	 * 累计里程 圈数 4字节 高位在前，低位在后
	 */
	private Integer accumulativeRim;
	/**
	 * 当前电量 kW•h 高位在前，低位在后
	 */
	private short electricQuantity;

	public byte getStart() {
		return start;
	}

	public void setStart(byte start) {
		this.start = start;
	}

	public Integer getAccumulativeRim() {
		return accumulativeRim;
	}

	public void setAccumulativeRim(Integer accumulativeRim) {
		this.accumulativeRim = accumulativeRim;
	}

	public short getElectricQuantity() {
		return electricQuantity;
	}

	public void setElectricQuantity(short electricQuantity) {
		this.electricQuantity = electricQuantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StartEndMsg [start=");
		builder.append(start);
		builder.append(", ");
		if (accumulativeRim != null) {
			builder.append("accumulativeRim=");
			builder.append(accumulativeRim);
			builder.append(", ");
		}
		builder.append("electricQuantity=");
		builder.append(electricQuantity);
		builder.append(", ");
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
