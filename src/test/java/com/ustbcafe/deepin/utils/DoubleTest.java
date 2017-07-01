package com.ustbcafe.deepin.utils;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by Rudy Steiner on 2017/5/12.
 */
public class DoubleTest extends TestCase {
    public  void testDoubleEqual(){
        double a=123.74787;
        double b=123.74789;
        double c=123.74787;
        boolean resultB=DoubleUtil.isEqual(a,b);
        boolean resultC=DoubleUtil.isEqual(a,c);
        Assert.assertEquals(false,resultB);
        Assert.assertEquals(false,resultC);
    }
}
