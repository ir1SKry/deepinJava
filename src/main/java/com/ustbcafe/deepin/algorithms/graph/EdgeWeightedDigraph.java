package com.ustbcafe.deepin.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
  private final int V;
  private int E;
  private List<DirectedEdge>[] adj;
  public EdgeWeightedDigraph(int V){
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

  public void addEdge(DirectedEdge e){
    adj[e.from()].add(e);
    E++;
  }
  public Iterable<DirectedEdge> adj(int v){
    return adj[v];
  }

  public Iterable<DirectedEdge> edges(){
    List<DirectedEdge> bag=new ArrayList<>();
    for(int v=0;v<V;v++){
      for(DirectedEdge e:adj[v]){
             bag.add(e);
      }
    }
    return bag;
  }


}
