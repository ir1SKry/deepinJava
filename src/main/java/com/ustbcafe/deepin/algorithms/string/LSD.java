package com.ustbcafe.deepin.algorithms.string;

import java.util.Random;

/**
 * Least-Significant-Digit First
 **/
public class LSD {
  private static final char[] charTable =new char[] {
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
      'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','a', 'b', 'c', 'e', 'e', 'f', 'g', 'h', 'i', 'j',
      'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
  };
  private static Random rd=new Random();
    public static void sort(String[] a,int w){
      int N=a.length;
      int R=256;
      String[] aux=new String[N];
      for(int d=w-1;d>=0;d--){
        int[] count=new int[R+1];
        for(int i=0;i<N;i++){
          count[a[i].charAt(d)+1]++;
        }
        for(int r=0;r<R;r++){
          count[r+1]+=count[r];
        }
        for(int i=0;i<N;i++){
          aux[count[a[i].charAt(d)]++]=a[i];
        }
        for(int i=0;i<N;i++){
          a[i]=aux[i];
        }
      }
    }

    public static  String random(int len){
      byte[] bytes=new byte[len];
      for(int i=0;i<len;i++) {
        bytes[i]=(byte) charTable[rd.nextInt(62)];
      }
      return new String(bytes);
    }
    public static void main(String[] args){
       //Character.
       int N=52;
       int w=3;
       String[] strings=new String[N];
       for(int i=0;i<N;i++){
           strings[i]=random(w);
       }
      sort(strings,3);
      for(int i=0;i<N;i++){
        System.out.println(strings[i]);
      }
    }
}
