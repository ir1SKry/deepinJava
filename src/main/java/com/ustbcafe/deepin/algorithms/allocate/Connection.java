package com.ustbcafe.deepin.algorithms.allocate;

import java.util.Set;

/**
 * Created by wangjin18 on 2018/3/28.
 */
public class Connection {
    private long clientId;
    private Set<Long> brokerIdSet;

    @Override
    public int hashCode() {
        return (int)(clientId^clientId>>32);
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Set<Long> getBrokerIdSet() {
        return brokerIdSet;
    }

    public void setBrokerIdSet(Set<Long> brokerIdSet) {
        this.brokerIdSet = brokerIdSet;
    }
}
