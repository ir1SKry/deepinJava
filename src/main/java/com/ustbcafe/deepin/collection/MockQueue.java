package com.ustbcafe.deepin.collection;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Rudy Steiner on 2017/2/24.
 * 剑指offer 第七题
 * 用两个stack 模拟一个队列
 */
public class MockQueue<T>  {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public MockQueue(){
        stack1=new Stack<T>();
        stack2 =new Stack<T>();
    }
    public T removeHead() throws Exception{

        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()) throw new Exception("queue is empty!");
        return stack2.pop();
    }
    public boolean addTail(T element){

        stack1.push(element);
        return true;
    }
    public boolean empty(){
        if(stack2.empty()&&stack1.empty())
            return true;
        return false;
    }

    public void visit(T ele){
        System.out.print(ele+" ");
    }
    public static void main(String[] args) throws  Exception{

     //String
      MockQueue<String> queue= new MockQueue<>();

                        queue.addTail("a");
                        queue.addTail("b");
                        queue.visit(queue.removeHead());
                        queue.addTail("d");
                        queue.addTail("e");
                        queue.addTail("f");
                        queue.addTail(null);
                         while(!queue.empty()){
                             queue.visit(queue.removeHead());
                         }
//                         Scanner scanner=new Scanner(System.in);
//                         scanner.next();
        System.out.println("");
        System.out.println("two stack mock queue:");
        MockQueue<Integer> intQueue= new MockQueue<>();
              intQueue.addTail(2);
              intQueue.addTail(5);
              intQueue.addTail(8);
              intQueue.addTail(null);
              intQueue.addTail(12);
               while(!intQueue.empty()){
                  intQueue.visit(intQueue.removeHead());
              }
    }

}
