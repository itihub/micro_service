package com.xxx.user.utils;

import org.apache.tomcat.util.buf.HexUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: MD5工具类
 * @Author: Jimmy
 */
public class MD5Util {

    /**
     * MD5加密
     * @param password 明文
     * @return
     */
    public static String encrypt(String password){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(password.getBytes("UTF-8"));
            return HexUtils.toHexString(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
}
