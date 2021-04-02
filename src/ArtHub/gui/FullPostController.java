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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */
public class FullPostController implements Initializable {

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
            p = pc.FindPost(id_post_clicked);
            setData(p);
            u = uc.FindUser(p.getId_user().getId_user());
        user_name.setText(u.getNom());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FullPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idPost=id_post_clicked;
       
       FillVbox(myLst,CommentsVBox); 
    }
    
    
    private void FillVbox(List<Comment> myLst, VBox DisplayInMe) {
        postCRUD cm = new postCRUD();
        List<Comment> comments ;
        comments = cm.Findcomment(id_post_clicked);
        System.err.println("waaaaaaaaaa");
        
        
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
         
         //user_name
        System.out.println(post.getFile());
       Image image =new Image(new FileInputStream(post.getFile())); 
      img.setImage(image);
      
      
      
      
        
       
      
      
      
      
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
        
        if (new_cmnt.getText() == null || new_cmnt.getText().trim().isEmpty()){
            
       
            String title = "Error";
        String message = "Write a comment !";
        //Notification notification = Notifications.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(12000));
        
        }
        
        
        
        
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
             
             
             
             
               String title = "Thank you";
        String message = "Comment added";
        //Notification notification = Notifications.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(12000));
             
             
             
             
             
             
         } catch (Exception ex) {
           Logger.getLogger(FullPostController.class.getName()).log(Level.SEVERE, null, ex);
       }
         
         
       
         FillVbox(myLst,CommentsVBox); 
         
         
         
         
         
    }

   
   
      
   
    }

   
    
    





