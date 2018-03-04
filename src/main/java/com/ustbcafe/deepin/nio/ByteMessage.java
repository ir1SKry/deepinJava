package com.ustbcafe.deepin.nio;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by Rudy Steiner on 2018/3/4.
 */
public class ByteMessage {
    private byte type;
    private int length;
    private byte[] body;

    public ByteMessage(byte type, int length, byte[] body) {
        this.type = type;
        this.length = length;
        this.body = body;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        try {
            return new String(body, "GBK");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return  null;
    }
}
