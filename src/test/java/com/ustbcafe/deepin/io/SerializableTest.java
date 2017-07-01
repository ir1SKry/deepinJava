package com.ustbcafe.deepin.io;

import com.sun.corba.se.pept.encoding.InputObject;
import com.ustbcafe.deepin.collection.LinkedQueue;
import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Rudy Steiner on 2017/5/4.
 */
public class SerializableTest extends TestCase {
    public void testSerializeObject() throws IOException ,ClassNotFoundException{
        String body="jdkjfkdjjdkaf2368763x2 b8c";
        DefaultMessage df=new DefaultMessage(body.getBytes());
        DefaultMessage ddf;
        df.setCount(2);
        df.setDiscount(0.8);
        df.setName("rudy");
        HashMap<String,LinkedQueue<Integer>> map=new HashMap<>();
        Random rd=new Random();
        int len=15;
        int rand;
        LinkedQueue<Integer> linkedQueue;
        for(int i=0;i<len;i++){
            rand=rd.nextInt(len);
            linkedQueue=new LinkedQueue<>();
            for(int j=0;j<rand;j++ ){
                linkedQueue.enqueue(rd.nextInt(200));
            }
            map.put(i+"",linkedQueue);
        }

        df.setKvs(map);
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream=new PrintStream(baoStream);
        ObjectSerializeUtil.serializeObject(new ObjectOutputStream(cacheStream),df);
        RedisCache.connect();
        RedisCache.set("DefaultMessage",baoStream.toByteArray());
        byte[] bytes=RedisCache.get("DefaultMessagea");
        ByteArrayInputStream inputStream=new ByteArrayInputStream(bytes);
        ObjectInputStream ois=new ObjectInputStream(inputStream);
        DefaultMessage newDf=(DefaultMessage)ois.readObject();
        System.out.println(df);
        System.out.println(newDf);
    }
}
