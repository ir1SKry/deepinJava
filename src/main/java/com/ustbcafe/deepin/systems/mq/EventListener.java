package com.ustbcafe.deepin.systems.mq;

/**
 * Created by wangjin18 on 2018/4/24.
 */
public interface EventListener<E extends Event> {

    public void onEvent(E e);
}
