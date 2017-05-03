package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 *
 * 长度为n的序列中，最长的递增子序列 Longest increasing sequence
 */
public class LIS {
    /*
    *  @param 输入序列
    *  @param c[i] 记录以seq[i]结尾的最长递增子序列长度
    *  @param pre[i] 记录以seq[i]结尾的最长递增子序列的前驱
    *  @return 返回最大递增子序列最后一个元素所在下标
    * */
    public static int lis(int[] seq,int[] c,int[] pre){
        int n=seq.length;
        int i;
        for(i=0;i<n;i++){
            c[i]=1;
            pre[i]=-1;
        }
        int maxInd=0;
        for(i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i]&&c[j]+1>c[i]){
                     c[i]=c[j]+1;
                     pre[i]=j;
                }
            }
            if(c[i]>c[i-1])
                 maxInd=i;
        }
        return maxInd;
    }
    public static void printLIS(int[] seq, int[] pre, int last){
        if(pre[last]==-1){
            System.out.print(seq[last]);
            return ;
        }
          if(pre[last]>=0){
              printLIS(seq,pre,pre[last]);
              System.out.print(seq[last]);
          }
    }
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
         int n=in.nextInt();
         int[] x=new int[n];
         int[] c=new int[n];
         int[] pre=new int[n];
         for(int i=0;i<n;i++) x[i]=in.nextInt();
         int maxInd=lis(x,c,pre);
         System.out.printf("最长递增子序列长度：%d,",c[maxInd]);
         printLIS(x,pre,maxInd);
    }

}
