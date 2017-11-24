package com.ustbcafe.deepin.algorithms.sort;

/**
 * Created by wangjin18 on 2017/11/24.
 */
public class MergeSort2 {

    public  int[] aux;
    public  int[] mergeSort(int[] A, int n) {
        // write code here

        //·ÇµÝ¹é
        aux=new int[n];
        int len=1;
        while(len<n ){
            for(int i=0;i+len<n;i+=2*len){
                merge(A,i,i+len,Math.min(i+2*len,n));
            }
            len*=2;
        }

       // µÝ¹é
       // recursiveMergeSort(A,0,n/2,n);

        return A;
    }
    /**
     *  µÝ¹é¹é²¢ÅÅÐò
     *  @hi
     **/
    public void recursiveMergeSort(int[] A,int lo, int mid,int hi){
        if(lo==mid)
            return ;
        recursiveMergeSort(A,lo,lo+(mid-lo)/2,mid);
        recursiveMergeSort(A,mid,mid+(hi-mid)/2,hi);
        merge(A,lo,mid,hi);

    }
    public void merge(int[] A,int lo,int mid,int hi){
        int i=lo;
        int j=mid;
        for(int k=lo;k<hi;k++){
            aux[k]=A[k];
        }
        for(int k=lo;k<hi;k++){
            if(i>=mid) A[k]=aux[j++];
            else if(j>=hi) A[k]=aux[i++];
            else if(aux[i]<aux[j]){A[k]=aux[i++];}
            else A[k]=aux[j++];
        }
    }
    public static void main(String[] args){
        // verified in nowcoder

    }

}
