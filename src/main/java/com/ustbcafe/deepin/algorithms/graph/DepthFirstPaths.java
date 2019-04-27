package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;
import java.util.Stack;

/**
 *  path to vertex
 *
 **/
public class DepthFirstPaths implements Paths {

  private boolean[] marked;
  private int[] edgeTo;
  private final int s;
  public DepthFirstPaths(Graph g,int s){
    this.s=s;
    this.edgeTo=new int[g.Vertex()];
    this.marked=new boolean[g.Vertex()];
    dfs(g,s);
  }

  /**
   *
   **/
  private void dfs(Graph g,int v){
    marked[v]=true;
    for(int w:g.adj(v)){
      if(!marked[w]){
        edgeTo[w]=v;
        dfs(g,w);
      }
    }
  }

  @Override
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    if(!hasPathTo(v)) return null;
    Stack<Integer> path=new Stack();
    for(int x=v;x!=s;x=edgeTo[x]){
      path.push(x);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args){

    Scanner in=new Scanner(System.in);
    Graph graph=GraphUtil.read(in);
    int s=in.nextInt();
    Paths paths=new BreadFirstPaths(graph,s);
    for(int v=0;v<graph.Vertex();v++){
      System.out.print(s +" to "+v+":" );
      Iterable<Integer> path=paths.pathTo(v);
      if(path!=null) {
        for (int x :path) {
          if (x == s) System.out.print(x);
          else System.out.print(x+"-");
        }
      }else{
        System.out.print("nul");
      }
      System.out.println();
    }
  }
}
