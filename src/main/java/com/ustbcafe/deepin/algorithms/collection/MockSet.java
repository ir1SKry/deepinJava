package com.ustbcafe.deepin.algorithms.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/4/7.
 */
public class MockSet {

    public static void  addSet(int[] a,int[] b){
        int aLen=a.length;
        int bLen=b.length;
        HashSet<Integer> hashSet=new HashSet<Integer>();
        int i;
        for(i=0;i<aLen;i++) hashSet.add(a[i]);
        for( i=0;i<bLen;i++) hashSet.add(b[i]);
        Integer[] result=new Integer[hashSet.size()];
        hashSet.toArray(result);
        Arrays.sort(result);
        int rLen=result.length;
        for(i=0;i<rLen;i++) System.out.print(result[i].intValue()+" ");
        System.out.println();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i,aLen,bLen;
        int[] a,b;
        while(in.hasNext()) {
             aLen = in.nextInt();
             bLen = in.nextInt();
             a = new int[aLen];
             b = new int[bLen];
            for (i = 0; i < aLen; i++) a[i] = in.nextInt();
            for (i = 0; i < bLen; i++) b[i] = in.nextInt();
            addSet(a,b);
        }
    }
}
