package com.ustbcafe.deepin.algorithms.sort;

import static com.ustbcafe.deepin.algorithms.sort.SortUtils.swap;

/**
 * Created by Rudy Steiner on 2017/3/20.
 */
public class HeapSort {

    public static void sort(int data[]){
            if(data==null||data.length==0)
                return;
            int len=data.length;
            int i;
            for(i=len/2-1;i>=0;i--){
                 adjust(data,i,len);
            }
            for(i=len-1;i>=1;i--){
                 swap(data,0,i);
                 adjust(data,0,i-1);
            }
    }
    private static void adjust(int data[],int rootInd,int lastInd){
        int  s=rootInd;
        int  j=2*s+1;
        int temp=data[s];
        while(j<=lastInd){
            if(j<lastInd&&data[j+1]>data[j]) j++;
            if(data[j]>temp){
                data[s]=data[j];
                s=j;
                j=2*s+1;
            }else break;
        }
        data[s]=temp;
    }
}
