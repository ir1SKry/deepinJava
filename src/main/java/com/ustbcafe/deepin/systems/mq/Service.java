package com.ustbcafe.deepin.systems.mq;

/**
 * Created by wangjin18 on 2018/4/24.
 */
public interface Service {

     void start() throws  Exception;
     boolean isStart();
     void stop()  throws  Exception;
}
