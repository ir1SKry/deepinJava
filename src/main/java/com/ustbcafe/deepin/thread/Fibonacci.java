package com.ustbcafe.deepin.thread;

import java.util.Arrays;

/**
 * Created by Rudy Steiner on 2016/12/28.
 */
public class Fibonacci {
    int a0=0;
    int a1=1;
    int max=12;
    int[] fib;
    public Fibonacci(int a0,int a1,int months){
          this.a0=a0;
          this.a1=a1;
          this.max=months;
          fib=new int[months];
    }
    public void  fibonacci(){
        if(max<2)
            return ;
            fib[0]=a0;
            fib[1]=a1;
         for(int i=2;i<max;i++){
             fib[i]=fib[i-1]+fib[i-2];
         }
    }
    public static void  main(String[] args){
        Fibonacci f=new Fibonacci(1,1,12);
                  f.fibonacci();
        Arrays.toString(f.fib);
        System.out.println(Arrays.toString(f.fib));
    }
}
