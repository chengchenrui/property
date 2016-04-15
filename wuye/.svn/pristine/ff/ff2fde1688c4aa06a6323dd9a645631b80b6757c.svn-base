package com.wuye.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 字符串MD5加密类
 * @author cheng
 *
 */
public class MD5 {
	 // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
	/**
	 * 外部调用
	 * 获取字符串的MD5加密16进制字符串
	 * @param strObj
	 * @return
	 */
    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(MD5.getMD5Code("000000"));
        System.out.println(MD5.getMD5Code("appId=417areaId=1customSecurityLevel=1osap_user=1000235_417_100signature_method=MD5ticket=ULS8fa08538a8354558a4cfe282445e2ee5timestamp=1426668369296t2UXsUutI6uECyBT"));
    }
}
