package com.ustbcafe.deepin.systems.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Rudy Steiner on 2017/3/12.
 * 设计一个系统模拟餐厅
 * 1、先下的单先做
 * 2、后来的订单可以和已有的相同的订单合并，一块做
 *
 */
public class Restaurant {

    //String[] dishName={"西红柿炒鸡蛋","回锅肉","Pizza","Salad","Dumpling","Noodles"};
    public static void main(String[] args){
        BlockingQueue<Order> orderQueue=new ArrayBlockingQueue<Order>(20);
        List<Thread>  threads=new ArrayList<>();
       // List<Thread>  waiters=new ArrayList<>();
      //  new ThreadPoolExecutor();
        Thread chefA=new Thread(new Chef("A",orderQueue),"A");
        Thread chefB=new Thread(new Chef("B",orderQueue),"B");
        Thread chefC=new Thread(new Chef("C",orderQueue),"C");
        Thread chefD=new Thread(new Chef("D",orderQueue),"D");
        Thread chefE=new Thread(new Chef("E",orderQueue),"E");
        threads.add(chefA);
        threads.add(chefB);
        threads.add(chefC);
        threads.add(chefD);
        threads.add(chefE);
        Thread waiter1=new Thread(new Waiter("first",orderQueue,100,40),"first");
        Thread waiter2=new Thread(new Waiter("second",orderQueue,100,40),"second");
        Thread waiter3=new Thread(new Waiter("third",orderQueue,100,40),"third");
        threads.add(waiter1);
        threads.add(waiter2);
        threads.add(waiter3);
       // try {
        long startTime=System.currentTimeMillis();
            for (Thread thread : threads) {
                 thread.start();
            }
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            }catch (InterruptedException e){
            }
           long endTime=System.currentTimeMillis();
           System.out.println("stop the whole world! total elapsed time:"+(endTime-startTime)+"ms");
    }
}
