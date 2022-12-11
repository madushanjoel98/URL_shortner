/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.url.dao;

import com.url.controllers.db.DbConnection;
import com.url.model.URLmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author madushan
 */
public class URLs_DAO {

    public  String geturlByUniqueID(String url_id) throws SQLException {
        System.out.println("ID:" + url_id);

        java.sql.Connection conn = null;
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        boolean updator = false;
        ResultSet rs = null;
        String urlid = "";
        PreparedStatement statement = null;

        String query = "SELECT url FROM  url_shortner.urls where unique_id ='" + url_id + "'";

        System.out.println(query);

        try {
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
            // statement.setString(1, name);
            rs = statement.executeQuery(query);

            while (rs.next()) {

                urlid = rs.getString("url");
                System.out.println("*" + urlid);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-*" + urlid);
        return urlid;
    }

    public boolean insertNew(URLmodel uRLmodel,String uniqu) throws Exception {
        Connection conn = null;
        boolean isInserted = false;
        int row = 0;

      
            conn = DbConnection.getConnection();

            boolean updator = false;
            ResultSet rs = null;

            PreparedStatement statement = null;
            int i = 0;
            //id, url, unique_id, add_date
            String query = "INSERT INTO `urls`(`unique_id`,`url`) VALUES (?,?)";

            statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1,uniqu );
            statement.setString(2, uRLmodel.getURL());

            row = statement.executeUpdate();
            if(row>0){
             isInserted = true;
            }
           
        

//         finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//
//                    e.printStackTrace();
//                }
//            }
//        }
        return isInserted;

    }

    public  int geturfl(String url) throws SQLException {
        //System.out.println("ID:"+url_id);
        java.sql.Connection conn = null;
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        boolean updator = false;
        ResultSet rs = null;
        String urlid = "";
        PreparedStatement statement = null;

        String query = "SELECT if(url='" + url + "',true,false) from url_sh";

        try {
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
            // statement.setString(1, name);
            rs = statement.executeQuery(query);

            if (rs.next()) {

                urlid = rs.getString("if(url='" + url + "',true,false)");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (urlid == "") {
            return 0;
        }
        return Integer.parseInt(urlid);
    }

    public  String geturlid(String url) throws SQLException {

        java.sql.Connection conn = null;
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        boolean updator = false;
        ResultSet rs = null;
        String urlid = "";
        PreparedStatement statement = null;

        String query = "SELECT url_id FROM url_sh where url ='" + url + "'";

        System.out.println(query);

        try {
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
            // statement.setString(1, name);
            rs = statement.executeQuery(query);

            while (rs.next()) {

                urlid = rs.getString("url_id");
                System.out.println("*" + url);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-*" + urlid);
        return urlid;
    }
public List<URLmodel> selected_all(){
java.sql.Connection conn = null;
    List<URLmodel> list=new ArrayList<>();
          try {
            conn = DbConnection.getConnection();
       
        boolean updator = false;
        ResultSet rs = null;
        String urlid = "";
        PreparedStatement statement = null;

        String query = "SELECT * FROM url_shortner.urls;";

        System.out.println(query);

     
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
            // statement.setString(1, name);
            rs = statement.executeQuery(query);

            while (rs.next()) {
    URLmodel urls=new URLmodel(rs.getInt("id"), rs.getString("url"), 
            rs.getString("unique_id"), rs.getDate("add_date").toString());
                list.add(urls);
            }
            return  list;
        }
       catch (Exception e) {
            // TODO Auto-generated catch block
           return  null;
        }
        

}
}
