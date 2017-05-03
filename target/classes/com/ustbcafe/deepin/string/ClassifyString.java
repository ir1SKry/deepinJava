package com.ustbcafe.deepin.string;

import java.util.*;

/**
 * Created by Rudy Steiner on 2017/3/23.
 *  nowcoder 字符串分类
 *  测试输入：
 *  5
 *  abcdefs
 *  abefscd
 *  fdhdhfhe
 *  fhdhfhde
 *  dfeeieff
 */
public class ClassifyString {

     String[] strs;
    public void readConsole(){
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        scanner.nextLine();  //escape first line
        strs=new String[n];
        String line;
        char[] chars;
        for(int i=0;i<n;i++){
            line=scanner.nextLine();
            Arrays.sort(chars=line.toCharArray());
            strs[i]=new String(chars);
        }
    }
    public int classify(){
        Arrays.sort(strs);
         String temp="";
         int classes=0;
         for(int i=0;i<strs.length;i++){
             if(!strs[i].equals(temp))  {
                 temp=strs[i];
                 classes++;
             }
         }
        System.out.println(Arrays.toString(strs));
        System.out.println("classified into:"+classes+" classes");
        return classes;
    }
    public static void main(String[] args){
        ClassifyString cs=new ClassifyString();
        cs.readConsole();
        cs.classify();
    }

}
