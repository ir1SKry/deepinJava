package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/3/28.
 * 算法导论 动态规划-钢条切割问题
 */
public class SteelCutting {

    /* 自顶向下，朴素递归切割
    * @param p： 收益数组
    * @param n： 待切割钢条长度
    * */
    public static int tDRecursiveCut(int[] p,int n){
        System.out.print(n+" ");
        if(n==0)
            return 0;
        int result=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            result=Math.max(result,p[i]+tDRecursiveCut(p,n-i-1));
        }

        return result;
    }
    /*
    *  自顶向下，带记忆的切割
    *  @param p： 收益数组
    *  @param n： 待切割的长度
    *  @param r:  收益记忆数组
    * */
    public static int tDRecursiveCutWithMemory(int[] p,int n,int[] r){
        if(r[n]>=0){
            return r[n];
        }
        System.out.print(n+" ");
        int result=Integer.MIN_VALUE;
        if(n==0)
            result=0;
        else {
            for (int i = 0; i < n; i++) {
                result = Math.max(result, p[i] + tDRecursiveCutWithMemory(p, n - i - 1, r));
            }
        }
        r[n]=result;
        return result;
    }
    /*
    *  自底向上,非递归切割
    *  @param p： 收益数组
    *  @param n： 待切割的长度
    *  @param c:  切割方案
    * */
    public static int bUNonRecursive(int[] p,int n,int[] c){
        int result;
        int[] r=new int[n+1];
        int rn=r.length;
        r[0]=0;
        c[0]=0;
        for(int i=1;i<rn;i++){
            result=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(result<p[j]+r[i-j-1]) {
                    result = p[j] + r[i - j - 1];
                    c[i]=j+1;
                }
            }
            r[i]=result;
        }
        return  r[n];
    }
    public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      int  n=in.nextInt();
      int[] p=new int[n];

      for(int i=0; i<n;i++){
           p[i]=in.nextInt();
      }
        int toCut=in.nextInt();
        int[] r=new int[toCut+1];
        int[] c=new int[toCut+1];
        for(int i=r.length-1;i>=0;i--){
            r[i]=Integer.MIN_VALUE;
        }
        int value;
        //value=tDRecursiveCut(p,toCut);
        //value=tDRecursiveCutWithMemory(p,toCut,r);
        value=bUNonRecursive(p,toCut,c);
        System.out.print("切割方案：");
        while(toCut>0){
            System.out.print(c[toCut]+" ");
            toCut=toCut-c[toCut];
        }
        System.out.printf("\r\n最优切割受益：%d,耗时:%d",value,0);
    }
}
