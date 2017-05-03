package com.ustbcafe.deepin.algorithms.list;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/2/25.
 * 剑指offer 链表
 */
public class MyLinkedList<T> {
    private ListNode<T> head;
    static class ListNode<T>{
        T val;
        ListNode<T> next;
        public ListNode(T val){
            this.val=val;
            next=null;
        }
    }
    public void addToTail(T val){

        ListNode<T> newNode=new ListNode<>(val);
        if(head==null){
            head=newNode;
            return;
        }
        ListNode<T> pNode=head;
        while(pNode.next!=null){
            pNode=pNode.next;
        }
        pNode.next=newNode;
    }
    public void removeNode(T val){
        if(head==null)
            return ;

         if(head.val.equals(val)){
             head=head.next;
         }else{
             ListNode<T> pNode=head;
             while(pNode.next!=null&&!pNode.next.val.equals(val)){
                 pNode=pNode.next;
             }
             if(pNode.next!=null&&pNode.next.val.equals(val)){
                 pNode.next=pNode.next.next;
             }
         }
    }

}
