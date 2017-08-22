package com.ustbcafe.deepin.db;

import java.sql.*;

/**
 * Created by Rudy Steiner on 2017/2/20.
 *
 * encoding error lead by class file encoding
 */
public class RDBPool {
    public static void main(String[] args){
        String driver="com.mysql.jdbc.Driver";
       // String url="jdbc:mysql://192.168.195.161:3306/themis?useUnicode=true&amp;characterEncoding=UTF-8 "; //jdbc:mysql://192.168.195.161:3306/themis
        String url="jdbc:mysql://127.0.0.1:3306/jubao?useUnicode=true&amp;characterEncoding=UTF-8";

        String password="123456";//123456,popware_themis
        String user="root";  //root,popware_themis
        try {
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,user,password);
            if(!conn.isClosed()){

                String sql="INSERT INTO `jubao_role`(role_name,role_desc,product_type,dept0_id,dept0_name,dept1_id,dept1_name,created,modified,modified_by,status) " +
                          " VALUES ('服饰采销909', '服饰采销', '2', '2', null, '5', null, '2017-08-04 08:52:25', '2017-08-04 08:52:25', 'qxgf', '1');";
                PreparedStatement stat=conn.prepareStatement(sql);
                int rs =stat.executeUpdate(sql);
                if(rs!=-1){
                    System.out.println("execute ok!");
                }
                conn.close();
               // conn.commit();
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
