package com.ustbcafe.deepin.algorithms.string;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/9/18.
 */
public class Main {

    public static void main(String[] args) {
        int count = 0;
        Scanner in= new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            if (str.contains("u51")) {
                count++;
            }
        }
        System.out.println(count);
    }


}
