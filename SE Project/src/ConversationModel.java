/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yara mansour
 */
public class ConversationModel extends MessageController{
    
    public void AddNewUser(String name){
        receivedUsers.add(name);
    }
    public void RemoveUser(String name){
        receivedUsers.remove(name);
    }
    
}
