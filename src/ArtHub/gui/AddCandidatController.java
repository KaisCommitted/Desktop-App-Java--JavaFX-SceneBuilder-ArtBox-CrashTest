/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Candidat;
import ArtHub.services.CandidatCRUD;
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
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AddCandidatController implements Initializable {
    
    //yomkon neksin l foreign keys taa id_ann w id_user
    @FXML
    private TextField txt_cv;
    @FXML
    private Button btnAddCand;

    private Label Control;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  Control.setVisible(false);
 Notifications notificationBuilder = Notifications.create()
               .title("Application successfully submitted!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       Stage stage = (Stage) btnAddCand.getScene().getWindow();
                       stage.close();
                       System.out.println("clicked ON ");
               }});

    }

    private void addCandidat(ActionEvent event) {
        try {
            
            Control.setVisible(false);
               String control = "";
                //controle de saisie
            if (txt_cv.getText() == null || txt_cv.getText().trim().isEmpty()) {
                control = "Make sure to fill all the fields";
               // Control.setVisible(true);
                Control.setText(control);  
                 notificationShow("Alert!",control);
            } else{//fin de controle de saisie
           
            System.out.println("Pressed");
            // Ajouter Candidat
            
            String rCv = txt_cv.getText();
            Candidat a = new Candidat(rCv);
            CandidatCRUD cand = new CandidatCRUD();
            cand.ajouterCandidat(a);
            
            
             Notifications notificationBuilder = Notifications.create()
               .title("Application submitted successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       Stage stage = (Stage) btnAddCand.getScene().getWindow();
                       stage.close();
                       System.out.println("clicked ON ");
               }});
           
            }
        }
         catch (Exception ex) {
            Logger.getLogger(AddCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void notificationShow(String alert, String control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
