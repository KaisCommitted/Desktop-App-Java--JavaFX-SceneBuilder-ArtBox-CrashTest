/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Post;
import ArtHub.entities.User;
import ArtHub.entities.interactions;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import static ArtHub.gui.PostGController.highlight;
import ArtHub.services.InteractionsCrud;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Adam khalfaoui
 */
public class mp3Controller implements Initializable {
     Post post;
    boolean firstTime = true;
    @FXML
    private ToggleButton playPause;
    @FXML
    private MediaView player;
    
    @FXML
    private Slider volume;
    @FXML
    private ImageView img;
    private ArrayList<Media> mediaFiles = new ArrayList();
    private int counter = -1;
    @FXML
    private VBox root;
    @FXML
    private ToolBar toolContainer;
    @FXML
    private Label nameLabel;
    @FXML
    private Label descreption;
    @FXML
    private Label idLabel;
    @FXML
    private JFXButton like_btn;
    
     @FXML
    private ImageView imgbtn = new ImageView();
    
    @FXML
    private Label likesLabel;
    String s;
    
    public static int id_post_clicked = 0;
    static int current_post=0;
    
 User CurrentUser = new User(2);
    @FXML
    private JFXButton cmnt_btn;
    @FXML
    private ImageView cmntbtn;
    
    public static int id_post_clicked_mp3 = 0;
    @FXML
    private AnchorPane ItemBox;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
                    

        

    }

    public void setData(Post post) throws FileNotFoundException {
        
        
        nameLabel.setText(post.getNom_post());
        descreption.setText(post.getDescription());
         likesLabel.setText(Integer.toString(post.getLikes()));
         idLabel.setText(Integer.toString(post.getId_post()));
        System.out.println(post.getId_post());
        
        current_post=post.getId_post();
        
       Image image =new Image(new FileInputStream(post.getAlbum_cover()));
       s=post.getFile();
       img.setImage(image);
     
       
       
       
        
       
        Post CurrentPost = new Post(Integer.parseInt(idLabel.getText()));
         interactions p = new interactions(CurrentPost, CurrentUser);      
         InteractionsCrud  ppt = new InteractionsCrud();
         Image image1;
       if (ppt.Checklike(p.getId_user().getId_user(), p.getId_post().getId_post())){
           
           
       try {
           image1 = new Image(new FileInputStream("C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like_selec.png"));
           
           imgbtn.setImage(image1);
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       }
       else{
       
       
        try {
           image1 = new Image(new FileInputStream("C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like_null.png"));
           
           imgbtn.setImage(image1);
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       }
       
       
       
       
       try {
           //String path="file:///C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\gui\\post_pics\\like_selec.png" ;
           
           
           //Image image = new Image("/ArtHub.postpics/heart-69-xxl.png");
           String Empty = userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\cmnt.gif";
           Image image3 =new Image(new FileInputStream(Empty));
           cmntbtn.setImage(image3);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
        
    }
    
    
    
    
    @FXML
    private void playPauseClicked(ActionEvent event)throws IOException {
         
       //
            
                
                Media media = new Media(new File(s).toURI().toString());
                
                MediaPlayer mediaplayer = new MediaPlayer(media);
                mediaplayer.play();
                ++counter;
                player = new MediaView(mediaplayer);
                mediaplayer.setAutoPlay(true);
                player.getMediaPlayer().getMedia().getMetadata().addListener((MapChangeListener.Change<? extends String, ? extends Object> change) -> {
                    if (change.wasAdded()) {
                        if (change.getKey().equals("image")) {
                            Image art = (Image) change.getValueAdded();
                            System.out.println();
                            double artWidth = art.getWidth(), viewWidth = img.getFitWidth();
                            img.setX(200);
                            img.setImage(art);
                            img.setX(200);
                        }
                    }
                });
                volume.valueProperty().addListener((Observable observable) -> {
                    if (volume.isValueChanging()) {
                        System.out.println(volume.getValue());
                        player.getMediaPlayer().setVolume(volume.getValue() / 100);
                    }
                });
                player.getMediaPlayer().setOnEndOfMedia(() -> {
                    playPause.setSelected(false);
                });
                

            
        
            System.out.println("I'm here");
            if (playPause.isSelected()) {
                player.getMediaPlayer().play();
            } else {
                player.getMediaPlayer().pause();
            }
        
    }
    
    
    
    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
    final StringBuilder sb = new StringBuilder(
            input.length() /* also inspired by seh's comment */);
    for(int i = 0; i < input.length(); i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
    return sb.toString();
    }
    
    
    
     @FXML
void like(ActionEvent event) {
        Post CurrentPost = new Post(Integer.parseInt(idLabel.getText())); 
         System.out.println(idLabel.getText());
        interactions p = new interactions(CurrentPost, CurrentUser);
        InteractionsCrud  ppt = new InteractionsCrud();
        String aux = likesLabel.getText();
                aux = stripNonDigits(aux);
         
         
        
        
        if (ppt.Checklike(p.getId_user().getId_user(), p.getId_post().getId_post())){
         ppt.supprimerInteraction(p);
          likesLabel.setText(Integer.toString(Integer.parseInt(aux) -1) );
          
          
           Image image;
       try {
           image = new Image(new FileInputStream("C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like2.gif"));
           
           imgbtn.setImage(image);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
          
        }
        else{
        
        likesLabel.setText(Integer.toString(Integer.parseInt(aux) +1));
        ppt.ajouterInteraction(p);
        
        
        
        Image image;
       try {
           image = new Image(new FileInputStream("C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like.gif"));
           
           imgbtn.setImage(image);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        }
        

    }

    @FXML
    private void Comments(ActionEvent event) {
        
        
         try {
           
            id_post_clicked_mp3= Integer.parseInt(idLabel.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fullmp3.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Host an event");

            stage.setScene(new Scene(root1));

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void effectOn(MouseEvent event) {
        ItemBox.setEffect(null);
    }

    @FXML
    private void effectOff(MouseEvent event) {
          ItemBox.setEffect(highlight);
        ItemBox.setCursor(Cursor.HAND);
    }
        
        
        
        
        
        
    }
    
   
   


