package com.ustbcafe.deepin.systems.restaurant;

/**
 * Created by Rudy Steiner on 2017/3/12.
 */
public class Dish {
    private int no;
    private String name;
    private volatile int amount;
    private volatile DishStatus status;
    public Dish(int dishNo,String dishName,int amount,DishStatus dishStatus){
        this.no=dishNo;
        this.name=dishName;
        this.status=dishStatus;
        this.amount=amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public DishStatus getStatus() {
        return status;
    }

    public void setStatus(DishStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
