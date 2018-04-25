package com.ustbcafe.deepin.systems.mq.concurrent;

import com.ustbcafe.deepin.systems.mq.Event;
import com.ustbcafe.deepin.systems.mq.EventListener;
import com.ustbcafe.deepin.systems.mq.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wangjin18 on 2018/4/24.
 */
public class EventBus<E extends Event> implements Service{

    private CopyOnWriteArrayList<EventListener<E>> listeners=new CopyOnWriteArrayList<>();
    private AtomicBoolean started=new AtomicBoolean(false);
    private BlockingQueue<E> events;
    private String name;

    public EventBus(String name){
           this(name,0);
    }
    public EventBus(String name,int capability){
        this.name=name;
        if(capability>0)
            this.events=new ArrayBlockingQueue<>(capability);
        else this.events=new LinkedBlockingQueue<E>();
    }

    public void subscribe(EventListener<E> listener){
         if(listener!=null)
             listeners.addIfAbsent(listener);
    }
    public void unSubscribe(EventListener<E> listener){
        if(listener!=null)
            listeners.remove(listener);
    }


    /**
     *  add the specific element to event bus,wait if necessary
     *  for space to be available
     *
     **/
    public boolean  add(E e){
        try {
            events.put(e);
            return true;
        }catch(InterruptedException ignore){
            // quick return
        }
        return false;
    }

    @Override
    public void start() throws Exception {
       if(started.compareAndSet(false, true)) {

       }
    }

    @Override
    public boolean isStart() {
        return started.get();
    }

    @Override
    public void stop() throws Exception {

    }
}
