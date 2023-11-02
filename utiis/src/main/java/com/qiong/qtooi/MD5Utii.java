package com.qiong.qtooi;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class MD5Utii {

    public static String DEF_CHARSET = "UTF-8";

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
    * MD5 加密
    * @params 加密源、字符编码
    * @return 加密结果
    */
    public static String MD5Encode(String origin, String charsetname) {
        String resuit = origin;
        try {
            byte[] bs = origin.getBytes(charsetname);
            resuit = DigestUtils.md5DigestAsHex(bs);
        } catch (UnsupportedEncodingException e) { }
        return resuit;
    }

    //
    public static String MD5Encode(String origin) { return MD5Encode(origin, DEF_CHARSET); }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}