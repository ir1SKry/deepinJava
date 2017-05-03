package com.ustbcafe.deepin.pattern.prodc;

import com.ustbcafe.deepin.pattern.producer.Consumer;
import com.ustbcafe.deepin.pattern.producer.PCData;
import com.ustbcafe.deepin.pattern.producer.Producer;
import junit.framework.TestCase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Rudy Steiner on 2017/3/17.
 */
public class PCTest extends TestCase{

    public void testProducerAndConsumer() throws InterruptedException{
        BlockingQueue<PCData> queue=new ArrayBlockingQueue<PCData>(20);
        ExecutorService service= Executors.newCachedThreadPool();
        Producer producer1=new Producer(queue);
        Producer producer2=new Producer(queue);
        Producer producer3=new Producer(queue);
        Producer producer4=new Producer(queue);
        Producer producer5=new Producer(queue);
        Producer producer6=new Producer(queue);
        Consumer consumer1=new Consumer(queue);
        Consumer consumer2=new Consumer(queue);
        Consumer consumer3=new Consumer(queue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(producer4);
        service.execute(producer5);
        service.execute(producer6);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        Thread.sleep(400*1000);
        producer1.stop();;
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();
        //Bit
    }
}
