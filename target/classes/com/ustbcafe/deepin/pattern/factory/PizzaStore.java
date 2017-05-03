package com.ustbcafe.deepin.pattern.factory;

/**
 * Created by Rudy Steiner on 2017/3/13.
 */
public abstract class PizzaStore {

   SimplePizzaFactory pizzaFactory;
    public PizzaStore(SimplePizzaFactory pizzaFactory){
        this.pizzaFactory=pizzaFactory;
    }
    Pizza orderPizza(String type){

          Pizza pizza=null;
          pizza=pizzaFactory.createPizza(type);
          pizza.prepare();
          pizza.bake();
          pizza.cut();
          pizza.box();
        return pizza;
    }
    // 工厂方法，由子类做决定
      abstract  Pizza createPizza(String style);
}
