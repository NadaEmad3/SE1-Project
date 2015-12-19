/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.sql.*;

/**
 *
 * @author Yara mansour
 */
public class MessageModel {
    UserModel user;
    ConversationModel conversation;
    String text;
    Date date;
    static int count =0;
    static final String USER = "username";
    static final String PASS = "password";
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project [nbuser on Default schema]";

    public MessageModel()
    {
        count++;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    
    
    public void addNewMessage() throws ClassNotFoundException, SQLException{  
        Connection conn ;
        Statement stmt;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        String sql1 ,sql2;
        sql1 = "INSERT INTO Message (Message_ID, Username, Text,ID) VALUES ("+count+","+user.username+","+text+","+count+");";
        sql2 ="INSERT INTO CONVERSATION (ID) VALUES ("+count+");";
        ResultSet rs1 = stmt.executeQuery(sql1);
        ResultSet rs2 = stmt.executeQuery(sql2);
    }
    public void updateMessage(){
        
    }
    
}
