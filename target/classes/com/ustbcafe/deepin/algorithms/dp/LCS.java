package com.ustbcafe.deepin.algorithms.dp;

import com.ustbcafe.deepin.algorithms.utils.AssistKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/4/5.
 */
public class LCS {
    private static final byte GO_LEFT=1;
    private static final byte GO_LEFT_UP=2;
    private static final byte GO_UP=3;
    /*
    *
    * @param  x 第一个字符序列
    * @param  y 第二个字符序列
    * @param solutionTable  辅助解答表
    * @param route 路径     辅助路径记录
    * */
    public static int lcs(char[] x, char[] y, int[][] solutionTable,byte[][] route){
        int rowM=x.length+1;
        int columnN=y.length+1;
        for(int i=1;i<rowM;i++){
            for(int j=1;j<columnN;j++){
                if(x[i-1]==y[j-1]){
                       solutionTable[i][j]=solutionTable[i-1][j-1]+1;
                       route[i][j]=GO_LEFT_UP;
                }else if(solutionTable[i-1][j]>=solutionTable[i][j-1]){
                       solutionTable[i][j]=solutionTable[i-1][j];
                        route[i][j]=GO_UP;
                }else{
                       solutionTable[i][j]=solutionTable[i][j-1];
                       route[i][j]=GO_LEFT;
                }
            }
        }
        return solutionTable[x.length][y.length];
    }
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
         int  xLen=in.nextInt();
         int  yLen=in.nextInt();
         byte[][] route=new byte[xLen+1][yLen+1];
         char[] x=new char[xLen];
         char[] y=new char[yLen];
         int i;
         for(i=0;i<xLen;i++) x[i]=in.next().charAt(0);
         for(i=0;i<yLen;i++) y[i]=in.next().charAt(0);
         int[][] solutionTable=new int[xLen+1][yLen+1];
         int len=lcs(x,y,solutionTable,route);
         System.out.printf("最长公共字串长度：%d,",len);
         //System.out.println();
         printLcs(x,route,xLen,yLen);
    }
    public static void printLcs(char[] X,byte[][] route,int x,int y){
         if(x==0||y==0)
             return;
         if(route[x][y]==GO_LEFT_UP) {
             printLcs(X,route,x-1,y-1);
             System.out.print(X[x - 1]);
         }else if(route[x][y]==GO_LEFT)
             printLcs(X,route,x,y-1);
        else printLcs(X,route,x-1,y);
    }
}
