package com.ustbcafe.deepin.collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class QueueTest extends TestCase {

    public static void main(String[] args) throws IOException {
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
