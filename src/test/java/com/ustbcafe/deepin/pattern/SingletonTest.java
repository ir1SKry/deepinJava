
package com.ustbcafe.deepin.pattern;

import com.ustbcafe.deepin.pattern.singleton.EagerSingleton;
import com.ustbcafe.deepin.pattern.singleton.LazySingleton;
import org.junit.Test;

import javax.management.ReflectionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    @Test
     public void singletonReflect(){
         String singleClass="com.ustbcafe.deepin.pattern.singleton.LazySingleton";
         try {
             Class lazySingleton=   Class.forName(singleClass);
             Constructor  constructor=   lazySingleton.getDeclaredConstructor(null);
             constructor.setAccessible(true);
             Object obj=      constructor.newInstance();
             System.out.println(obj);
         }catch (ClassNotFoundException e){
             e.printStackTrace();
         }catch (IllegalAccessException e){
             e.printStackTrace();
         }catch (InstantiationException e){
             e.printStackTrace();
         }catch (NoSuchMethodException e){
             e.printStackTrace();
         }catch (InvocationTargetException e){
             e.printStackTrace();
         }
     }
     @Test
   public void eagerSingletonTest(){
       EagerSingleton singleton=EagerSingleton.getInstance();
       System.out.println(singleton);
   }

    @Test
    public void lazySingletonTest(){
        LazySingleton singleton= LazySingleton.getInstance();
        System.out.println(singleton);
    }

}