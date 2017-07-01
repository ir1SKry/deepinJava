package com.ustbcafe.deepin.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ustbcafe.deepin.systems.pojo.LatLonPoint;
import com.ustbcafe.deepin.systems.pojo.LatLonPointWrapper;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rudy Steiner on 2017/5/12.
 */
public class JacksonTest extends TestCase{

    public void  testObjectToJson() throws IOException{
        String id="18611111";
        List<String> list;
        Map<String,List<String>> map=new HashMap<>();
        list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put(id,list);
        LatLonPoint latLonPoint=new LatLonPoint(192.11,36.32);
        Gson gson=new GsonBuilder().create();
        ///String latLonJson=gson.toJson(latLonPoint);

        ObjectMapper jsonMapper=new ObjectMapper();
        jsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //LatLonPoint Ll=new LatLonPoint();
        String latLonJson=jsonMapper.writeValueAsString(latLonPoint);
        //LatLonPoint latLonPointNew=  gson.fromJson(latLonJson,LatLonPoint.class);
        String queueString=jsonMapper.writeValueAsString(map);
        LatLonPoint lp=jsonMapper.readValue(latLonJson,LatLonPoint.class);
        System.out.println(latLonJson);
    }
}
