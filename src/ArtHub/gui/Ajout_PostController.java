/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Post;
import ArtHub.services.postCRUD;
import ArtHub.services.postCRUD;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JFileChooser;


import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javax.swing.filechooser.FileNameExtensionFilter;
//import javafx.scene.control.Tab;


/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */
public class Ajout_PostController implements Initializable {

     @FXML
    private StackPane parentContainer1;

    @FXML
    private AnchorPane anchorRoot1;

     @FXML
    private Button feed_button;
     
      @FXML
    private JFXButton upload_image;
      
       @FXML
    private JFXTextField p_name;

    @FXML
    private JFXTextArea p_desc;
    
     @FXML
    private JFXTabPane pan1;
     
     @FXML
    private JFXTextField image_path;

    
     
    public static String s;
    
    
    public static int tindex;

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    private void load_feed(ActionEvent event ) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("feed gui.fxml"));
      Scene scene = feed_button.getScene();
      
      root.translateXProperty().set(scene.getHeight());
      parentContainer1.getChildren().add(root);
      
           
      
      
      
      Timeline timeline = new Timeline();
      KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
      KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
      timeline.getKeyFrames().add(kf);
       
      timeline.play(); 
        //parentContainer.getChildren().remove(anchorRoot);
     
    }
    
    
     @FXML
    private void image_file(ActionEvent event) {
        
     JFileChooser fileChooser = new JFileChooser();
         
          tindex = pan1.getSelectionModel().getSelectedIndex();
          
          fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
          
          if(tindex==0){
         
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
         fileChooser.addChoosableFileFilter(filter);
          }
          else if(tindex==1){
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.VIDEO", "mp4","mov");
          fileChooser.addChoosableFileFilter(filter);
          }
          else{
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.AUDIO", "mp3","wav");
          fileChooser.addChoosableFileFilter(filter);
          }
         
         
         
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
            s = path;
            
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
         
         tindex = pan1.getSelectionModel().getSelectedIndex();
         
         
     }
    
    
    @FXML
    void create_image(ActionEvent event) throws Exception {
        
            String rNom_post = p_name.getText();
            String rdesc = p_desc.getText();
            Post p = new Post(22,rNom_post,rdesc);
            postCRUD prc = new postCRUD();
            prc.ajouterPost(p);
        
        
        
        

    }
    
    
    
        
    
    
    
   
    
}
