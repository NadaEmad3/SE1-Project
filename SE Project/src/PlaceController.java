/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author nahla pc
 */
public class PlaceController 
{
    static final String JDBC_DRIVER = "apache_derby_net";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project";
    static final String USER = "nbuser";
    static final String PASS = "nbuser";
    Connection conn = null;
    Statement stmt = null;
    
    public ArrayList<PlaceModel> getNearestPlaces()
    {
        ArrayList<PlaceModel> nearestPlaces = new ArrayList<>();
        
        return nearestPlaces;
    }
    public void ratePlace(int rate, int id)
    {
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
        String sql = "UPDATE \"Place\" " + "SET Rate = rate WHERE Place_ID = id";
        stmt.executeUpdate(sql);
      
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
    }
    public void saveCheckIn()
    {
        
    }
   /*
    public void addNewPlace(UserModel user)
    {
        
    }
    */
}
