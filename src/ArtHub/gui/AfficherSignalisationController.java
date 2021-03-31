/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;


import ArtHub.entities.Signalisation;
import ArtHub.services.SignalisationCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
 * @author Moetez
 */
public class AfficherSignalisationController implements Initializable {

    @FXML
    private AnchorPane anchorsignal;
    SignalisationCRUD ps;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SignalisationCRUD ps = new SignalisationCRUD();
        // id_signal table view
        JFXTreeTableColumn<Signalisation, String> id_signal = new JFXTreeTableColumn<>("id_signal");
        id_signal.setPrefWidth(150);
        id_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_signal()));
            }
        });
         JFXTreeTableColumn<Signalisation, String> id_user = new JFXTreeTableColumn<>("id_user");
        id_signal.setPrefWidth(150);
        id_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_user().getId_user()));
            }
        });
         JFXTreeTableColumn<Signalisation, String> id_post = new JFXTreeTableColumn<>("id_post");
        id_signal.setPrefWidth(150);
        id_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_post().getId_post()));
            }
        });
        
         //contenu_signal table view
        JFXTreeTableColumn<Signalisation, String> contenu_signal = new JFXTreeTableColumn<>("contenu_signal");
        contenu_signal.setPrefWidth(150);
        contenu_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getContenu_signal());
            }
        });
        
        // type_signal table view
        JFXTreeTableColumn<Signalisation, String> type_signal = new JFXTreeTableColumn<>("type_signal");
        type_signal.setPrefWidth(150);
        type_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getType_signal());
           }
        });
        
         // etat_signal table view
        JFXTreeTableColumn<Signalisation, String> etat_signal = new JFXTreeTableColumn<>("etat_signal");
        etat_signal.setPrefWidth(150);
        etat_signal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Signalisation, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Signalisation, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getEtat_signal());
            }
        });
                 etat_signal.setCellFactory((TreeTableColumn<Signalisation, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable etat_signal text field
        etat_signal.setOnEditCommit((CellEditEvent<Signalisation, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_signal();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setEtat_signal(t.getNewValue());
            ps.modifierSignalisation(idd, "etat_signal", newValue);
        });
        
        
        List<Signalisation> myLst;
        myLst = ps.consulterSignalisation();
        ObservableList<Signalisation> Signalisations = FXCollections.observableArrayList();
        myLst.forEach(f -> Signalisations.add(f));
        JFXTreeTableView<Signalisation> treeview = new JFXTreeTableView<>();
        final TreeItem<Signalisation> root = new RecursiveTreeItem<>(Signalisations, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_signal,contenu_signal,type_signal,etat_signal);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
         
        
        //declarer la bouton supprimer
        JFXButton DltBtn = new JFXButton("Remove");
        DltBtn.setLayoutY(410D);
        DltBtn.setOnAction(new EventHandler<ActionEvent>() {
        //eventHandler de la button supprimer
        @Override
        public void handle(ActionEvent event) {
        Dialog confirmation = new Dialog();
        GridPane grid2 = new GridPane();
        Label l1 = new Label("Delete Signalisation?");
        grid2.add(l1, 2, 2);
        confirmation.setTitle("Confirmation de suppression!");
        confirmation.getDialogPane().setContent(grid2);
        ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
        confirmation.getDialogPane().getButtonTypes().add(Confi);
        confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        confirmation.setResultConverter(new Callback<ButtonType, Signalisation>() {
        @Override
        public Signalisation call(ButtonType param) {
        if (param == Confi) {
        Signalisation p = treeview.getSelectionModel().getSelectedItem().getValue();
        ps.supprimerSignalisation((Signalisation) p);
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
         
        /* input.setPromptText("Rechercher ..");
        input.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        treeview.setPredicate(new Predicate<TreeItem<Signalisation>>() {
        @Override
        public boolean test(TreeItem<Produits> t) {
        boolean flag = t.getValue().getEtat_signal().getValue().contains(newValue);
        return flag;
        }
        });
        }
        });*/
        anchorsignal.getChildren().addAll(treeview,DltBtn);
    }    
    
}
        
    

