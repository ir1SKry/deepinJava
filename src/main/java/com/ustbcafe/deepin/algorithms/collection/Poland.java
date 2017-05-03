package com.ustbcafe.deepin.algorithms.collection;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by Rudy Steiner on 2017/4/26.
 */
public class Poland {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        Stack<Integer> stack=new Stack();
        int len=expr.length();
        int result;
         char tmp;
          for(int i=0;i<len;i++){
              if(isNumeric(tmp=expr.charAt(i))) {
                  int start=i,end;
                  i++;
                  while(isNumeric(expr.charAt(i))) i++;
                  end=i;
                  if(!isFull(stack))
                      stack.push(Integer.valueOf(expr.substring(start,end)));
                  else return -2;
                  i--;
              }else{
                 result=operator(stack,tmp);
                  if(result==-1||result==-2)
                      return  result;
              }
          }
        return  stack.pop() ;
    }
    public static boolean isFull(Stack<Integer> stack){
        int stackThreshold=16;
       if(stack.size()<stackThreshold)
           return false;
        return true;
    }
    public static int operator(Stack<Integer> stack,char operator){
        Integer a,b;
        switch (operator){
            case '^':
                Integer top=stack.pop();
                if(!isFull(stack))
                    stack.push(top+1);
                break;
            case '+':
                if(stack.size()<2)
                    return -1;
                a=stack.pop();
                b=stack.pop();
                if(!isFull(stack))
                    stack.push(a+b);
                else return -2;
                break;
            case '*':
                if(stack.size()<2)
                    return -1;
                a=stack.pop();
                b=stack.pop();
                if(!isFull(stack))
                    stack.push(a*b);
                else return -2;
                break;
            default:
                break;
        }
        return 1;
    }
    public static boolean isNumeric(char c){
       if(c>='0'&&c<='9')
           return true;
        return false;
    }
}
