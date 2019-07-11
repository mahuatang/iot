/**
 * Project Name:SOCO_API
 * File Name:UserApi.java
 * Package Name:com.soco.car.user.api
 * Date:2018年7月24日下午1:08:36
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.api;

import com.github.pagehelper.PageInfo;
import com.soco.car.user.entity.PhoneVersion;
import com.soco.car.user.entity.SmsLog;
import com.soco.car.user.entity.User;
import com.soco.car.user.entity.UserRunPoint;

/**
 * ClassName:UserApi <br/>
 * Reason: 用户相关接口 <br/>
 * Date: 2018年7月24日 下午1:08:36 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface UserApi {

	/**
	 * 
	 * findByPhone:根据手机号码查询用户
	 *
	 * @author sunlangping
	 * @param account
	 *            TODO
	 * @return
	 */
	public User findByAccount(String account);
	/**
	 * 
	 * findByDeviceNo:根据设备号查询绑定的用户信息
	 *
	 * @author sunlangping
	 * @param deviceNo
	 * @return
	 */
	public User findBindByDeviceNo(String deviceNo);

	/**
	 * 
	 * save: 新增用户
	 *
	 * @author sunlangping
	 * @param user
	 * @return
	 */
	public User save(User user);

	/**
	 * 
	 * findHistryList:
	 *
	 * @author sunlangping
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageInfo<UserRunPoint> findRunHistryList(Long userId, Integer pageNo, Integer pageSize);

	/**
	 * 添加APP安装的手机信息
	 * 
	 * @param phoneVersion
	 */
	public void savePhoneVersion(PhoneVersion phoneVersion);
	/**
	 * 
	 * saveSmsLog:插入发送短信日志
	 *
	 * @author sunlangping
	 * @param smslog
	 */
	public void saveSmsLog(SmsLog smslog);
}
