package com.ustbcafe.deepin.algorithms.ali;

/**
 * Created by Rudy Steiner on 2017/8/12.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int maxScore(int[] score) {
        int[] shootScore=new int[score.length];
        int len=score.length;
        for(int i=0;i<len;i++){
            if(i-1>=0&&i+1<len){
                //if()
            }
                     //shootScore[i]=
        }
        return 0;
    }
    static int shootScore(int i,int[] score){
        int len=score.length;
        if(score[i]==0)
            return 0;
        if(i==0){
            if(i+1<len){
                //return score[i]
            }
        }
        return  0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        res = maxScore(_score);
        System.out.println(String.valueOf(res));

    }
}
