package com.ustbcafe.deepin.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/8/21.
 *
 * UVA
 */
public class KnightMove {
    public static class Node{
        public Node(){}
        public Node(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
        int x;
        int y;
        int count;
    }
    static int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    static int[][] map=new int[8][8];
    public  static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
             String line=in.nextLine();
             Node s=new Node();
             Node e=new Node();
             parseInput(line,s,e);
             initMap(map);
             int steps=moveTo(s,e);
             if(steps!=Integer.MAX_VALUE){
                 String[] points=line.split(" ");
                 System.out.println("To get from "+points[0]+" to "+points[1]+" takes "+steps+" knight moves.");
             }
        }

    }
    public static int moveTo(Node s,Node e){
        s.count=0;
        map[s.x][s.y]=1; // mark pass
        Queue<Node> q=new LinkedList<>();
        q.add(s) ;
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.x==e.x&&node.y==e.y){
                return node.count;
            }
            for(int i=0;i<8;i++){
               int nextX=   node.x+dir[i][0];
               int nextY= node.y+dir[i][1];
               if(in(nextX,nextY)&&map[nextX][nextY]==0){
                   map[nextX][nextY]=1; //mark pass
                   q.offer(new Node(nextX,nextY,node.count+1));
               }
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void initMap(int[][] map){
        for(int i=map.length-1;i>=0;i--){
            for(int j=map[0].length-1;j>=0;j--){
                map[i][j]=0;
            }
        }
    }
    public static boolean in(int x,int y){
        if(x>=0&&x<8&&y>=0&&y<8)
            return true;
        else return  false;
    }
    public static void parseInput(String line,Node s,Node e){
        String[] input=line.split(" ");
              int x1=input[0].charAt(0)-'a';
              int y1=input[0].charAt(1)-'1';
              s.x=x1;
              s.y=y1;
        int x2=input[1].charAt(0)-'a';
        int y2=input[1].charAt(1)-'1';
        e.x=x2;
        e.y=y2;
    }
}
