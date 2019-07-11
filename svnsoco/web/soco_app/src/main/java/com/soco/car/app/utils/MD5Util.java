package com.soco.car.app.utils;

import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * MD5工具类
 * @author Lynn
 *
 */
public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public final static String MD5(String str) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
        	
        	str = URLEncoder.encode(str, "utf-8").replace("*","%2A").replace("+","%20");
//        	str = URLEncoder.encode(str, "utf-8");
        	str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
            byte[] btInput = str.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char strs[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                strs[k++] = hexDigits[byte0 >>> 4 & 0xf];
                strs[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(strs);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
	
	
	public static void main(String[] args) {
		String str="0,120,30,50,4,9,7,6,31,18,58,6,6,1,4";
		String [] split=str.split(",");
		byte [] nstr = new byte[15];
		
		for(int i =0;i<split.length;i++){
			nstr[i]=Byte.parseByte(split[i]);
		}
		
    }
}
