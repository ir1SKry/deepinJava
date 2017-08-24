package com.ustbcafe.deepin.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangjin18 on 2017/7/26.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Monitor {

    Key key();
    enum Key{
        API("api"),
        DATA("data");
        private String key;
        Key(String key){
            this.key=key;
        }
        public  String getKey(){
            return key;
        }
    }
}
