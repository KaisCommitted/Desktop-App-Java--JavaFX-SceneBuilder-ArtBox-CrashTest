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
        
        
        
    
           }catch (Exception ex) {
        Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
           }}

    @FXML
    private void addUser(KeyEvent event) {
    }
}
