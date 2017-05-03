package com.ustbcafe.deepin.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudy Steiner on 2017/1/8.
 */
public class ListTest {
    public static void main(String[] args){
        List<Character> list=new ArrayList(15);
         list.add('r');
         list.add('u');
         list.add('d');
         list.add('y');

         System.out.println( ((Character)list.get(1)).charValue());
            System.out.println( list.size());
    }

}
