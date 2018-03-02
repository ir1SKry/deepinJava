package com.ustbcafe.deepin.exception;

/**
 * Created by wangjin18 on 2018/1/17.
 */
public class ExceptionMain {

    public static void main(String[] args){
        int len=10;
        for(int i=0;i<len;i++){
            try {
                throw new IllegalArgumentException("exception " + i);
            }catch (Exception e){
                  if(e instanceof  IllegalArgumentException)
                      continue;
                  else throw  e;
            }
        }
         String str="a;b;";
        String[] strs=str.split(";");
        System.out.println(strs);
    }
}
