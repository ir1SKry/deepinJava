package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 * Created by wangjin18 on 2017/8/29.
 */
public class Narray {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int[] flag=new int[n];
        int[] arrangement=new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        backtracking(a,flag,0,arrangement);
    }
    public static void backtracking(int[] a,int[] flag,int i,int[] arrangement){

           if(i==a.length){
               // print
               print(arrangement);
           }else{
               for(int j=0;j<a.length;j++){
                     if(flag[j]==0){
                         flag[j]=1;
                         arrangement[i]=a[j];
                         backtracking(a,flag,i+1,arrangement);
                         flag[j]=0;
                     }
               }
           }
    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
