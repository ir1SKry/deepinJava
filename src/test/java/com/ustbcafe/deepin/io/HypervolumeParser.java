package com.ustbcafe.deepin.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/11/3.
 */
public class HypervolumeParser {
          @Test
          public void parse(){
              String path="F:/Data mini/";
              String algorithmFile="RVEAa_hvigd(WFG9 MaF15).txt";
              File file=new File(path+algorithmFile);
              String algorithmName;
              String problemName;
              String M;
              String nPath;
              File nFile;
              String nFileName;
              if(file.exists()){
                  try {
                      Scanner in = new Scanner(new FileInputStream(file));
                      while(in.hasNext()){
                          String content=in.nextLine();
                          while((content==null||content.trim().length()==0)&&in.hasNext())
                              content=in.nextLine();
                          String[] args= content.split(",");
                          algorithmName=args[0];
                          problemName=args[1];
                          M=args[2];
                          // skip line
                          content=in.nextLine();
                          if(!content.trim().equals("HV:")){
                              System.out.println(content);
                              throw new RuntimeException("there are somethings wrong!");
                          }
                          content=in.nextLine();
                          args=content.split("\r\t");
                          int len=args.length;
                          nPath=path+"/"+algorithmName.trim()+"/";
                          nFileName=nPath+problemName.trim()+"_"+M.trim().substring(2,M.trim().length()-1)+".txt";
                          nFile=new File(nFileName);
                          if(!nFile.exists()){
                              nFile.createNewFile();
                              FileOutputStream os=  new FileOutputStream(nFile);
                              os.write(content.getBytes());os.flush();
                          }else{
                              System.out.println("ignore:"+nFileName);
                          }
                          //System.out.println(Arrays.toString(args));
                          in.nextLine();
                          in.nextLine();
                          in.nextLine();
                          in.nextLine();
                          in.nextLine();
                          in.nextLine();
                      }
                  }catch (FileNotFoundException e){
                      e.printStackTrace();
                  }catch (IOException e){
                      e.printStackTrace();
                  }
              }else{
                  System.out.println(algorithmFile+" not found!");
              }

          }
}
