package com.ustbcafe.deepin.algorithms.virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by wangjin18 on 2018/4/12.
 */
public class LoadBalance implements Associate<Client,Broker> {
    private Hash hash;
    private final int REPLICAS=120;
    private Circle<Hash,Broker> circle;
    public LoadBalance(){
        this.hash=new BoundedMurmurHash(16384);
        this.circle=new Circle<Hash,Broker>(REPLICAS,hash);
    }


    public void init(List<Client> clients,List<Broker> brokers,List<String> cliId,List<String> broId){
        Client c;
        Broker b;
        for(String s:cliId){
            c=new Client();
            c.setId(s);
            clients.add(c);
        }
        for(String s:broId){
            b=new Broker();
            b.setId(s);
            brokers.add(b);
        }

    }

    /**
     *@param clientsId  client id 列表
     *@param brokersId  broker id 列表
     *@param k          expect have k clients connect to each broker,suggest k=3 or bigger
     *@return  client id with a set of broker ids. ensure each broker has ceil(2*k/3) brokers.
     **/
    public Map<String, Set<String>> balance(List<String> clientsId,List<String> brokersId,int k){
        if(clientsId==null||clientsId.size()==0||brokersId==null||brokersId.size()==0){
            throw new RuntimeException("clients and brokers can't be empty");
        }
        circle.clear();
        List<Client> clients=new ArrayList<Client>();
        List<Broker> brokers=new ArrayList<Broker>();
        init(clients, brokers, clientsId, brokersId);
        run(clients, brokers, k);
        return  AllocationEvaluation.clientMap(clients);
    }

    public void run(List<Client> clients,List<Broker> brokers,int k){
          circle.add(brokers);
          double d=(double) clients.size()/brokers.size();
          k= Math.max((int) Math.ceil(d), k);
          d= (double)k*brokers.size()/clients.size() ;
          int cliVirtualReplicas=(int) Math.ceil(d);
          long[] keys;
          Broker b;
          for(Client c:clients){
              keys=hash.hash(c.getId(),cliVirtualReplicas);
              for(long key:keys){
                  b=circle.get(key);
                  associate(c,b);
              }
          }
        ruleBrokerCheck(clients, brokers, k);
    }

    public void ruleBrokerCheck(List<Client> clients,List<Broker> brokers,int k){
        int lowBound=(int) Math.ceil((double) k * 2 / 3);
        lowBound= Math.max(lowBound, 2);
        for(Broker b:brokers){
            if(b.getClients().size()<lowBound){
                associate(clients,b);
                System.out.println("full client:"+b);
            }
        }
    }

    @Override
    public void associate(List<Client> clients, Broker broker) {
        for(Client c:clients)
            associate(c,broker);
    }

    @Override
    public void associate(Client client, Broker broker) {
        client.getBrokers().add(broker);
        broker.getClients().add(client);
    }
}
