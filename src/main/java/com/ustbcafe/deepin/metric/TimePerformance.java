package com.ustbcafe.deepin.metric;

/**
 * Created by wangjin18 on 2017/12/13.
 */
public interface TimePerformance {
    boolean start();
    boolean tic(String subTheme);
    boolean stop();
}
