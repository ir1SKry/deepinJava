package com.ustbcafe.deepin.algorithms.string.match;

/**
 * Created by Rudy Steiner on 2017/7/2.
 * substring search in source content
 * fastest algorithm for string pattern
 */
public class Sunday {

    public int  match(String source,String pattern){
        char[] sChars=source.toCharArray();
        char[] pChars=pattern.toCharArray();
        int sLen=sChars.length;
        int pLen=pChars.length;
        int i=0,j=0;
        while(i<sLen&&j<pLen){
            if(sChars[i]!=pChars[j]){
                int lastNext=i+pLen-j;
                if(lastNext<sLen) {
                    int pos=reverseSearchLocation(pChars, sChars[lastNext]);
                    if (pos == -1) {
                        i = lastNext + 1;
                    } else {
                        i = lastNext-pos;
                    }
                    j=0;
                }else break;
            }else{
                i++;
                j++;
            }
        }
        return j==pLen? i-j:-1;

    }
    public int reverseSearchLocation(char[] pattern,char a){
       int pos=pattern.length;
        while(--pos>=0){
            if(pattern[pos]==a){
                return pos;
            }
        }
      return pos;
    }


}
