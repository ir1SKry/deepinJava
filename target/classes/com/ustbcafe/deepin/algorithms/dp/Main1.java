package com.ustbcafe.deepin.algorithms.dp;

import java.util.*;

/**
 * Created by Rudy Steiner on 2017/3/29.
 * 超时
 */
public class Main1 {

   static Map<Integer,Integer> map=new HashMap<>(30);
    public static void main(String[] args){

         Scanner in=new Scanner(System.in);
         while(in.hasNext()){
              int zeroCount=in.nextInt();
                  System.out.println(f(zeroCount));
         }
    }
    /*
    *   满足zeroCount个0的最小数
    *
    * */
    public static int f(int zeroCount){
        int h=5;
        int n=0;
        int result=0;
        int zero=0;
        while(zero<zeroCount){
            n=n+h;
            if(map.get(n)!=null){
                zero=map.get(n);
            }else{
                zero=h(n,h);
                map.put(n,zero);
            }
            if(zero==zeroCount){
                result=n;
            }
        }
        if(zero!=zeroCount)
            result=-1;
        return result;
    }
    /*
    *  n中5的个数，即0的个数
    * */
    public static int h(int n,int p){
         int result=0;
            int i = 1;
            int divide = 0;
            while ((divide = (int) Math.pow(p, i)) <= n) {
                result += n / divide;
                i++;
            }
        return result;
    }
}
