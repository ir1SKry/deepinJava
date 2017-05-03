package com.ustbcafe.deepin.algorithms.string;

/**
 * Created by Rudy Steiner on 2017/2/23.
 * 剑指offer 第四题
 */
public class Solution {

    public char[] replaceBlank(char[] chars){

        if(chars==null||chars.length==0)
            return chars;
        int len=chars.length;

        int blankCount=0;
        int p1=len-1;
        int p2=0;
        int index=0;
         while(index<len){
             if(chars[index++]==' ')
                 blankCount++;
         }
         p2=p1+blankCount*2;
          //%20
         char[] newChars=new char[len+blankCount*2];
         while(p1>=0){
              if(chars[p1]!=' ') newChars[p2--]=chars[p1--];
               else {
                   newChars[p2--]='0';
                   newChars[p2--]='2';
                   newChars[p2--]='%';
                   p1--;
              }
         }
         return  newChars;
    }
    public static boolean checkDifferent(String iniString) {
        // write code here
        if(iniString.length()>256) return false;
        boolean[] char_set=new boolean[256];
        int len=iniString.length();
        for(int i=0;i<len;i++){
            int val=iniString.charAt(i);
            if(char_set[val])
                return false;
            char_set[val]=true;
        }
        return true;
    }

    public static void main(String[] args){
        String t="acbdbesy";
        boolean result=checkDifferent(t);
        System.out.println(":"+result);
        String str1=new String("abc jj kk");
        System.out.println("原字符串："+str1);
       char[] newChars=new Solution().replaceBlank(str1.toCharArray());
        System.out.print("替换后字符串：");
        System.out.println(new String(newChars));
    }
}
