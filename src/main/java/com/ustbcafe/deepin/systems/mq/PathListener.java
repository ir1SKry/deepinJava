package com.ustbcafe.deepin.systems.mq;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjin18 on 2018/4/23.
 */
public class PathListener implements ConnectionListener {
    private static Logger logger= LoggerFactory.getLogger(PathListener.class);
    private String path;
    private ZKClient zkClient;
    private UpdateWatcher updateWatcher;
    public PathListener(ZKClient client,String path){
        this.path=path;
        this.zkClient=client;
        this.updateWatcher=new UpdateWatcher();
    }
    @Override
    public void connected() {
        if(zkClient.exist(path)==null) {
            logger.info(String.format("path: %s not exist,create",path));
            zkClient.create(path, "init path value".getBytes());
        }else show();
    }

    public class UpdateWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            switch (event.getType()){
                case NodeDataChanged:
                    show();
                   break;
                case NodeDeleted:
                    break;
                case NodeChildrenChanged:
                    break;
                default:
                    break;
            }
        }
    }
    public void show(){

        byte[] value=  zkClient.getData(path,updateWatcher);
        if(value!=null){
            logger.info("path value:"+new String(value));
        }
    }
}
