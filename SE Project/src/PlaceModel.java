/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
        
public class PlaceModel
{
    public int id;
    public String name;
    public double rate;
    public int num_of_check_ins;
    public String description;
    static int ID=0;
    
    static final String JDBC_DRIVER = "apache_derby_net";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project";

    static final String USER = "nbuser";
    static final String PASS = "nbuser";
    
    Statement stmt = null;

    
    
    public PlaceModel( String name, double rate, int num_of_check_ins, String description) 
    {
        ID++;
        this.id = ID;
        this.name = name;
        this.rate = rate;
        this.num_of_check_ins = num_of_check_ins;
        this.description = description;
    }
    
    public void savePlace(PlaceModel place) throws SQLException
    {
        
        System.out.println("Connecting to database...");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException classNotFoundException) 
        {}
      
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        
        System.out.println("Inserting records into the table...");
        
        String sql = "INSERT INTO \"Place\" " + "VALUES ("+id+", '"+name+"', '"+description+"',null,null,'place',5,5,5,5)";
        stmt.executeUpdate(sql);
        
        conn.close();
        stmt.close();
        
      
       
        
    }
    public void updatePlace(int id)
    {
        
    }
    
    public void deletePlace(String placeName) throws SQLException
    {
       
       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException classNotFoundException) {}
      
       System.out.println("Connecting to database...");
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
  
        stmt = conn.createStatement();
        String sql = "DELETE FROM \"Place\" " + "WHERE \"Name\" ='"+ placeName+"'";
        stmt.executeUpdate(sql);
        conn.close();
        stmt.close();
      
        
    }
    
    public void getPlace(String placeName) throws SQLException
    {
        
       
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException classNotFoundException) {}
      
         System.out.println("Connecting to database...");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        String sql = "SELECT * FROM \"Place\"" + "WHERE \"Name\" = '"+ placeName+"'";
        ResultSet rs = stmt.executeQuery(sql);
       if (rs.next()) 
       {
            int Id = rs.getInt("Place_ID");
            String Name = rs.getString("Name");
            String Description = rs.getString("Description");
            double Rate = rs.getDouble("Rate");
            System.out.println("Place ID: "+Id);
            System.out.println("Name: "+Name);
            System.out.println("Description: "+Description);
            System.out.println("Rate: "+Rate);
       }
      
       else
       {    
           System.out.println("No such place.");
       }
        
        
        
        
 
        
    }
}
