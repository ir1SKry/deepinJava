package com.ustbcafe.deepin.pattern.singleton;

/**
 * Created by Rudy Steiner on 2017/6/30.
 * forbidden inherit
 */
public final class FinalLazySingleton {
    //静态内部类不能直接访问外部类数据
    private  static class  LazySingletonLoader{
        private static final FinalLazySingleton instance=new FinalLazySingleton();
    }
    private FinalLazySingleton(){
        if(LazySingletonLoader.instance!=null){
            throw new IllegalStateException("Already instantiated");
        }
    }
    public static FinalLazySingleton getInstance(){
        return LazySingletonLoader.instance;
    }
}
