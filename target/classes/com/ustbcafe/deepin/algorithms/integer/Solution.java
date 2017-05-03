package com.ustbcafe.deepin.algorithms.integer;

/**
 * Created by Rudy Steiner on 2017/2/22.
 */
public class Solution {
    public int hammingDistance(int a,int b){
         int distance=0;
          if(a-b==0)
              return distance;
         int pos1=a;
         int pos2=b;
         int max=Math.max(pos1,pos2);
         while(max>0) {
             distance += pos1 % 2 ^ pos2 % 2;
             pos1=pos1>>1;
             pos2=pos2>>1;
             max=max>>1;
         }
        return distance;
    }
    /*
    *  整数对应二进制中，1的个数
    * */
    public int countOneOfInt(long val){
        int count=0;
        while(val!=0){
            count++;
            val=val&(val-1);
        }
        return count;
    }
    public static void main(String[] args){

        int a=0x01;
        int b=0x05;
        int c=a^b;

        System.out.println(c);
        System.out.println("byte 运算：");

         //整数对应二进制中1的个数
         long min=0x8000000000000000L;
         long minusOne=0xffffffffffffffffL;
         long one=0x0000000000000001L;
         long max=0x7fffffffffffffffL;
         long minMinus=min-1;
        System.out.println(minMinus);
        System.out.println(max+1);
        Solution sol=new Solution();
        System.out.println("min:"+min+",minus one:"+minusOne+",one:"+one+",max:"+max);
        System.out.println(sol.countOneOfInt(min)+","+sol.countOneOfInt(minusOne)+","+sol.countOneOfInt(one)+","+sol.countOneOfInt(max));



    }
}
