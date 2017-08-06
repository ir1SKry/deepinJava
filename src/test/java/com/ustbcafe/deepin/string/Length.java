package com.ustbcafe.deepin.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Rudy Steiner on 2017/7/16.
 */
public class Length {
    @Test
    public void length(){
        String a="敏景";
        String b="林";
        System.out.println(a+","+a.getBytes().length+","+ Arrays.toString(a.getBytes()));
        System.out.println(b+","+b.getBytes().length+","+ Arrays.toString(b.getBytes()));
    }
}
