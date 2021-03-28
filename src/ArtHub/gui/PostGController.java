package ArtHub.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ArtHub.entities.Post;
import ArtHub.entities.User;
import ArtHub.entities.interactions;
import static ArtHub.gui.ItemBoxController.stripNonDigits;
import ArtHub.services.postCRUD;
import ArtHub.gui.MyListener;
import ArtHub.services.InteractionsCrud;
import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PostGController implements Initializable {
   @FXML
    private Label nameLabel;

    @FXML
    private Label likesLabel;


    @FXML
    private ImageView img;
    
     @FXML
    private ImageView imgbtn = new ImageView();

     String userHomeFolder = System.getProperty("user.home");


 @FXML
    private Label descreption;
   
  @FXML
    private Label idLabel;
    
  @FXML
    private JFXButton like_btn;
  
 User CurrentUser = new User(2);
    //@FXML
    //private void click(MouseEvent mouseEvent) {
       // myListener.onClickListener(post);
    //}
    @FXML
    private ImageView addsignal;
 
 
 
 
 
 
 
 
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try {
           //String path="file:///C:\\Users\\Adam Khalfaoui\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\gui\\post_pics\\like_selec.png" ;
           
           
           //Image image = new Image("/ArtHub.postpics/heart-69-xxl.png");
           String Empty = userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\flag.png";
           Image image =new Image(new FileInputStream(Empty));
           addsignal.setImage(image);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(PostGController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
 
 
        
       
        
 
 
 
        
    }
    
    //private MyListener myListener;

    public void setData(Post post) throws FileNotFoundException {
        
        
        nameLabel.setText(post.getNom_post());
        descreption.setText(post.getDescription());
         likesLabel.setText(Integer.toString(post.getLikes()));
         idLabel.setText(Integer.toString(post.getId_post()));
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
    private void addReport(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSignalisation.fxml"));
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
