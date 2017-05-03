package com.ustbcafe.deepin.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Rudy Steiner on 2017/3/11.
 */
public class AnnotationOperator {

    public static void main(String[] args) throws IllegalAccessException ,InvocationTargetException{

        MyProxy proxy=new MyProxy();
        Method[] methods=MyProxy.class.getDeclaredMethods();
        for (Method method : methods) {
                     MyAnnotation annotationTmp = null;
                         if((annotationTmp = method.getAnnotation(MyAnnotation.class))!=null) // 检测是否使用了我们的注解
                             method.invoke(proxy,annotationTmp.name()); // 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
                        else
                            method.invoke(proxy, "Rose"); // 如果没有使用我们的注解，我们就需要使用普通的方式来调用方法了
                    }
    }
}
