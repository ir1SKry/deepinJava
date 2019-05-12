package com.ustbcafe.deepin.algorithms.graph;

import java.util.PriorityQueue;
import java.util.Queue;


public class IndexPriorityQueue<T extends Comparable> {

  private Queue<Node> pq;
  private Node[] index;
  public class Node<V extends Comparable> implements Comparable<Node>{
    private int index;
    private V v;
    public Node(int index,V v){
      this.index=index;
      this.v=v;
    }
    @Override
    public int compareTo(Node o) {
      return v.compareTo(o.v);
    }
  }
  public IndexPriorityQueue(int capacity){
    this.pq=new PriorityQueue<>();
    this.index = new Node[8];
//    for(int i=0;i<capacity;i++){
//      this.index[i]=new Node()
//    }
  }
  public int delMin(){
      Node<T> min=this.pq.poll();
      this.index[min.index]=null;
      return min.index;
  }

  public void insert(int index,T t){
     Node node=new Node(index,t);
     this.index[index]=node;
     this.pq.offer(node);
  }

  public void change(int index,T t){
    Node<T> old=this.index[index];
    this.pq.remove(old);
    old.v=t;
    this.pq.offer(old);
  }
  public boolean contains(int w){
    return index[w]!=null;
  }
  public boolean isEmpty(){
   return this.pq.isEmpty();
  }

}
