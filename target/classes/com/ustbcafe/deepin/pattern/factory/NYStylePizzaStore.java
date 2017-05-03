package com.ustbcafe.deepin.pattern.factory;

/**
 * Created by Rudy Steiner on 2017/3/13.
 *
 */
public class NYStylePizzaStore extends PizzaStore{

    public NYStylePizzaStore(SimplePizzaFactory pizzaFactory) {
        super(pizzaFactory);
    }

    @Override
    Pizza createPizza(String style) {
        return null;
    }
}
