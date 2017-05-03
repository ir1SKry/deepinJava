package com.ustbcafe.deepin.collection;

import com.ustbcafe.deepin.collection.LinkedStack;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/5/3.
 */
public class StackTest {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        LinkedStack<Integer> stack=new LinkedStack<>();
        for(int i=0;i<n;i++){
            stack.push(in.nextInt());
        }
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
