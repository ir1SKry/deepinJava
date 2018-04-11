package com.ustbcafe.deepin.algorithms.virtual;

import java.util.List;

/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class Client {
    private String id;
    private long hashId;
    private List<Broker> brokers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return id;
    }
}
