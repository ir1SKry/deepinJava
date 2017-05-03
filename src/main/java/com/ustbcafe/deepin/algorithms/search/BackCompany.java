package com.ustbcafe.deepin.algorithms.search;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/3/25.
 * 网易 2017春招实习 Java第一题
 */
public class BackCompany {
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args){
        int result=0,walkTime,taxTime;
        Scanner in=new Scanner(System.in);
        int taxiPorts=in.nextInt();
        in.nextLine();
        Point[] ps=new  Point[taxiPorts];
        Point  aim;
        String line;
        line=in.nextLine();
        String[] x=line.split(" ");
        line=in.nextLine();
        String[]  y=line.split(" ");
        for(int i=0;i<taxiPorts;i++){
             ps[i]=new Point(Integer.parseInt(x[i]),Integer.parseInt(y[i]));
        }
        line=in.nextLine();
        x=line.split(" ");
        aim= new Point(Integer.parseInt((x[0])),Integer.parseInt((x[1])));
        line=in.nextLine();
        x=line.split(" ");
        walkTime=Integer.parseInt((x[0]));
        taxTime=Integer.parseInt((x[1]));
        System.out.println(result);
    }
}
