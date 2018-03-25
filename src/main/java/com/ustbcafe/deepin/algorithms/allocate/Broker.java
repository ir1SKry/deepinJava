package com.ustbcafe.deepin.algorithms.allocate;

import java.util.List;

/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class Broker {
    private long id;
    private long hashId;
    private List<Client> clients;
    private List<Client> lefts;
    private List<Client> rights;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public long getHashId() {
        return hashId;
    }

    public void setHashId(long hashId) {
        this.hashId = hashId;
    }

    public List<Client> getLefts() {
        return lefts;
    }

    public void setLefts(List<Client> lefts) {
        this.lefts = lefts;
    }

    public List<Client> getRights() {
        return rights;
    }

    public void setRights(List<Client> rights) {
        this.rights = rights;
    }
}
