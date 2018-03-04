package com.ustbcafe.deepin.algorithms.string;


import com.ustbcafe.deepin.string.ClassifyString;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Rudy Steiner on 2017/3/23.
 */
public class ClassifyStringTest extends TestCase{


    public void testClassify(){

        System.out.println("5\r\n" +
                "abcdefs\n" +
                "abefscd\n" +
                "fdhdhfhe\n" +
                "fhdhfhde\n" +
                "dfeeieff");
        ClassifyString cs=new ClassifyString();
        cs.readConsole();
        int n=cs.classify();
        Assert.assertEquals(3,n);
    }
}
