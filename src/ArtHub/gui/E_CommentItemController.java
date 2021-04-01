/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.E_Comment;
import ArtHub.entities.Evenement;
import ArtHub.entities.Rating;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.UserCRUD;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class E_CommentItemController implements Initializable {

    @FXML
    private AnchorPane anchorComment;
    @FXML
    private TextField content;
    @FXML
    private Button btnUser;
    @FXML
    private Label date;
 UserCRUD uc = new UserCRUD();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addComment(ActionEvent event) {
    }
    
     public void setData(E_Comment C) {
         btnUser.setText(uc.FindUser(C.getId_user().getId_user()).getUsername());
         date.setText(C.getCommentDate().toString());
        content.setText(C.getContent());   
     }     
        
        
    
}
