package com.ustbcafe.deepin.systems.restaurant;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Rudy Steiner on 2017/3/12.
 */
public class Waiter implements  Runnable {

    private final static char[] nameField={'a','b','d','e','f','g','1','2','c','w','e'};
    private final static String[] dishName={"西红柿炒鸡蛋","回锅肉","Pizza","Salad","Dumpling","Noodles"};
    private static Random random;
    StringBuilder nameBuilder;
    private BlockingQueue<Order> orderBlockingQueue;
    private int maxOrderNums;
    private int maxTable;
    private String name;

    public Waiter(String name,BlockingQueue<Order> orderQueue,int maxOrderNums,int maxTable){
        this.orderBlockingQueue=orderQueue;
        this.maxOrderNums=maxOrderNums;
        this.name=name;
        this.maxTable=maxTable;
        this.random=new Random();
        this.nameBuilder=new StringBuilder();
    }

    @Override
    public void run() {
        try {
            int  orderNums=maxOrderNums;
            HashMap<Integer,Dish> dishMap=new HashMap<>();
            while (orderNums-- > 0) {

                Customer customer = new Customer(randName(), random.nextInt(maxTable));
                int rand = random.nextInt(dishName.length);
                // 单个订单，多个菜
                while (rand >= 0) {
                    int randDishId= random.nextInt(dishName.length);
                    Dish oldDish;
                    if((oldDish=dishMap.get(randDishId))==null)
                           dishMap.put(randDishId,new Dish(randDishId, dishName[randDishId], random.nextInt(2) + 1, DishStatus.WAITING));
                    else  oldDish.setAmount(oldDish.getAmount()+random.nextInt(2) + 1);
                    rand--;
                }
                               customer.addDishes(dishMap);
                               dishMap.clear();
                Order curOrder=customer.createOrder();
                System.out.println("线程："+Thread.currentThread().getName()+":"+customer.getName()+"亲，正在下单......");
                while(!orderBlockingQueue.offer(curOrder));
                {
                        System.out.println("服务员"+name+":\","+customer.getName()+"请稍等,正在下单!\"");
                        Thread.sleep(100);
                }
                System.out.println("服务员 "+name+":\","+customer.getName()+"下单成功,订单号："+curOrder.getOrderId()+"\"");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){

        }
    }
    public String randName(){
        int rand;
        if(nameBuilder.length()!=0)
             nameBuilder.setLength(0);
             while((rand=random.nextInt(nameField.length))!=0&&nameBuilder.length()<nameField.length)
                  nameBuilder.append(nameField[rand]);
        return  nameBuilder.toString();
    }
}
