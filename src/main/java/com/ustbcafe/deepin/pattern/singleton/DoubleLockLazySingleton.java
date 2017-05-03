package com.ustbcafe.deepin.pattern.singleton;

/**
 * Created by Rudy Steiner on 2017/3/1.
 *  双检查加锁单例实现
 */
public class DoubleLockLazySingleton {

    private  static DoubleLockLazySingleton uniqueInstance=null;
    private static Object object=new Object();
    private DoubleLockLazySingleton(){};
    public static DoubleLockLazySingleton getInstance(){
        if(uniqueInstance==null){
            synchronized (object){
                if(uniqueInstance==null)
                    uniqueInstance=new DoubleLockLazySingleton();
            }
        }
        return uniqueInstance;
    }

    public  static void main(String[] args){
        // ugly test
        DoubleLockLazySingleton singleton1=DoubleLockLazySingleton.getInstance();
        DoubleLockLazySingleton singleton2=DoubleLockLazySingleton.getInstance();
        if(singleton1.equals(singleton2)){
            System.out.println("singleton");
        }
    }

}
