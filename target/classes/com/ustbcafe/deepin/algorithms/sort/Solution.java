package com.ustbcafe.deepin.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudy Steiner on 2017/3/23.
 */
public class Solution {
    private List<Integer> list;
    private int data;
    private int[] datas;
    private int product=1;
    public Solution(int data){
        this.data=data;
        list=new ArrayList<>();
        ints(data);
        fillData();
    }
    private void ints(int data){
        int left;
        int right;
        do{
            left=data/10;
            right=data%10;
            list.add(right);
            data=left;
        }while(data>0);
    }
    private void fillData(){
        datas=new int[list.size()];
        int i=0;
        for(Integer integer:list){
             datas[i++]=integer.intValue();
        }
    }
    public boolean isBalance(){

        return true;
    }
    public static void main(String[] args){
           new Solution(1221);
    }
}
