package com.ustbcafe.deepin.algorithms.virtual;

/**
 * Created by wangjin18 on 2018/4/12.
 */
public interface Hash {

    long hash(String text);
    long[] hash(String text, int virtualNodes);
}
