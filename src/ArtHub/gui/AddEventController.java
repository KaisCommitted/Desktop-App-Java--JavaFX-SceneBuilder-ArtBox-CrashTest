package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.services.EvenementCRUD;
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


public class AddEventController implements Initializable {

    @FXML
    private TextField txt_org;
    @FXML
    private TextField txt_date;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_categorie;
    @FXML
    private TextField txt_description;
    @FXML
    private Button btnValiderA_event;
    @FXML
    private TextField txt_type;
    @FXML
    private ComboBox<String> combo_type = new ComboBox<>();
    

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
            String rDate = txt_date.getText();
            String rNom = txt_nom.getText();
             String rType = combo_type.getValue();
             String rCategorie = txt_categorie.getText();
             String rDescription = txt_description.getText();
            int Org = DatatypeConverter.parseInt(rOrg);
            //int Type = DatatypeConverter.parseInt(rType);
            int Categorie = DatatypeConverter.parseInt(rCategorie);

            Evenement e = new Evenement(Org,rDate,rNom,rType,Categorie,rDescription);
            EvenementCRUD evt = new EvenementCRUD();
            evt.ajouterEvenement(e);
            
            
        }catch (Exception ex) {
        Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
