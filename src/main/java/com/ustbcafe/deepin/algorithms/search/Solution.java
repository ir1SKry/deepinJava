package com.ustbcafe.deepin.algorithms.search;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Rudy Steiner on 2017/2/22.
 */
public class Solution {
    /*
    *  return  -1 表明查找失败
    * */
    public int binarySearch(int[] a,int b){
        if(a==null||a.length==0)
            return -1;
        if(b<a[0]||b>a[a.length-1])
            return -1;
        int low=0;
        int high=a.length;
        int mid;
        while(low<=high){
            // 防止溢出
            mid=(high-low)/2+low;
            if(a[mid]==b) return mid;
            if(a[mid]<b) low=mid+1;
                    else high=mid-1;
        }
        return -1;
    }
    public int minAtSpinArray(int data[]){
        if(data==null||data.length==0)
            throw new RuntimeException("Invalid Exception");
        int low=0;
        int high=data.length-1;
        int mid=0;
        while(data[low]>=data[high]){
             if(high-low==1){
                 mid=high;
                 break;
             }
             mid=low+(high-low)/2;
             if(data[low]==data[mid]&&data[mid]==data[high]){
                 return minAtArray(data,low,high);
             }
             if(data[mid]>=data[low]) low=mid;
             else if(data[mid]<=data[high]) high=mid;
        }
        return data[mid];
    }
    public int minAtArray(int data[],int low,int high){
        if(data==null||data.length==0||low<0||high>data.length-1)
            throw new RuntimeException("Invalid Parameters");

        int min=data[low];
        for(int ind=low;ind<=high;ind++){
                 min=Math.min(min,data[ind]);
        }
        return min;
    }
    public static void main(String[] args){


        int[] a={3,12,18,20,32,55,60,68,80,86,90,100};
       // int[] a=new int[0];
        int k=101;
        int pos=new Solution().binarySearch(a,k);
        System.out.println(Arrays.toString(a));
        if(pos>=0)
           System.out.println( k+" at position:"+pos);
        else System.out.println("search failed");

        int[] spin1={7,8,9,4,5,6};
        int [] spin2={};
        int [] spin3={1,0,1,1,1,1};
        int [] spin4={1,2,3,4,5,6};
        int[] spin=spin3;
        System.out.println("旋转数组："+Arrays.toString(spin));
        System.out.println("最小值："+new Solution().minAtSpinArray(spin));
        //System.out.println("最小值："+new Solution().minAtArray(spin,0,spin.length-1));
        new IllegalArgumentException();
    }

}
