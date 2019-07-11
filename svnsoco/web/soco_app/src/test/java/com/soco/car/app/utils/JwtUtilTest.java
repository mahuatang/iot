/**
 * Project Name:SOCO_APP
 * File Name:JwtUtilTest.java
 * Package Name:com.soco.car.app.utils
 * Date:2018年7月18日上午9:34:58
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.utils;

import java.security.Key;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * ClassName:JwtUtilTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月18日 上午9:34:58 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class JwtUtilTest {

	@Test
	public void testToken() throws Exception {
		Key KEY = new SecretKeySpec("soco".getBytes(), SignatureAlgorithm.HS512.getJcaName());
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("type", "1");
		String payload = "{\"user_id\":\"1341137\", \"expire_time\":\"2018-01-01 0:00:00\"}";
		String compactJws = Jwts.builder().setHeader(stringObjectMap).setPayload(payload)
				.signWith(SignatureAlgorithm.HS512, KEY).compact();

		System.out.println("jwt key:" + new String(KEY.getEncoded()));
		System.out.println("jwt payload:" + payload);
		System.out.println("jwt encoded:" + compactJws);

		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(compactJws);
		JwsHeader header = claimsJws.getHeader();
		Claims body = claimsJws.getBody();

		System.out.println("jwt header:" + header);
		System.out.println("jwt body:" + body);
		System.out.println("jwt body user-id:" + body.get("user_id", String.class));

	}

	@Test
	public void testDate() throws Exception {
		Date date = new Date(1533265369746l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
	}

	@Test
	public void testUrl() throws Exception {
		String url = "/test/{0}/{1}/{2}";
		System.out.println(MessageFormat.format(url, "v1","user","get"));
	}

}
