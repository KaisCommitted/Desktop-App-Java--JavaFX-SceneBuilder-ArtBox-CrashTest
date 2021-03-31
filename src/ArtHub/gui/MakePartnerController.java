/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class MakePartnerController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_description;
    @FXML
    private ComboBox<?> combo_type;
    @FXML
    private Button btnValiderA_event;
    @FXML
    private JFXDatePicker tDatenaiss;
    @FXML
    private TextField txt_capacite;
    @FXML
    private JFXButton upload_image;
    @FXML
    private TextField event_location;
    @FXML
    private ComboBox<?> txt_categorie;
    @FXML
    private Label Control;
    @FXML
    private TextField code;
    @FXML
    private Button reset;
    @FXML
    private ImageView cap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChangeLocationPropmt(ActionEvent event) {
    }

    @FXML
    private void addEvent(ActionEvent event) {
    }

    @FXML
    private void image_file(ActionEvent event) {
    }

    @FXML
    private void resetCaptcha(ActionEvent event) {
    }
    
}
