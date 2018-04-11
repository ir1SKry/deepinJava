package com.ustbcafe.deepin.algorithms.allocate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.log4j.Logger;



/**
 * Created by Rudy Steiner on 2018/3/24.
 */
public class LoadBalance implements Associate<Client,Broker> {
    // logger
    private  Logger log =
            Logger.getLogger( LoadBalance.class.getName() );
     public void balance(List<Client> clients,List<Broker> brokers,int k){
            for(Client c:clients){
                c.setHashId(md5HashingAlg(c.getId()));
            }
            for(Broker b:brokers){
              b.setHashId(md5HashingAlg(b.getId()));
             }

         Collections.sort(brokers, new Comparator<Broker>() {
             @Override
             public int compare(Broker o1, Broker o2) {
                 long diff=o1.getHashId()-o2.getHashId();
                 if(diff==0)
                     return 0;
                 else if(diff<0)
                     return -1;
                 else return  1;
             }
         });
         Collections.sort(clients, new Comparator<Client>() {
             @Override
             public int compare(Client o1, Client o2) {
                 long diff=o1.getHashId()-o2.getHashId();
                 if(diff==0)
                     return 0;
                 else if(diff<0)
                     return -1;
                 else return  1;
             }
         });
         int clientSize=clients.size();
         int j=0;
         for(int i=0;i<clientSize;i++){
             while(j<brokers.size()&&clients.get(i).getHashId()>=brokers.get(j).getHashId())
                 j++;
             if(j==brokers.size()&&i<clientSize){
                 for(int kk=i;kk<clientSize;kk++){
                     if(brokers.get(0).getLefts()==null)
                         brokers.get(0).setLefts(new ArrayList<Client>());
                     brokers.get(0).getLefts().add(clients.get(kk));
                 }
                 break;
             }
             if(brokers.get(j).getLefts()==null)
                 brokers.get(j).setLefts(new ArrayList<Client>());
             brokers.get(j).getLefts().add(clients.get(i));
         }
         printBroker(brokers);
         double d=(double) clients.size()/brokers.size();
         k=Math.max((int)Math.ceil(d),k);
         // rule 1
         cluster(brokers, k);
         // rule 2
         ruleCheck(clients, brokers, k);
     }

     public void cluster(List<Broker> brokers,int k){
         BrokerClusterComparator c;
         for(int i=0;i<brokers.size();i++) {
                 Broker b=brokers.get(i);
                 c = new BrokerClusterComparator(b);
                 List<Client> cluster=new ArrayList<>();
                 if( b.getLefts()!=null&&b.getLefts().size()>0)
                     cluster.addAll(b.getLefts());
                 int rightBrokerIndex=(i+1)%brokers.size();
                 if( brokers.get(rightBrokerIndex).getLefts()!=null&&brokers.get(rightBrokerIndex).getLefts().size()>0)
                     cluster.addAll(brokers.get(rightBrokerIndex).getLefts());
                  if(cluster.size()>k){
                      Collections.sort(cluster,c);
                      List<Client> cs=cluster.subList(0,k);
                      associate(cs,b);
                      b.setClients(cs);
                  }else {
                      b.setClients(cluster);
                      associate(cluster,b);
                      amend(brokers,b,c,i-1,i+2,k);
                  }
         }
     }
     public void amend(List<Broker> brokers,Broker current,Comparator<Client> c,int left,int right, int k){
               if(current.getClients().size()>=k||(left<0&&right>=brokers.size())) {
                   System.out.println("broker id:"+current.getId()+",amend finish!");
                   return;
               }
               int remain=k-current.getClients().size();
                 List<Client> cluster=new ArrayList<>();
                if(left>=0&&brokers.get(left).getLefts()!=null&&brokers.get(left).getLefts().size()>0)
                     cluster.addAll(brokers.get(left).getLefts());
                if( right<brokers.size()&&brokers.get(right).getLefts()!=null&&brokers.get(right).getLefts().size()>0)
                    cluster.addAll(brokers.get(right).getLefts());
                if(cluster.size()>remain){
                     Collections.sort(cluster,c);
                     List<Client> cs=cluster.subList(0,remain);
                     associate(cs,current);
                    current.getClients().addAll(cs);
                    System.out.println("broker id:"+current.getId()+",amend finish!");
                }else {
                    current.getClients().addAll(cluster);
                    associate(cluster,current);
                    amend(brokers,current,c,left-1,right+1,k);
                 }
     }
      public void ruleCheck(List<Client> clients,List<Broker> brokers,int k){
          int av=brokers.size()*k/clients.size();

          List<Integer>  noneBrokerList=new ArrayList<>();
          List<Integer>  moreBrokerList=new ArrayList<>();
          Client c;
          for(int i=0;i<clients.size();i++){
              c=clients.get(i);
              if(c.getBrokers()==null||c.getBrokers().size()==0)
                  noneBrokerList.add(i);
              else if(c.getBrokers().size()>av){
                  moreBrokerList.add(i);
              }
          }
          int moreBrokerIndex=0;
          for(Integer index:noneBrokerList){
              if(clients.get(index).getBrokers()==null)
                  clients.get(index).setBrokers(new ArrayList<Broker>());
               int ind=moreBrokerList.get(moreBrokerIndex);
               Broker b=clients.get(ind).getBrokers().remove(0);
               associate(clients.get(index),b);
               b.getClients().remove(clients.get(ind));
               b.getClients().add(clients.get(index));
               if(clients.get(ind).getBrokers().size()==av) {
                   moreBrokerIndex++;
                   if(moreBrokerIndex>moreBrokerList.size())
                       System.out.println("something wrong!");
               }
          }

      }
     class BrokerClusterComparator implements Comparator<Client>{
         private Broker center;
         public BrokerClusterComparator(Broker b){
             this.center=b;
         }
         @Override
         public int compare(Client o1, Client o2) {
             long a1=Math.abs(o1.getHashId()-center.getHashId());
             long a2=Math.abs(o2.getHashId()-center.getHashId());
             if(a1==a2)
                 return 0;
             else if(a1>a2)
                 return 1;
             return -1;
         }
     }
    /**
     *
     * jump consistent hash ,FNV hash
     * Calculates the Ketama hash value for a string
     * @param key
     * @return
     */
    public  Long md5HashingAlg(Long key) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("++++ no md5 algorythm found");
            throw new IllegalStateException("++++ no md5 algorythm found");
        }
        md5.reset();
        md5.update(key.byteValue());
        byte[] bKey = md5.digest();
        long res = ((long) (bKey[3] & 0xFF) << 24)
                | ((long) (bKey[2] & 0xFF) << 16)
                | ((long) (bKey[1] & 0xFF) << 8) | (long) (bKey[0] & 0xFF);
        return res;
    }

    public static  void main(String[] args){
        LoadBalance lb=new LoadBalance();
        int k=2;
        List<Client> oldClients=new ArrayList<>();
        List<Broker> oldBrokers=new ArrayList<>();
            lb.initRand(oldClients,oldBrokers,10,30,70);
            lb.balance(oldClients, oldBrokers, k);
        List<Client>            clients=new ArrayList<>();
        List<Broker>            brokers=new ArrayList<>();
                    lb.initRand(clients, brokers, 10, 42, 70);
                    lb.balance(clients, brokers, k);


        String result1= JSON.toJSONString(oldClients, SerializerFeature.DisableCircularReferenceDetect);
        String result2= JSON.toJSONString(clients, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result1.equals(result2));
        String  result=AllocationEvaluation.evaluation(oldClients,clients);
        System.out.println(result);
        System.out.println(JSON.toJSONString(AllocationEvaluation.connectionMap(oldClients).values()));
        System.out.println(JSON.toJSONString(AllocationEvaluation.connectionMap(clients).values()));
    }
    public void initRand(List<Client> clients,List<Broker> brokers,int cStart,int cEnd,int bStart){
        Client client;
        Broker broker;
        for(int i=cStart;i<cEnd;i++){
            client=new Client();
            client.setId(i);
            clients.add(client);
        }
        for(int i=bStart;i<bStart+ 10;i++){
            broker=new Broker();
            broker.setId(i);
            brokers.add(broker);
        }
    }
    public void printBroker(List<Broker> brokers){
        for(Broker b:brokers){
          System.out.println("{clientId:"+Arrays.toString(b.getLefts()==null?new Object[0]:b.getLefts().toArray())+",brokerId:"+b.getHashId()+"}");
        }
    }

    @Override
    public void associate(List<Client> clients, Broker broker) {
        for(Client c:clients) {
            if (c.getBrokers() == null)
                c.setBrokers(new ArrayList<Broker>());
            c.getBrokers().add(broker);
        }
    }

    @Override
    public void associate(Client client, Broker broker) {
        if (client.getBrokers() == null)
            client.setBrokers(new ArrayList<Broker>());
        client.getBrokers().add(broker);
    }
}
