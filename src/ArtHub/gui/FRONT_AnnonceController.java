/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Annonce;
import ArtHub.services.AnnonceCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class FRONT_AnnonceController implements Initializable {

    @FXML
    private StackPane parentContainer1;
    @FXML
    private AnchorPane anchorRoot1;
    @FXML
    private JFXButton Btn_AddEvent;
    @FXML
    private JFXTextField input;
    @FXML
    private Text refresh;
    @FXML
    private JFXButton feed_button;
    @FXML
    private GridPane grid_annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int column = 0;
        int row = 1;
         AnnonceCRUD ps = new AnnonceCRUD();
            List<Annonce> myLst;
           
                myLst = ps.consulterAnnonce();
                grid_annonce.getChildren().clear();
               
               
                    for (int i = 0; i < myLst.size(); i++) {
                        
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("ItemAnnonce.fxml"));
                 AnchorPane AnchorPaneAnnonce = fxmlLoader.load();
                 ItemAnnonceController eventController = fxmlLoader.getController();
                 eventController.setData(myLst.get(i));
                
                 if (column == 3) {
                    column = 0;
                    row++;
                }

                grid_annonce.add(AnchorPaneAnnonce, column++, row); //(child,column,row)
                //set grid_annonce width
                grid_annonce.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid_annonce.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid_annonce.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid_annonce height
                grid_annonce.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid_annonce.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid_annonce.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(AnchorPaneAnnonce, new Insets(10));
             }
             // TODO
             catch (IOException ex) {
                 Logger.getLogger(FRONT_AnnonceController.class.getName()).log(Level.SEVERE, null, ex);
             }
                        
                        
                    }
              
            
    }    

    @FXML
    private void AddEvent(ActionEvent event) {
    }

    @FXML
    private void filterEvent(KeyEvent event) {
    }

    @FXML
    private void refresh(MouseEvent event) {
    }

    @FXML
    private void load_feed(ActionEvent event) {
    }
    
}
