package com.example.supplysystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {
    String SQLURL="jdbc:mysql://localhost:3306/supply?useSSL=false";
    String userName="root";
    String password="Dipayan77";

     Connection con=null;
    databaseConnection(){
        try {
            con = DriverManager.getConnection(SQLURL, userName, password);
            if(con!=null){
                System.out.println("connection is successful");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String query){
        ResultSet res=null;
        try {
            Statement statement = con.createStatement();
            res=statement.executeQuery(query);
            return  res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  res;
    }
    public int executeUpdate(String query){
        int res=0;
        try {
            Statement statement = con.createStatement();
            res = statement.executeUpdate(query);
            return  res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  res;
    }
}
