package com.ustbcafe.deepin.algorithms.collection;

import java.util.regex.Pattern;

/**
 * Created by Rudy Steiner on 2017/4/26.
 */
public class Filter {

    public  int filter(String msg,String pat){
        Pattern pattern = Pattern.compile(pat);
         if(pattern.matcher(msg).matches())
             return 1;
        return 0;
    }
}
