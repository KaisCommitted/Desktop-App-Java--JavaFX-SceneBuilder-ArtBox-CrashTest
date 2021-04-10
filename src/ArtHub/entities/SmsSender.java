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
            "AC387bd70d04aeec74e4ca8b1850a05092";
    public static final String AUTH_TOKEN =
            "8cb35da3b3ba362b0864f3c7b7217d51";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       Message message = Message 
                .creator(new PhoneNumber("+21624439982"), // to
                        new PhoneNumber("+17708249312"), // from
                       ""+ s)
                .create();
  System.out.println("aslema");
        System.out.println(message.getSid());
    
}
}


