package com.ustbcafe.deepin.systems.restaurant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rudy Steiner on 2017/3/12.
 */
public class Chef implements  Runnable{
    private Dish cookingDish;
    private Order cookingOrder;
    private BlockingQueue<Order> orderQueue;
    private String name;
    private Status status;
    public  Chef(String name,BlockingQueue<Order> orderQueue){
        this.orderQueue=orderQueue;
        this.name=name;
    }
    public void cookDish(Dish dish,DishStatus status){
                 dish.setStatus(status);
                 cookHint(dish);
    }
    public void cookHint(Dish dish){
        System.out.println("线程："+Thread.currentThread().getName()+",厨师,"+name+","+dish.toString());
    }

    @Override
    public String toString() {
        return "Chef{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public void run() {
        try {
            while (true) {

                 if((cookingOrder=orderQueue.poll(500, TimeUnit.MILLISECONDS))!=null) {
                    while (!cookingOrder.isCookedAll()) {
                        cookingDish=cookingOrder.getDish();
                        cookingOrder.setChef(name);
                        cookDish(cookingDish, DishStatus.COOKING);
                        Thread.sleep(50);
                        cookDish(cookingDish, DishStatus.COOKED);
                    }
                    //cookingOrder.orderCurrentStatus();
                     System.out.println(cookingOrder.toString());
                }else {
                       status=Status.EMPTY;
                       System.out.println(toString());
                        break;
                 }
            }

        }catch (InterruptedException e){

        }

    }
}
