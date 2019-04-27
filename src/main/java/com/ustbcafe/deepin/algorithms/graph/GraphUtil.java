package com.ustbcafe.deepin.algorithms.graph;


import java.util.Scanner;

public class GraphUtil {

  public static Graph read(Scanner in){
    int V=in.nextInt();
    int E=in.nextInt();
    in.nextLine();
    Graph graph=new Graph(V);
    for(int i=0;i<E;i++){
      String line= in.nextLine();
      String[] edge=line.split(" ");
      if(edge.length>=2){
        graph.addEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));
      }
    }
    //in.close();
    return graph;
  }

  public static Digraph readDirectedGraph(Scanner in){
    int V=in.nextInt();
    int E=in.nextInt();
    in.nextLine();
     Digraph graph=new Digraph(V);
    for(int i=0;i<E;i++){
      String line= in.nextLine();
      String[] edge=line.split(" ");
      if(edge.length>=2){
        graph.addEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));
      }
    }
    //in.close();
    return graph;
  }




}
