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
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

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
 Notifications notificationBuilder = Notifications.create()
               .title("Job offer added successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       Stage stage = (Stage) btnAddAnn.getScene().getWindow();
                       stage.close();
                       System.out.println("clicked ON ");
               }});
      txt_categorie.getItems().addAll("Dancing", "Theatre", "Painting", "Singing", "Photography");

    }

    @FXML
    private void addAnnonce(ActionEvent event) {
        try {
            /*if(i>0){initialize(urll, rbb)
                    ;}
            i++;  
            System.out.println(i);
            Control.setVisible(false);
            String control = "";
            if (txt_id_user.getText() == null || txt_id_user.getText().trim().isEmpty() 
                    || txt_categorie.getValue() == null || txt_categorie.getValue().isEmpty() || txt_titre_ann.getValue() == null || txt_titre_ann.getText() == null
                    || txt_desc_ann.getText().trim().isEmpty() || txt_desc_ann.getText() == null || txt_capacite.getText().trim().isEmpty() || event_location.getText() == null
                    || event_location.getText().trim().isEmpty()) {
                control = "Make sure to fill all the fields";
                Control.setVisible(true);
                Control.setText(control);
            } else if (Evenement.isNotInteger(txt_capacite.getText())) {
                control += "\nEvent capacity should be an integer";
                txt_capacite.clear();
                Control.setText(control);
                Control.setVisible(true);
                txt_capacite.setStyle("background-color: rgba(255,0,0,0.2);");
            } else if (path=="") {
                control += "\nMake sure to upload event picture ";
                Control.setText(control);
                Control.setVisible(true);
                 upload_image.setStyle("background-color: rgba(255,0,0,0.2);");
            } else if (tDatenaiss.getValue().isBefore(LocalDate.now())) {
                control += "\nMake sure to select an upcoming date ";
                Control.setText(control);
                Control.setVisible(true);
                tDatenaiss.setStyle("background-color: rgba(255,0,0,0.2);");
            }else {*/
            System.out.println("Pressed");
            // Ajouter Annonce
             Notifications notificationBuilder = Notifications.create()
               .title("Job offer added successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.BASELINE_CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       Stage stage = (Stage) btnAddAnn.getScene().getWindow();
                       stage.close();
                       System.out.println("clicked ON ");
               }});
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
            
           
       // }
        } catch (Exception ex) {
            Logger.getLogger(AddAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
