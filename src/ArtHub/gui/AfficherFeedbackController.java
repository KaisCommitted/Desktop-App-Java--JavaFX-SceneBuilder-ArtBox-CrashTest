/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;


import ArtHub.entities.Feedback;
import ArtHub.services.FeedbackCRUD;
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
public class AfficherFeedbackController implements Initializable {

    @FXML
    private AnchorPane anchorfeedback;
    FeedbackCRUD ps;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FeedbackCRUD ps = new FeedbackCRUD();
        // id_feedback table view
        JFXTreeTableColumn<Feedback, String> id_feedback = new JFXTreeTableColumn<>("id_feedback");
        id_feedback.setPrefWidth(150);
        id_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_feedback()));
            }
        });
        
         //contenu_feedback table view
        JFXTreeTableColumn<Feedback, String> contenu_feedback = new JFXTreeTableColumn<>("contenu_feedback");
        contenu_feedback.setPrefWidth(150);
        contenu_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getContenu_feedback());
            }
        });
        
        // type_feedback table view
        JFXTreeTableColumn<Feedback, String> type_feedback = new JFXTreeTableColumn<>("type_feedback");
        type_feedback.setPrefWidth(150);
        type_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getType_feedback());
           }
        });
        
         // etat_feedback table view
        JFXTreeTableColumn<Feedback, String> etat_feedback = new JFXTreeTableColumn<>("etat_feedback");
        etat_feedback.setPrefWidth(150);
        etat_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getEtat_feedback());
            }
        });
                 etat_feedback.setCellFactory((TreeTableColumn<Feedback, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable etat_feedback text field
        etat_feedback.setOnEditCommit((CellEditEvent<Feedback, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_feedback();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setEtat_feedback(t.getNewValue());
            ps.modifierFeedback(idd, "etat_feedback", newValue);
        });
        
        
        List<Feedback> myLst;
        myLst = ps.consulterFeedback();
        ObservableList<Feedback> Feedbacks = FXCollections.observableArrayList();
        myLst.forEach(f -> Feedbacks.add(f));
        JFXTreeTableView<Feedback> treeview = new JFXTreeTableView<>();
        final TreeItem<Feedback> root = new RecursiveTreeItem<>(Feedbacks, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_feedback,contenu_feedback,type_feedback,etat_feedback);
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
        Label l1 = new Label("Delete Feedback?");
        grid2.add(l1, 2, 2);
        confirmation.setTitle("Confirmation de suppression!");
        confirmation.getDialogPane().setContent(grid2);
        ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
        confirmation.getDialogPane().getButtonTypes().add(Confi);
        confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        confirmation.setResultConverter(new Callback<ButtonType, Feedback>() {
        @Override
        public Feedback call(ButtonType param) {
        if (param == Confi) {
        Feedback p = treeview.getSelectionModel().getSelectedItem().getValue();
        ps.supprimerFeedback((Feedback) p);
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
        treeview.setPredicate(new Predicate<TreeItem<Feedback>>() {
        @Override
        public boolean test(TreeItem<Produits> t) {
        boolean flag = t.getValue().getEtat_feedback().getValue().contains(newValue);
        return flag;
        }
        });
        }
        });*/
        anchorfeedback.getChildren().addAll(treeview,DltBtn);
    }    
    
}
        
    

