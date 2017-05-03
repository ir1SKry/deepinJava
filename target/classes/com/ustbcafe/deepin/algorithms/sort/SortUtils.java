package com.ustbcafe.deepin.algorithms.sort;

/**
 * Created by Rudy Steiner on 2017/3/20.
 */
public class SortUtils {
    public static void swap(int data[] ,int i,int j){
        int temp= data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
