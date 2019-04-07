package com.ustbcafe.deepin.algorithms.string.match;

public class RabinKarp {
  /**
   * @param source:
   * @param target:
   * @return: return the index
   */
  public int strStr(String s, String t) {
    // Write your code here
    // Write your code here
    long Q=3947;
    long R=256;
    int txtLen=s.length();
    int M=t.length();
    if(M==0)
      return 0;
    long MR=1;
    for(int i=0;i<M;i++){
      MR=(MR*R)%Q;
    }
    if(txtLen<M) return -1;
    long hashTxt=0;
    long patHash=hash(t,Q);
    for(int i=0;i<txtLen;i++){
      hashTxt=((hashTxt*R)%Q+s.charAt(i))%Q;
      if(i<M-1){
        continue;
      }
      if(i>=M){
        hashTxt=hashTxt-(MR*s.charAt(i-M))%Q;
        if(hashTxt<0) hashTxt=hashTxt+Q;
      }
      if(hashTxt==patHash&&check(s,t,i-M+1)){
        return i-M+1;
      }
    }
    return -1;
  }

  public boolean check(String s,String t, int i){
    int M=t.length();
    for(int j=0;j<M;j++){
      if(s.charAt(j+i)!=t.charAt(j))
        return false;
    }
    return true;
  }

  public long hash(String pat,long Q){
    long hashTxt=0;
    int M=pat.length();
    long R=256;
    for(int i=0;i<M;i++){
      hashTxt=(hashTxt*R)%Q+pat.charAt(i);
    }
    return hashTxt%Q;
  }
}
