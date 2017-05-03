package com.ustbcafe.deepin.pattern.producer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Rudy Steiner on 2017/3/17.
 */
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME=1000;
    //private volatile  boolean isRunning=true;
    public Consumer(BlockingQueue<PCData> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
            System.out.println("start consumer id="+Thread.currentThread().getId());
            Random random=new Random();
         try {
             while (true) {
                 PCData data = queue.take();
                 if(null!=data){
                      int re=data.getData()*data.getData();
                      System.out.println(MessageFormat.format("{0}*{1}={2}",data.getData(),data.getData(),re));
                      Thread.sleep(random.nextInt(SLEEPTIME));
                 }
             }
         }catch (InterruptedException e){
             e.printStackTrace();
             Thread.currentThread().getId();
         }
    }
}
