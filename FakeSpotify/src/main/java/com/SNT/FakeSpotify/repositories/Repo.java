package com.SNT.FakeSpotify.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class Repo { 
    private final String url = "jdbc:mysql://localhost:3306/fakespotify";
    private final String user = "root";
    private final String pass = "";
    protected Connection connection;
        
    protected Connection connect(){ 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }  
}