/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Annonce;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class ItemAnnonceController implements Initializable {

    @FXML
    private Label titre_annonce;
    @FXML
    private Label desc_annonce;
    @FXML
    private Label pay_annonce;
    @FXML
    private Label ddl_annonce;
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @FXML
    private Button apply;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent event) {
    }

    public void setData(Annonce p) {

        titre_annonce.setText(p.getTitre_ann());
        desc_annonce.setText(p.getDesc_ann());
        pay_annonce.setText(Integer.toString(p.getPay())+ "tnd");
       // ddl_annonce.setText(p.getDdl_ann().format(formatters));
       }

    @FXML
    private void JoinEvent(ActionEvent event) {
             try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCandidat.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Apply to a job opportunity");

            stage.setScene(new Scene(root1));

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_AnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
