package com.ustbcafe.deepin.collection;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public interface IStack<T> {
    public T pop();
    public void push(T e);
    public boolean empty();
}
