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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class PostGController implements Initializable {
   @FXML
    private Label nameLabel;

    @FXML
    private Label likesLabel;

    @FXML
    private Label commentsLabel;

    @FXML
    private ImageView img;

 @FXML
    private VBox Postbox;
 
   @FXML
    private AnchorPane anchorpane;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }
    
    //private MyListener myListener;

    public void setData(Post post) throws FileNotFoundException {
        System.out.println("Rani dkhalet 2 ");
        
        nameLabel.setText(post.getNom_post());
        descreption.setText(post.getDescription());
         likesLabel.setText(Integer.toString(post.getLikes()));
         idLabel.setText(Integer.toString(post.getId_post()));
        System.out.println(post.getFile());
       Image image =new Image(new FileInputStream(post.getFile())); 
      img.setImage(image);
        
      
        
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
        }
        else{
        
        likesLabel.setText(Integer.toString(Integer.parseInt(aux) +1));
        ppt.ajouterInteraction(p);
        }
        

    }
    
    
    
}
