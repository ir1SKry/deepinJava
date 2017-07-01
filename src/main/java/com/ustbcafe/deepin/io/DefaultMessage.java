package com.ustbcafe.deepin.io;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudy Steiner on 2017/5/4.
 */
public class DefaultMessage<T> implements Serializable {
    private  Map<String, Object> kvs=null;
    private int count;
    private double discount;
    private String name;
    private byte[] body;
    public DefaultMessage(byte[] body){
        this.body=body;
    }

    public Map<String, Object> getKvs() {
        return kvs;
    }

    public void setKvs(Map<String,Object> map){
        this.kvs=map;
    }
    public void putKv(String key,Object val){
        if(kvs==null){
            kvs=new HashMap();
        }
        kvs.put(key,val);
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
