package com.ustbcafe.deepin.collection;

import java.util.EmptyStackException;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class LinkedStack<T> implements IStack<T>{
    ListNode<T> top;
    public  LinkedStack(){
        top=null;
    }
    @Override
    public T pop() {
     T result=null;
        if(!empty()){
            result=top.val;
            top=top.next;
        }else throw new EmptyStackException();
        return result;
    }


    @Override
    public void push(T e) {
          if(top==null){
              top=new ListNode<>(e);
          }else{
              ListNode<T> newNode=new ListNode<T>(e);
              newNode.next=top;
              top=newNode;
          }
    }

    @Override
    public boolean empty() {
        if(top==null)
            return true;
        return false;
    }
}
