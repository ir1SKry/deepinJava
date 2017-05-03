package com.ustbcafe.deepin.systems.restaurant;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Rudy Steiner on 2017/3/12.
 */
public class Customer {
    private Order myOrder;
    private int tableId;
    private String name;
    public Customer(String name, int tableId){

        this.name=name;
        this.tableId=tableId;
        this.myOrder=new Order(name,tableId);

    }
   public  boolean addDish(Dish dish){
             myOrder.addDish(dish);
       return true;
   }
   public Order createOrder() throws  InterruptedException{
       return myOrder;
   }
   public void addDishes(HashMap<Integer,Dish> dishMap){
         Collection<Dish> collection=dishMap.values();
          myOrder.addDish(collection);
   }


    public String getName() {
        return name;
    }
}
