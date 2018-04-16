package com.ustbcafe.deepin.algorithms.virtual;



import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class Broker {
    private String id;
    private long hashId;
    private Set<Client> clients;

    public Broker(){
        this.clients=new HashSet();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
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
