package com.ustbcafe.deepin.string;

import java.util.*;

/**
 *  Created by Rudy Steiner on 2017/3/31.
 *  效率不够高
 *
 */
public class PermutationString {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        String  input=in.nextLine();
        char[] chars=input.toCharArray();
         List<String> list=new ArrayList<>();
        list.add(String.valueOf(chars[0]));
        int len=chars.length;
        for(int i=1;i<len;i++){
             insert(list,chars[i]);
        }
        System.out.println("全排列："+list.size());
        for(String sb:list){
           System.out.println(sb.toString());
        }
        //Collections.sort();
    }
    public void permutation(List<String> list,char[] cs, int start,char[] result){
        int len=cs.length;
        if(start==cs.length){
            list.add(new String(result));
            return ;
        }
        for(int i=start;i<len;i++){
                 result[i]=cs[i];
                 permutation(list,cs,start+1,result);
        }
    }

    public static void insert(List<String> sBL,char c){
        int len=sBL.size();
        String sb;
        while(len>0){
               sb=sBL.remove(0);
               int cLen=sb.length();
               for(int j=0;j<=cLen;j++){
                   //sbNew=new String(sb);
                   sBL.add(insertChar(sb,c,j));
               }
               sb=null;
               len--;
        }
    }
    public static String insertChar(String string,char c,int pos){
        String subString1=string.substring(0,pos);
        String subString2=string.substring(pos);
        String result=new StringBuilder(subString1).append(c).append(subString2).toString();
        return result;
    }
   // public static int
}
