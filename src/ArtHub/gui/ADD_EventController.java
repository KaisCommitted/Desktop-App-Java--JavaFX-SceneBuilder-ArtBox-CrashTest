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


public class ADD_EventController implements Initializable {

    @FXML
    private TextField txt_org;
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
            String rOrg = txt_org.getText();
       LocalDate Datenaiss = tDatenaiss.getValue();
        
            String rNom = txt_nom.getText();
             String rType = combo_type.getValue();
             String rCategorie = txt_categorie.getText();
             String rDescription = txt_description.getText();
            int Org = DatatypeConverter.parseInt(rOrg);
            User id_user = new User();
            id_user.setId_user(Org);
            int Categorie = DatatypeConverter.parseInt(rCategorie);
            String Scapacite = txt_capacite.getText();
            int Capacite = DatatypeConverter.parseInt(Scapacite);

            Evenement e = new Evenement(id_user,Datenaiss,rNom,rType,Categorie,rDescription,Capacite);
            EvenementCRUD evt = new EvenementCRUD();
            evt.ajouterEvenement(e);
            
            
        }catch (Exception ex) {
        Logger.getLogger(ADD_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
