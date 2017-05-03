package com.ustbcafe.deepin.algorithms.sort.application;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Rudy Steiner on 2017/3/19.
 */
public class MessageSortAndStatistics {
    private TreeMap<Long,String> messageTreeMap;
    private HashMap<Integer,Integer> frequencyMap;
    private String filePath;
    private int keyColumn;
    private String regex;
    private DateFormat dateFormat;
    public MessageSortAndStatistics(String filePath,int keyColumn,String regex){
        this.messageTreeMap= new TreeMap<>();
        this.frequencyMap=new HashMap<>();
        this.dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.filePath=filePath;
        this.keyColumn=keyColumn;
        this.regex=regex;
    }
    public void  createMessageSortedTree() throws FileNotFoundException{
        InputStream in= new FileInputStream(filePath);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
        if(bufferedReader!=null){
            String line;
            Long key;
            String[] columnArray;
            int id;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    columnArray=line.split(regex);
                    key=dateFormat.parse(columnArray[keyColumn]).getTime();
                    id=Integer.parseInt(columnArray[0].trim());
                    fillMaps(id,key,line);
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }catch (ParseException pe){
                pe.printStackTrace();
            }
        }
    }
    private void  fillMaps(int id,long key,String content){
        if(!frequencyMap.containsKey(id)){
            frequencyMap.put(id,1);
        }else{
            frequencyMap.put(id,frequencyMap.get(id)+1);
        }
        messageTreeMap.put(key,content);
    }
    public void traverse(){
        Iterator<Map.Entry<Long,String>> it=messageTreeMap.entrySet().iterator();
        while(it.hasNext()){
               System.out.println(it.next().getValue());
        }
    }
    public void generalization(){
        Iterator<Map.Entry<Integer,Integer>> it=frequencyMap.entrySet().iterator();
        while(it.hasNext()){
              Map.Entry<Integer,Integer> entry=it.next();
              int key=entry.getKey();
              int value=entry.getValue();
              System.out.println("id:"+key+",发言次数："+value);
        }
    }
}
