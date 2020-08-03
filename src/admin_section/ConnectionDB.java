/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_section;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author VAISAL
 */
public class ConnectionDB {
 Connection koneksi=null;
public static Connection koneksiDb(){
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection filekoneksi = DriverManager.getConnection("jdbc:mysql://localhost/market","root","");
        //System.out.println("Connection Success");
        return filekoneksi;
    }
    catch (Exception e){
        //System.out.println("Connection error");
        return null;
    }
}   
}
