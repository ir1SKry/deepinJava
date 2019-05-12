package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;

public class UF {
  private int[] id;
  private int count;
  public UF(int N){
    count =N;
    id=new int[N];
    for(int i=0;i<N;i++){
      id[i]=i;
    }

  }

  public int count(){
    return count;
  }

  public boolean connected(int p,int q){
    return  find(p)==find(q);
  }

  public int find(int p){
    return id[p];
  }

  public void union(int p,int q){
    int pid=find(p);
    int qid=find(q);
    if(qid==pid) return;
    for(int i=0;i<id.length;i++){
      if(id[i]==pid) id[i]=qid;
    }
    count--;
  }

  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    int N=scanner.nextInt();
    UF uf=new UF(N);
    while(scanner.hasNext()){
      int p=scanner.nextInt();
      if(p<0) break;
      int q=scanner.nextInt();
      if(uf.connected(p,q))continue;
      uf.union(p,q);
      System.out.println(p+" "+q);
    }

    System.out.println(uf.count()+" Components");
  }
}
