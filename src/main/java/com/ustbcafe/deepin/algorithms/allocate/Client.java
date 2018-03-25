package com.ustbcafe.deepin.algorithms.allocate;

import java.util.List;

/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class Client {
    private long id;
    private long hashId;
    private List<Broker> brokers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Broker> getBrokers() {
        return brokers;
    }

    public void setBrokers(List<Broker> brokers) {
        this.brokers = brokers;
    }

    public long getHashId() {
        return hashId;
    }

    public void setHashId(long hashId) {
        this.hashId = hashId;
    }

    @Override
    public String toString() {
        return hashId+"";
    }
}
