package com.ustbcafe.deepin;
/**
 * Created by Rudy Steiner on 2016/12/23.
 */
public  class MyString {

    private final char value[];
    public MyString(char value[]){
        int len=value.length;
        this.value=new char[len];
        System.arraycopy(value,0,this.value,0,len);
    }

//    public String toString(){
//          return this;
//      }
      public  int length(){
       return value.length;
      }


      public void  encodeLenTest(){

      }
}
