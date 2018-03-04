package com.ustbcafe.deepin.algorithms.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangjin18 on 2017/8/24.
 *
 *  Largest sum of continuous sub array
 *  子数组的最大和
 *  program pear
 *
 */
public class LCSSum {

    public static void main(String[] args){

//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int[] array=new int[n];
//        for(int i=0;i<n;i++)
//           array[i]= in.nextInt();
//        int max=largestSum(array);
//        System.out.println("子数组的最大和："+max);
          int[]  input=scan();
          int max=largestSum(input);
          System.out.println(max);
    }
    public static int[] scan(){
        Scanner in=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while(in.hasNextInt()){
            int n=in.nextInt();
            list.add(n);
            //in.next();
        }
        int count=list.size();
        int[] input=new int[count];
        for(int i=0;i<count;i++){
            input[i]=list.get(i);
        }
        return input;
    }
    /*
     *  sum[i] 表示以下标i结尾的子数组的最大和
     *   leetcode
     *   53. Maximum Subarray
     * */
    public static int largestSum(int[]  nums){
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        int max=sum[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=Math.max(nums[i],sum[i-1]+nums[i]);
            max=Math.max(sum[i],max);
        }
        return max;
    }




}
