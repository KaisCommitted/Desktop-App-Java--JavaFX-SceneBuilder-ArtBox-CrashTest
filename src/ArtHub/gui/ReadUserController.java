/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;
import ArtHub.entities.User;
import ArtHub.services.UserCRUD;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class ReadUserController implements Initializable {

    @FXML
    private AnchorPane Userview;
    @FXML
    private JFXTextField input;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserCRUD ps = new UserCRUD();
        // id table view
        JFXTreeTableColumn<User, String> id_user = new JFXTreeTableColumn<>("id_user");
        id_user.setPrefWidth(150);
        id_user.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_user()));
            }
        });
        
         // nom table view
        JFXTreeTableColumn<User, String> nom = new JFXTreeTableColumn<>("nom");
        nom.setPrefWidth(150);
        nom.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty((param.getValue().getValue().getNom()));
            }
        });
        //making the cell editable
        nom.setCellFactory((TreeTableColumn<User, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable nom text field
        nom.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> u) -> {
            int idd = u.getTreeTableView().getTreeItem(u.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = u.getNewValue();

            u.getTreeTableView()
                    .getTreeItem(u.getTreeTablePosition()
                            .getRow())
                    .getValue().setNom((u.getNewValue()));
            ps.modifierUser(idd, "nom", newValue);
        });
        
        
//        
//         // date table view
//        JFXTreeTableColumn<User, String> date = new JFXTreeTableColumn<>("Date_naissance");
//        date.setPrefWidth(150);
//        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return new SimpleStringProperty(param.getValue().getValue().getDate_naissance());
//            }
//        });
//                 date.setCellFactory((TreeTableColumn<User, String> param) -> {
//            return new GenericEditableTreeTableCell<>(
//                    new TextFieldEditorBuilder());
//        });
//        //setting the new value for editable date text field
//        date.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> {
//            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
//            String newValue = t.getNewValue();
//
//            t.getTreeTableView()
//                    .getTreeItem(t.getTreeTablePosition()
//                            .getRow())
//                    .getValue().setDate_event(t.getNewValue());
//            ps.modifierUser(idd, "date", newValue);
//        });
//        
         // nom_event table view
        JFXTreeTableColumn<User, String> prenom = new JFXTreeTableColumn<>("prenom");
        prenom.setPrefWidth(150);
        prenom.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getPrenom());
            }
        });
                 prenom.setCellFactory((TreeTableColumn<User, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable nom_event text field
        prenom.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setPrenom(t.getNewValue());
            ps.modifierUser(idd, "prenom", newValue);
        });
        
         // username table view
        JFXTreeTableColumn<User, String> username = new JFXTreeTableColumn<>("username");
        username.setPrefWidth(150);
        username.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty((param.getValue().getValue().getUsername()));
            }
        });
        username.setCellFactory((TreeTableColumn<User, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable username text field
        username.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setUsername(t.getNewValue());
            ps.modifierUser(idd, "username", newValue);
        });
        
         // mail table view
        JFXTreeTableColumn<User, String> mail = new JFXTreeTableColumn<>("mail");
        mail.setPrefWidth(150);
        mail.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getMail());
           }

       });
        
        mail.setCellFactory((TreeTableColumn<User, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable mail text field
        mail.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setMail(t.getNewValue());
            ps.modifierUser(idd, "mail", newValue);
        });
        // pwd_user table view
        JFXTreeTableColumn<User, String> pwd_user = new JFXTreeTableColumn<>("pwd_user");
        pwd_user.setPrefWidth(150);
        pwd_user.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getPwd_user());
            }
        });
        
                 pwd_user.setCellFactory((TreeTableColumn<User, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable pwd_user text field
        pwd_user.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_user();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setPwd_user(t.getNewValue());
            ps.modifierUser(idd, "pwd_user", newValue);
        });

     
        
        List<User> myLst;
        myLst = ps.afficherUser();
        ObservableList<User> Users = FXCollections.observableArrayList();

        myLst.forEach(p -> Users.add(p));
        JFXTreeTableView<User> treeview = new JFXTreeTableView<>();
        final TreeItem<User> root = new RecursiveTreeItem<User>(Users, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_user, nom,prenom,username,mail,pwd_user);
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
                Label l1 = new Label("Delete User?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, User>() {
                    @Override
                    public User call(ButtonType param) {
                        if (param == Confi) {
                            User p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerUser((User) p);
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
                treeview.setPredicate(new Predicate<TreeItem<User>>() {
                    @Override
                    public boolean test(TreeItem<Produits> t) {

                        boolean flag = t.getValue().getNom_event().getValue().contains(newValue);
                        return flag;
                    }
                });
            }
        });*/
        
        
        Userview.getChildren().addAll(treeview,DltBtn);
       
  
        
  
    }    
    
    
}
