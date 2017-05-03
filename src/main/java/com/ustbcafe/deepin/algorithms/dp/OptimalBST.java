package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/5/1.
 */
public class OptimalBST {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        double[] p=new double[n];
        double[] q=new double[n+1];
        for(int i=0;i<n;i++) p[i]=in.nextDouble();
        for(int i=0;i<=n;i++) q[i]=in.nextDouble();
        double result=optimal(p,q);
        System.out.println("optimal result:"+result);
    }
    private static double optimal(double[] p,double[] q){
        int n=p.length;
        double e[][]=new double[n+1][n+1];
        double w[][]=new double[n+1][n+1];
        int[][] root=new int[n][n];
        for(int i=0;i<=n;i++){
            e[i][i]=q[i];
            w[i][i]=q[i];
        }
        int j;
        double t;
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                j=i+l;
                e[i][j]=Double.MAX_VALUE;
                w[i][j]=w[i][j-1]+p[j-1]+q[j];
                for(int r=i;r<=j;r++){
                  t=e[i][r] +e[r+1][j+1]+w[i][j];
                    if(t<e[i][j]){
                        e[i][j]=t;
                        root[i][j-1]=r;
                    }
                }
            }
        }
        return e[0][n-1];
    }
}
