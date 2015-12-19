/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;

/**
 *
 * @author Yara mansour
 */
public class ConversationController extends MessageController {
    static final String USER = "username";
    static final String PASS = "password";
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
    static final String DB_URL = "jdbc:derby://localhost:1527/project [nbuser on Default schema]";
    @Override
    public void sendMessage(String text) throws ClassNotFoundException, SQLException{
        msg.setText(text);
       msg.addNewMessage();
        
    }
    public void nameConversation(String name) throws ClassNotFoundException, SQLException{
        Connection conn ;
        Statement stmt;
        Class<?>forName = Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        String sql;
        sql = "INSERT INTO CONVERSATION (NAME) VALUES ("+name+");";
        ResultSet rs1 = stmt.executeQuery(sql);
    }
    
}
