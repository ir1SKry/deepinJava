package com.ustbcafe.deepin.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rudy Steiner on 2016/12/28.
 */
public class ArrayMultiThreadMultiple {
    int[][] A;
    int[][] B;
    int[][] C;
    List<Thread> list=new ArrayList<Thread>();
    public  ArrayMultiThreadMultiple(int[][] A,int[][] B){

       this.A=A;
        this.B=B;
        if(A.length<=0||B.length<=0||A[0].length!=B.length)
            throw new IllegalArgumentException("矩阵不能为空，且A列数与B额行数相同");
        C= new int[A.length][B[0].length];
    }
    public void multiple(){
        ExecutorService executors= Executors.newFixedThreadPool(5);
            for(int i=0;i<C.length;i++)
                for(int j=0;j<C[0].length;j++){
                    Thread th= new Thread(new MultipleThread(i,j,A,B,C),""+i+","+j);
                           //th.start();
                           executors.execute(th);
//                           list.add(th);
            }
            executors.shutdown();
            try {
                executors.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            }catch (InterruptedException ie){

            }
            /*
             *  wait multi-thread finish
             * **/
//           for(Thread t:list) {
//               try {
//                   t.join();
//               }catch (InterruptedException ie){
//               }
//           }

    }
    public int[][] getResult(){
        return C;
    }


    public static void  main(String[] args){
        int[][] A={{1,4,3,7,9,10,25,20,11,12},
                   {2,5,34,47,23,38,20,34,10,11},
                   {3,6,38,20,34,10,11,12,27,90}};
        int[][] B={{8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,1,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43},
                    {8,7,6,55,33,456,75,12,0,43}};
        long begin=System.currentTimeMillis();
        ArrayMultiThreadMultiple am=new ArrayMultiThreadMultiple(A,B);
                                 am.multiple();
        int[][] result=am.getResult();

        for(int i=0;i<result.length;i++)
                    System.out.println(Arrays.toString(result[i]));

        System.out.println("time elasped:"+(System.currentTimeMillis()-begin)+" ms");
    }
}
