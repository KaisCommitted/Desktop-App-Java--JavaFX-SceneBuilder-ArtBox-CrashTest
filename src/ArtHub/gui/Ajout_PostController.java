/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Post;
import ArtHub.entities.User;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.postCRUD;
import ArtHub.services.postCRUD;
import SentimentAnalysis.SentimentAPI;
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
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.ws.spi.http.HttpContext;


import sun.net.www.http.HttpClient;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    private JFXButton btn_event;

    
     
    public static String s;
    public static String s1;
    
    
    public static int tindex;

    
    
    @FXML
    private JFXButton create_image;
    @FXML
    private JFXTextField video_name;
    @FXML
    private JFXButton create_video;
    @FXML
    private JFXTextArea video_desc;
    @FXML
    private JFXButton upload_image1;
    @FXML
    private JFXButton create_image11;
    @FXML
    private JFXButton upload_image11;
    @FXML
    private JFXTextField song_name;
    @FXML
    private JFXTextArea song_desc;
    @FXML
    private JFXButton upload_cover;
    
    
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
             File src = new File(selectedFile.getPath());
             File dest = new File("C:/xampp/php/www/pidev/Postes/");
             java.nio.file.Path sr = src.toPath();
            java.nio.file.Path ds = new File(dest, src.getName()).toPath();
            File newDes = new File("C:/xampp/php/www/pidev/Postes/" + selectedFile.getName());
            selectedFile.renameTo(newDes);
            s = "C:/xampp/php/www/pidev/Postes/" + selectedFile.getName().toString();
            
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
         
         tindex = pan1.getSelectionModel().getSelectedIndex();
         
         
     }
    
    @FXML
    private void cover_file(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
            s1 = path;
            
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
        
    }
    
    
    
    
    
    @FXML
    void create_image(ActionEvent event) throws Exception {
        
        String resp=null;
         try{
            resp = SentimentAPI.GetSentiment(p_desc.getText());
            
            
        }catch(IOException ex){
            System.out.println("Check the bugs in the Sent API on Azure");
        }
        
            String rNom_post = p_name.getText();
            String rdesc = p_desc.getText();
            User id_user = CurrentUser;
            String desc_analys= resp;
            
            
            
            
            Post p = new Post(id_user,rNom_post,rdesc,desc_analys);
            postCRUD prc = new postCRUD();
            prc.ajouterImage(p);
            
            
            
          String title = "Congratulations";
        String message = "You've successfully created your post";
        //Notification notification = Notifications.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        
        
        

    }
    
    
    @FXML
    void create_video(ActionEvent event) throws Exception {
        
        String resp=null;
         try{
            resp = SentimentAPI.GetSentiment(video_desc.getText());
            
            
        }catch(IOException ex){
            System.out.println("Check the bugs in the Sent API on Azure");
        }
        
        
        
            String rNom_post = video_name.getText();
            String rdesc = video_desc.getText();
            User id_user = CurrentUser;
            String desc_analys= resp;
            Post p = new Post(id_user,rNom_post,rdesc,desc_analys);
            postCRUD prc = new postCRUD();
            prc.ajouterVideo(p);
        
            
             String title = "Congratulations";
        String message = "You've successfully created your post";
        //Notification notification = Notifications.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        
        
        

    }
    
    
    @FXML
    void create_music(ActionEvent event) throws Exception {
        
        
        
        
        String resp=null;
         try{
            resp = SentimentAPI.GetSentiment(song_desc.getText());
            
            
        }catch(IOException ex){
            System.out.println("Check the bugs in the Sent API on Azure");
        }
        
        
        
            String rNom_post = song_name.getText();
            String rdesc = song_desc.getText();
            User id_user = CurrentUser;
            String desc_analys= resp;
            
            
            
            
            
            Post p = new Post(id_user,rNom_post,rdesc,desc_analys);
            postCRUD prc = new postCRUD();

            prc.ajouterMusic(p);
        
        
        
         String title = "Congratulations";
        String message = "You've successfully created your post";
        //Notification notification = Notifications.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));


    }
    
    
    
    
    
    @FXML
    void load_event(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FRONT_Event.fxml"));
      Scene scene = btn_event.getScene();
      
      root.translateXProperty().set(scene.getHeight());
      parentContainer1.getChildren().add(root);
      
           
      
      
      
      Timeline timeline = new Timeline();
      KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
      KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
      timeline.getKeyFrames().add(kf);
       
      timeline.play(); 
        //parentContainer.getChildren().remove(anchorRoot);
        
        
        

    }

    
    
    static long download(String sourceUrl, String targetFileName) throws Exception {
    try (InputStream in = URI.create(sourceUrl).toURL().openStream()) {
        return Files.copy(in, Paths.get(targetFileName));
    }
}
    
   
    
    
        
    
    
    
   
    
}
