package com.ustbcafe.deepin.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KosarajuSCC {

    private boolean marked[];
    private int[] id;
    private int count;
    public KosarajuSCC(Digraph G){
        marked=new boolean[G.Vertex()];
        id=new int[G.Vertex()];
        DirectedDepthFirstOrder order=new DirectedDepthFirstOrder(G.reverse());
        for(int s:order.reversePost()){
          if(!marked[s]){
              dfs(G,s);count++;
          }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v]=true;
        id[v]=count;
        for(int w:G.adj(v)){
            if(!marked[w]){dfs(G,w);}
        }
    }

    public boolean stronglyConnectd(int v,int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Digraph digraph=GraphUtil.readDirectedGraph(in);
        //int s=in.nextInt();
        KosarajuSCC kosarajuSCC=new KosarajuSCC(digraph);
        System.out.println(kosarajuSCC.count() +" components ");
        List<Integer>[] connected=new List[kosarajuSCC.count()];
        for(int v=0;v<digraph.Vertex();v++){
            if(connected[kosarajuSCC.id(v)]==null){
                connected[kosarajuSCC.id(v)]=new ArrayList<>();
            }
            connected[kosarajuSCC.id(v)].add(v);
        }
        for(List<Integer> c:connected){
            for(int v:c){
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

    }
}
