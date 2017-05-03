package com.ustbcafe.deepin.algorithms.search;

import sun.rmi.server.InactiveGroupException;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/4/7.
 */
public class Thief {

    public static void findThief(String content,HashSet<Integer> thiefSet){
        int n=content.length();
        char cur;
        int power;
        int curInd;
//        HashSet<Integer> thiefSet=new HashSet<>();
        for(int i=0;i<n;i++){
            if((cur=content.charAt(i))!='X'&&cur!='#'){
                  power=Integer.valueOf(cur-'0');
                  curInd=i;
                  findNearThief(content,power,n,curInd,thiefSet);
            }
        }
    }
    public static void findNearThief(String content,int power,int n,int position,HashSet<Integer> set){
                for(int i=1;i<=power;i++){
                       if(position-i>=0&&content.charAt(position-i)=='X'){
                             set.add(Integer.valueOf(position-i));
                       }
                    if(position+i<n&&content.charAt(position+i)=='X'){
                        set.add(Integer.valueOf(position+i));
                    }
                }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String content=in.nextLine();
        HashSet<Integer> thiefSet=new HashSet<>();
        findThief(content,thiefSet);
        System.out.println(thiefSet.size());
    }
}
