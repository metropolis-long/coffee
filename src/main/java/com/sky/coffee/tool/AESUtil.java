package com.sky.coffee.tool;

import java.math.BigInteger;

public class AESUtil {

    private static final int RADIX = 16;
    private static final String SEED = "0933910847463829232312312";

    public static final String encrypt(String password)  throws Exception {
        if (password == null || password.length() == 0)
            return "";

        BigInteger bi_passwd = new BigInteger(password.getBytes());
        BigInteger bi_r0 = new BigInteger(SEED);
        BigInteger bi_r1 = bi_r0.xor(bi_passwd);

        return bi_r1.toString(RADIX);
    }

    public static final String decrypt(String encrypted)  throws Exception {
        if (encrypted == null || encrypted.length() == 0)
            return "";

        BigInteger bi_confuse = new BigInteger(SEED);
        BigInteger bi_r1 = new BigInteger(encrypted, RADIX);
        BigInteger bi_r0 = bi_r1.xor(bi_confuse);

        return new String(bi_r0.toByteArray());
    }



    private AESUtil() {
    }

    public static void main(String[] args) throws Exception {
        String pwd=encrypt("qwe");
        System.out.println(pwd);
        System.out.println(decrypt(pwd));
    }
}
