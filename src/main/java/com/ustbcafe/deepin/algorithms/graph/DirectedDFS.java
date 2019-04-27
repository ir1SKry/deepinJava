package com.ustbcafe.deepin.algorithms.graph;

/**
 *
 *  Direct Graph
 *
 **/
public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph digraph,int s){
         marked=new boolean[digraph.Vertex()];
         dfs(digraph,s);
    }

    public DirectedDFS(Digraph digraph,Iterable<Integer> sources){
        marked=new boolean[digraph.Vertex()];
        for(int s:sources){
            if(!marked[s]){dfs(digraph,s);}
        }
    }

    /**
     * deep first search
     *
     **/
    public void dfs(Digraph G,int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){dfs(G,w);}
        }
    }

    public boolean marked(int v){
        return marked[v];
    }


}
