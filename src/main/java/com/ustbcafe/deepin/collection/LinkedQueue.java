package com.ustbcafe.deepin.collection;

import java.io.Serializable;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class LinkedQueue<T> implements IQueue<T> ,Serializable{
    private ListNode<T> head,last;
    private int len;
    @Override
    public void enqueue(T e) {
       ListNode<T> newNode=new ListNode<T>(e);
        if(head==null){
            last=newNode;
            head=last;
        }else{
            last.next=newNode;
            last=last.next;
        }
        len++;
    }

    @Override
    public T dequeue() {
        T result=null;
        if(head!=null) {
            result = head.val;
            head = head.next;
            len--;
        }
        return result;
    }
    @Override
    public T peek() {
        T result=null;
        if(head!=null)
            result=head.val;
        return result;
    }
}
