package com.ustbcafe.deepin;

/**
 * Created by Rudy Steiner on 2017/2/11.
 *  innner class 的使用，访问控制和隐式指针问题
 */

 class Outer
{
   private int b=1024;
    // float or double
   public float a=3.4f;
   protected double c=2.4;

     class Inner{

         public void f(){

            int a= 1/0;
         }
     }
    public static void foo(){
           int g=2;
           //new Inner();
    }
    public void inner(){
        new Inner();
    }

    public static void main(String[] args){

        //new Inner();
        Inner in=new Outer().new Inner();
        in.f();
    }
}
