package com.ustbcafe.deepin.algorithms.string;


import static com.ustbcafe.deepin.algorithms.string.LSD.random;

import java.util.Random;

/**
 * fast-sort for string
 *
 **/
public class Quick3String {

  public static void sort(String[] a,int lo,int hi, int d){
    if(hi<=lo){
      return;
    }
    int lt=lo,gt=hi;
    int v=MSD.charAt(a[lo],d);
    int i=lo+1;
    while(i<=gt){
      int t=MSD.charAt(a[i],d);
      if(t<v)exch(a,lt++,i++);
      else if(t>v) exch(a,i,gt--);
      else i++;
    }
    sort(a,lo,lt-1,d);
    if(v>0) sort(a,lt,gt,d+1);
    sort(a,gt+1,hi,d);
  }

  public static void exch(String[] a,int i,int j){
    String tmp=a[i];
    a[i]=a[j];
    a[j]=tmp;
  }
  public static void main(String[] args){
    //Character.
    int N=52;
    int w=8;
    Random rInt=new Random(0);
    String[] strings=new String[N];
    for(int i=0;i<N;i++){
      strings[i]=random(rInt.nextInt(w)+5);
    }
    sort(strings,0,N-1,0);
    for(int i=0;i<N;i++){
      System.out.println(strings[i]);
    }
  }
}
