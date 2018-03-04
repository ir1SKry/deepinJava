package com.ustbcafe.deepin.lang;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rudy Steiner on 2017/8/26.
 *  JDK8 new features test
 */
public class JDK8 {

     /*
      * (params)->expression
      *
      * */
     public static void main(String[] args){
           lambdaFeature();
           //listIterator();
           methodReference();
           Defaulable.staticMethod();
           //new Defaulable().notRequired();
     }
      public static  void lambdaFeature(){
          new Thread(()->System.out.println("hello lambda!")).start();
      }
      public static void listIterator(){
          // Java 8之后：
          List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
          features.forEach(n -> System.out.println(n));
      }
      /*
      *  方法和类引用
      *
      * */
      public static void methodReference(){
          // Java 8之后：
          List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
          //features.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
          features.forEach(System.out::println);
      }
      private interface  Defaulable{
          default  String notRequired(){
              return "default interface method";
          }
          static void staticMethod(){
              System.out.println("static interface method");
          }
      }

}
