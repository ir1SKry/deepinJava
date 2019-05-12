package com.ustbcafe.deepin.algorithms.graph;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
  private boolean[] marked;
  private Queue<Edge> mst;
  private Queue<Edge> pq;

  public LazyPrimMST(EdgeWeightedGraph G){
    pq=new PriorityQueue<>();
    marked=new boolean[G.V()];
    mst=new LinkedList<>();
    visit(G,0);
    while(!pq.isEmpty()){
      Edge e=pq.poll();
      int v=e.either(),w=e.other(v);
      if(marked[v]&&marked[w]) continue;
      mst.offer(e);
      if(!marked[v]) visit(G,v);
      if(!marked[w]) visit(G,w);
    }
  }

  public void visit(EdgeWeightedGraph G,int v){
    marked[v]=true;
    for(Edge e:G.adj(v)){
      if(!marked[e.other(v)]) pq.offer(e);
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


}
