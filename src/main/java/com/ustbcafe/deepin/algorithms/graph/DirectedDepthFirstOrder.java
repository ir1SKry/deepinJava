package com.ustbcafe.deepin.algorithms.graph;

import java.util.*;

public class DirectedDepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DirectedDepthFirstOrder(Digraph G){
        pre=new LinkedList<>();
        post=new LinkedList<>();
        reversePost=new Stack<>();
        marked=new boolean[G.Vertex()];
        for(int v=0;v<G.Vertex();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public void dfs(Digraph G,int v){
        pre.offer(v);
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){dfs(G,w);}
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        List<Integer> reverse=new LinkedList<>();
        while(!reversePost.empty()){
            reverse.add(reversePost.pop());
        }
        return reverse;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Digraph digraph=GraphUtil.readDirectedGraph(in);
        //int s=in.nextInt();
        DirectedDepthFirstOrder directedCycle=new DirectedDepthFirstOrder(digraph);
        for(int p:directedCycle.pre()){
            System.out.print(p);
            System.out.print(" ");
        }
        System.out.println(" ");


        for(int p:directedCycle.post()){
            System.out.print(p);
            System.out.print(" ");
        }
        System.out.println(" ");
        for(int p:directedCycle.reversePost()){
            System.out.print(p);
            System.out.print(" ");
        }

    }


}
