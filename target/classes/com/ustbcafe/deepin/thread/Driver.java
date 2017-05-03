package com.ustbcafe.deepin.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Rudy Steiner on 2016/12/28.
 */
public class Driver {
    public static void main(String[] args){
        Sum  sumA=new Sum();
        Sum  sumB=new Sum();
        Thread threadA= new Thread(new SummationRunnable(10,sumA));
        Thread threadB= new Thread(new SummationThread(15,sumB));
        threadA.start();
        try {
            threadA.join();
        }catch (InterruptedException ie){

        }
        Condition  sufficientCondition;
        Lock reentrantLock;
        ReentrantLock reentrantLock1;
        System.out.println(sumA.getSum());
    }
}
