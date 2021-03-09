package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.User;
import ArtHub.services.EvenementCRUD;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.xml.bind.DatatypeConverter;
import java.sql.Date;
import java.time.LocalDate;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ADD_EventController implements Initializable {

    @FXML
    private StackPane parentContainer1;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_categorie;
    @FXML
    private TextField txt_description;
    @FXML
    private Button btnValiderA_event;
    @FXML
    private ComboBox<String> combo_type = new ComboBox<>();
    @FXML
    private JFXDatePicker tDatenaiss;
    @FXML
    private TextField txt_capacite;
    User CurrentUser = new User(1, "0");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_type.setPromptText("Choisissez un type ..");
        combo_type.getItems().addAll("En ligne", "Exposé", "Festival", "Formation", "Autres");

    }

    @FXML
    private void addEvent(ActionEvent event) {
        try {
            // Ajouter Event

            LocalDate Datenaiss = tDatenaiss.getValue();

            String rNom = txt_nom.getText();
            String rType = combo_type.getValue();
            String rCategorie = txt_categorie.getText();
            String rDescription = txt_description.getText();

            int Categorie = DatatypeConverter.parseInt(rCategorie);
            String Scapacite = txt_capacite.getText();
            int Capacite = DatatypeConverter.parseInt(Scapacite);

            Evenement e = new Evenement(CurrentUser, Datenaiss, rNom, rType, Categorie, rDescription, Capacite);
            EvenementCRUD evt = new EvenementCRUD();
            evt.ajouterEvenement(e);

            if (CurrentUser.getRef_admin().equals("0")) {
                
    Stage stage = (Stage) btnValiderA_event.getScene().getWindow();
    stage.close();
    //TODO go to FRONT_Event.fxml + refresh

                /* Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    
    
    Parent loader = FXMLLoader.load(getClass().getResource("FRONT_Event.fxml"));//Creates a Parent called loader and assign it as ScReen2.FXML

    Scene scene = new Scene(loader); //This creates a new scene called scene and assigns it as the Sample.FXML document which was named "loader"

    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();//this accesses the window.
    app_stage.setX(bounds.getMinX());
    app_stage.setY(bounds.getMinY());
    app_stage.setWidth(bounds.getWidth());
    app_stage.setHeight(bounds.getHeight());

    app_stage.setScene(scene); //This sets the scene as scene

    app_stage.show(); // this shows the scene*/
            }

        } catch (Exception ex) {
            Logger.getLogger(ADD_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
