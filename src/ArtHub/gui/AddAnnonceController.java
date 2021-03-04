/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Annonce;
import ArtHub.services.AnnonceCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.xml.bind.DatatypeConverter;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AddAnnonceController implements Initializable {
    @FXML
    private TextField txt_titre_ann;
    @FXML
    private TextField txt_desc_ann;
    @FXML
    private TextField txt_pay;
    @FXML
    private TextField txt_competences;
    @FXML
    private TextField txt_categorie;
    @FXML
    private TextField txt_ddl_ann;
    @FXML
    private Button btnAddAnn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void addAnnonce(ActionEvent event) {
        try { System.out.println("Pressed");
            // Ajouter Annonce
            String rTitreAnn = txt_titre_ann.getText();
            String rDescAnn = txt_desc_ann.getText();
            String rPay = txt_pay.getText();
             String rCompetences = txt_competences.getText();
             String rCategorie = txt_categorie.getText();
             String rDdlAnn = txt_ddl_ann.getText();
            int Pay = DatatypeConverter.parseInt(rPay);
            int Categorie = DatatypeConverter.parseInt(rCategorie);

            Annonce a = new Annonce(rTitreAnn,rDescAnn,Pay,rCompetences,Categorie,rDdlAnn);
            AnnonceCRUD ann = new AnnonceCRUD();
            ann.ajouterAnnonce(a);
            
            
        }catch (Exception ex) {
        Logger.getLogger(AddAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
