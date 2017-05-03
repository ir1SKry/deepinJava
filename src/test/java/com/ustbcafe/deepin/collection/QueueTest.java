package com.ustbcafe.deepin.collection;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class QueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedQueue<Integer> queue=new LinkedQueue<>();
        for(int i=0;i<n;i++){
            queue.enqueue(in.nextInt());
        }
        while(queue.peek()!=null){
            System.out.print(queue.dequeue()+" ");
        }
    }
}
