package com.ustbcafe.deepin;

import java.util.*;

/**
 * Created by Rudy Steiner on 2016/12/29.
 */
public class MapTest {

    public static class StaticInner{

        public StaticInner(){

        }
    }
    public static void main(String[] args){

        Map<String,String> m=new HashMap();
        m.put("rudy","ustb");
        m.put(null,null);
        m.put(null,"jj");
        if(m!=null&&m.size()>0) {
            Set<Map.Entry<String, String>> es = m.entrySet();
            for (Map.Entry<String, String> e : es)
                System.out.println(e.toString());

                Iterator<Map.Entry<String, String>> it = es.iterator();
                while (it.hasNext()) {
                    Map.Entry<String,String> e =  it.next();
                      String k= e.getKey();
                      String v=e.getValue();
                      if(v.equals("jj"))
                          e.setValue("jjmodi");
                    System.out.println(k+":"+v);
                }
        }

        Map<String,String> table=new Hashtable<String, String>();
        try {
            table.put("jj", "rudy");
            table.put("aa", "rudy");
            table.put("rudy", "rudy");
        }catch(Exception e){
            e.printStackTrace();
        }
        Set set=table.entrySet();
        Iterator it=   set.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
                      System.out.println(entry.toString());
        }

    }
}
 class Else{


 }