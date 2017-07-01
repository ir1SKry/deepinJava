package com.ustbcafe.deepin.system.db;

import com.ustbcafe.deepin.Constant;
import junit.framework.TestCase;
import redis.clients.jedis.Jedis;

/**
 * Created by Rudy Steiner on 2017/5/4.
 */
public class RedisTest extends TestCase{
    public static final String key = "jredis::examples::HelloAgain::message";
    public static final byte[] bkey = key.getBytes();
    public void testRedis(){
    Jedis jRedis=new Jedis(Constant.VM_REDIS_HOST);
          jRedis.auth(Constant.VM_REDIS_PASS);
        System.out.println(jRedis.ping());
        //jRedis.a
        if(!jRedis.exists(bkey)) {
            jRedis.set(key, "Hello Again!");
            //jRedis.set
            System.out.format("Hello!  You should run me again!\n");
        }
        else {
            String msg = jRedis.get(key);
            System.out.println(msg);
        }
    }
}
