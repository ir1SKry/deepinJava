package com.ustbcafe.deepin.algorithms.list;
import  junit.framework.Test;
import junit.framework.TestCase;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/2/25.
 */
public class MyLinkedListTest extends TestCase {


    public  void  testTntElementInMyLinedList(){

        MyLinkedList<Integer>  linkedList=new MyLinkedList<>();
        linkedList.addToTail(3);
        linkedList.addToTail(5);
        linkedList.removeNode(3);
        linkedList.addToTail(6);
        linkedList.addToTail(7);
        linkedList.removeNode(6);
        linkedList.removeNode(8);
        linkedList.removeNode(7);
        //new Scanner(System.in).nextLine();
    }

}
