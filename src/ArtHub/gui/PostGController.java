package ArtHub.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ArtHub.entities.Post;
import ArtHub.services.postCRUD;
import ArtHub.gui.MyListener;


public class PostGController {
   @FXML
    private Label nameLabel;

    @FXML
    private Label likesLabel;

    @FXML
    private Label commentsLabel;

    @FXML
    private ImageView img;


    //@FXML
    //private void click(MouseEvent mouseEvent) {
       // myListener.onClickListener(post);
    //}

    private Post post;
    //private MyListener myListener;

    public void setData(Post post) {
        this.post = post;
        //this.myListener = myListener;
        nameLabel.setText(post.getNom_post());
        likesLabel.setText(post.getDescription());
        
        Image image = new Image(getClass().getResourceAsStream(post.getFile()));
        img.setImage(image);
        
    }
}
