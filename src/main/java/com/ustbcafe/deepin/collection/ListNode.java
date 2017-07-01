package com.ustbcafe.deepin.collection;

import com.ustbcafe.deepin.algorithms.list.LinkedSolution;

import java.io.Serializable;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class ListNode<T> implements Serializable{
    public T val;
    public ListNode<T> next;
    public ListNode(T e){
        this.val=e;
        next=null;
    }
}
