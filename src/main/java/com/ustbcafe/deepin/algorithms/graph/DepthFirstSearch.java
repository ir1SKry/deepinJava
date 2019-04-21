package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;

public class DepthFirstSearch {

  private boolean[] marked;
  private int count=0;
  public DepthFirstSearch(Graph G, int s){
       this.marked=new boolean[G.Vertex()];
       dfs(G,s);
  }

  private void dfs(Graph G, int v){
    marked[v]=true;
    count++;
    for(int w:G.adj(v)){
      if(!marked[w])dfs(G,w);
    }
  }

  /**
   * 起点与给定点是否连通
   **/
  public  boolean marked(int v){
    return marked[v];
  }
  /**
   * 与s 连通的顶点数
   **/
  int count(){
     return count;
  }


  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Graph graph=GraphUtil.read(in);
    int s=in.nextInt();
    DepthFirstSearch search=new DepthFirstSearch(graph,s);
    for(int v=0;v<graph.Vertex();v++){
        if(search.marked(v)){
          System.out.print(v+" ");
        }
    }

    if(search.count()!=graph.Vertex()){
      System.out.println("not connected");
    }else{
      System.out.println(" connected");
    }
  }
}

//  test case
// 13 V
//  13 E
//  0 5
//  4 3
//  0 1
//  9 12
//  6 4
//  5 4
//  0 2
//  11 12
//  9 10
//  0 6
//  7 8
//  9 11
//  5 3
