/**
 * Project Name:SOCO_IOT
 * File Name:Base7979Msg.java
 * Package Name:com.soco.car.iot.message
 * Date:2018年7月9日上午3:20:31
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message;

/**
 * ClassName:Base7979Msg <br/>
 * Reason: 7979协议基础类 ,集成此类默认为透传协议<br/>
 * Date: 2018年7月9日 上午3:20:31 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public abstract class Base7979Msg extends BaseMsg {

	private static final long serialVersionUID = 7722947714827070719L;

	/**
	 * 基础指令 长度为2字节
	 */
	private Short command;

	/**
	 * 内容长度 长度为2字节
	 */
	private Short contentLength;
	/**
	 * 协议号 2 字节
	 */
	private byte[] protocol;
	/**
	 * 自定义透传模块协议
	 */
	private byte modelProtocol;
	/**
	 * 信息序列号 2字节
	 */
	private Short messageSerialNumber;
	/**
	 * 校验码 字节长度2
	 */
	private Short checkCode;
	/**
	 * 停止位符
	 */
	private Short stopCode;
	/**
	 * ----------------透传子协议内容公共属性 开始----------------
	 */
	/**
	 * 透传的指令
	 */
	private Short childCommand;
	/**
	 * 透传指令中的协议
	 */
	private Short childProtocol;
	/**
	 * 透传指令中内容长度
	 */
	private Short childContentLength;
	/**
	 * 透传指令校验位
	 */
	private Short childCheckCode;

	/**
	 * ----------------透传子协议内容公共属性结束----------------
	 */

	public Short getCommand() {
		return command;
	}

	public void setCommand(Short command) {
		this.command = command;
	}

	public Short getContentLength() {
		return contentLength;
	}

	public void setContentLength(Short contentLength) {
		this.contentLength = contentLength;
	}

	public byte[] getProtocol() {
		return protocol;
	}

	public void setProtocol(byte[] protocol) {
		this.protocol = protocol;
	}

	public byte getModelProtocol() {
		return modelProtocol;
	}

	public void setModelProtocol(byte modelProtocol) {
		this.modelProtocol = modelProtocol;
	}

	public Short getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(Short checkCode) {
		this.checkCode = checkCode;
	}

	public Short getStopCode() {
		return stopCode;
	}

	public void setStopCode(Short stopCode) {
		this.stopCode = stopCode;
	}

	public Short getChildCommand() {
		return childCommand;
	}

	public void setChildCommand(Short childCommand) {
		this.childCommand = childCommand;
	}

	public Short getChildProtocol() {
		return childProtocol;
	}

	public void setChildProtocol(Short childProtocol) {
		this.childProtocol = childProtocol;
	}

	public Short getChildContentLength() {
		return childContentLength;
	}

	public void setChildContentLength(Short childContentLength) {
		this.childContentLength = childContentLength;
	}

	public Short getChildCheckCode() {
		return childCheckCode;
	}

	public void setChildCheckCode(Short childCheckCode) {
		this.childCheckCode = childCheckCode;
	}

	public Short getMessageSerialNumber() {
		return messageSerialNumber;
	}

	public void setMessageSerialNumber(Short messageSerialNumber) {
		this.messageSerialNumber = messageSerialNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Base7979Msg [");
		if (command != null) {
			builder.append("command=");
			builder.append(command);
			builder.append(", ");
		}
		if (contentLength != null) {
			builder.append("contentLength=");
			builder.append(contentLength);
			builder.append(", ");
		}
		builder.append("protocol=");
		builder.append(protocol);
		builder.append(", modelProtocol=");
		builder.append(modelProtocol);
		builder.append(", ");
		if (checkCode != null) {
			builder.append("checkCode=");
			builder.append(checkCode);
			builder.append(", ");
		}
		if (stopCode != null) {
			builder.append("stopCode=");
			builder.append(stopCode);
			builder.append(", ");
		}
		if (childCommand != null) {
			builder.append("childCommand=");
			builder.append(childCommand);
			builder.append(", ");
		}
		if (childProtocol != null) {
			builder.append("childProtocol=");
			builder.append(childProtocol);
			builder.append(", ");
		}
		if (childContentLength != null) {
			builder.append("childContentLength=");
			builder.append(childContentLength);
			builder.append(", ");
		}
		if (childCheckCode != null) {
			builder.append("childCheckCode=");
			builder.append(childCheckCode);
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
