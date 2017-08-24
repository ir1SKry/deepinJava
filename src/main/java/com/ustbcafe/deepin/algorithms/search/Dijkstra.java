package com.ustbcafe.deepin.algorithms.search;

import java.util.Scanner;

/**
 * Created by wangjin18 on 2017/8/22.
 * http://ac.jobdu.com/problem.php?pid=1447
 *
 * http://blog.csdn.net/acm_jl/article/details/51002489
 */
public class Dijkstra {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(true) {
            int start=1;
            int N = in.nextInt(); //
            int M = in.nextInt(); //

            if(N==0&&M==0)
                break;

            int[][] costMatrix=new int[N+1][N+1];
            // init
            for(int i=1;i<=N;i++){
                for(int j=1;j<N;j++){
                    if(i!=j) costMatrix[i][j]=Integer.MAX_VALUE;
                    else costMatrix[i][j]=0;
                }
            }
            for(int i=0;i<M;i++){
                   int row=in.nextInt();
                   int column=in.nextInt();
                   int cost=in.nextInt();
                   costMatrix[row][column]=cost;
                   costMatrix[column][row]=cost;
            }
            int[] shortest=new int[N+1];
            boolean[] visited=new boolean[N+1];
            for(int i=1;i<=N;i++){
                shortest[i]=costMatrix[start][i];
            }
            int cost=time(N,costMatrix,shortest,visited,start);
             System.out.println("form start: "+start+" to "+N+" spend "+cost);
        }
    }
    /*
     * @param N
     * @param M
     * @param a
     * @param b
     *
     * */
    public static int time(int N,int[][] costMatrix,int[] shortest, boolean[] visited,int start){
         visited[start]=true;
        for(int i=2;i<=N;i++){
            int min=Integer.MAX_VALUE;
            int minInd=0;
            for(int j=1;j<=N;j++) {
                if (!visited[i] &&costMatrix[start][i]<min){
                     min=costMatrix[start][i];
                     minInd=i;
                }
            }
            visited[minInd]=true;
            for(int k=1;k<=N;k++){
                if(!visited[k]&&shortest[k]>=shortest[minInd]+costMatrix[minInd][k]){
                        // 过 minInd 点， 更短
                        shortest[k]=shortest[minInd]+costMatrix[minInd][k];
                }
            }
         }
        return shortest[N];
    }
}
