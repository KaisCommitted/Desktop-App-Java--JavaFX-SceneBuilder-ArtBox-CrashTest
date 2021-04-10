/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.entities;


import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


    public class SmsSender {
    

     /**
     */
   // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACa94392349aea6125a4255361cc6322ef";
    public static final String AUTH_TOKEN =
            "88732f5646a78aeab040641fe67c551e";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       Message message = Message 
                .creator(new PhoneNumber("+21624235625"), // to
                        new PhoneNumber("+19724356167"), // from
                       ""+ s)
                .create();
  System.out.println("aslema");
        System.out.println(message.getSid());
    
}
}


