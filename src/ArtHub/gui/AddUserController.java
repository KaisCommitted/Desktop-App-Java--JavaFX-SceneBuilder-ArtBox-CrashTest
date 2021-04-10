/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.User;
import ArtHub.services.UserCRUD;
import ArtHub.tools.MailSend;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import javax.mail.Session;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Date;
import java.time.LocalDate;
import javafx.event.EventHandler;
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnSignup.setOnAction((ActionEvent event) -> {
            try {
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
                
                User u = new User(rNom, rPrenom, rUsername, rMail, rDatenaiss, rPwd, rRef_admin);
                UserCRUD usrc = new UserCRUD();
                usrc.ajouterUser(u);
                
                MailSend m = new MailSend();
                String subject = "Sign Up Confirmation";
                String message = "Welcome to ArtBox.";
                
                
                m.sendMail("0artbox1@gmail.com", rMail, subject, message);
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

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
