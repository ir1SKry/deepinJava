package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/3/29.
 */
public class Main4 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int   giftCount=in.nextInt();
        int[] weights=new int[giftCount];
        int[] values=new int[giftCount];
        int i;
        for( i=0;i<giftCount;i++) values[i]=in.nextInt();
        for( i=0;i<giftCount;i++)  weights[i]=in.nextInt();
        int weightLimit=in.nextInt();
        int maxValue=Integer.MIN_VALUE;
        for(i=0;i<giftCount;i++){
              int choosedGV=values[i];
              int choosedGW=weights[i];
            if(choosedGW<weightLimit) {
                weights[i] = weights[0];
                values[i] = values[0];
                maxValue = Math.max(maxValue,choosedGV+getMaxValue(values,weights,1,weightLimit-choosedGW));
            }
        }

    }
    public static int getMaxValue(int[] gifts,int[] weight,int n,int left){
        int len=gifts.length;
        int maxValue=Integer.MIN_VALUE;
        if(len==n){
            return 0;
        }
        for(int i=n;i<len;i++){
              if(weight[i]<left){
                   maxValue=Math.max(maxValue,gifts[i]+getMaxValue(gifts,weight,n+1,left-weight[i]));
              }
        }
        return maxValue;
    }
}
