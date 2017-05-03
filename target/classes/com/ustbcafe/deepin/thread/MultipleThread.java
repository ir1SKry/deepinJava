package com.ustbcafe.deepin.thread;

/**
 * Created by Rudy Steiner on 2016/12/28.
 */
public class MultipleThread extends Thread {
     private int row;
     private int column;
     private int[][] A;
     private int[][] B;
     private int[][] C;
    public MultipleThread(int row,int column,int[][] A,int[][] B,int[][] C){
        this.row=row;
        this.column=column;
        this.A=A;
        this.B=B;
        this.C=C;

    }
    public void run(){
        System.out.println(getName()+" running");
        int result=0;
        for(int i=0;i< A[row].length;i++)
               result+=A[row][i]*B[i][column];
        C[row][column]=result;
        try {
            sleep(1);
        }catch (InterruptedException ie){

        }
        System.out.println(getName()+" endding");
    }
}
