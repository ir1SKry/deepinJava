package com.ustbcafe.deepin.algorithms.dp;

/**
 * Created by Rudy Steiner on 2017/9/9.
 */
import java.util.Scanner;
public class Arrays4 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int count = scan.nextInt();
            for (int  j= 0; j< count; j++) {
                    int t = scan.nextInt();
                    int[] a = new int[t];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = scan.nextInt();
                    }
                    int c1 = 0;
                    int c2 = 0;
                    int c3 = 0;
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] % 4 == 0) c1++;
                        else if (a[i] % 2 == 0) {
                            c2++;
                        } else c3++;
                    }
                    if (c2 == 0 && c1 >= c3 - 1) System.out.println("Yes");
                    else if (c2 != 0 && c1 > c3 - 1) System.out.println("Yes");
                    else System.out.println("No");
                }
        }
}
