/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.User;
import ArtHub.services.UserCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author louay
 */
public class AddUserController implements Initializable {

    @FXML
    private JFXTextField tNom;
    @FXML
    private JFXTextField tPrenom;
    @FXML
    private JFXTextField tUsername;
    @FXML
    private JFXTextField tMail;
    @FXML
    private JFXTextField tRef_admin;
    @FXML
    private JFXDatePicker tDatenaiss;
    @FXML
    private JFXPasswordField tPwd;
    @FXML
    private JFXButton btnSignup;

       
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
    @FXML
    private void addUser(ActionEvent event) {
    
        
     
        try{
               System.out.println("Pressed");
        //AjouterUser
        String rNom = tNom.getText();
        String rPrenom = tPrenom.getText();
        String rUsername = tUsername.getText();
        String rMail = tMail.getText();
        LocalDate auxDatenaiss = tDatenaiss.getValue();
        Date rDatenaiss = Date.valueOf(auxDatenaiss);
        String rPwd = tPwd.getText();
        String rRef_admin = tRef_admin.getText();

        
        User u = new User(rNom,rPrenom,rUsername,rMail,rDatenaiss,rPwd,rRef_admin);
        UserCRUD usrc = new UserCRUD();
        usrc.ajouterUser(u);
        
        final String fromEmail = "0artbox1@gmail.com"; //requires valid gmail id
		final String password = "CrashTest01"; // correct password for gmail id
		final String toEmail = rMail; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

	        EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

	
        
    
           }catch (Exception ex) {
        Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
           }}

    @FXML
    private void addUser(KeyEvent event) {
    }

    private static class EmailUtil {

        private static void sendEmail(Session session, String toEmail, String sslEmail_Testing_Subject, String sslEmail_Testing_Body) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void sendAttachmentEmail(Session session, String toEmail, String sslEmail_Testing_Subject_with_Attachment, String sslEmail_Testing_Body_with_Attachment) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void sendImageEmail(Session session, String toEmail, String sslEmail_Testing_Subject_with_Image, String sslEmail_Testing_Body_with_Image) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public EmailUtil() {
        }
    }
}
