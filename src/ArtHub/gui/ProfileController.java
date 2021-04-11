/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.User;
import static ArtHub.gui.ADD_EventController.copyContent;
import static ArtHub.gui.ADD_EventController.path;
import static ArtHub.gui.FRONT_EventController.setImage;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.UserCRUD;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author louay
 */


public class ProfileController implements Initializable {
    @FXML
    private ImageView user_image;
    @FXML
    private ImageView label_image;
    @FXML
    private JFXButton upload_image;
    @FXML
    private TextField txt_first_name;
    @FXML
    private TextField txt_last_name;
    @FXML
    private TextField username;
    @FXML
    private TextField mail;
    @FXML
    private Button update_profile;
    @FXML
    private Button close;
    @FXML
    private DatePicker birth_date_selector;
    @FXML
    private JFXButton logout;
    
    //Var
    User user;
    UserCRUD userService;
    
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
    private String updateImage(ActionEvent event) {
         
     
//upload_image
        path="";
        Stage currentStage = (Stage) upload_image.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File f = new File("C:/Users/21698/Desktop");
        fileChooser.setInitialDirectory(f);
        File selectedFile = fileChooser.showOpenDialog(currentStage);

        if (selectedFile != null) {
            String userHomeFolder = System.getProperty("user.home");
          
            
            File src = new File(selectedFile.getPath());
            File dest = new File("C:/xampp/php/www/ArtBox-CrashTest-WEB/public/avatar/");
            java.nio.file.Path sr = src.toPath();
            java.nio.file.Path ds = new File(dest, src.getName()).toPath();
            File newDes = new File("C:/xampp/php/www/ArtBox-CrashTest-WEB/public/avatar/" + username.getText() + selectedFile.getName());
            try {
                copyContent(selectedFile,newDes);
            } catch (Exception ex) {
                Logger.getLogger(ADD_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
             Path local = Paths.get("C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\" + username.getText() + selectedFile.getName());
           
           
           
            try {
                copyContent(newDes, local.toFile());
            } catch (Exception ex) {
                Logger.getLogger(ADD_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        path = "C:/xampp/php/www/ArtBox-CrashTest-WEB/public/avatar/" + username.getText() + selectedFile.getName().toString();
        return username.getText();

 
    }
    
         @FXML
    private void logout(ActionEvent event) {
        disconnect();
    }
         @FXML
    private void update(ActionEvent event) {
        userService.modifierUser(user.getId_user(),"nom",txt_first_name.getText());
         userService.modifierUser(user.getId_user(),"prenom",txt_last_name.getText());
          userService.modifierUser(user.getId_user(),"username",username.getText());
           userService.modifierUser(user.getId_user(),"mail",mail.getText());
            userService.modifierUser(user.getId_user(),"date_naissance",Date.from(birth_date_selector.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            userService.modifierUser(user.getId_user(),"image",path);
            JOptionPane.showMessageDialog(null, "User update Successfully !" );
    }
         @FXML
    private void close_ui(ActionEvent event) {
            // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    public static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
}
            public void disconnect() {
             try {
           
           Stage stage1 = (Stage) logout.getScene().getWindow();
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
