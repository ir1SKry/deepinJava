package com.ustbcafe.deepin.string;

import com.ustbcafe.deepin.algorithms.string.match.BF;
import com.ustbcafe.deepin.algorithms.string.match.KMP;
import com.ustbcafe.deepin.algorithms.string.match.Sunday;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Rudy Steiner on 2017/7/2.
 */
public class ContextMatchTest {
    String source="hyurefirugrfrg";
    String case1="rgg";
    String case4="frg";
    String case5="hyure";
    String case2="hyurefirugrfrdeg";
    String case3="eru";
    String source2="mississippi";
    String case21="issipi";
    String case22="pi";
    @Test
    public void matchTest(){
        String pattern=case3;
        BF bf=new BF();
        int pos=bf.match(source,pattern);
        if(pos>=0){
            System.out.println("find the pattern, begin position is:"+(pos+1));
        }else{
            System.out.println("not find the pattern");
        }
    }
    @Test
    public void kmpNextTest(){
        String a="ABCDABD";
        KMP kmp=new KMP();
        int [] next=kmp.next(a);
        System.out.println(Arrays.toString(next));
    }
    @Test
    public void kmpTest(){
        KMP kmp=new KMP();
        String pattern=case22;
        String sourceNow=source2;
        int pos=   kmp.match(sourceNow,pattern);
        if(pos>=0){
            System.out.println(pattern+" find in "+sourceNow+" begin position is:"+(pos+1));
        }else{
            System.out.println(pattern+" not find  in "+sourceNow);
        }
    }
    @Test
    public void sunnyTest(){
        Sunday sunday=new Sunday();
        String pattern=case21;
        String sourceNow=source2;
        int pos=   sunday.match(sourceNow,pattern);
        if(pos>=0){
            System.out.println(pattern+" find in "+sourceNow+" begin position is:"+(pos+1));
        }else{
            System.out.println(pattern+" not find  in "+sourceNow);
        }
    }

}
