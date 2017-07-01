package com.ustbcafe.deepin.algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/5/19.
 */
public class Max {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int total=n*3;
        int[] power=new int[total];
        for(int i=0;i<total;i++){
            power[i]=in.nextInt();
        }
        int result=0;
        Arrays.sort(power);
        for(int i=total-2;i>=n;){
            result+=power[i];
            i-=2;
        }
        System.out.println(result);
    }
}
