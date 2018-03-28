package com.ustbcafe.deepin.algorithms.allocate;

import java.util.*;

/**
 * Created by wangjin18 on 2018/3/28.
 *
 * 如果client 在上次分配中存在，期望下次分配也存在
 */
public class AllocationEvaluation {

    public static String evaluation(List<Client> olds,List<Client> news){
        int oldTotal=0;
        int disconnect=0;
        Map<Long,Connection> connectionMap=new HashMap<>();
        Connection connection;
        Set<Long> brokerIdSet;
        for(Client c:news){
            if(c.getBrokers()!=null&&c.getBrokers().size()>0){
                connection=new Connection();
                connection.setClientId(c.getId());
                brokerIdSet=new HashSet<>();
                for(Broker b:c.getBrokers()){
                    brokerIdSet.add(b.getId());

                }
                connection.setBrokerIdSet(brokerIdSet);
                connectionMap.put(connection.getClientId(),connection);
            }
        }
        for(Client c:olds){
            connection=connectionMap.get(c.getId());
            if(connection!=null){
               if(c.getBrokers()!=null)
                   oldTotal+=c.getBrokers().size();
                for(Broker b:c.getBrokers()){
                   if(!connection.getBrokerIdSet().contains(b.getId()))
                       disconnect++;
                }

            }

        }
        return "{total:"+oldTotal+",disconnect:"+disconnect+"}";
    }
  public static Map<Long,Connection> connectionMap(List<Client> clients){
      Map<Long,Connection> connectionMap=new HashMap<>();
      Connection connection;
      Set<Long> brokerIdSet;
      for(Client c:clients){
          if(c.getBrokers()!=null&&c.getBrokers().size()>0){
              connection=new Connection();
              connection.setClientId(c.getId());
              brokerIdSet=new HashSet<>();
              for(Broker b:c.getBrokers()){
                  brokerIdSet.add(b.getId());

              }
              connection.setBrokerIdSet(brokerIdSet);
              connectionMap.put(connection.getClientId(),connection);
          }
      }
      return connectionMap;
  }
}
