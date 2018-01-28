package com.yy.crm.utils.md5_util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encryption {

    public static String EncoderByMd5(String str)  {
        String newStr=null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            BASE64Encoder base64Encoder = new BASE64Encoder();
            newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }

}
