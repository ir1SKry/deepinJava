package com.ustbcafe.deepin.utils;

import java.util.Random;

/**
 * Created by wangjin18 on 2017/12/13.
 */
public class RandomString {
    private static String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String rand(int len){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return  sb.toString();
    }
}