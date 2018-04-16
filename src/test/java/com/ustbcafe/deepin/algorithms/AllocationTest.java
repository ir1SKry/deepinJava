package com.ustbcafe.deepin.algorithms;



import com.alibaba.fastjson.JSON;
import com.ustbcafe.deepin.algorithms.virtual.AllocationEvaluation;
import com.ustbcafe.deepin.algorithms.virtual.LoadBalance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangjin18 on 2018/3/30.
 */
public class AllocationTest {


    LoadBalance lb = new LoadBalance();
    int k =3;

    /**
     * 测试只有1个client情况
     **/
    public void init(List<String> clientsId, List<String> brokersId, int cStart, int cEnd, int bStart, int bEnd) {
        for (int i = cStart; i < cEnd; i++) {
            clientsId.add(i + "");
        }
        for (int i = bStart; i < bEnd; i++) {
            brokersId.add(i + "");
        }
    }

    @Test
    public void lowBoundClientTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 10, 50, 60);
        init(newClientsId, newBrokersId, 0, 10, 50, 55);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }

    /*
    *
    * 增加client，
    * clause: 可能导致上次的全连接断开
    * clause: client 虚拟节点数变少，导致断开连接
    *
    **/
    @Test
    public void ClientIncrementTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 5, 50, 60);
        init(newClientsId, newBrokersId, 0, 8, 50, 60);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }

    /*
   *
   * 减少client，
   * clause: 可能导致上次的全连接断开
   * clause: client 虚拟节点数变多，不会导致连接断开
   *
   **/
    @Test
    public void ClientDecrementTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 15, 50, 60);
        init(newClientsId, newBrokersId, 0, 10, 50, 60);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }

    /*
  *
  * 同时增加、减少/client
  * clause: 可能导致上次的全连接断开
  * clause: client 虚拟节点数变多，不会导致连接断开
  *
  **/
    @Test
    public void ClientIncDecrementTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 15, 50, 60);
        init(newClientsId, newBrokersId, 5, 20, 50, 60);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }
    /*
    *
    * 同时增加、减少/broker
    * clause: 可能导致上次的全连接断开
    * clause: client 虚拟节点数变多，不会导致连接断开
    *
    **/
    @Test
    public void ClientIncDecrementBrokerTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 15, 50, 55);
        init(newClientsId, newBrokersId, 5, 15, 53,56);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }

    /*
   *
   * one broker
   * clause: 可能导致上次的全连接断开
   *
   *
   **/
    @Test
    public void oneBrokerTest() {
        List<String> clientsId = new ArrayList<String>();
        List<String> brokersId = new ArrayList<String>();
        List<String> newClientsId = new ArrayList<String>();
        List<String> newBrokersId = new ArrayList<String>();
        init(clientsId, brokersId, 0, 1, 50, 51);
        init(newClientsId, newBrokersId, 5, 7, 50,51);
        Map<String, Set<String>> connectionMap =   lb.balance(clientsId, brokersId, k);
        Map<String, Set<String>> newConnectionMap = lb.balance(newClientsId, newBrokersId, k);
        visualizeResult(connectionMap, newConnectionMap);
    }
    public void visualizeResult(Map<String, Set<String>> connectionMap, Map<String, Set<String>> newConnectionMap) {
        String result1 = JSON.toJSONString(connectionMap);
        String result2 = JSON.toJSONString(newConnectionMap);
        System.out.println(result1);
        System.out.println(result2);
        String result = AllocationEvaluation.evaluation(connectionMap, newConnectionMap);
        System.out.println(result);
    }


    @Test
    public void testSet(){
        int k=4;
        int lowBound=(int) Math.ceil((double) k * 2 / 3);
        int v=k^k;
        System.out.println(lowBound+","+v);
    }
}
