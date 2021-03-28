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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class FRONT_AnnonceController implements Initializable {

    @FXML
    private StackPane parentContainer1;
    @FXML
    private JFXButton Btn_AddEvent;
    @FXML
    private JFXTextField input;
    @FXML
    private JFXButton feed_button;
    @FXML
    private GridPane grid_annonce;
    @FXML
    private ImageView BtnClose;
    @FXML
    private AnchorPane addFeedback3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Notifications notificationBuilder = Notifications.create()
               .title("Job offer added successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       
                       System.out.println("clicked ON ");
               }}); 
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
        Notifications notificationBuilder = Notifications.create()
               .title("Job offer added successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       
                       System.out.println("clicked ON ");
               }}); 
        
    }

    @FXML
    private void filterEvent(KeyEvent event) {
    }


    @FXML
    private void load_feed(ActionEvent event) {
    }

    @FXML
    private void offEffectSearch(MouseEvent event) {
    }

    @FXML
    private void onEffectSearch(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
        Stage CurrentStage = (Stage) BtnClose.getScene().getWindow();
        CurrentStage.close();
    }

    @FXML
    private void AddFeedback(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddFeedback.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Statistiques");
            
            stage.setScene(new Scene(root1));
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
