/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Partenaire;
import ArtHub.services.PartenaireCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class UpdateUserasParController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Button btnupdateA_Partner;
    @FXML
    private TableView<Partenaire> listupdate;
    @FXML
    private TableColumn<Partenaire, String> col;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col.setCellValueFactory(new PropertyValueFactory<>("nom"));
        PartenaireCRUD pc = new PartenaireCRUD();
        System.out.println(pc.consulterPartenairess());
        listupdate.setItems(pc.consulterPartenairess());
        // TODO
    }    

    @FXML
    private void updatePartner(ActionEvent event) {
       PartenaireCRUD pc = new PartenaireCRUD();
       Partenaire u = listupdate.getSelectionModel().getSelectedItem();
        System.out.println(u);
       pc.affectPartenaire(u.getId_part(),1);
       listupdate.setItems(pc.consulterPartenairess());
    }
    
}
