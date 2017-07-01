package com.ustbcafe.deepin.algorithms.sort;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by Rudy Steiner on 2017/3/9.
 */
public class SortTest extends TestCase{

    public void testSort(){
//        int[] data={};
//        int[] expected={};
        int[] data={50,36,66,76,59,95,12,25,36};
        int[] expected={12,25,36,36,50,59,66,76,95};
//        int[] data={3};
//        int[] expected={3};
//        int[] data={9,8,7,6,5,5,7,4,3,2,3,2,1};
//        int[] expected={1,2,2,3,3,4,5,5,6,7,7,8,9};
        //Sort.bubbleSort2(data);
        Sort.recursiveFastSort(data,0,data.length-1);
        //HeapSort.sort(data);
        System.out.println(Arrays.toString(data));
        Assert.assertEquals(Arrays.toString(expected),Arrays.toString(data));
    }

}
