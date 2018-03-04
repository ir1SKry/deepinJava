package com.ustbcafe.deepin.algorithms.sort.application;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/8/26.
 * 数组中k 大的值
 */
public class Kth {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arrayLine= in.nextLine();
        String[] arr= arrayLine.split(" ");
        int len=arr.length;
        int[] inputArray=new int[len];
        for(int i=0;i<len;i++){
            inputArray[i]=Integer.parseInt(arr[i]);
        }
        int k= in.nextInt();
        int kth=-1;
        if(k<inputArray.length)
              kth=kth(inputArray,0,len-1,k);
        else if(k==inputArray.length)
              kth= min(inputArray);
        else throw new IllegalArgumentException("in valid k ");
        System.out.println(kth);

    }
    public static int min(int[] a){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
    public static int kth(int[] a,int low,int high,int k){
            if(low>high)
                throw new IllegalArgumentException("not found");
             int mid=partition(a,low,high);
             int h=high-mid;
             if(h+1==k) return a[mid];
             if(h+1<k)
                 return kth(a,low,mid-1,k-h-1);
             else return kth(a,mid+1,high,k);

    }
    public static int partition(int array[], int low, int high){
        //
        if(array==null||array.length==0||low<0||high>array.length-1)
            throw new IllegalArgumentException("Invalid parameters");
        int i=low;
        int j=high;
        int pivot=array[low];
        while(i<j){
            while(i<j&&array[j]>pivot)j--;
            if(i<j) array[i++]=array[j];
            while(i<j&&array[i]<pivot)i++;
            if(i<j) array[j--]=array[i];
        }
        array[i]=pivot;
        return i;
    }

}
