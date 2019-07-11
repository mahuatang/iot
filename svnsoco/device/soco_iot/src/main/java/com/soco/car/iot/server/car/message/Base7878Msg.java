/**
 * Project Name:SOCO_IOT
 * File Name:Base7878Message.java
 * Package Name:com.soco.car.iot.message
 * Date:2018年7月9日上午3:19:37
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ClassName:Base7878Message <br/>
 * Reason: 7878协议基础包 <br/>
 * Date: 2018年7月9日 上午3:19:37 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public abstract class Base7878Msg extends BaseMsg implements Serializable {

	private static final long serialVersionUID = -1291519651101790533L;

	/**
	 * 基础指令 长度为2字节
	 */
	private Short command;
	/**
	 * 协议号 1 字节
	 */
	private Byte protocol;
	/**
	 * 内容长度（包长度） 长度为 2字节
	 */
	private Byte contentLength;
	/**
	 * 信息序列号 2字节
	 */
	private Short messageSerialNumber;
	/**
	 * 校验码 字节长度2
	 */
	private Short checkCode;

	public Short getCommand() {
		return command;
	}

	public void setCommand(Short command) {
		this.command = command;
	}

	public Byte getProtocol() {
		return protocol;
	}

	public void setProtocol(Byte protocol) {
		this.protocol = protocol;
	}

	public Byte getContentLength() {
		return contentLength;
	}

	public void setContentLength(Byte contentLength) {
		this.contentLength = contentLength;
	}

	public Short getMessageSerialNumber() {
		return messageSerialNumber;
	}

	public void setMessageSerialNumber(Short messageSerialNumber) {
		this.messageSerialNumber = messageSerialNumber;
	}

	public Short getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(Short checkCode) {
		this.checkCode = checkCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Base7878Msg [");
		if (command != null) {
			builder.append("command=");
			builder.append(command);
			builder.append(", ");
		}
		if (protocol != null) {
			builder.append("protocol=");
			builder.append(protocol);
			builder.append(", ");
		}
		if (contentLength != null) {
			builder.append("contentLength=");
			builder.append(contentLength);
			builder.append(", ");
		}
		if (messageSerialNumber != null) {
			builder.append("messageSerialNumber=");
			builder.append(messageSerialNumber);
			builder.append(", ");
		}
		if (checkCode != null) {
			builder.append("checkCode=");
			builder.append(checkCode);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
