package com.ustbcafe.deepin.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Direct graph
 *
 **/
public class Digraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;
    public Digraph(int V){
        this.V=V;
        this.adj=new ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    public int Vertex(){
        return V;
    }
    public int Edge(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph digraph=new Digraph(V);
        for(int v=0;v<V;v++){
            for(int w: adj[v]){
                digraph.addEdge(w,v);
            }
        }
        return digraph;
    }

}
