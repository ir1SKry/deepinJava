package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;

public class DeepFirstSearch {

  private boolean[] marked;
  private int count=0;
  public DeepFirstSearch(Graph G, int s){
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
    int V=in.nextInt();
    int E=in.nextInt();
    in.nextLine();
    Graph graph=new Graph(V);
    for(int i=0;i<E;i++){
     String line= in.nextLine();
     String[] edge=line.split(" ");
     if(edge.length>=2){
       graph.addEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));
     }
    }
    int s=in.nextInt();
    DeepFirstSearch search=new DeepFirstSearch(graph,s);
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
