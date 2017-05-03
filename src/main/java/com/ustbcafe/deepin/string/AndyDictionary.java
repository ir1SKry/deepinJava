package com.ustbcafe.deepin.string;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Rudy Steiner on 2017/3/24.
 * UVA 10815
 */
public class AndyDictionary {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line;
        Set<String> tree=new TreeSet<>();
        while(sc.hasNext()){
             line=sc.nextLine();
             if(line!=null){
                 if(line.equals("EOF")) break;
                String[] temp= line.toLowerCase().split("[^a-z]");
                for(String str:temp){
                    if(str!=null&&!str.equals("")){
                        tree.add(str);
                    }
                }
             }
        }
        for(String str:tree){
            System.out.println(str);
        }
    }
}
