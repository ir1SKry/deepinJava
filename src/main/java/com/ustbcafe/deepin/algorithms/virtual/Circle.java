package com.ustbcafe.deepin.algorithms.virtual;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wangjin18 on 2018/4/12.
 */
public class Circle<H extends Hash,T> {
    private final int numberOfVirtualNodeReplicas;
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    private H hash;
    public Circle(int numberOfVirtualNodeReplicas, List<T> nodes, H hash) {
        this.numberOfVirtualNodeReplicas = numberOfVirtualNodeReplicas;
        this.hash=hash;
        add(nodes);
    }
    public Circle(int numberOfVirtualNodeReplicas, H hash) {
        this.numberOfVirtualNodeReplicas = numberOfVirtualNodeReplicas;
        this.hash=hash;
    }

    public synchronized void add(T node) {
        w.lock();
        try {
            addNode(node);
        } finally {
            w.unlock();
        }
    }

    public synchronized void add(List<T> nodes) {
        w.lock();
        try {
            for (T node : nodes) {
                addNode(node);
            }
        } finally {
            w.unlock();
        }
    }

    public synchronized void remove(List<T> nodes) {
        w.lock();
        try {
            for (T node : nodes) {
                removeNode(node);
            }
        } finally {
            w.unlock();
        }
    }

    public synchronized void remove(T node) {
        w.lock();
        try {
            removeNode(node);
        } finally {
            w.unlock();
        }
    }

    public T get(long key) {
        if (circle.isEmpty()) {
            return null;
        }
        r.lock();
        try {
            if (!circle.containsKey(key)) {
                SortedMap<Long, T> tailMap = circle.tailMap(key);
                key = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
            }
            return circle.get(key);
        } finally {
            r.unlock();
        }
    }

    private void addNode(T node) {
           long[] keys=   hash.hash(node.toString(),numberOfVirtualNodeReplicas);
           for(long k:keys)
                circle.put(k, node);
    }

    private void removeNode(T node) {
        long[] keys=   hash.hash(node.toString(),numberOfVirtualNodeReplicas);
        for(long k:keys)
            circle.remove(node);
    }
    public void clear(){
        this.circle.clear();
    }

}
