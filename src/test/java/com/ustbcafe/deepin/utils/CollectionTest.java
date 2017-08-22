package com.ustbcafe.deepin.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjin18 on 2017/8/8.
 */
public class CollectionTest {

    @Test
    public void mapTest(){
        Map<String,String> map=new HashMap<>(8);
        map.put("name","wag");
        System.out.println(map);
    }
}
