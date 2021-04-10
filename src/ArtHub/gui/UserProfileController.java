/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;
import ArtHub.entities.User;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.UserCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class UserProfileController implements Initializable {

    @FXML
    private StackPane parentContainer1;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton feed_button;
    @FXML
    private ImageView BtnClose;
    @FXML
    private JFXButton btneditProfile;
       @FXML
    private ImageView user_image;
    @FXML
    private JFXTextField txt_first_name;
    @FXML
    private JFXTextField txt_last_name;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField mail;
    @FXML
    private DatePicker birth_date_selector;
    @FXML
    private ImageView label_image;
    
    //VAR
    
    User user;
        UserCRUD userService;
    @FXML
    private ImageView logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       user=CurrentUser;
        userService=new UserCRUD();
       txt_first_name.setText(user.getNom());
        txt_last_name.setText(user.getPrenom());
         username.setText(user.getUsername());
          mail.setText(user.getMail());
          birth_date_selector.setValue(convertToLocalDateViaSqlDate(user.getDate_naissance()));
          System.out.print("heooooooooo"+user.getImage());
                   setImage(user.getImage(), user_image);
        
        
    }    

    @FXML
    private void load_jobs(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FRONT_annonce.fxml"));
            Scene scene = feed_button.getScene();
            
            root.translateXProperty().set(scene.getHeight());
            parentContainer1.getChildren().add(root);
            
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            
            timeline.play();
            //parentContainer.getChildren().remove(anchorRoot);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           public static void setImage(String from,ImageView image) {
        try {
            Image img3 = new Image(new FileInputStream(from));
            image.setImage(img3);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}

    @FXML
    private void load_events(ActionEvent event) {
            try {
            Parent root = FXMLLoader.load(getClass().getResource("FRONT_Event.fxml"));
            Scene scene = feed_button.getScene();
            
            root.translateXProperty().set(scene.getHeight());
            parentContainer1.getChildren().add(root);
            
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            
            timeline.play();
            //parentContainer.getChildren().remove(anchorRoot);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void load_feed(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("feed gui.fxml"));
            Scene scene = feed_button.getScene();
            
            root.translateXProperty().set(scene.getHeight());
            parentContainer1.getChildren().add(root);
            
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            
            timeline.play();
            //parentContainer.getChildren().remove(anchorRoot);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeOFF(MouseEvent event) {
    }

    @FXML
    private void closeON(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void EditMyProfile(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void AddFeedback(MouseEvent event) {
    }

    @FXML
    private void logout(MouseEvent event) { try {
           
           Stage stage1 = (Stage) BtnClose.getScene().getWindow();
           stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
    
}
