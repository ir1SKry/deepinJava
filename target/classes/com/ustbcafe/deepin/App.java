package com.ustbcafe.deepin;




import com.sun.xml.internal.fastinfoset.algorithm.IntegerEncodingAlgorithm;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;


import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException,ArithmeticException
    {
      /**
       *  override and hide
       **/

        Sub sub=new Sub();
        Super sup=sub;
        System.out.println("sub class:"+sub.greeting()+","+sub.name()+","+sub.a);
        System.out.println("super class:"+sup.greeting()+","+sup.name()+","+sup.a);

      /*
      *  String replace
      * */
       String name=new String("rudyr");
       String name1=name;
        name1=name1.replace('r','j');
        CharSequence name1cs=name1;
        System.out.println(name+","+name1);
        System.out.println(name1cs);

        //字符串拼接,频繁操作
        String strCons="dfueye";
        String str1=new String(strCons);
        String str2=new String("jklmn");

        String str11=new String("DfuEye");
        StringBuilder buider=new StringBuilder(str1);
        buider.append(str2);
        System.out.println(buider+","+buider.length()+","+buider.capacity());
        String concatenation=buider.toString();
        char[] chars=concatenation.toCharArray();

        System.out.println(concatenation+","+chars.length+"char at 3:"+concatenation.charAt(3));

        System.out.println(concatenation.codePointAt(3)+"compare str1 and str11:"+str1.compareTo(str11));
        System.out.println("code point:"+str1.codePointAt(0)+","+str11.codePointAt(0)+"compare str1 and str11:"+str1.compareTo(str11));
        System.out.println("code point:"+str1.codePointAt(0)+","+str11.codePointAt(0)+"compare str1 and str11:"+str1.compareToIgnoreCase(str11));
        concatenation=concatenation.concat("julia");
        System.out.println(concatenation);
        System.out.println(concatenation.contains("julia"));
        Logger log= Logger.getLogger("com.ustbafe.app");
        log.setLevel(Level.ALL);
        log.info("haha");
        log.info(strCons.hashCode()+",hashcode,"+str1.hashCode());
        log.info("code point at str1 0:"+Integer.toString(str1.codePointAt(0)));
        log.info("str1 class name:"+str1.getClass().getName()+",str1 supper class "+str1.getClass().getSuperclass().toString());
        // 从类的实例获得类名称，包名
        log.info(str1.getClass().getPackage().toString());

        //通过类获得类修饰符
        log.info("class modifier of str1:"+Modifier.toString(str1.getClass().getModifiers()));

        //通过类获得类实现的接口
        for(Class cls:str1.getClass().getInterfaces())
                  log.info(cls.toString());
        //类名获得包名
        log.info(App.class.getPackage().toString());

        int i=3;
        byte iii=0x18;
        int ii=0x00000010;
        log.info("iii:"+Byte.toString(iii));
        log.info(String.valueOf(ii));
        byte j=3;
        char ch='a';

       /*
        *  date format
        *
        *
        * */
        SimpleDateFormat sDF=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formatDate=sDF.format(new Date(103,10,1,9,29));
        log.info(formatDate);

        Formatter fm;
        DateFormat df;
        Calendar cl=Calendar.getInstance();
        cl.setTimeInMillis((691207200000l-24*60*60*1000));

        formatDate=sDF.format(cl.getTime());
        log.info(formatDate);
        log.info( String.valueOf(cl.get(Calendar.DAY_OF_MONTH)));
        log.info( String.valueOf(cl.get(Calendar.MONTH)));
        log.info( String.valueOf(cl.get(Calendar.YEAR)));
        new Date();
        // Calendar cl2=new Calendar.Builder().setCalendarType("iso8061").setFields(Calendar.YEAR,21, Calendar.MONTH,11, Calendar.DAY_OF_MONTH,21).build();
        /*
         * expression
         * */
        try {
            IOException e = new IOException("File not found");
            throw e;
        }catch(IOException e){
            e.printStackTrace();
        }
        int b=-8;
        int c=2;
         b=b>>2;
        byte d=0x71;
        log.info(Byte.toString(d));
        log.info(Integer.toString(b));
        b=b^c;
        log.info(Integer.toString(b));
        /**
         * @param
         *
         */
        List list=new LinkedList<String>();
        list.add(null);
        System.out.println("list size:"+list.size());

        System.out.println(list.toArray());
        String a="00";
        char  one='1';
        int a0= (int)a.charAt(0);
        int sum=(int)a.charAt(0)+(int)a.charAt(1);
        // 访问具有包package权限内部类
//          Outer outer= new Outer();
//          Outer.Inner inner=outer.new Inner();
//          inner.f();
         ArrayList<String> arrayList=new ArrayList();
         arrayList.add(new String("abcde"));
         arrayList.add(new String("abcdefeg"));
         arrayList.add(new String("abcde"));
//        for(String str:arrayList){
//            System.out.println(str);
//        }
        Iterator<String> it=arrayList.iterator();
        while(it.hasNext()){
        //for and remove
            String e=it.next();
            if(e.equals("abcde")) {
                it.remove();
            }
            System.out.println(e);
        }
        // Array List 增加

        arrayList.add(1,"jj");
//        arrayList.remove(0);
//        arrayList.remove("abcde");
        System.out.println("----removed ----");
        for(String str:arrayList){
            System.out.println(str);
        }
        arrayList.contains("abcde");

        Map<String,String> map=new HashMap<String, String>();
        map.put("a","a");
        map.put("b","b");
        //map.put(new Long(12),"12");
        Set<Map.Entry<String,String>>  entrySet=map.entrySet();
        for(Map.Entry<String,String> entry:entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());


        }
        Charset cset= Charset.forName("ISO-8859-1");
//               for(String name:cset.keySet())
        System.out.println("working dir:"+System.getProperty("user.dir"));



    }
}
