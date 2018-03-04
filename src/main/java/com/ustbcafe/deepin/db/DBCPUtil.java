package com.ustbcafe.deepin.db;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wangjin18 on 2017/12/13.
 *
 *  建立一个连接池大约花费2s
 */
public class DBCPUtil {
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    static{
              try{
                     FileInputStream is = new FileInputStream("src/main/java/resources/dbcp.properties");
                     properties.load(is);
                   }catch(IOException e){
                       e.printStackTrace();
              }
             try{
                         dataSource = BasicDataSourceFactory.createDataSource(properties);
                  }catch(Exception e){
                         e.printStackTrace();
                     }
             }
            //从连接池中获取一个连接
           public static Connection getConnection() {
               Connection connection = null;
               try {
                   connection = dataSource.getConnection();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               try {
                   connection.setAutoCommit(false);
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               return connection;
           }

    }
