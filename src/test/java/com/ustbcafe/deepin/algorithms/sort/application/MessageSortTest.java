package com.ustbcafe.deepin.algorithms.sort.application;

import junit.framework.TestCase;

import java.io.FileNotFoundException;

/**
 * Created by Rudy Steiner on 2017/3/19.
 */
public class MessageSortTest extends TestCase{

    public void testMessageSort(){
        String absPath="src/main/java/resources/file/talkmsg.txt";
        MessageSortAndStatistics msas=new MessageSortAndStatistics(absPath,2,"\\|");
        try {
            msas.createMessageSortedTree();
        }catch (FileNotFoundException fnfe){
             fnfe.printStackTrace();
        }
        msas.traverse();
        msas.generalization();
    }
}
