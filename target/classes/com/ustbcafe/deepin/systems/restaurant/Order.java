package com.ustbcafe.deepin.systems.restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rudy Steiner on 2017/3/12.
 */
public class Order {
    private long orderId;
    private int tableId;
    private volatile DishStatus status;
    private transient  volatile int next=0;
    private String customerName;
    private String chef;
    private List<Dish>  dishes=null;
    //private HashMap<Integer,Dish>  dishMap;



    public void setChef(String chef) {
        this.chef = chef;
    }

    public Order(String customerName,int tableId){
        this.customerName=customerName;
        this.tableId=tableId;
        //this.dishMap=new HashMap<>();
        this.dishes=new ArrayList<>();
        this.orderId=System.currentTimeMillis();
    }
    public void orderCurrentStatus(){
        if(dishes.size()!=0) {
            System.out.println(customerName+"的订单:" + orderId);
            for (Dish dish : dishes) {
                System.out.println(dish.toString());
            }
        }
    }
    public boolean isCookedAll(){
        if(status!=DishStatus.COOKED) {
            if (dishes.size() != 0) {
                for (Dish dish:dishes ) {
                    if (dish.getStatus() != DishStatus.COOKED) {
                        return false;
                    }
                }
            }
        }
        status=DishStatus.COOKED;
        return true;
    }
    public Dish getDish(){
        Dish d=null;
        if(next<dishes.size()) {
            d = dishes.get(next);
            next++;
        }
        return d;
    }
    public boolean addDish(Dish dish){

        return dishes.add(dish);
    }
    public boolean addDish(Collection<Dish> collection){
          dishes.addAll(collection);
          return true;
    }
    public boolean cancelDish(){

        return false;
    }
   public int size(){
       return dishes.size();
   }
    public long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", tableId=" + tableId +
                ", status=" + status +
                ", next=" + next +
                ", customerName='" + customerName + '\'' +
                ", chef='" + chef + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
