package com.ustbcafe.deepin.algorithms.graph;

import java.util.Scanner;
import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;
    public DirectedCycle(Digraph G){
        onStack=new boolean[G.Vertex()];
        edgeTo=new int[G.Vertex()];
        marked=new boolean[G.Vertex()];
        for(int v=0;v<G.Vertex();v++){
            if(!marked[v]){
              dfs(G,v);
            }
        }
    }
    public void dfs(Digraph G,int v){
        onStack[v]=true;
        marked[v]=true;
        for(int w:G.adj(v)){
            if(hasCycle()){
                return;
            }else if(!marked[w]){
                edgeTo[w]=v;dfs(G,w);
            }else{
                cycle=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
        onStack[v]=false;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public  boolean hasCycle(){
        return cycle!=null;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Digraph digraph=GraphUtil.readDirectedGraph(in);
        //int s=in.nextInt();
        DirectedCycle directedCycle=new DirectedCycle(digraph);
        for(int p:directedCycle.cycle()){
            System.out.print(p);
            System.out.print(" ");
        }
    }
}
// case 1
//13
//22
//4 2
//2 3
//3 2
//6 0
//0 1
//2 0
//11 12
//12 9
//9 10
//9 11
//8 9
//10 12
//11 4
//4 3
//3 5
//7 8
//8 7
//5 4
//0 5
//6 4
//6 9
//7 6
