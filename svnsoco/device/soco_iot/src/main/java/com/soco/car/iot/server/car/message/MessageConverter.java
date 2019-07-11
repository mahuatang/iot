/**
 * 
 */
package com.soco.car.iot.server.car.message;

import io.netty.channel.Channel;

/**
 * 
 * ClassName: MessageConverter <br/>
 * Function: 消息转换工具类 <br/>
 * date: 2018年7月12日 上午10:13:23 <br/>
 *
 * @author sunlangping
 * @version
 */
public interface MessageConverter {

	/**
	 * 
	 * convert2Message: 转换器
	 *
	 * @author sunlangping
	 * @param channel TODO
	 * @param msg
	 * @return
	 */
	BaseMsg convert2Message(Channel channel, byte[] msg);

	/**
	 * 
	 * supportProcotol: 继承此接口支持的协议
	 *
	 * @author sunlangping
	 * @return
	 */
	public  byte supportProcotol();
	/**
	 * 
	 * passthroughFlag:是否透传协议使用透传协议解析包解析
	 *
	 * @author sunlangping
	 * @param flag
	 * @return
	 */
	public default boolean passthroughFlag() {
		return false;
	}
	

}
