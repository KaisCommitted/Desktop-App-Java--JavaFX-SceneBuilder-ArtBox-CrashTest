/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Post;
import ArtHub.entities.User;
import ArtHub.entities.interactions;
import ArtHub.services.InteractionsCrud;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    private Label likesLabel;
    String s;
    
 User CurrentUser = new User(2);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
                    System.out.println("Rani dkhalet 7 ");

        

    }

    public void setData(Post post) throws FileNotFoundException {
        
        
        nameLabel.setText(post.getNom_post());
        descreption.setText(post.getDescription());
         likesLabel.setText(Integer.toString(post.getLikes()));
         idLabel.setText(Integer.toString(post.getId_post()));
        System.out.println(post.getId_post());
        
       Image image =new Image(new FileInputStream(post.getAlbum_cover()));
       s=post.getFile();
       img.setImage(image);
     
        
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
        }
        else{
        
        likesLabel.setText(Integer.toString(Integer.parseInt(aux) +1));
        ppt.ajouterInteraction(p);
        }
        

    }
    
   


}
