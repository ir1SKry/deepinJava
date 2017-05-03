package com.ustbcafe.deepin.algorithms.sort;

import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/3/24.
 */
public class Marble {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int marbles,ques;
        int[] marble;
        int marbleVal;
        int caseCount=0;
        while( (marbles=in.nextInt())!=0&&(ques=in.nextInt())!=0){
            caseCount++;
            marble=new int[marbles];
            int i=0;
            while(marbles>0) {
                marble[i++] = in.nextInt();
                marbles--;
            }
            Arrays.sort(marble);
            System.out.println("CASE# "+caseCount+":");
            while(ques>0) {
                marbleVal=in.nextInt();
                findMarble(marble,marbleVal);
                ques--;
            }
        }
    }
    private static void findMarble(int[] marbles,int marbleVal){
        int len=marbles.length;
        int i;
        for(i=0;i<len;i++){
            if(marbles[i]==marbleVal){
                System.out.println(marbleVal+" found at "+(i+1));
                break;
            }
        }
        if(i==len){
            System.out.println(marbleVal +" not found");
        }
    }
}
