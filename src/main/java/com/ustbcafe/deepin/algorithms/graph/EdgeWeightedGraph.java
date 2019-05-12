package com.ustbcafe.deepin.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
  private final int V;
  private int E;
  private List<Edge>[] adj;

  public EdgeWeightedGraph(int V){
    this.V=V;
    this.E=0;
    adj=new List[V];
    for(int v=0;v<V;v++){
      adj[v]=new ArrayList<>();
    }
  }

  public int V(){
    return V;
  }
  public int E(){
    return E;
  }
  public void addEdge(Edge e){
    int v=e.either();
    int w=e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }
  public Iterable<Edge> adj(int v){
    return adj[v];
  }

  public Iterable<Edge>  edges(){
    List<Edge> b=new ArrayList<>();
    for(int v=0;v<V;v++){
      for(Edge e:adj[v]){
        if(e.other(v)>v) b.add(e);
      }
    }
    return b;
  }

}
