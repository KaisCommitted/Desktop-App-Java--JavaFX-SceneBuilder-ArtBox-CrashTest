/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Annonce;
import ArtHub.services.AnnonceCRUD;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.xml.bind.DatatypeConverter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AddAnnonceController implements Initializable {

    @FXML
    private TextField txt_id_user;
    @FXML
    private TextField txt_titre_ann;
    @FXML
    private TextField txt_desc_ann;
    @FXML
    private TextField txt_pay;
    @FXML
    private ComboBox<String> txt_categorie = new ComboBox<>();
    @FXML
    private JFXDatePicker txt_ddl_ann;
    @FXML
    private Button btnAddAnn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  Control.setVisible(false);
        txt_categorie.getItems().addAll("Dancing", "Theatre", "Painting", "Singing", "Photography");

    }

    @FXML
    private void addAnnonce(ActionEvent event) {
        try {
            System.out.println("Pressed");
            // Ajouter Annonce

            String rIdUser = txt_id_user.getText();
            String rTitreAnn = txt_titre_ann.getText();
            String rDescAnn = txt_desc_ann.getText();
            String rPay = txt_pay.getText();
            String Categorie = txt_categorie.getValue();
            LocalDate auxDdlAnn = txt_ddl_ann.getValue();
            Date rDdlAnn = Date.valueOf(auxDdlAnn);

            int IdUser = DatatypeConverter.parseInt(rIdUser);
            int Pay = DatatypeConverter.parseInt(rPay);

            Annonce a = new Annonce(IdUser, rTitreAnn, rDescAnn, Pay, Categorie, rDdlAnn);
            AnnonceCRUD ann = new AnnonceCRUD();
            ann.ajouterAnnonce(a);

        } catch (Exception ex) {
            Logger.getLogger(AddAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
