/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.E_Comment;
import ArtHub.entities.Evenement;
import ArtHub.entities.User;
import static ArtHub.gui.ItemBoxController.id_clicked;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.E_CommentCRUD;
import ArtHub.services.EvenementCRUD;
import ArtHub.services.UserCRUD;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class EventCommentsController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private ImageView ImageEvent;
    E_CommentCRUD cc = new E_CommentCRUD();
    E_Comment c = new E_Comment();
    EvenementCRUD ec = new EvenementCRUD();
    Evenement e = new Evenement();
    UserCRUD uc = new UserCRUD();
    User u = new User();
    @FXML
    private ScrollPane commentScroll;
    @FXML
    private VBox CommentsVBox;
    @FXML
    private TextField content;
    @FXML
    private Button btnComment;
    List <E_Comment> myLst ;
    URL url;
    ResourceBundle rb;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("INIIIIIIIIIIIIIIIIIIIIIIIIIT");
    e= ec.FindEvenement(id_clicked);
        FRONT_EventController.setImage(e.getImage_event(), ImageEvent);
        name.setText(e.getNom_event());
        u = uc.FindUser(e.getId_org().getId_user());
        username.setText("Organized by "+u.getNom());
        commentScroll.setFitToHeight(true);
            commentScroll.setFitToWidth(true);
            commentScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            commentScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      
      myLst = cc.FindComments(id_clicked);
        FillVbox(myLst, CommentsVBox);
        
        
    }    

    @FXML
    private void addComment(ActionEvent E_CommentItem) {
       c.setContent(content.getText());
       c.setId_event(ec.FindEvenement(id_clicked));
       c.setId_user(CurrentUser);
        cc.ajouterE_Comment(c);
        content.clear();
        initialize(url, rb);
        
        
    }
     private void FillVbox(List<E_Comment> myLst, VBox DisplayInMe) {
        CommentsVBox.getChildren().clear();
        for (int i = 0; i < myLst.size(); i++) {

            try {
                        
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("E_CommentItem.fxml"));
                AnchorPane EventBox = fxmlLoader.load();
                E_CommentItemController controller = fxmlLoader.getController();
               controller.setData(myLst.get(i));
                DisplayInMe.getChildren().add(EventBox);
            } catch (IOException ex) {
                Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
      

   
     public void refresh(){initialize(url,rb);}

    @FXML
    private void Reloadui(MouseEvent event) {
        refresh();
    }
    
}
