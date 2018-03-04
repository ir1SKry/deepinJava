package com.ustbcafe.deepin.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/9/18.
 */
public class Main1 {

    public static void main(String[] args) {
        int count = 0;
        Scanner in= new Scanner(System.in);
        String vLine=in.nextLine();
        String[] vStr=vLine.split(" ");
        int len= vStr.length;
        int[] v=new int[len];
        int[] w=new int[len];
        for(int i=0;i<len;i++){
            v[i]=Integer.parseInt(vStr[i]);
        }
        String wLine=in.nextLine();
        String[] wStr=wLine.split(" ");
        for(int i=0;i<len;i++){
            w[i]=Integer.parseInt(wStr[i]);
        }
        System.out.println(count);
    }
}
