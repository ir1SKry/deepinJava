package com.ustbcafe.deepin.utils;

/**
 * Created by Rudy Steiner on 2017/5/12.
 */

public class DoubleUtil {
    private  static final double ACCURATE=0x1P-6;
    public static  boolean isEqual(double a,double b){
        if(Math.abs(b-a)>ACCURATE){
            return false;
        }
        return  true;
    }
}
