package com.ustbcafe.deepin.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Rudy Steiner on 2017/3/11.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String paramValue() default  "default";  // 表示我的注解需要一个参数 名为"paramValue" 默认值为"johness"
}
