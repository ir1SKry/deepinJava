package com.ustbcafe.deepin.db;

import com.ustbcafe.deepin.metric.TimeM;
import com.ustbcafe.deepin.utils.RandomString;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wangjin18 on 2017/12/13.
 */
public class HotAreaHistoryMock {
    public static void main(String[] args){
        // System.out.println("aa");
        // long start= System.currentTimeMillis();
        //mockInsertSku(1000,16000L);
//         long end=System.currentTimeMillis();
//         System.out.println("time elapse:"+(end-start)+" ms ");
        //insertHotarea(13000L,17000L);
//        Random random=new Random();
//        for(int i=0;i<10;i++)
//        System.out.println(random.nextInt(2)+1);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.DAY_OF_MONTH,22);
        calendar.set(Calendar.HOUR_OF_DAY,9);
        calendar.set(Calendar.MINUTE, 5);
        calendar.set(Calendar.SECOND, 0);
        Long time=calendar.getTimeInMillis();
        //System.out.println(time);
         mockInsertHotareaRealTime(1L, 100L, time);
    }
    /**
     *   @num
     *   @param baseSkuId SkuId
     *   about insert 1000 record in 2.5s
     * **/
    public static void mockInsertSku(int num,Long baseSkuId){
        TimeM monitor=new TimeM("Insert Sku");
        monitor.start();
        String insertSku="INSERT INTO zshhj_sku(sku_id,sku_name,status,created,creator) VALUES(?,?,1,NOW(),'wangjin18')";
        //monitor.tic(null);
        Connection c=DBCPUtil.getConnection();
        monitor.tic("connection");
        //PreparedStatement preparedStatement;
        try {
            PreparedStatement preparedStatement=  c.prepareStatement(insertSku, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //monitor.start();
            for(int i=0;i<num;i++){
                preparedStatement.setLong(1,baseSkuId+i);
                preparedStatement.setString(2, RandomString.rand(5));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            c.commit();
            c.close();
            monitor.stop();
        }catch (SQLException e){
            Logger.getLogger(HotAreaHistoryMock.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    public static void mockInsertHotarea(Long skuIdStart,Long skuIdEnd){
        TimeM monitor=new TimeM("Insert hotarea");
        monitor.start();
        String insertHotarea="INSERT INTO zshhj_hotarea(shelf_id,sku_id,adver_id,hotarea_no,status,created,creator)" +
                                                       "VALUES(28,?,17,?,1,NOW(),'wangjin18')";
        String selectSkuIds="SELECT sku_id from zshhj_sku WHERE sku_id>=? AND sku_id<?";
        Connection c=DBCPUtil.getConnection();
        monitor.tic("connected");
        try {
            PreparedStatement preparedStatement = c.prepareStatement(selectSkuIds, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setLong(1,skuIdStart);
            preparedStatement.setLong(2,skuIdEnd);
            ResultSet rs=preparedStatement.executeQuery();
            List<Long> skuIds=new ArrayList<>();
            while(rs.next()){
                skuIds.add(rs.getLong(1));
            }
            monitor.tic("query skuIds finished:"+skuIds.size());
            preparedStatement=c.prepareStatement(insertHotarea, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for(Long skuId:skuIds){
                preparedStatement.setLong(1, skuId);
                preparedStatement.setString(2, "RQ" + skuId);
                preparedStatement.addBatch();;
            }
            preparedStatement.executeBatch();
            c.commit();
            c.close();
            monitor.stop();
        }catch (SQLException e){
            Logger.getLogger(HotAreaHistoryMock.class.getName()).log(Level.SEVERE, null,e);

        }
    }

    public static void mockInsertHotareaRealTime(Long hotAreaIdStart,Long hotAreaIdEnd,Long baseTime){
        TimeM monitor=new TimeM("Insert realtime hotarea ");
        monitor.start();
        String selectHotIds="SELECT id from zshhj_hotarea WHERE status=1 and id>=? and id<?";
        Connection c=DBCPUtil.getConnection();
        monitor.tic("connected");
        try {
            PreparedStatement preparedStatement = c.prepareStatement(selectHotIds, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setLong(1, hotAreaIdStart);
            preparedStatement.setLong(2, hotAreaIdEnd);
            ResultSet rs = preparedStatement.executeQuery();
            List<Long> hotareaIds = new ArrayList<>();
            while (rs.next()) {
                hotareaIds.add(rs.getLong(1));
            }
            monitor.tic("query hotarea id finished");
            String insertHotareaRecord="INSERT INTO zshhj_hotarea_record(hotarea_id,time,state,pic,status,created,creator)" +
                    "VALUES(?,?,?,'//DABY.jpg',1,NOW(),'wangjin18')";
            preparedStatement=c.prepareStatement(insertHotareaRecord,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Random random=new Random();
            random.nextBoolean();
            for(Long hotareaId:hotareaIds){
               boolean qaulified= random.nextBoolean();
                for(int i=0;i<12;i++) {
                    preparedStatement.setLong(1,hotareaId);
                    Timestamp t= new Timestamp(baseTime + i * 5 * 60*1000);
                    preparedStatement.setTimestamp(2, t);
                    if(qaulified==false)
                        preparedStatement.setInt(3,2);
                    else
                        preparedStatement.setInt(3,random.nextInt(2)+1 );
                    preparedStatement.addBatch();
                }
            }
            preparedStatement.executeBatch();
            c.commit();
            c.close();
            monitor.stop();
        }catch (SQLException e){
            Logger.getLogger(HotAreaHistoryMock.class.getName()).log(Level.SEVERE, null,e);
        }
    }




}
