/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.User;
import ArtHub.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Button login;
    @FXML
    private Button reinit;
    @FXML
    private Hyperlink signup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Authentification(ActionEvent event) {
        try{
        UserCRUD us = new UserCRUD();
         User usr = new User();
         
         usr.setUsername(tfusername.getText());
         usr.setPwd_user(tfpassword.getText());
         boolean verify = us.Authentifier(usr.getUsername(),usr.getPwd_user());
         boolean verifyAd = false;
         
         int UserID = us.currentUser.getId_user();
                if (verify) {
                try {
                    JOptionPane.showMessageDialog(null, "Welcome to ArtBox " + usr.getUsername() + "!");
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddUser.fxml"));
                    Parent root = loader.load();
                    tfusername.getScene().setRoot(root);
                    
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password " + usr.getUsername()+ "!");
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ReadUser.fxml"));
//                Preferences pref = Preferences.userNodeForPackage(User.class);
//                pref.put("User_id",String.valueOf(UserID));
Parent root = loader.load();
tfusername.getScene().setRoot(root);

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

         
        } catch(SQLException ex){Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @FXML
    private void forgotpwd(ActionEvent event) {
    }

    @FXML
    private void register(ActionEvent event) {
    }
    
}
