package com.ustbcafe.deepin.algorithms.string;

import static com.ustbcafe.deepin.algorithms.string.LSD.random;

import java.util.Random;

/**
 *
 * Most-Significant-Digit First
 **/
public class MSD {

  private final static int R=256;
  private  static String[] aux;
  public static int charAt(String s,int d){
    if(d<s.length()){
       return s.charAt(d);
    }else return  -1;
  }

  public static  void sort(String[] a,int lo,int hi,int d){
    if(lo>hi){
      return;
    }
    int[] count=new int[R+2];
    for(int i=lo;i<=hi;i++){
       count[charAt(a[i],d)+2]++;
    }
    for(int r=0;r<R;r++){
      count[r+1]+=count[r];
    }
    for(int i=lo;i<=hi;i++){
      aux[count[charAt(a[i],d)+1]++]=a[i];
    }
    for(int i=lo;i<=hi;i++){
      a[i]=aux[i-lo];
    }
    for(int r=0;r<R;r++){
      sort(a,lo+count[r],lo+count[r+1]-1,d+1);
    }
  }

  public static void main(String[] args){
    //Character.
    int N=52;
    int w=8;
    Random rInt=new Random(0);
    String[] strings=new String[N];
    aux=new String[N];
    for(int i=0;i<N;i++){
      strings[i]=random(rInt.nextInt(w)+5);
    }
    sort(strings,0,N-1,0);
    for(int i=0;i<N;i++){
      System.out.println(strings[i]);
    }
  }



}
