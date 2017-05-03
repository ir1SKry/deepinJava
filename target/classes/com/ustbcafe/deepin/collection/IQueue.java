package com.ustbcafe.deepin.collection;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public interface IQueue<T> {
    void enqueue(T e);
    T dequeue();
    T peek();
}
