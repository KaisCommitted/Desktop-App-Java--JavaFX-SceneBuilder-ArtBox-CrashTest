package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.User;
import ArtHub.services.EvenementCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class HomeController implements Initializable {
 
    EvenementCRUD ps;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnJobs;
    @FXML
    private Button BtnLabels;
    @FXML
    private Button btnFeedbacks;
    @FXML
    private Button btnEvents;
    @FXML
    private Button btnCategories;
    @FXML
    private Button btnPosts;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlEvents;
    @FXML
    private TextField inputEvents;
    @FXML
    private HBox event_stats;
    @FXML
    private Label Events_thisweek;
    @FXML
    private Label Eventsthisweek;
    @FXML
    private ImageView showHistory;
    @FXML
    private VBox pnItems1;
    @FXML
    private Pane pnlUsers;
    @FXML
    private TextField inputUsers;
    @FXML
    private HBox Users_stats;
    @FXML
    private ImageView showHistory1;
    @FXML
    private VBox pnItems11;
    @FXML
    private Pane pnlJobs;
    @FXML
    private TextField inputJobs;
    @FXML
    private HBox Jobs_stats;
    @FXML
    private ImageView showHistory11;
    @FXML
    private VBox pnItems111;
    @FXML
    private Pane pnlLabels;
    @FXML
    private HBox Labels_stats;
    @FXML
    private ImageView showHistory111;
    @FXML
    private VBox pnItems1111;
    @FXML
    private Pane pnlFeedback;
    @FXML
    private HBox Feedback_stats;
    @FXML
    private ImageView showHistory1111;
    @FXML
    private VBox pnItems11111;
    @FXML
    private Pane pnlCategorie;
    @FXML
    private HBox Categorie_stats;
    @FXML
    private ImageView showHistory11111;
    @FXML
    private VBox pnItems111111;
    @FXML
    private Pane pnlPosts;
    @FXML
    private HBox Posts_stats;
    @FXML
    private ImageView showHistory111111;
    @FXML
    private VBox pnItems1111111;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }


    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == BtnLabels) {
            ShowLabels();
            pnlLabels.setStyle("-fx-background-color : #02030A");
            pnlLabels.toFront();
          
           
        }
        if (actionEvent.getSource() == btnCategories) {
            ShowCategorie();
            pnlCategorie.setStyle("-fx-background-color : #02030A");
            pnlCategorie.toFront();
            
           
        }
        if (actionEvent.getSource() == btnFeedbacks) {
             ShowFeeback();
            pnlFeedback.setStyle("-fx-background-color : #02030A");
            pnlFeedback.toFront();
            
        }
        if (actionEvent.getSource() == btnUsers)
       
        {
             ShowUsers();
            pnlUsers.setStyle("-fx-background-color : #02030A");
            pnlUsers.toFront();
               
            
        }
        if(actionEvent.getSource()==btnJobs)
        {
            ShowJobs();
            pnlJobs.setStyle("-fx-background-color : #02030A");
            pnlJobs.toFront();
        }
        if(actionEvent.getSource()==btnSignout)
        {
            
        }
        if(actionEvent.getSource()==btnPosts)
        {
            ShowPosts();
            pnlPosts.setStyle("-fx-background-color : #02030A");
            pnlPosts.toFront();
            
        }
        
        if(actionEvent.getSource()==btnEvents)
        {  
            ShowEvents();
            pnlEvents.setStyle("-fx-background-color : #02030A");
            pnlEvents.toFront();
        }
    }
    
    
    
      public void ShowUsers()
      { 
        Users_stats.setVisible(true);
      }
      public void ShowJobs()
      { 
           Jobs_stats.setVisible(true);
      }
      public void ShowLabels()
      { 
          Labels_stats.setVisible(true);
      }
     public void ShowFeeback()
      { 
           Feedback_stats.setVisible(true);
      }
      public void ShowCategorie()
      { 
           Categorie_stats.setVisible(true);
      }
          
     public void ShowPosts()
      { 
            Posts_stats.setVisible(true);
      }
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void ShowEvents(){ 
   
    pnItems1.getChildren().clear();
            EvenementCRUD ps = new EvenementCRUD();
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
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_org().getId_user()));
            }
        });
        //making the cell editable
        id_org.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable id_org text field
        id_org.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();
            User id_user = new User();
            id_user.setId_user(Integer.parseInt(t.getNewValue()));
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_org(id_user);
            ps.modifierEvenement(idd, "id_org", newValue);
        });
        
        
        
         // date table view
         DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        JFXTreeTableColumn<Evenement, String> date = new JFXTreeTableColumn<>("date");
        date.setPrefWidth(150);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDate_event().format(formatters));
            }
        });
                 date.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable date text field
        date.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {  
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDate_event(LocalDate.parse(t.getNewValue(),formatters));
            ps.modifierEvenement(idd, "date", newValue);
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
                 nom_event.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable nom_event text field
        nom_event.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setNom_event(t.getNewValue());
            ps.modifierEvenement(idd, "nom_event", newValue);
        });
        
         // type_event table view
        JFXTreeTableColumn<Evenement, String> type_event = new JFXTreeTableColumn<>("type_event");
        type_event.setPrefWidth(150);
        type_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getType_event());
            }
        });
        type_event.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable type_event text field
        type_event.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setType_event(t.getNewValue());
            ps.modifierEvenement(idd, "type_event", newValue);
        });
        
         // categorie table view
        JFXTreeTableColumn<Evenement, String> categorie = new JFXTreeTableColumn<>("categorie");
        categorie.setPrefWidth(150);
        categorie.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getCategorie());
           }

       });
        
        categorie.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable cat+1egorie text field
        categorie.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCategorie(t.getNewValue());
            ps.modifierEvenement(idd, "categorie", newValue);
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
        
            description.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable description text field
        description.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDescription(t.getNewValue());
            ps.modifierEvenement(idd, "description", newValue);
        });
        JFXTreeTableColumn<Evenement, String> capacite_event = new JFXTreeTableColumn<>("capacite_event");
        capacite_event.setPrefWidth(150);
        capacite_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getCapacite_event()));
           }

       });
        
        capacite_event.setCellFactory((TreeTableColumn<Evenement, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable capacite_event text field
        capacite_event.setOnEditCommit((CellEditEvent<Evenement, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCapacite_event(Integer.parseInt(t.getNewValue()));
            ps.modifierEvenement(idd, "capacite_event", newValue);
        });

     
        
        List<Evenement> myLst;
        myLst = ps.consulterEvenement();
        ObservableList<Evenement> Evenements = FXCollections.observableArrayList();

        myLst.forEach(p -> Evenements.add(p));
        int i=0;
        for (int j=0;j<myLst.size();j++){
        if (myLst.get(j).getDate_event().compareTo(LocalDate.now()) >= 7) {i++;}
        }
        JFXTreeTableView<Evenement> treeview = new JFXTreeTableView<>();
        final TreeItem<Evenement> root = new RecursiveTreeItem<Evenement>(Evenements, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id, id_org,date,nom_event,type_event,categorie,description,capacite_event);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
        treeview.getStylesheets().add(getClass().getResource("treetableview.css").toExternalForm());
        
        
        
       
        //declarer la button supprimer
        JFXButton DltBtn = new JFXButton("Remove");
        DltBtn.setLayoutY(410D);
        //DltBtn.getStylesheets().add(getClass(button3).getResource("feed gui.css").toExternalForm());
        DltBtn.setOnAction(new EventHandler<ActionEvent>() {
            //eventHandler de la button supprimer
            @Override
            public void handle(ActionEvent event) {
                Dialog confirmation = new Dialog();
                GridPane grid2 = new GridPane();
                Label l1 = new Label("Delete Evenement?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Evenement>() {
                    @Override
                    public Evenement call(ButtonType param) {
                        if (param == Confi) {
                            Evenement p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerEvenement((Evenement) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            ShowEvents();
                        }

                        return null;
                    }
                });
                confirmation.showAndWait();
            }
        }); 
        
        inputEvents.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               treeview.setPredicate(new Predicate<TreeItem<Evenement>>() {
                    @Override
                    public boolean test(TreeItem<Evenement> t) {

                        boolean flag = t.getValue().getNom_event().toLowerCase().contains(newValue.toLowerCase());
                        return flag;
                    }
                });
            }
        });
         event_stats.setVisible(true);
        Events_thisweek.setText(Integer.toString(i));
        Eventsthisweek.setText("Events this week");
        treeview.setStyle("-fx-background-color:rgba(0,255,255,0.2);");
        pnItems1.getChildren().addAll(treeview,DltBtn);
       
    
    }
}
