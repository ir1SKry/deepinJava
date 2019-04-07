package com.ustbcafe.deepin.algorithms.sort;

public class Quick3Way {



    /**
     * @param a index to exchange
     * @param b
     * */
    public static void exch(long[] value,int a,int b){
         long tmp=value[a];
         value[a]=value[b];
         value[b]=tmp;
    }

    /**
     * partition
     *
     **/
    private static int partition(long[] value,int lo,int hi){
        int i=lo,j=hi+1;
        long pivot=value[lo];
        while(true){
            while(value[++i]<pivot){
                if(i==hi) break;
            }
            while(pivot<value[--j]){
                if(j==lo) break;
            }
            if(i>=j) break;
            exch(value,i,j);
        }
        exch(value,lo,j);
        return j;
    }

    public static void quickSort(long[] value,int lo,int hi){
        if(hi<=lo) return;
        int j=partition(value,lo,hi);
        quickSort(value,lo,j-1);
        quickSort(value,j+1,hi);
    }


}
