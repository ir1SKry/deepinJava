package com.ustbcafe.deepin.algorithms.graph;

public class Edge  implements Comparable<Edge> {

  private final int v;
  private final int w;
  private final double weight;
  public Edge(int v,int w,double weight){
    this.v=v;
    this.w=w;
    this.weight=weight;
  }
  public double weight(){
    return weight;
  }

  public int either(){
    return v;
  }

  public int other(int v){
    if(v==this.v)return w;
    if(v== this.w) return this.v;
    else throw new RuntimeException("Inconsistent edge");
  }


  @Override
  public int compareTo(Edge o) {
    if(this.weight<o.weight) return -1;
    else if(this.weight>o.weight) return 1;
    return 0;
  }

  public String toString(){
    return String.format("%d-%d %.2f",v,w,weight);
  }
}
