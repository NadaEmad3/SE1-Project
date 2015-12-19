/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author nahla pc
 */
public class CheckInModel 
{
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project [nbuser on Default schema]";

   //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";
    Connection conn = null;
    Statement stmt = null;
    
    public void saveCheckIn()
    {
        try
        {
        stmt = conn.createStatement();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException classNotFoundException) {}
        
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        String sql = "INSERT INTO CheckinPost " + "VALUES ()";
        stmt.executeQuery(sql);
      
        }catch(SQLException se){
        }catch(Exception e){
        }finally{
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){}
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){}
        }  
    }
    public CheckInModel getCheckIn(int id)
    {
        CheckInModel required = null;
        try
        {
        stmt = conn.createStatement();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException classNotFoundException) {}
      
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        
        stmt = conn.createStatement();
        String sql = "SELECT * FROM Checkinpost" + "WHERE PostID = id";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        }catch(SQLException se){
        }catch(Exception e){
        }finally{
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){}// do nothing
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){}//end finally try
        }//end try
        return required;
    }
    public void updateCheckIn()
    {
        
    }
}
