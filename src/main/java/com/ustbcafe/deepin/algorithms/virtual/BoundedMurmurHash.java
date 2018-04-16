package com.ustbcafe.deepin.algorithms.virtual;

/**
 * Created by wangjin18 on 2018/4/13.
 */
public class BoundedMurmurHash implements Hash {

    private int bound;
    private final int seed = 0x1234ABCD;
    public BoundedMurmurHash(int bound){
        this.bound=bound;

    }
    @Override
    public long hash(String text) {
       return MurmurHash.hash(text.getBytes(),seed)%bound;
    }

    @Override
    public long[] hash(String text, int virtualNodes) {
        long[] values=new long[virtualNodes];
        for(int i=0;i<virtualNodes;i++){
            values[i]=MurmurHash.hash((text+"-"+i).getBytes(),seed)%bound;
        }
        return values;
    }
}
