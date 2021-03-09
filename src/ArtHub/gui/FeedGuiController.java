/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
//import java.time.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;


import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */







public class FeedGuiController implements Initializable {

    
    @FXML
    private JFXButton cp_btn;
     @FXML
    private AnchorPane anchorRoot;
      
     @FXML
    private StackPane parentContainer;


      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void load_ajoute(ActionEvent event ) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("Ajout_post.fxml"));
      Scene scene = cp_btn.getScene();
      
      root.translateXProperty().set(scene.getHeight());
      parentContainer.getChildren().add(root);
      
           
      
      
      
      Timeline timeline = new Timeline();
      KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
      KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
      timeline.getKeyFrames().add(kf);
       
      timeline.play(); 
        //parentContainer.getChildren().remove(anchorRoot);
      
      
      
      
      
  
        
    }

   
    
}

