package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;
import java.util.Stack;

public class DijkstraSP {
  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private IndexPriorityQueue<Double> pq;

  public DijkstraSP(EdgeWeightedDigraph G,int s){
    this.pq=new IndexPriorityQueue<>(G.V());
    this.edgeTo=new DirectedEdge[G.V()];
    this.distTo=new double[G.V()];
    for (int v=0;v<G.V();v++){
      distTo[v]=Double.MAX_VALUE;
    }
    distTo[0]=0.0;
    pq.insert(s,0.0);

    while(!pq.isEmpty()){
      relax(G,pq.delMin());
    }
  }

  public void relax(EdgeWeightedDigraph G,int v){
      for(DirectedEdge e:G.adj(v)){
        int w=e.to();
        if(distTo[w]>distTo[v]+e.weight()){
          distTo[w]=distTo[v]+e.weight();
          edgeTo[w]=e;
          if(pq.contains(w)) pq.change(w,distTo[w]);
          else pq.insert(w,distTo[w]);
        }
      }
  }

  public double distTo(int v){
     return distTo[v];
  }
  public boolean hasPathTo(int v){
    return distTo[v]<Double.MAX_VALUE;
  }
  public Iterable<DirectedEdge> pathTo(int v){
    if(!hasPathTo(v))return null;
    Stack<DirectedEdge> path=new Stack();
    for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
      path.push(e);
    }
    return path;
  }

  public static void main(String[] args){

    Scanner in=new Scanner(System.in);
    int V=in.nextInt();
    int E=in.nextInt();
    in.nextLine();
    EdgeWeightedDigraph graph=new EdgeWeightedDigraph(V);
    for(int i=0;i<E;i++){
      String line= in.nextLine();
      String[] edge=line.split(" ");
      if(edge.length>=3){
        graph.addEdge(new DirectedEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]),Double.parseDouble(edge[2])));
      }
    }
    int s=in.nextInt();
    DijkstraSP sp=new DijkstraSP(graph,s);
    for(int t=0;t<graph.V();t++){
       System.out.print(s+" to "+t);
       System.out.print(String.format("(%4.2f)",sp.distTo(t)));
       if(sp.hasPathTo(t)){
         for(DirectedEdge e:sp.pathTo(t)){
           System.out.print(e+ " ");
         }
         System.out.println();
       }
    }
  }
//    tinyEWG.txt
//    8
//    15
//    4 5 0.35
//    5 4 0.35
//    4 7 0.37
//    5 7 0.28
//    7 5 0.28
//    5 1 0.32
//    0 4 0.38
//    0 2 0.26
//    7 3 0.39
//    1 3 0.29
//    2 7 0.34
//    6 2 0.40
//    3 6 0.52
//    6 0 0.58
//    6 4 0.93
}
