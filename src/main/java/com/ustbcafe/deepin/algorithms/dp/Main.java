package com.ustbcafe.deepin.algorithms.dp;

import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/8/12.
 */
public class Main {
    public static void main2(String[] args){
        Scanner in=new Scanner(System.in);
        //  房租单价
        int x=in.nextInt();
        //  fruit amount
        int f=in.nextInt();
        //   own money
        int d=in.nextInt();
        //  fruit price
        int p=in.nextInt();
//        long totalMoney= d+f*p;
//        long day=totalMoney/(x+p);
        System.out.println(f1(x,f,d,p));
    }

    public static int f(int x,int f,int d,int p){
        int day=0;
        while(true){
            if(f>=1){
                f--;
            }else{
                if(f==0){
                    if(d>=p){
                        d-=p;
                    }else {
                        break;
                    }
                }
            }
            if(d>=x){
                d-=x;
            }else{
                break;
            }
            day++;
        }
             return day;
    }

    public static int  f1(int x,int f,int d,int p){
        int day=0;
        if(f*x<=d){
            day=day+f;
            int leftMoney=d-f*x;
            int leftDay=leftMoney/(p+x);
            day+=leftDay;
        } else{
            day=d/x;
        }
        return day;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //  length
        int n=in.nextInt();
        //  range
        int k=in.nextInt();
        //   own money
        System.out.println(f(n,k,0));
    }

    public static int f(int n,int k ,int last){
        int result=0;
        if(n==1)
            return count(last)+k-last+1;  // 只有一个时才确定
        for(int i=1;i<=k;  i++) {
           // int bigger=k-last+1;
            if(i<last&&last%i!=0)
                  result+= f(n - 1, k, i);
            else result+=f(n-1,k,i);
        }
        return result;
    }
    public static int count(int last){
        int cnt=0;
        for(int i=1;i<last;i++){
            if(last%i!=0){
                cnt++;
            }
        }
        return  cnt;
    }
}
