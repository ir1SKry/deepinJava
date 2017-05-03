package com.ustbcafe.deepin.base;

/**
 * Created by Rudy Steiner on 2017/3/18.
 */
public class Bits {
    public static void main(String[] args){
        long i=1L;
        int bitIndex=67;
        int n=1;
         int result=new Bits().optimizeReverseBits(n);
        System.out.println("traverse "+n+",result:"+result);
        System.out.println(i<<bitIndex);
    }
    /*
    * LeetCode  190
    *
    * */
    public int reverseBits(int n) {
        int first=0;
        int last=31;
        while(first<last){
            int firstMask=1<<first;
            int lastMask=1<<last;
            int firstVal=n&firstMask;
            int lastVal=n&lastMask;
            if((firstVal<<(last-first)^lastVal)!=0){
                n=n^firstMask;
                n=n^lastMask;
            }
            first++;
            last--;
        }
        return n;
    }

    // not a good dp
    public int optimizeReverseBits(int n) {
        int firstMask=1;
        int lastMask=1<<31;
        do{
            int firstVal=n&firstMask;
            int lastVal=n&lastMask;
            if((firstVal==0||lastVal==0)&&!(firstVal==0&&lastVal==0)){
                n=n^firstMask;
                n=n^lastMask;
            }
            firstMask=firstMask<<1;
            lastMask=lastMask>>>1;
        }while(lastMask>firstMask);
        return n;
    }
}
