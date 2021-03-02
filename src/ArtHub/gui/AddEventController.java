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
    private TextField txt_type;
    @FXML
    private TextField txt_categorie;
    @FXML
    private TextField txt_description;
    @FXML
    private Button btnValiderA_event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void addEvent(ActionEvent event) {
        try {
            // Ajouter Event
            String rOrg = txt_org.getText();
            String rDate = txt_date.getText();
            String rNom = txt_nom.getText();
             String rType = txt_type.getText();
             String rCategorie = txt_categorie.getText();
             String rDescription = txt_description.getText();
            int Org = DatatypeConverter.parseInt(rOrg);
            int Type = DatatypeConverter.parseInt(rType);
            int Categorie = DatatypeConverter.parseInt(rCategorie);

            Evenement e = new Evenement(Org,rDate,rNom,Type,Categorie,rDescription);
            EvenementCRUD evt = new EvenementCRUD();
            evt.ajouterEvenement(e);
            
            
        }catch (Exception ex) {
        Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
