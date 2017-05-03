package com.ustbcafe.deepin.pattern.singleton;

import java.io.Serializable;

/**
 * Created by Rudy Steiner on 2016/12/27.
 *  线程安全，效率不高
 */
public class ThreadSafeSingleton implements Serializable{

    final int a;
    private  static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(int a){
        // 反射实例化
       if(instance!=null){
           throw new IllegalStateException("already instantiated");
       }
       //TO-DO
        this.a=a;

    }
    public static synchronized  ThreadSafeSingleton getInstance(){
        if(instance==null)
            instance=new ThreadSafeSingleton(2);
        return instance;
    }

    @SuppressWarnings("unused")
    private ThreadSafeSingleton readResolve(){
        return  instance;
    }

}
