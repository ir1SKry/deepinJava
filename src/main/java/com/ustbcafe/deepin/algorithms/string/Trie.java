package com.ustbcafe.deepin.algorithms.string;


/**
 * prefix tree  
 **/
public class Trie<V> {

    private static int R=256;
    private Node root;
    private static class Node{
       private Object val;
       private Node[] next=new Node[R];
    }

    public V get(String key){
      Node x=get(root,key,0);
      if(x==null) return null;
      return (V)x.val;
    }

    private Node get(Node x,String key,int d){
      if(x==null) return null;
      if(d==key.length()) return x;
      char c=key.charAt(d);
      return get(x.next[c],key,d+1);
    }

    public void put(String key,V value){
      root=put(root,key,value,0);
    }

    /**
     *
     *
     **/
    private Node delete(Node x,String key,int d){

      if(x==null) return null;
      if(d==key.length()){
         x.val=null;
      }else{
        char c=key.charAt(d);
        x.next[c]=delete(x.next[c],key,d+1);
      }
      if(x.val!=null) return x;
      for(char c=0;c<R;c++){
         if(x.next[c]!=null) return x;
      }
      return null;
    }


    private Node put(Node x,String key,V value,int d){
      if(x==null) x=new Node();
      if(d==key.length()){x.val=value;return x;}
      char c=key.charAt(d);
      x.next[c]=put(x.next[c],key,value,d+1);
      return x;
    }



}
