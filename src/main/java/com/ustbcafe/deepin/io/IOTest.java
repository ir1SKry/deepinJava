package com.ustbcafe.deepin.io;

import java.io.*;

/**
 * Created by Rudy Steiner on 2017/2/20.
 */
public class IOTest {

    private final String path;
    public IOTest(String path){
        this.path=path;

    }
    /*
     * use path relative to compiled classes root
     * */
    public DataInputStream readByByte(){

        InputStream in= IOTest.class.getResourceAsStream(path);
        return new DataInputStream(in);

    }
    /*
     *  relative path to project(name) root
     *  Class File use path relative to project root or
     *  absolute file path of system
     *  such as: src/main/java/resources/file/talkmsg.txt
     *  不能处理中文字符
     *
     * */
    public BufferedInputStream bufferStreamRead() throws FileNotFoundException{

        return  new BufferedInputStream(new FileInputStream(this.path));
    }

    public static void main(String[] args){

        String userDir=System.getProperty("user.dir");
        System.out.println(File.separator);
        System.out.println(userDir);
        System.out.println(IOTest.class.getName());
         byte[] bytes=new byte[100];
        /*
         *  read byte by buffer
         * */
        int temp;
        int len;
        FileInputStream fin=null;
        BufferedInputStream bin=null;
        try {
            fin = new FileInputStream("src/main/java/resources/file/talkmsg.txt");
            bin=new BufferedInputStream(fin);
            while( (temp=bin.read())!=-1) {
                System.out.print((char) temp);


            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if (bin!= null)
                    bin.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


        InputStream in= IOTest.class.getResourceAsStream("/resources/file/talkmsg.txt");
        DataInputStream din=new DataInputStream(in);
        try {
            while((len=din.read(bytes, 0, 10))>0){
               for(int i=0;i<len;i++)
                System.out.println(bytes[i]);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        try(PrintWriter out=new PrintWriter("/aa.txt","UTF-8")){
                    out.print("rudy");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        try {
            if (in != null) {
                in.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        BufferedReader bReader=null;
        in= IOTest.class.getResourceAsStream("/resources/file/talkmsg.txt");
        try {

             bReader=new BufferedReader( new InputStreamReader(in,"UTF-8"));
            String line=null;
            while( (line=bReader.readLine())!=null){
                System.out.println(line);
                System.out.println("split:");
               String[] strs=line.split("|");
                System.out.println(strs.length);
                for(String str:strs)
                      System.out.println(str+":"+str.length()+":"+str.getBytes().length);
            }

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            if (bReader != null) {
                try {
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
