package com.ustbcafe.deepin.algorithms.graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadFirstPaths implements Paths{
   private boolean[] marked;
   private int[] edgeTo;
   private final int s;

   public BreadFirstPaths(Graph graph,int s){
     this.s=s;
     this.marked=new boolean[graph.Vertex()];
     this.edgeTo=new int[graph.Vertex()];
     bfs(graph,s);
   }

   private void bfs(Graph graph,int s){
     Queue<Integer> queue=new LinkedList<>();
     marked[s]=true;
     queue.offer(s);
     while(!queue.isEmpty()){
        int v=queue.poll();
        for(int w:graph.adj(v)){
          if(!marked[w]){
            edgeTo[w]=v;
            marked[w]=true;
            queue.offer(w);
          }
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
}
