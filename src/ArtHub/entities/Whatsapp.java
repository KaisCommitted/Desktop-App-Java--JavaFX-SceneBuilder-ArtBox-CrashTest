/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.entities;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 

        /**
 *
 * @author Kais
 */
public class Whatsapp {
    
     // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC989043320961d4e8814d4a98bd2b8a4e"; 
    public static final String AUTH_TOKEN = "8a7dcee8719743232065fa6783fc4516"; 
 public static void send(String content) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+21654472642"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                ""+content)      
            .create(); 
 
        System.out.println(message.getSid()); 
    } 
    
}
