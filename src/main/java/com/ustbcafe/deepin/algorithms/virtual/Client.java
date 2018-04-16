package com.ustbcafe.deepin.algorithms.virtual;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class Client {
    private String id;
    private long hashId;
    private Set<Broker> brokers;
    public Client(){
        brokers=new HashSet<Broker>();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Broker> getBrokers() {
        return brokers;
    }

    public void setBrokers(Set<Broker> brokers) {
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

    @Override
    public int hashCode() {
        return id==null?0:id.hashCode();
    }
}
