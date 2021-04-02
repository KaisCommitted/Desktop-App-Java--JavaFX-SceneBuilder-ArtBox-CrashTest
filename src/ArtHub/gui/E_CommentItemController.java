/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.E_Comment;
import ArtHub.entities.Evenement;
import ArtHub.entities.Rating;
import ArtHub.entities.User;
import static ArtHub.gui.FRONT_EventController.setImage;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.E_CommentCRUD;
import ArtHub.services.UserCRUD;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
 E_CommentCRUD cc = new E_CommentCRUD ();
    @FXML
    private Label username;
    @FXML
    private ImageView pencil;
    @FXML
    private ImageView delete;
    @FXML
    private Button btnUser1;
    URL url;
    ResourceBundle rb;
    @FXML
    private Label id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\pencil.png",pencil);
          setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\delete.png",delete);
    }    

    @FXML
    private void addComment(ActionEvent event) {
    }
    
     public void setData(E_Comment C) {
         
        Long Date = DAYS.between(C.getCommentDate(), LocalDate.now());
       if (Date>365 && Date/365!=1) {date.setText(Date/365+" Years ago");} else if (Date>365 && Date/365==1) {date.setText(Date/365+" Year ago");} else if (Date>30 && Date/30==1) {date.setText(Date/30+" Month ago");}else if (Date>30 && Date/30!=1) {date.setText(Date/30+" Months ago");} else if(Date==1){ date.setText(Date.toString()+" Day ago");} else if(Date>1){ date.setText(Date.toString()+" Days ago");} else{date.setText("Today");} 
      String i=  uc.FindUser(C.getId_user().getId_user()).getUsername();
      int x = uc.FindUser(C.getId_user().getId_user()).getId_user();
       username.setText(i);
        System.out.println("IIIIIIIIIIIIIIII "+i+" CURRRRENT "+CurrentUser.getUsername());
        content.setText(C.getContent());   
    
          id.setText(Integer.toString(C.getId()));
        
        if ( x == CurrentUser.getId_user()) {
           
            delete.setVisible(true);
        pencil.setVisible(true);}
       deselect(content);
     }     
        
        private void deselect(TextField textField) {
    Platform.runLater(() -> {
        if (textField.getText().length() > 0 &&
                textField.selectionProperty().get().getEnd() == 0) {
            deselect(textField);
        }else{
            textField.selectEnd();
            textField.deselect();
        }
    });
}

    @FXML
    private void editComment(MouseEvent event) {
        content.setEditable(true);
        delete.setVisible(false);
        pencil.setVisible(false);
        btnUser1.setVisible(true);
        date.setVisible(false);
    
    }

    @FXML
    private void deleteComment(MouseEvent event) {
       
        E_Comment C = cc.FindUserExistsByID(Integer.parseInt(id.getText()));
        cc.DeleteE_Comment(C);
        initialize(url, rb);
        
    }

    @FXML
    private void UpdateComment(ActionEvent event) {
        Date DateX = Date.valueOf(LocalDate.now());
        cc.UpdateE_Comment(Integer.parseInt(id.getText()), "content", content.getText());
        cc.UpdateE_Comment(Integer.parseInt(id.getText()), "commentDate",DateX );  
        content.setEditable(false);
        delete.setVisible(true);
        pencil.setVisible(true);
        btnUser1.setVisible(false);
        date.setVisible(true);
        
        
      
        
    }

  
}
