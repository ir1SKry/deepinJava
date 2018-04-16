package com.ustbcafe.deepin.algorithms.virtual;

import java.util.*;

/**
 * Created by wangjin18 on 2018/3/28.
 *
 * 如果client 在上次分配中存在，期望下次分配也存在
 * 辅助评估连接分配结果
 */
public class AllocationEvaluation {


    /**
     *   两次连接分配中，client和broker 都存在，且上次有链接，如果在新的分配中无连接 则统计
     *
     *
     **/
    public  static String evaluation(Map<String,Set<String>> old,Map<String,Set<String>> newCon){
        String key;
        int oldTotalConnection=0;
        int disconnected=0;
        Set<String> totalBrokerIds=new HashSet();
        Set<String> commonIds=null;
        for(Map.Entry<String,Set<String>> e:old.entrySet()){
            if(commonIds==null) {
                commonIds = new HashSet<String>(e.getValue());
            }else {
                commonIds.retainAll(e.getValue());
            }
        }
        for(Map.Entry<String,Set<String>> e:newCon.entrySet()){
            totalBrokerIds.addAll(e.getValue());
        }
        for(Map.Entry<String,Set<String>> e:old.entrySet()){
            key= e.getKey();
            oldTotalConnection+=e.getValue().size();
            Set<String> newBrokerIds=newCon.get(key);
            if(newBrokerIds!=null) {
                for (String v : e.getValue()){
                    if(totalBrokerIds.contains(v)&&!newBrokerIds.contains(v)&&!commonIds.contains(v)){
                        disconnected++;
                    }
                }
            }
        }
        return "{old total:"+oldTotalConnection+",disconnect:"+disconnected+",exclude full connection in last time}";
    }

    public static Map<String,Set<String>> clientMap(List<Client> clients){
        Map<String,Set<String>> connectionMap=new HashMap<String,Set<String>>();
        Set<String> brokerIdSet;
        for(Client c:clients){
            if(c.getBrokers()!=null&&c.getBrokers().size()>0){
                brokerIdSet=new HashSet<String>();
                for(Broker b:c.getBrokers()){
                    brokerIdSet.add(b.getId());

                }
                connectionMap.put(c.getId(),brokerIdSet);
            }
        }
        return connectionMap;
    }


}
