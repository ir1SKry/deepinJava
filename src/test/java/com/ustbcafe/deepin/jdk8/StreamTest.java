package com.ustbcafe.deepin.jdk8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Rudy Steiner on 2017/7/1.
 */
public class StreamTest {

    @org.junit.Test
    public  void  streamTest(){
        //System.out.println((int x,int y)-> {return x+y;});
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
//        long count=nums.stream().filter(num -> num != null).count();
//        System.out.println(count);
    }
}
