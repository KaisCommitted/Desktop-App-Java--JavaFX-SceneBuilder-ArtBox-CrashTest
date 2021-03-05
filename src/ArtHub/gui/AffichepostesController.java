/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Post;
import ArtHub.services.postCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
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
 * @author Adam Khalfaoui
 */
 


public class AffichepostesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private AnchorPane anchorpostes;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       postCRUD ps = new postCRUD();
        // id table view
        JFXTreeTableColumn<Post, String> id = new JFXTreeTableColumn<>("id");
        id.setPrefWidth(150);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_post()));
            }
        });
        
         // Nom table view
        JFXTreeTableColumn<Post, String> Nom = new JFXTreeTableColumn<>("Nom");
        Nom.setPrefWidth(150);
        Nom.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getNom_post());
            }
        });
        //making the cell editable
        Nom.setCellFactory((TreeTableColumn<Post, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable Nom text field
        Nom.setOnEditCommit((CellEditEvent<Post, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_post();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_post(Integer.parseInt(t.getNewValue()));
            ps.modifierPost(idd, "Nom", newValue);
        });
        
        
        
         // date table view
        JFXTreeTableColumn<Post, String>  Description= new JFXTreeTableColumn<>("Description");
        Description.setPrefWidth(150);
        Description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDescription());
            }
        });
                 Description.setCellFactory((TreeTableColumn<Post, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable date text field
        Description.setOnEditCommit((CellEditEvent<Post, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_post();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDescription(t.getNewValue());
            ps.modifierPost(idd, "Description", newValue);
        });
        
         // Categorie table view
        JFXTreeTableColumn<Post, String> Categorie = new JFXTreeTableColumn<>("Categorie");
        Categorie.setPrefWidth(150);
        Categorie.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getCategorie());
            }
        });
                 Categorie.setCellFactory((TreeTableColumn<Post, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable Categorie text field
        Categorie.setOnEditCommit((CellEditEvent<Post, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_post();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCategorie(t.getNewValue());
            ps.modifierPost(idd, "Categorie", newValue);
        });
        
         // type_event table view
        JFXTreeTableColumn<Post, String> date = new JFXTreeTableColumn<>("Date");
        date.setPrefWidth(150);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getPost_date());
            }
        });
        date.setCellFactory((TreeTableColumn<Post, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable type_event text field
        date.setOnEditCommit((CellEditEvent<Post, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_post();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setPost_date(t.getNewValue());
            ps.modifierPost(idd, "date", newValue);
        });
        
         // categorie table view
        JFXTreeTableColumn<Post, String> File = new JFXTreeTableColumn<>("File");
        File.setPrefWidth(150);
        File.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getFile());
           }

       });
        
        File.setCellFactory((TreeTableColumn<Post, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable categorie text field
        File.setOnEditCommit((CellEditEvent<Post, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_post();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_post(Integer.parseInt(t.getNewValue()));
            ps.modifierPost(idd, "File", newValue);
        });
        

     
        
        List<Post> myLst;
        myLst = ps.consulterPost();
        ObservableList<Post>postes = FXCollections.observableArrayList();

        myLst.forEach(p ->postes.add(p));
        JFXTreeTableView<Post> treeview = new JFXTreeTableView<>();
        final TreeItem<Post> root = new RecursiveTreeItem<Post>(postes, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id,Nom,Description,Categorie,date,File);
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
                Label l1 = new Label("Deletepost?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType,Post>() {
                    @Override
                    public Post call(ButtonType param) {
                        if (param == Confi) {
                           Post p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerPost((Post) p);
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
                treeview.setPredicate(new Predicate<TreeItem<Post>>() {
                    @Override
                    public boolean test(TreeItem<Produits> t) {

                        boolean flag = t.getValue().getNom_event().getValue().contains(newValue);
                        return flag;
                    }
                });
            }
        });*/
        
        
        anchorpostes.getChildren().addAll(treeview,DltBtn);
       
  
        
  
    }  
}
    




