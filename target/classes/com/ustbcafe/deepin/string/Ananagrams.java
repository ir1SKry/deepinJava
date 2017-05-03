package com.ustbcafe.deepin.string;

import java.util.*;

/**
 * Created by Rudy Steiner on 2017/3/24.
 * VUA 165 反片语
 */
public class Ananagrams {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<String> sL=new ArrayList<>();
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        String word;
        char[] chars;
        while(sc.hasNext()){
               word=sc.next();
               if(word.equals("#")) break;
               sL.add(word);
               Arrays.sort(chars=word.toLowerCase().toCharArray());
               word=new String(chars);
               Integer wordCount;
                if((wordCount=map.get(word))==null){
                    map.put(word,1);
                }else{
                    map.put(word,wordCount+1);
                }
        }
        for(String str:sL){
            Arrays.sort(chars=str.toLowerCase().toCharArray());
            word=new String(chars);
             if(map.get(word).intValue()==1){
                 result.add(str);
             }
        }
        Collections.sort(result);
        for(String str:result){
            System.out.println(str);
        }
    }
}
