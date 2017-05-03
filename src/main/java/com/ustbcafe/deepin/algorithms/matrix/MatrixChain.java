package com.ustbcafe.deepin.algorithms.matrix;

import com.ustbcafe.deepin.algorithms.utils.AssistKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/4/2.
 */
public class MatrixChain {
    public static void optimizedMatrixChain(int[] p,Map<AssistKey,Integer> s){
                int n=p.length-1;
                Map<AssistKey,Integer> m= new HashMap<>();
                for(int i=1;i<=n;i++){
                    m.put(new AssistKey(i,i),0);
                }
                //len is the chain length
                for(int len=2;len<=n;len++){
                    int iHigh=n-len+1;
                    int j,mVal,q;
                    for(int i=1;i<=iHigh;i++){
                          j=i+len-1;
                          mVal=Integer.MAX_VALUE;
                          for(int k=i;k<=j-1;k++){
                              q=m.get(new AssistKey(i,k))+m.get(new AssistKey(k+1,j))+p[i-1]*p[k]*p[j];
                              if(q<mVal){
                                  mVal=q;
                                  s.put(new AssistKey(i,j),k);
                              }
                          }
                          m.put(new AssistKey(i,j),mVal);
                    }
                }
    }
    public static void printParens(Map<AssistKey,Integer> s,int i,int j){
            if(i==j)
                System.out.print("A"+i);
             else {
                System.out.print("(");
                int k=s.get(new AssistKey(i,j)).intValue();
                printParens(s,i,k);
                printParens(s,k+1,j);
                System.out.print(")");
            }
    }

    public static void main(String[] args){
          Scanner in=new Scanner(System.in);
          //n 个矩阵
          int n=in.nextInt();
          Map<AssistKey,Integer> s=new HashMap<>();
          int[] p=new int[++n];
          for(int i=0;i<n;i++){
               p[i]=in.nextInt();
          }
          optimizedMatrixChain(p,s);
          printParens(s,1,n-1);
    }
}
