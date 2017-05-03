package com.ustbcafe.deepin.algorithms.list;

import java.util.Stack;

/**
 * Created by Rudy Steiner on 2017/2/23.
 */
public class LinkedSolution {

     static class Node<T>{
        int value;
        Node next;
         public Node(int value){
              this.value=value;
              next=null;
         }
    }
    public void addToTail(Node pHead,int value){

          Node newNode= new Node(value);
          if(pHead==null) {
              pHead = newNode;
              return ;
          }

          Node curNode=pHead;
          while(curNode.next!=null)  curNode=curNode.next;
          curNode.next=newNode;
          System.out.println("add node:"+value);
          return;

    }
    public void printLinkedList(Node pHead){

        if(pHead==null) {
            System.out.println("链表为空");
            return ;
        }
        StringBuilder strBuilder= new StringBuilder();
        Node curNode=pHead;
        while(curNode!=null){
            strBuilder.append("(").append(curNode.value).append(")");
            if(curNode.next==null) break;
            else {
                curNode=curNode.next;
                strBuilder.append("-->");
            }
        }
        System.out.println(strBuilder.toString());
    }
    public void reversePrintLinkedList(Node pHead){

        StringBuilder strBuilder= new StringBuilder();

        if(pHead==null) {
            System.out.println("链表为空");
            return ;
        }
        Stack<Integer> stack=new Stack<>();

        Node curNode=pHead;
        while(curNode!=null){
           // strBuilder.append("(").append(curNode.value).append(")");
            stack.push(new Integer(curNode.value));
            if(curNode.next==null) break;
            else {
                curNode=curNode.next;
                //strBuilder.append("-->");
            }
        }
       //System.out.println(strBuilder.toString());
            printStack(stack);
    }
    public void printStack(Stack stack){

        if(stack==null||stack.empty())
            return;
        StringBuilder strBuilder= new StringBuilder();
        while(!stack.empty()){
            strBuilder.append("(").append(((Integer) stack.pop()).intValue()).append(")");
            if(!stack.empty()) strBuilder.append("-->");
        }
        System.out.println(strBuilder);
    }
    public static void main(String[] args){
           Node head=null;//new Node(2);
           LinkedSolution sol= new LinkedSolution();

//           sol.addToTail(head,-1);
//           sol.addToTail(head,3);
           System.out.println("打印链表：");
           sol.printLinkedList(head);
           System.out.println("逆序打印链表：");
           sol.reversePrintLinkedList(head);
    }
}
