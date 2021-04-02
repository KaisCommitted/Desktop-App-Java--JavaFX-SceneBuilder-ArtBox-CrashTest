/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Comment;
import ArtHub.entities.Post;
import ArtHub.entities.User;
import ArtHub.entities.interactions;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import static ArtHub.gui.LoginController.CurrentUser;
import static ArtHub.gui.PostGController.id_post_clicked;
import static ArtHub.gui.PostGController.stripNonDigits;
import static ArtHub.gui.mp3Controller.id_post_clicked_mp3;
import ArtHub.services.InteractionsCrud;
import ArtHub.services.UserCRUD;
import ArtHub.services.postCRUD;
import SentimentAnalysis.SentimentAPI;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import javafx.beans.Observable;
import javafx.collections.MapChangeListener;

/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */
public class FullMP3Controller implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label nameLabel;
    @FXML
    private Label descreption;
    @FXML
    private JFXButton like_btn;
    @FXML
    private ImageView imgbtn;
    @FXML
    private Label likesLabel;
    @FXML
    private Label idLabel;
    @FXML
    private JFXTextField new_cmnt;
    @FXML
    private JFXButton btn_cmnt;
    @FXML
    private ImageView img_cmnt;
    @FXML
    private VBox CommentsVBox;
    List <Comment> myLst ;
     
    AnchorPane EventBox;
    int idPost;
    @FXML
    private ToolBar toolContainer;
    @FXML
    private ToggleButton playPause;
    @FXML
    private Slider volume;
    
    private int counter = -1;
    String s;
    @FXML
    private MediaView player;
    @FXML
    private Label user_name;
    User u = new User();
    Comment c = new Comment();
    UserCRUD uc = new UserCRUD();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            postCRUD pc = new postCRUD();
            Post p = new Post();
            p = pc.FindPostmusic(id_post_clicked_mp3);
            setData(p);
             u = uc.FindUser(p.getId_user().getId_user());
        user_name.setText(u.getNom());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FullPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idPost=id_post_clicked_mp3;
       
       FillVbox(myLst,CommentsVBox); 
    }
    
    
    private void FillVbox(List<Comment> myLst, VBox DisplayInMe) {
        postCRUD cm = new postCRUD();
        List<Comment> comments ;
        comments = cm.Findcomment(id_post_clicked_mp3);
       
        //System.err.println(id_post_clicked_mp3);
        
        
        try {
            for (int i = 0; i < comments.size(); i++) {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("comments.fxml"));
                AnchorPane Commentbox = fxmlLoader.load();
                CommentsController commentController = fxmlLoader.getController();
                commentController.setData(comments.get(i));
                CommentsVBox.getChildren().add(Commentbox);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
          CommentsVBox.setSpacing(20);
          CommentsVBox.setAlignment(Pos.CENTER);
        

    }
    
    
    
    
    
    


public void setData(Post post) throws FileNotFoundException {
        
        
        nameLabel.setText(post.getNom_post());
        descreption.setText(post.getDescription());
         likesLabel.setText(Integer.toString(post.getLikes()));
         idLabel.setText(Integer.toString(post.getId_post()));
         
       //System.out.println(post.getId_post());
       
     Image image =new Image(new FileInputStream(post.getAlbum_cover())); 
     img.setImage(image);
      
      
      
     s=post.getFile();
       
      
      
      
      
      // set a clip to apply rounded border to the original image.
            Rectangle clip = new Rectangle(img.getFitWidth(), img.getFitHeight()
);
            clip.setArcWidth(30);
            clip.setArcHeight(30);
            img.setClip(clip);

            // snapshot the rounded image.
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            WritableImage imag = img.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            img.setClip(null);

            // apply a shadow effect.
            img.setEffect(new DropShadow(20, Color.BLACK));

            img.setImage(imag);
           
      
      Post CurrentPost = new Post(Integer.parseInt(idLabel.getText()));
         interactions p = new interactions(CurrentPost, CurrentUser);      
         InteractionsCrud  ppt = new InteractionsCrud();
         Image image1;
       if (ppt.Checklike(p.getId_user().getId_user(), p.getId_post().getId_post())){
           
           
       try {
           image1 = new Image(new FileInputStream(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like_selec.png"));
           
           imgbtn.setImage(image1);
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       }
       else{
       
       
        try {
           image1 = new Image(new FileInputStream(userHomeFolder+ "\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like_null.png"));
           
           imgbtn.setImage(image1);
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       }
      
        
      
        
    }

   
    

    @FXML
    private void like(ActionEvent event) {
        
        
        Post CurrentPost = new Post(Integer.parseInt(idLabel.getText()));   
        interactions p = new interactions(CurrentPost, CurrentUser);
        InteractionsCrud  ppt = new InteractionsCrud();
        String aux = likesLabel.getText();
                aux = stripNonDigits(aux);
         
         
        
        
        if (ppt.Checklike(p.getId_user().getId_user(), p.getId_post().getId_post())){
         ppt.supprimerInteraction(p);
         
         likesLabel.setText(Integer.toString(Integer.parseInt(aux) -1));
           Image image;
       try {
           image = new Image(new FileInputStream(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like2.gif"));
           
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
           image = new Image(new FileInputStream(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\like.gif"));
           
           imgbtn.setImage(image);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        }
        
    }

    
    

    @FXML
    private void Add_comment(ActionEvent event) {
        
        
         try {
             
             
             Post CurrentPost = new Post(Integer.parseInt(idLabel.getText()));
             
             
             Image image3;
             try {
                 image3 = new Image(new FileInputStream(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\post_pics\\comment.gif"));
                 
                 img_cmnt.setImage(image3);
                 
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             
             
             String resp=null;
             try{
                 resp = SentimentAPI.GetSentiment(new_cmnt.getText());
                 
                 
             }catch(IOException ex){
                 System.out.println("Check the bugs in the Sent API on Azure");
             }
             
             
             
             User id_user = CurrentUser;
             String comment = new_cmnt.getText();
             String comment_analys= resp;
             
             Comment c = new Comment(CurrentPost,id_user,comment,comment_analys);
             postCRUD prc = new postCRUD();
             prc.ajouterComment(c);
             
             
             
             
             
             
             
             
             
             
             
         } catch (Exception ex) {
           Logger.getLogger(FullPostController.class.getName()).log(Level.SEVERE, null, ex);
       }
         
         FillVbox(myLst,CommentsVBox); 
    }

    
   

    @FXML
    private void playPauseClicked(ActionEvent event) {
        
        
        
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

    @FXML
    private void like(MouseEvent event) {
    }
   
      
   
    }

   
    
    





