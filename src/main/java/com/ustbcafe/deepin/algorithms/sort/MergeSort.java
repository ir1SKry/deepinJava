package com.ustbcafe.deepin.algorithms.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/4/8.
 */
public class MergeSort {
    /*
    * @param f 待排序文件
    * @param f1 归并结果存储文件
    * @param start 待合并第1组数据起始位置
    * @param mid   待合并第1组数据最后一个数据位置
    * @param end   带合并第2组数据最后一个数据位置
    * */
    public static void mergeHelper(int[] f,int[] f1,int start,int mid,int end){
        int i=start,j=mid+1;
        int k=start,t;
        while(i<=mid&&j<=end){
            if(f[i]<=f[j]){
                f1[k]=f[i];
                i++;k++;
            }else{
                f1[k]=f[j];
                j++;k++;
            }
        }
       if(i<=mid) t=mid;
        else{
            i=j;t=end;
       }
        while(i<=t){
            f1[k]=f[i];
            k++;i++;
        }
    }
    public static void mergeStep(int[] f,int[] f1,int step){
        int start=0,len=f.length-1;
        int i,j,end,nextEnd;
        while((nextEnd=start+2*step-1)<len){
            i=start;j=start+step-1;end=nextEnd;
            mergeHelper(f,f1,i,j,end);
            start=end+1;
        }
        if((j=start+step-1)<len){
            i=start;
            mergeHelper(f,f1,i,j,len);
        }else{
            while(start<=len) {
                f1[start]=f[start];
                start++;
            }
        }
    }
   public static void sort(int[] f,int[] f1){
       int step=1,len=f.length;
       while(step<len){
           mergeStep(f,f1,step);
           step=step*2;
           mergeStep(f1,f,step);
           step=step*2;
       }
   }
   public static void main(String[] args){
       Scanner in=new Scanner(System.in);
       int  n=in.nextInt();
       int[] f=new int[n];
       int[] f1=new int[n];
       for(int i=0;i<n;i++) f[i]=in.nextInt();
       sort(f,f1);
       System.out.print(Arrays.toString(f));
   }
}
