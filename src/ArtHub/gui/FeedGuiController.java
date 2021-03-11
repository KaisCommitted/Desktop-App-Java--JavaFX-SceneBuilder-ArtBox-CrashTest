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
import ArtHub.entities.Post;
import ArtHub.services.postCRUD;
import java.util.List;
import ArtHub.gui.MyListener;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import ArtHub.gui.MyListener;
import static java.time.Clock.system;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


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
    @FXML
    private JFXButton btn_event;
    
    
    @FXML
    private ScrollPane scroll1;
    @FXML
    private HBox ph_postes;

  
  
    private MyListener myListener;
    @FXML
    private HBox music_postes;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load poste de type image *******************
         
        ph_postes.setSpacing(20);
        scroll1.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll1.setVbarPolicy(ScrollBarPolicy.NEVER);
       
        postCRUD ps = new postCRUD();
        List<Post> postes ;
        postes = ps.consulteImage();
        
        try {
            for (int i = 0; i < postes.size(); i++) {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PostG.fxml"));
                AnchorPane PostBox = fxmlLoader.load();
                PostGController postController = fxmlLoader.getController();
                postController.setData(postes.get(i));
                ph_postes.getChildren().add(PostBox);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      
        // TODO
        
        //Load poste de type music*************************
        
        
        ph_postes.setSpacing(20);
        
        music_postes.setSpacing(20);
       
        postCRUD ps1 = new postCRUD();
        List<Post> postes1  ;
        postes1 = ps1.consulteMusic();
        
        
        try {
            for (int j = 0; j < postes1.size(); j++) {
              
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("mp3.fxml"));
                
                AnchorPane MusicBox = fxmlLoader1.load();
                System.out.println("heeeeeeeeeere");
                mp3Controller mp3Controller = fxmlLoader1.getController();
                mp3Controller.setData(postes1.get(j));
                music_postes.getChildren().add(MusicBox);
                
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
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

    @FXML
    private void load_event(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FRONT_Event.fxml"));
      Scene scene = btn_event.getScene();
      
      root.translateXProperty().set(scene.getHeight());
      parentContainer.getChildren().add(root);
      
           
      
      
      
      Timeline timeline = new Timeline();
      KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
      KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
      timeline.getKeyFrames().add(kf);
       
      timeline.play(); 
        //parentContainer.getChildren().remove(anchorRoot);
      
      
      
      
      
  
        
    }
    
    
    
    

    public void affiche(URL location, ResourceBundle resources) {
       
         
    }

    
    

    

   
    
}

