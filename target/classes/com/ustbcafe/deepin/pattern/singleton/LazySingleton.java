package com.ustbcafe.deepin.pattern.singleton;

/**
 * Created by Rudy Steiner on 2016/12/27.
 *  第一次调用getInstance 才加载，
 */
public class LazySingleton {

            //静态内部类不能直接访问外部类数据
            private  static class  LazySingletonLoader{
                private static final LazySingleton instance=new LazySingleton();
            }
            private LazySingleton(){
                if(LazySingletonLoader.instance!=null){
                    throw new IllegalStateException("Already instantiated");
                }
            }
            public static LazySingleton getInstance(){
                return LazySingletonLoader.instance;
            }
}
