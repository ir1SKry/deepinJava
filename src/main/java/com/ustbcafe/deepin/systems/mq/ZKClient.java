package com.ustbcafe.deepin.systems.mq;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangjin18 on 2018/4/23.
 */
public class ZKClient implements Watcher{
    private static Logger  logger= LoggerFactory.getLogger(ZKClient.class);
    private String url;
    private ZooKeeper zk;
    private int connectionTimeout=3000;
    List<ConnectionListener> connectionListeners=new ArrayList<>();
    public static void main(String[] args){
        String address="127.0.0.1:2181";
        String path="/topic";
        ZKClient     zkClient=new ZKClient(address);
        PathListener pathListener=new PathListener(zkClient,path);
                     zkClient.register(pathListener);
        CountDownLatch latch=new CountDownLatch(1);
        try {
                latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

   public ZKClient(String url){
       this.url=url;
       try {
           this.zk = new ZooKeeper(url, connectionTimeout, this);

       }catch (IOException e){
           e.printStackTrace();
       }
   }
    public void register(ConnectionListener listener){
        this.connectionListeners.add(listener);
    }

    @Override
    public void process(WatchedEvent event) {

        switch (event.getState()){
            case SyncConnected:
                logger.info("connected");
                for(ConnectionListener c:connectionListeners){
                    c.connected();
                }
                break;
            default:
                logger.info("event state: " + event.getState().getIntValue());
                break;
        }
    }
  public byte[] getData(String path,Watcher watcher){
      Stat stat=new Stat();
      try {
         return zk.getData(path, watcher, stat);
      }catch (InterruptedException e){
          e.printStackTrace();
      }catch (KeeperException e){
          e.printStackTrace();
      }
      return null;
  }

  public String createData(String path,byte[] value){
      try {
        return  zk.create(path, value, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      }catch(InterruptedException e){
          e.printStackTrace();
      }catch (KeeperException e){
          e.printStackTrace();
      }
      return null;
  }

}
