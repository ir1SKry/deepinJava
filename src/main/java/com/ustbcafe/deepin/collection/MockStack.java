package com.ustbcafe.deepin.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;

/**
 * Created by Rudy Steiner on 2017/2/24.
 */
public class MockStack<T>  {
    private Queue<T> queue1;
    private Queue<T> queue2;
    public MockStack(){
        queue1=new LinkedList<T>();
        queue2=new LinkedList<T>();
    }
    /*
     * 出栈过程中，不能进站
     *
     * */
    public T push(T element){
        //为空默认进入队列1
        if(empty())  {
            queue1.offer(element);
        }else if(queue1.peek()!=null){
            queue1.offer(element);
        }else if(queue2.peek()!=null){
            queue2.offer(element);
        }
        return element;
    }
    public boolean empty(){
        if(queue1.peek()==null&&queue2.peek()==null)
           return true;
        else return false;
    }
    public T pop() {

        if(empty()) throw  new RuntimeException("empty stack");
        Queue<T> empty;
        Queue<T>  nonEmpty;
        if(queue1.peek()!=null){
            empty=queue2;
            nonEmpty=queue1;
        }else{
            empty=queue1;
            nonEmpty=queue2;
        }
        T result=null;
        while(nonEmpty.peek()!=null){
            result=nonEmpty.poll();
            if(nonEmpty.peek()!=null) empty.offer(result);
        }
        return result;
    }
    public void visit(T ele){
        System.out.print(ele+ " ");
    }

    public static void main(String[] args){
        MockStack<String> stack=new MockStack<>();
                          stack.push("a");
                          stack.push("b");
                          stack.visit(stack.pop());
                          stack.push("c");
                           stack.push("e");
                         while(!stack.empty()) {
                             stack.visit(stack.pop());
                         }

    }
}
