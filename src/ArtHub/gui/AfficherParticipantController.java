/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Participant;
import ArtHub.services.ParticipantCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AfficherParticipantController implements Initializable {

    @FXML
    private AnchorPane anchorparticipant;
    ParticipantCRUD ps;
    @FXML
    private JFXTextField input;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ParticipantCRUD ps = new ParticipantCRUD();
       
        // id_participation table view
        JFXTreeTableColumn<Participant, String> id_participation = new JFXTreeTableColumn<>("id_participation");
        id_participation.setPrefWidth(250);
        id_participation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_participation()));
            }
        });
        
         // id_user table view
        JFXTreeTableColumn<Participant, String> id_user = new JFXTreeTableColumn<>("id_user");
        id_user.setPrefWidth(250);
        id_user.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_user()));
            }
        });
        // id_event table view
        JFXTreeTableColumn<Participant, String> id_event = new JFXTreeTableColumn<>("id_event");
        id_event.setPrefWidth(250);
        id_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_event()));
           }

       });
         
     
        
        List<Participant> myLst;
        myLst = ps.consulterParticipant();
        ObservableList<Participant> Participants = FXCollections.observableArrayList();

        myLst.forEach(p -> Participants.add(p));
        JFXTreeTableView<Participant> treeview = new JFXTreeTableView<>();
        final TreeItem<Participant> root = new RecursiveTreeItem<Participant>(Participants, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_participation,id_user,id_event);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
        
       
        
        //declarer la button supprimer
        JFXButton DltBtn = new JFXButton("Remove");
        DltBtn.setLayoutY(410D);
        DltBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            //eventHandler de la button supprimer
            @Override
            public void handle(ActionEvent event) {
                Dialog confirmation = new Dialog();
                GridPane grid2 = new GridPane();
                Label l1 = new Label("Delete Participant?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Participant>() {
                    @Override
                    public Participant call(ButtonType param) {
                        if (param == Confi) {
                            Participant p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerParticipant((Participant) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            initialize(url, rb);
                        }

                        return null;
                    }
                });
                confirmation.showAndWait();
            }
        }); 
        
        input.setPromptText("Rechercher ..");
        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                treeview.setPredicate(new Predicate<TreeItem<Participant>>() {
                    @Override
                    public boolean test(TreeItem<Participant> t) {

                        boolean flag = String.valueOf(t.getValue().getId_participation()).contains(newValue);
                        return flag;
                    }
                });
            }
        });
        
        
        anchorparticipant.getChildren().addAll(treeview,DltBtn);
    }    
    
}
