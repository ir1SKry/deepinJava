package com.ustbcafe.deepin.algorithms.string.match;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangjin18 on 2017/8/28.
 */
public class BracketMatch {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String  content=in.nextLine();
        boolean valid=match(content.toCharArray());
        System.out.println(content+";"+valid);
    }
    public static  boolean match(char [] content){
        Stack<Character>  bracketStack=new Stack<>();
        for(int i=0;i<content.length;i++){
           char cur= content[i];
           char top;
            switch (cur){
                case '{':
                case '[':
                case '(':
                    bracketStack.push(cur);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!bracketStack.isEmpty()) {
                        top = bracketStack.pop();
                        if (top == '{' && cur == '}' || top == '[' && cur == ']' || top == '(' && cur == ')')
                            break;
                        else return false;
                    }
                    return false;
                default:;
            }
        }
        return true;
    }

}
