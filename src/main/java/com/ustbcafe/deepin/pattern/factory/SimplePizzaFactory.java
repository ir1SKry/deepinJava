package com.ustbcafe.deepin.pattern.factory;

/**
 * Created by Rudy Steiner on 2017/3/13.
 * 简单工厂，只是将类的创建移到工厂里面来
 * 简单工厂其实并不是一种设计模式
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type){

        Pizza pizza=null;
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if(type.equals("greek")) {
            pizza = new GreekPizza();
        } else if(type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
