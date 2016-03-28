package org.itsk.datamaster.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 *MD5加密的工具类.
 */
public class Encrypt {


    /**
     * MD5 摘要，使用系统缺省字符集编码
     * 
     * @param input
     * @return
     */
    public static String MD5(String input) {
        return MD5(input, Charset.defaultCharset());
    }

    /**
     * MD5 摘要
     * 
     * @param input
     * @param charset
     * @return
     */
    public static String MD5(String input, String charset) {
        return MD5(input, Charset.forName(charset));
    }

    /**
     * MD5 摘要
     * 
     * @param input
     * @param charset
     * @return
     */
    public static String MD5(String input, Charset charset) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //去掉编码支持.
        md.update(input.getBytes());

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        byte tmp[] = md.digest();
        char str[] = new char[16 * 2];

        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte byte0 = tmp[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }

        String result = new String(str);

        //转换为大写
        return result.toUpperCase(Locale.CHINA);
    }
   
}
