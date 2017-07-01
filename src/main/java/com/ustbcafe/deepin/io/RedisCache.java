package com.ustbcafe.deepin.io;

import com.ustbcafe.deepin.Constant;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;


/**
 * Created by Rudy Steiner on 2017/5/5.
 */
public class RedisCache {
    static Jedis jRedis;
    static boolean isActive;
    static BASE64Encoder encoder=new BASE64Encoder();
    static BASE64Decoder decoder=new BASE64Decoder();
    public static boolean  connect(){
        jRedis=new Jedis(Constant.VM_REDIS_HOST);
        jRedis.auth(Constant.VM_REDIS_PASS);
       if(jRedis.ping().equals("PONG")) {
           isActive=true;
           return true;
       }
        return false;
    }
    public static void set(String key,byte[] bytes){
        if(jRedis==null||!isActive){
            connect();
        }
        jRedis.set(key,encoder.encode(bytes));
    }
    public static byte[] get(String key) throws IOException{
        String str="";
        if(jRedis==null||!isActive){
            connect();
        }
        str= jRedis.get(key);
        if(str!=null&&str.length()>0)
            return   decoder.decodeBuffer(str);
        return new byte[0];
    }
}
