/**
 * Project Name:soco_app
 * File Name:FtpFileService.java
 * Package Name:com.soco.car.app.service
 * Date:2018年7月26日下午12:14:34
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.utils.DirecotryUtil;
import com.soco.car.user.api.DictApi;
import com.soco.car.user.entity.Dict;


/**
 * ClassName:FtpFileService <br/>
 * Reason: 图片处理工具类. <br/>
 * Date: 2018年7月26日 下午12:14:34 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class FtpFileService {
	
	private static final Logger logger = LoggerFactory.getLogger(FtpFileService.class);

	/**
	 * ftp服务器ip地址
	 */
	@Value("${ftp.address}")
	private String ftpAddress;
	/**
	 * 端口号
	 */
	@Value("${ftp.port}")
	private Integer ftpPort;
	/**
	 * 用户名
	 */
	@Value("${ftp.username}")
	private String ftpUsername;
	/**
	 * 密码
	 */
	@Value("${ftp.password}")
	private String ftpPassword;

	@com.alibaba.dubbo.config.annotation.Reference
	private DictApi dictApi;

	public String uploadFile(String type, String originFileName, InputStream input) throws IOException {
		String fileIndex = "";
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		try {
			int reply;
			ftp.connect(ftpAddress, ftpPort);// 连接FTP服务器
			ftp.login(ftpUsername, ftpPassword);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			String directory = getFilePath(type);
			String newFileName = replaceFileName(originFileName);
			String[] directorys = directory.split("/");
			for (String d : directorys) {
				if (!ftp.changeWorkingDirectory(d)) {
					ftp.makeDirectory(d);
					ftp.changeWorkingDirectory(d);
				}
			}
			ftp.enterLocalPassiveMode();
			boolean flag = ftp.storeFile(newFileName, input);
			logger.info("上传文件名称:{},input:{},上传状态{}", newFileName, input, flag);

			fileIndex = directory + newFileName;
			input.close();
			ftp.logout();
		} catch (IOException e) {
			// 截取异常继续往外抛，外部拦截器统一处理
			throw new IOException(e);
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return fileIndex;
	}

	/**
	 * 
	 * getFilePath:根据不同类型返回不同地址
	 *
	 * @author sunlangping
	 * @param type
	 * @return
	 */
	private String getFilePath(String type) {
		// 默认所有上传的路径
		String filePath = "resource/default" + "/" + DirecotryUtil.generateYYYYMMDDDirecotry();
		List<Dict> dictList = dictApi.findByChild(SOCOAppConstant.IMAGE_PATH);
		Map<String, Dict> dictMap = dictList.stream().collect(Collectors.toMap(Dict::getCode, Dict -> Dict));
		Dict dict = dictMap.get(type);
		if (null == dictMap.get(type) || dict.getDelflag() == SOCOAppConstant.DELETE_FLAG_Y) {
			return filePath;
		}
		return dict.getValue() + "/" + DirecotryUtil.generateYYYYMMDDDirecotry();
	}

	/**
	 * 
	 * replaceFileName:替换文件名称
	 *
	 * @author sunlangping
	 * @param originFileName
	 *            原始文件名称
	 * @return
	 */
	private String replaceFileName(String originFileName) {
		if (StringUtils.isEmpty(originFileName)) {
			return null;
		}
		String suffix = "";
		if (originFileName.indexOf(".") > -1) {
			suffix = originFileName.substring(originFileName.indexOf("."), originFileName.length());
		}
		return DirecotryUtil.generateUUID() + suffix;
	}

}
