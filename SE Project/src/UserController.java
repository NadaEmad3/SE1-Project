
import java.util.Scanner;
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

public class UserController
{
    
    UserModel userModel=new UserModel();
    Scanner in=new Scanner(System.in);
    static final String JDBC_DRIVER = "apache_derby_net";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project";
    static final String USER = "nbuser";
    static final String PASS = "nbuser";
    
   public void login() throws ClassNotFoundException, SQLException
   {
       Statement stmt = null;
       try
       {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException classNotFoundException)
       {
           
       }
       System.out.println("Enter Username: ");
       String Username=in.nextLine();
       System.out.println("Enter Password: ");
       String Password=in.nextLine();
       System.out.println("Connecting to database...");
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
       System.out.println("Creating statement...");
       stmt = conn.createStatement();
       String sql;
       sql = "SELECT \"Username\", \"Password\" FROM \"User\" WHERE \"Username\"= '"+Username+"' ";
       ResultSet rs = stmt.executeQuery(sql);
       String check_pw = "";
       
       if (rs.next()) 
       {
            String s=rs.getString("Username");
            check_pw= rs.getString("Password");
            if (check_pw == null ? Password != null : !check_pw.equals(Password)) 
            {
                System.out.println("Incorrect Password");
            }
            else
            {
                System.out.println("User logged in successfully");
            }
       }
      
       else
       {    
           System.out.println("No such user.");
       }
         
     
         
        rs.close();
        stmt.close();
        conn.close();
        
       
  
   }
   public void signUp() throws SQLException
   {
       System.out.println("Enter Email ");
       String Email=in.nextLine();
       System.out.println("Enter Name ");
       String name=in.nextLine();
       System.out.println("Enter Username ");
       String Username=in.nextLine();
       System.out.println("Enter Password ");
       String Password=in.nextLine();
       System.out.println("Enter Gender ");
       String gender=in.nextLine();
       char Gender=gender.charAt(0);
       System.out.println("Enter Age ");
       int age=in.nextInt();
       in.nextLine();
       System.out.println("Enter User Type (premium) or (normal) ");
       String Type=in.nextLine();
       System.out.println("Answer the following security questions to backup password if forgot it later");
       System.out.println("What is your favorite colour ?");
       String Colour=in.nextLine();
       System.out.println("What is your first pet name ?");
       String petName=in.nextLine();
       System.out.println("What is your birth place ? ");
       String place=in.nextLine();
       
       userModel.addNewUser(Username, name, Password, Type, Email, Gender, age,Colour,petName,place);
   
       
   }
   public void forgetPassword(String Username) throws SQLException
   {
       
       Statement stmt = null;
       try
       {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException classNotFoundException)
       {
           
       }
       Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
       System.out.println("Creating statement...");
       stmt = conn.createStatement();
       String sql;
       sql = "SELECT \"Colour\", \"BirthPlace\", \"PetName\" FROM \"User\" WHERE \"Username\"= '"+Username+"' ";
       ResultSet rs = stmt.executeQuery(sql);
       
       if (rs.next()) 
       {
            
            String answer_colour= rs.getString("Colour");
            String answer_place=rs.getString("BirthPlace");
            String answer_Petname=rs.getString("PetName");
            
            int count =0;
            System.out.println("Answer the following security questions to backup password if forgot it later");
            System.out.println("What is your favorite colour ?");
            String Colour=in.nextLine();
            if (Colour == null ? answer_colour == null : Colour.equals(answer_colour)) 
            {
                System.out.println("Correct answer ");
                count++;
                
            }
            else
            {
                System.out.println("Incorrect answer");
            }
            System.out.println("What is your first pet name ?");
            String petName=in.nextLine();
            if (answer_Petname == null ? petName == null : answer_Petname.equals(petName)) 
            {
                System.out.println("Correct answer ");
                count++;
            }
            else
            {
                System.out.println("Incorrect answer");
            }
            System.out.println("What is your birth place ? ");
            String place=in.nextLine();
            if(place == null ? answer_place == null : place.equals(answer_place))
            {
                System.out.println("Correct answer ");
                count++;

            }
            else
            {
                System.out.println("Incorrect answer");
            }
            
            if (count == 3)
            {
                System.out.println("Enter New password");
                String new_pw=in.nextLine();
                sql = "UPDATE \"User\" SET \"Password\" ='"+new_pw+ "' WHERE \"Username\"= '"+Username+"' ";
                stmt.executeUpdate(sql);
                System.out.println("Password updated successfully !");
                
               
            }
            else
            {
                System.out.println("Questions weren't answered correctly. Try again");
            }
            
       }
      
       else
       {    
           System.out.println("No such user.");
       }
         
     
         
        rs.close();
        stmt.close();
        conn.close();
       
       
       
       
   }
   public void sendFriendRequest()
   {
       
   }
   public void acceptFriendRequest()
   {
       
   }
    
   
   
}
