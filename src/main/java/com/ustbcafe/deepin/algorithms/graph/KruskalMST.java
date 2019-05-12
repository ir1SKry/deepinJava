package com.ustbcafe.deepin.algorithms.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KruskalMST {
  private Queue<Edge> mst;

  public KruskalMST(EdgeWeightedGraph G){
    mst=new LinkedList<>();
    Queue<Edge> pq=new PriorityQueue<>();
    for(Edge e:G.edges()){
      pq.offer(e);
    }
    UF uf=new UF(G.V());
    while(!pq.isEmpty()&&mst.size()<G.V()-1){
      Edge e=pq.poll();
      int v=e.either(),w=e.other(v);
      if(uf.connected(v,w)) continue;
      uf.union(v,w);
      mst.offer(e);
    }
  }

  public Iterable<Edge> edges(){
    return mst;
  }

  public double weight(){
     double weight=0;
     for(Edge e:mst){
        weight+=e.weight();
     }
     return weight;
  }


  public static void main(String[] args){
     Scanner in=new Scanner(System.in);
    int V=in.nextInt();
    int E=in.nextInt();
    in.nextLine();
    EdgeWeightedGraph graph=new EdgeWeightedGraph(V);
    for(int i=0;i<E;i++){
      String line= in.nextLine();
      String[] edge=line.split(" ");
      if(edge.length>=3){
        graph.addEdge(new Edge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]),Double.parseDouble(edge[2])));
      }
    }
    KruskalMST mst=new KruskalMST(graph);
    for(Edge e:mst.edges()){
      System.out.println(e);
    }
    System.out.println(mst.weight());
  }
//   test case
//    8
//    16
//    4 5 0.35
//    4 7 0.37
//    5 7 0.28
//    0 7 0.16
//    1 5 0.32
//    0 4 0.38
//    2 3 0.17
//    1 7 0.19
//    0 2 0.26
//    1 2 0.36
//    1 3 0.29
//    2 7 0.34
//    6 2 0.40
//    3 6 0.52
//    6 0 0.58
//    6 4 0.93
}
