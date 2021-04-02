/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Categorie;
import ArtHub.entities.Annonce;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.AnnonceCRUD;
import ArtHub.services.CategorieCRUD;
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
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AddAnnonceController implements Initializable {

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
    private Label Control;
    @FXML
    private Button btnAddAnn; 
    AnnonceCRUD ann = new AnnonceCRUD();
     int i=0;
    List<Categorie> myLst;
             CategorieCRUD CC= new CategorieCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  Control.setVisible(false);
            myLst = CC.consulterCategorie();
             for (i=0;i<myLst.size();i++) { txt_categorie.getItems().add(myLst.get(i).getCategorie_name());}
           
    }

    @FXML
    private void addAnnonce(ActionEvent event) {
          try {
            Control.setVisible(false);
               String control = "";
                //controle de saisie
            if (txt_titre_ann.getText() == null || txt_titre_ann.getText().trim().isEmpty() ||txt_desc_ann.getText() == null || txt_desc_ann.getText().trim().isEmpty() ||txt_pay.getText() == null || txt_pay.getText().trim().isEmpty() || txt_categorie.getValue() == null || txt_categorie.getValue().isEmpty()
                    || txt_ddl_ann.getValue() == null ) {
                control = "Make sure to fill all the fields";
               // Control.setVisible(true);
                Control.setText(control);  
                 notificationShow("Alert!",control);
            } 
            else if (Annonce.isNotInteger(txt_pay.getText())) {
                control += "\nSalary should be an integer";
                txt_pay.clear();
                Control.setText(control);
               // Control.setVisible(true);
                notificationShow("Alert!",control);
                txt_pay.setStyle("background-color: rgba(255,0,0,0.2);");
            } 
            else if (txt_ddl_ann.getValue().isBefore(LocalDate.now())) {
                control += "\nMake sure to select an upcoming date ";
                Control.setText(control);
               // Control.setVisible(true);
                notificationShow("Alert!",control);
                txt_ddl_ann.setStyle("background-color: rgba(255,0,0,0.2);");
            }else{//fin de controle de saisie
            
              
         System.out.println("Pressed");
            // Ajouter Annonce
            
           // String rIdUser = txt_id_user.getText();
            String rTitreAnn = txt_titre_ann.getText();
            String rDescAnn = txt_desc_ann.getText();
            String rPay = txt_pay.getText();
            Categorie C =new Categorie();
            LocalDate auxDdlAnn = txt_ddl_ann.getValue();
            Date rDdlAnn = Date.valueOf(auxDdlAnn);

            //int IdUser = DatatypeConverter.parseInt(rIdUser);
            int Pay = DatatypeConverter.parseInt(rPay);
            C.setCategorie_name(txt_categorie.getValue());
            Annonce a = new Annonce(CurrentUser.getId_user(), rTitreAnn, rDescAnn, Pay, C, rDdlAnn);
            AnnonceCRUD ann = new AnnonceCRUD();
            ann.ajouterAnnonce(a);
            
             Notifications notificationBuilder = Notifications.create()
               .title("Job offer added successfully!").text("Hover to close").graphic(null).hideAfter(javafx.util.Duration.seconds(60))
               .position(Pos.CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       Stage stage = (Stage) btnAddAnn.getScene().getWindow();
                       stage.close();
                       System.out.println("clicked ON ");
               }});
            notificationBuilder.darkStyle();
       notificationBuilder.show();
       
        }
          }
    catch (Exception ex) {
            Logger.getLogger(AddAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void notificationShow(String alert, String control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}







