package com.ustbcafe.deepin.pattern.singleton;

/**
 * Created by Rudy Steiner on 2016/12/27.
 *  类加载时实例化,考虑了多线程，反射，序列化，克隆造成非单例的情况
 */

public class EagerSingleton {

    //静态变量，JVM同步，final保证不会重复初始化
    private static final EagerSingleton instance=new EagerSingleton();

    /*
     * 抛出异常，防止通过反射实例化
     *
     * */
    private  EagerSingleton(){
         if(instance!=null){
             throw new IllegalStateException("Already instantiated");
         }
         //To Do init
    }

    public static EagerSingleton getInstance(){
        return instance;
    }

    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("clone instance is not supported");
    }
}
