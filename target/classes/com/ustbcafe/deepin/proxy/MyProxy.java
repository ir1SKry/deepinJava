package com.ustbcafe.deepin.proxy;

/**
 * Created by Rudy Steiner on 2017/3/11.
 */
public class MyProxy {

    @MyAnnotation(name="USTB")
    public void  test(String param){
        System.out.println(param);
    }

    public void SayHiDefault(String name) {
        System.out.println("Hi, " + name);
    }
}
