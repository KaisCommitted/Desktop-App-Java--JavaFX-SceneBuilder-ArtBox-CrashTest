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
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Moetez
 */
public class AfficherFeedbackController implements Initializable {

    private ObservableList<Feedback> fedData = FXCollections.observableArrayList();
    @FXML
    private AnchorPane anchorfeedback;
    FeedbackCRUD ps;
    @FXML
    private TextField search;
    private TableColumn<Feedback, Integer>id;
    private TableColumn<Feedback, Integer> id_user;
    private TableColumn <Feedback, String> contenu;
    private TableColumn<Feedback, String> type;
    private TableColumn<Feedback, String> etat;
    private TableView<Feedback> table;
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

    @FXML
    private void GoToStat(MouseEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StatFeedback.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Statistiques");
            
            stage.setScene(new Scene(root1));
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }

    @FXML
    private void search(ActionEvent event) {
//         FilteredList<Feedback> filteredData = new FilteredList<>(fedData, b -> true);
//		
//		// 2. Set the filter Predicate whenever the filter changes.
//		search.textProperty().addListener((observable, oldValue, newValue) -> {
//			filteredData.setPredicate(Feedback -> {
//				// If filter text is empty, display all persons.
//								
//				if (newValue == null || newValue.isEmpty()) {
//					return true;
//				}
//				
//				// Compare first name and last name of every person with filter text.
//				String lowerCaseFilter = newValue.toLowerCase();
//				
//				if (Feedback.getEtat_feedback().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
//					return true; // Filter matches first name.
//				}
//				else if (String.valueOf(Feedback.getId_feedback()).contains(lowerCaseFilter))
//				     return true;
//				     else  
//				    	 return false; // Does not match.
//			});
//		});
//		// 3. Wrap the FilteredList in a SortedList. 
//		SortedList<Feedback> sortedData = new SortedList<>(filteredData);
//		// 4. Bind the SortedList comparator to the TableView comparator.
//		// 	  Otherwise, sorting the TableView would have no effect.
//		sortedData.comparatorProperty().bind( .comparatorProperty());
//		// 5. Add sorted (and filtered) data to the table.
//		treeview.setItems(sortedData);
//    
        
        
        
        
        
    }
    
}
        
    

