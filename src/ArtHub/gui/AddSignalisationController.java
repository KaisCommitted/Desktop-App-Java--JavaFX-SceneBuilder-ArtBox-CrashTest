/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities Signalisation;
import ArtHub.entities.Signalisation;
import ArtHub.services SignalisationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Moetez
 */
public class AddSignalisationController implements Initializable {

    @FXML
    private ComboBox<String> cmboTypeSignal;
    @FXML
    private TextArea txtContenuSignal;

   /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     cmboTypeSignal.getItems().add("Harcélement");
     cmboTypeSignal.getItems().add("Nom Inapproprié");
     cmboTypeSignal.getItems().add("Violence verbale");

    }    
    @FXML
    private void addSignalisation(ActionEvent event) {
        try {
             Ajouter Signalisation
            String rtypesignal = cmboTypeSingal.getValue();
            String rcontenusignal = txtContenuSignal.getText();
         
           
            Signalisation f = new Signalisation(rcontenusignal,rtypesignal);
            SignalisationCRUD feed = new SignalisationCRUD();
            feed.ajoute Signalisation(f);
            
            
        }catch (Exception ex) {
        Logger.getLogger(Ad SignalisationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
