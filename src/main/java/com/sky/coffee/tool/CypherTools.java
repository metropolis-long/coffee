package com.sky.coffee.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

public class CypherTools {
    /**
     * sha1加密方法.
     *
     * @param inStr 加密字符串
     * @param salt 密钥
     * @return 加密后的字符串
     * @throws Exception
     */
    public final static String shaEncode(final String inStr,final String salt) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (final Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        String appendStr = inStr + salt;
        byte[] byteArray = new byte[0];
        try {
            byteArray = appendStr.getBytes("UTF-8");
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final byte[] md5Bytes = sha.digest(byteArray);
        final StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            final int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    public final static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    public final static String generateShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(shaEncode("123456","fgiFFH"));
        System.out.println(generateShortUUID());
    }
}
