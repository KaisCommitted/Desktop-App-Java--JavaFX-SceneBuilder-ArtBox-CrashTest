/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Partenaire;
import static ArtHub.gui.LoginController.CurrentUser;
import static ArtHub.gui.ADD_EventController.copyContent;

import ArtHub.services.PartenaireCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class MakePartnerController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton upload_image;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_PhoneNumber;
    @FXML
    private TextField txt_rib;
    @FXML
    private TextField txt_Adress;
    String path;
    @FXML
    private Button btnValiderA_Partner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private String image_file(ActionEvent event) {
        //upload_image
        path = "";
        Stage currentStage = (Stage) upload_image.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File f = new File("C:/Users/Tarek/Desktop");
        fileChooser.setInitialDirectory(f);
        File selectedFile = fileChooser.showOpenDialog(currentStage);

        if (selectedFile != null) {
            String userHomeFolder = System.getProperty("user.home");

            File src = new File(selectedFile.getPath());
            File dest = new File("C:/xampp/php/www/pidev/imagepartenaire/");
            java.nio.file.Path sr = src.toPath();
            java.nio.file.Path ds = new File(dest, src.getName()).toPath();
            File newDes = new File("C:/xampp/php/www/pidev/imagepartenaire/" + txt_Name.getText() + txt_PhoneNumber.getText());
            try {
                copyContent(selectedFile, newDes);
            } catch (Exception ex) {

            }
            Path local = Paths.get(userHomeFolder + "\\Documents\\GitHub\\ArtBox-CrashTest\\img" + txt_Name.getText() + txt_PhoneNumber.getText());

            try {
                copyContent(newDes, local.toFile());
            } catch (Exception ex) {

            }
        }
        path = "C:/xampp/php/www/pidev/events/" + txt_Name.getText() + txt_PhoneNumber.getText();
        return txt_Name.getText() + txt_PhoneNumber.getText();
    }

    @FXML
    private void addPartner(ActionEvent event) {
        {
            Partenaire part = new Partenaire(txt_Name.getText(), txt_Adress.getText(), path, txt_rib.getText(), txt_PhoneNumber.getText(), 0, CurrentUser);
            PartenaireCRUD pc = new PartenaireCRUD();
            pc.ajouterPartenaire(part);
        }
    }

}
