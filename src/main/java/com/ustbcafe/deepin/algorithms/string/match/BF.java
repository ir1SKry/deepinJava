package com.ustbcafe.deepin.algorithms.string.match;

/**
 * Created by Rudy Steiner on 2017/7/2.
 */
public class BF {

    /*
    *  @text  一段文本
    *  @pattern  匹配的文本
    *  @return  匹配的第一个字符位置 ，适配返回-1
    *
    * */
    public int match(String text,String patten){
        if(text==null||patten==null||patten.length()>text.length())
            throw new IllegalArgumentException("illegal parameters! ");
        char[] origin=text.toCharArray();
        char[] pattern =patten.toCharArray();
        int i=0;
        int end=origin.length-patten.length()+1;
        while(i<end){
             int pos=findFirstMatchCharLocation(origin,i,pattern[0]);
             if(pos>=0){
                if(compare(origin,pos,pattern)){
                    return  pos;
                }else i++;
             }else break;
        }
        return -1;
    }
    /*
    *  @param origin 原始串
    *  @start 开始查找的第一个位置
    *  @c 查找的字符
    * */
    public int  findFirstMatchCharLocation(char[] origin,int start,char c){
        int len=origin.length;
        int i=start;
        while(i<len){
            if(origin[i]==c){
                return i;
            }else  i++;
        }
        return  -1;
    }
    public boolean compare(char[] origin,int start,char[] pattern){
        int len=pattern.length;
        int i=0;
        while(i<len){
            if(origin[start+i]!=pattern[i])
                return false;
            i++;
        }
        return true;
    }
}
