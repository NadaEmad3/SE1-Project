/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yara mansour
 */
public class MessageController {
    ArrayList<String> receivedUsers ;
    MessageModel msg;
    public void sendMessage(String text) throws ClassNotFoundException, SQLException{
       msg.setText(text);
       msg.addNewMessage();
    }
    public void addReceiver(String name){
           
    }
    
}
