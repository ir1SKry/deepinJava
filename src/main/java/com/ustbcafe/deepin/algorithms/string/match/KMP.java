package com.ustbcafe.deepin.algorithms.string.match;

/**
 * Created by Rudy Steiner on 2017/7/2.
 *  夏克俭 数据结构
 *  O(N+M)
 */
public class KMP {

    public int[] next(String pattern){
        int len= pattern.length();
        char[] p=pattern.toCharArray();
        int[] next=new int[len];
        next[0]=-1;
        int i=-1,j=1;
        while(j<len-1){
            if(i==-1||p[i]==p[j]){
                i++;j++;
                next[j]=i;
            }else i=next[i];
        }
        return  next;
    }
    public int match(String source,String pattern){
        if(source==null||pattern==null||pattern.length()>source.length())
            throw new IllegalArgumentException("illegal parameters! ");
        int i=0,j=0;
        int sLen=source.length();
        int pLen=pattern.length();
        char[] sChars=source.toCharArray();
        char[] pChars=pattern.toCharArray();
        int[] next=next(pattern);
        while(i<sLen&&j<pLen){
          if(j==-1||sChars[i]==pChars[j]){
              i++;
              j++;
          }else j=next[j];
        }
        return  j==pLen?i-j:-1;
    }
}
