package com.ustbcafe.deepin.algorithms.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/8/22.
 */
public class Pareto {
    static public class Node implements Comparable{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Object o) {
            Node tmp=(Node)o;
            if(x==tmp.x)
               return 0;
            if(x<tmp.x)
                return -1;
            else return 1;
        }
    }
    public  static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        Node[] nodes=new Node[num];
        for(int i=0;i<num;i++){
           nodes[i]=new Node(in.nextInt(),in.nextInt());
           //nodes[i].y=in.nextInt();
        }
        Arrays.sort(nodes);
        List<Node> nodeList=new ArrayList<>();
        for(int i=0;i<nodes.length;i++){
            nodeList.add(nodes[i]);
        }
        boolean delI=false;
        for(int i=0;i<nodeList.size();i++){
            if(delI==true) {
                nodeList.remove(i);
                i--;
            }
            for(int j=i+1;j<nodeList.size();j++){
                //int flag=0;
                int flag=flag=dominate(nodeList.get(i),nodeList.get(j));
                if(flag==1){
                     // delete j
                    nodeList.remove(j);
                    j--;
                }else if(flag==-1){
                    // delete i
                    delI=true;
                }

            }
        }
        if(nodeList.size()>0){
            for(int i=0;i<nodeList.size();i++){
             System.out.println(nodeList.get(i).x+" "+nodeList.get(i).y);
            }
        }
    }

    public static int dominate(Node a,Node b){
        if(a.x>b.x&&a.y>b.y)
            return 1;
        else if (a.x<b.x&&a.y<b.y)
                return  -1;
        else return 0;
    }


}
