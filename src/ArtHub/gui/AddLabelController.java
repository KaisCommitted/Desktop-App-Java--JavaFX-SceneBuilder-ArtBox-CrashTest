/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Labell;
import ArtHub.services.LabelCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AddLabelController implements Initializable {

    @FXML
    private Button button_addlabel;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
    }
    @FXML
    private void addLabel(ActionEvent event) {
        try {
            // Ajouter Labell
            String rName = txt_name.getText();
            String rType = txt_type.getText();
             

            Labell e = new Labell(rName,rType);
            LabelCRUD lbl = new LabelCRUD();
            lbl.ajouterLabel(e);
            
           
        }catch (Exception ex) {
        Logger.getLogger(AddLabelController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    
}
}