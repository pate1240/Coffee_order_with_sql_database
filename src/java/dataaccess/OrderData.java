/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author mohit
 */
public class OrderData {
    private PreparedStatement stmt;
    private Connection con;
    public OrderData() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","Mohit@123");
    }
    
    public void addToDatabase(String coffe,String Size,String creamss,String sug,int priceC){
    try{
            String sql="INSERT INTO orders (coffee,size,cream,sugar,price) VALUES (?,?,?,?,?)";
            stmt= con.prepareStatement(sql);
            stmt.setString(1,coffe);
            stmt.setString(2,Size);
            stmt.setInt(3,Integer.parseInt(creamss));
            stmt.setInt(4,Integer.parseInt(sug));
            stmt.setDouble(5,Double.parseDouble(""+priceC));
            stmt.executeUpdate();
                   
        }catch(Exception e){
            System.out.println(e);
        }
}
}