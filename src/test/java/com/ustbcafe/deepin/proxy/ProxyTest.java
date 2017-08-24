package com.ustbcafe.deepin.proxy;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by Rudy Steiner on 2017/3/11.
 */
public class ProxyTest extends TestCase{



    public void testAnnotation(){
         sayHello("jj");
    }


    @Monitor(key = Monitor.Key.API)
    public void sayHello(String name){
        System.out.println("i'm mister king,hello "+name);
    }

    @Monitor(key = Monitor.Key.API)
    public void testExceptionHello(){
        throw new IllegalArgumentException("jkdjfkdf");
    }


}
