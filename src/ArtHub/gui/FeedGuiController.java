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
    private JFXButton btn_load;
    @FXML
    private JFXButton btn_event;
    
     @FXML
    private GridPane grid;
  @FXML
    private ScrollPane scroll1; 
    private MyListener myListener;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        scroll1.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll1.setVbarPolicy(ScrollBarPolicy.NEVER);
       
        postCRUD ps = new postCRUD();
        List<Post> postes ;
        postes = ps.consulterPost();
       
        if (postes.size() > 0) {
            
             myListener = new MyListener() {
                @Override
                public void onClickListener(Post post) {
                   // setChosenFruit(post);
                }
            };
            //setChosenFruit(postes.get(0));
            
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < postes.size(); i++) {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PostG.fxml"));
                
                AnchorPane PostBox = fxmlLoader.load();
                System.out.println("check 1 ");
                PostGController postController = fxmlLoader.getController();
                
                postController.setData(postes.get(i));
                grid.getChildren().add(PostBox);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(PostBox, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(PostBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
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
    
    
    
    

    @FXML
    public void affiche(URL location, ResourceBundle resources) {
       
         
    }

    
    

    

   
    
}

