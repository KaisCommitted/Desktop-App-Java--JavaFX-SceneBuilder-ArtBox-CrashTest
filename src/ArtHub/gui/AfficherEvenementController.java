/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ArtHub.entities.Evenement;
import ArtHub.services.EvenementCRUD;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AfficherEvenementController implements Initializable {

    @FXML
    private AnchorPane anchorevent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // id table view
        JFXTreeTableColumn<Evenement, String> id = new JFXTreeTableColumn<>("id");
        id.setPrefWidth(150);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId()));
            }
        });
        
         // id_org table view
        JFXTreeTableColumn<Evenement, String> id_org = new JFXTreeTableColumn<>("id_org");
        id_org.setPrefWidth(150);
        id_org.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_org()));
            }
        });
        
         // date table view
        JFXTreeTableColumn<Evenement, String> date = new JFXTreeTableColumn<>("date");
        date.setPrefWidth(150);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDate_event());
            }
        });
        
         // nom_event table view
        JFXTreeTableColumn<Evenement, String> nom_event = new JFXTreeTableColumn<>("nom_event");
        nom_event.setPrefWidth(150);
        nom_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getNom_event());
            }
        });
        
         // type_event table view
        JFXTreeTableColumn<Evenement, String> type_event = new JFXTreeTableColumn<>("type_event");
        type_event.setPrefWidth(150);
        type_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getType_event()));
            }
        });
        
         // categorie table view
        JFXTreeTableColumn<Evenement, String> categorie = new JFXTreeTableColumn<>("categorie");
        categorie.setPrefWidth(150);
        categorie.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getCategorie()));
           }

       });
        // description table view
        JFXTreeTableColumn<Evenement, String> description = new JFXTreeTableColumn<>("description");
        description.setPrefWidth(150);
        description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getDescription());
            }
        });

       
        EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
        myLst = ps.consulterEvenement();
        ObservableList<Evenement> Evenements = FXCollections.observableArrayList();

        myLst.forEach(p -> Evenements.add(p));
        JFXTreeTableView<Evenement> treeview = new JFXTreeTableView<>();
        final TreeItem<Evenement> root = new RecursiveTreeItem<Evenement>(Evenements, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id, id_org,date,nom_event,type_event,categorie,description);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        anchorevent.getChildren().add(treeview);
        
        
        
    }    
    





}
