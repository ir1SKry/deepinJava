package com.ustbcafe.deepin.pattern.producer;

/**
 * Created by Rudy Steiner on 2017/3/17.
 */
public class PCData {
    private final int data;

    public PCData(int d){
        this.data=d;
    }

    public int getData() {
        return data;
    }
    @Override
    public String toString() {
        return "data:"+data;
    }
}
