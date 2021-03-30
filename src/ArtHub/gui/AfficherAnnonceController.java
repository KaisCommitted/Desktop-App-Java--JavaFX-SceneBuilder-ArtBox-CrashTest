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
import ArtHub.entities.Annonce;
import static ArtHub.gui.FRONT_EventController.setImage;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import ArtHub.services.AnnonceCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AfficherAnnonceController implements Initializable {

    private AnchorPane anchorevent;
    AnnonceCRUD ps;
    @FXML
    private AnchorPane anchorannonce;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AnnonceCRUD ps = new AnnonceCRUD();
        // id table view
        JFXTreeTableColumn<Annonce, String> id_ann = new JFXTreeTableColumn<>("id_ann");
        id_ann.setPrefWidth(150);
        id_ann.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_ann()));
            }
        });
        
        
        
         // id user table view
        JFXTreeTableColumn<Annonce, String> id_user = new JFXTreeTableColumn<>("id_user");
        id_user.setPrefWidth(150);
        id_user.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_user()));
           }

       });
        
        id_user.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable id_user text field
        id_user.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_user(Integer.parseInt(t.getNewValue()));
            ps.modifierAnnonce(idd, "id_user", newValue);
        });
        
        
        
        
         // titre_ann table view
        JFXTreeTableColumn<Annonce, String> titre_ann = new JFXTreeTableColumn<>("titre_ann");
        titre_ann.setPrefWidth(150);
        titre_ann.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getTitre_ann());
            }
        });
                 titre_ann.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable titre_ann text field
        titre_ann.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setTitre_ann(t.getNewValue());
            ps.modifierAnnonce(idd, "titre_ann", newValue);
        });
        
        
        
        
        
         // desc_ann table view
        JFXTreeTableColumn<Annonce, String> desc_ann = new JFXTreeTableColumn<>("desc_ann");
        desc_ann.setPrefWidth(150);
        desc_ann.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDesc_ann());
            }
        });
                 desc_ann.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable desc_ann text field
        desc_ann.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setTitre_ann(t.getNewValue());
            ps.modifierAnnonce(idd, "desc_ann", newValue);
        });
        
        
        
        
         // pay table view
        JFXTreeTableColumn<Annonce, String> pay = new JFXTreeTableColumn<>("pay");
        pay.setPrefWidth(150);
        pay.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getPay()));
           }

       });
        
        pay.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable pay text field
        pay.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setPay(Integer.parseInt(t.getNewValue()));
            ps.modifierAnnonce(idd, "pay", newValue);
        });
        
        
        // categorie table view
        JFXTreeTableColumn<Annonce, String> categorie = new JFXTreeTableColumn<>("categorie");
        categorie.setPrefWidth(150);
        categorie.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getCategorie());
           }

       });
        
        categorie.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable categorie text field
        categorie.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCategorie(t.getNewValue());
            ps.modifierAnnonce(idd, "categorie", newValue);
        });
        
        
        
      /* 
        // ddl_ann table view
        JFXTreeTableColumn<Annonce, String> ddl_ann = new JFXTreeTableColumn<>("ddl_ann");
        ddl_ann.setPrefWidth(150);
        ddl_ann.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getDdl_ann());
            }
        });
        
                 ddl_ann.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable ddl_ann text field
        ddl_ann.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDdl_ann(t.getNewValue());
            ps.modifierAnnonce(idd, "ddl_ann", newValue);
        });
*/
      

 // ddl_ann table view
         DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        JFXTreeTableColumn<Annonce, String> ddl_ann = new JFXTreeTableColumn<>("ddl_ann");
        ddl_ann.setPrefWidth(150);
        ddl_ann.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Annonce, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDdl_ann().toString());
                        //.format(formatters));
            }
        });
                 ddl_ann.setCellFactory((TreeTableColumn<Annonce, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable date text field
//        date.setOnEditCommit((CellEditEvent<Annonce, String> t) -> {  
//            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_ann();
//            String newValue = t.getNewValue();
//
//            t.getTreeTableView()
//                    .getTreeItem(t.getTreeTablePosition()
//                            .getRow()).getValue().setDdl_ann(Date.parse(t.getNewValue(),formatters));
//            ps.modifierAnnonce(idd, "ddl_ann", newValue);
//        });
     
        
        List<Annonce> myLst;
        myLst = ps.consulterAnnonce();
        ObservableList<Annonce> Annonces = FXCollections.observableArrayList();

        myLst.forEach(p -> Annonces.add(p));
        JFXTreeTableView<Annonce> treeview = new JFXTreeTableView<>();
        final TreeItem<Annonce> root = new RecursiveTreeItem<Annonce>(Annonces, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_ann, id_user, titre_ann,desc_ann,pay,categorie,ddl_ann);
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
                Label l1 = new Label("Supprimer Annonce?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmer suppression");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Oui", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("Non", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Annonce>() {
                    @Override
                    public Annonce call(ButtonType param) {
                        if (param == Confi) {
                            Annonce p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerAnnonce((Annonce) p);
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
                treeview.setPredicate(new Predicate<TreeItem<Annonce>>() {
                    @Override
                    public boolean test(TreeItem<Produits> t) {

                        boolean flag = t.getValue().getNom_event().getValue().contains(newValue);
                        return flag;
                    }
                });
            }
        });*/
        
        
        anchorannonce.getChildren().addAll(treeview,DltBtn);
       
  
        
  
    }    
    





}
