package com.ustbcafe.deepin.thread;

/**
 * Created by Rudy Steiner on 2016/12/28.
 */
public class SummationThread extends Thread{
    private int upper;
    private Sum sumInstance;
    public SummationThread(int upper,Sum sum){
        this.upper=upper;
        this.sumInstance=sum;
    }
    public void run(){
        int sum=0;
        for(int i=0;i<upper;i++)
            sum+=1;
        sumInstance.setSum(sum);
    }
}
