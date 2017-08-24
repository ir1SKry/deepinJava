package com.ustbcafe.deepin.algorithms.search;

import java.util.Scanner;

/**
 * Created by wangjin18 on 2017/8/22.
 * http://ac.jobdu.com/problem.php?pid=1447
 * 单源最短路径算法
 * http://blog.csdn.net/acm_jl/article/details/51002489
 */
public class Dijkstra {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(true) {
            int N = in.nextInt(); //路口数
            int M = in.nextInt(); // 路的条数
            if(N==0&&M==0)
                break;
            int[][] costMatrix=new int[N+1][N+1];
            for(int i=0;i<M;i++){
                   int row=in.nextInt();
                   int column=in.nextInt();
                   int cost=in.nextInt();
                   costMatrix[row][column]=cost;
                   costMatrix[column][row]=cost;

            }
        }
    }
    /*
     * @param N 路口数
     * @param M 路的数量
     * @param a  起点路口
     * @param b 终点路口
     *
     * */
    public static int time(int N,int M,int a,int b){


        return 0;
    }
}
