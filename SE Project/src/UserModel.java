

import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nada
 */
public class UserModel 
{
    static final String JDBC_DRIVER = "apache_derby_net";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project";
    static final String USER = "nbuser";
    static final String PASS = "nbuser";


    public UserModel() 
    {
    }

    String username;
    String Name;
    String Password;
    String Type;
    String Email;
    char Gender;
    int Age;
    
    public UserModel(String username,String Name, String Password, String Type, String Email, char Gender, int Age) 
    {
        this.username = username;
        this.Name = Name; 
        this.Password = Password;
        this.Type = Type;
        this.Email = Email;
        this.Gender = Gender;
        this.Age = Age;
    }

    public void addNewUser(String username,String Name ,String Password, String UserType, String Email, char Gender, int Age,String Colour,String petName,String place) throws SQLException
    {
       Statement stmt = null;
       try
       {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException classNotFoundException)
       {
           
       }
       System.out.println("Connecting to database...");
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
       stmt = conn.createStatement();
       String sql;
       sql = "SELECT \"Username\" FROM \"User\" WHERE \"Username\"= '"+username+"' ";
       ResultSet rs = stmt.executeQuery(sql);
       
       if (rs.next()) 
       {
           System.out.println("Username already exists, Try another one");
           
       }
       else
       {    
           System.out.println("User created successfully");
           sql="INSERT INTO \"User\" "+ "VALUES "+"('"+username+"','"+Name+"','"+Email+"','"+Password+"','"+Gender+"','"+UserType+"',"+Age+",'"+Colour+"',"+"'"+place+"',"+"'"+petName+"'"+")";
           stmt.executeUpdate(sql);
       }
       
       rs.close();
       stmt.close();
       conn.close();

        
    }
    
    public void getUser(String Username) throws SQLException
    {
       Statement stmt = null;
       try
       {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException classNotFoundException)
       {
           
       }
       System.out.println("Connecting to database...");
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
       stmt = conn.createStatement();
       
       String sql;
       sql = "SELECT \"Name\",\"Email\",\"Password\",\"Gender\",\"UserType\",\"Age\" FROM \"User\" WHERE \"Username\"= '"+Username+"' ";
       ResultSet rs = stmt.executeQuery(sql);
       
       if (rs.next()) 
       {
            String name = rs.getString("Name");
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            String UserType = rs.getString("UserType");
            int age = rs.getInt("Age");
            
            System.out.println("Name : "+name);
            System.out.println("Email : "+email);
            System.out.println("Password : "+password);
            System.out.println("Gender : "+gender);
            System.out.println("User Type : "+UserType);
            System.out.println("Age : "+age);
            
            
       }
      
       else
       {    
           System.out.println("No such user.");
       }
       rs.close();
       stmt.close();
       conn.close();

    }
    
    public void DeleteUser(String Username) throws SQLException
    {
        Statement stmt = null;
       try
       {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException classNotFoundException)
       {
           
       }
       System.out.println("Connecting to database...");
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
       stmt = conn.createStatement();
       
       String sql;
       sql="DELETE FROM \"User\" WHERE \"Username\"= '"+Username+"'";
       stmt.executeUpdate(sql);
       
       stmt.close();
       conn.close();
       
       
    }
    
    public void UpdateUser() throws SQLException
    {
        
    }
    
}
