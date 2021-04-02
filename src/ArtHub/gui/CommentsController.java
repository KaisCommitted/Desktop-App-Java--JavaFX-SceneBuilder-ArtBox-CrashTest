/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Comment;
import ArtHub.services.UserCRUD;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */
public class CommentsController implements Initializable {

    @FXML
    private Label cmnt;
    @FXML
    private Label time_cmnt;
    @FXML
    private Label user_cmnt;
    
    UserCRUD uc = new UserCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setData(Comment C){
         //user_cmnt.setText(uc.FindUser(C.getId_user().getId_user()).getUsername());
         time_cmnt.setText(C.getDate_comment());
         cmnt.setText(C.getComment());   
     }     
    
    
    
    
    
}
