package com.ustbcafe.deepin.algorithms;


import com.ustbcafe.deepin.algorithms.virtual.Broker;
import com.ustbcafe.deepin.algorithms.virtual.Client;
import com.ustbcafe.deepin.algorithms.virtual.KetamaConsistentHash;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjin18 on 2018/4/11.
 */
public class KetamaTest {

    @Test
    public void consistentHash(){
        int replicas=1;
        KetamaConsistentHash<Broker> KCH=null;
        int cNum=10;
        int bNum=10;
        int offset=50;
        int kk=2;
        // N 的最大值是kk
        double N= Math.max(bNum * kk, cNum)/cNum;
        int clientReplicas=(int) Math.ceil(N);
        List<Broker> broList=new ArrayList<Broker>();
        Broker b;
        for(int i=0;i<bNum;i++){
            b=new Broker();
            b.setId(i + "");
            broList.add(b);
        }
        KCH=  new KetamaConsistentHash<Broker>(replicas,broList);
        List<Client> clients=new ArrayList<Client>();
        Client c;
        for(int k=offset;k<offset+cNum;k++){
            c=new Client();
            c.setId(k+"");
            clients.add(c);
            b=KCH.get(c);
            System.out.println(c+" connect to "+b );
        }


    }
}
