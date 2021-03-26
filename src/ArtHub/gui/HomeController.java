package ArtHub.gui;

import ArtHub.entities.Categorie;
import ArtHub.entities.Evenement;
import ArtHub.entities.Feedback;
import ArtHub.entities.Labell;
import ArtHub.entities.Participant;
import ArtHub.entities.User;
import ArtHub.services.EvenementCRUD;
import ArtHub.services.FeedbackCRUD;
import ArtHub.services.LabelCRUD;
import ArtHub.services.ParticipantCRUD;
import ArtHub.services.UserCRUD;
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
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class HomeController implements Initializable {
 
   
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
    private Pane pnlUsers;
    @FXML
    private TextField inputUsers;
    @FXML
    private HBox Users_stats;
    @FXML
    private ImageView showHistory1;
    @FXML
    private Pane pnlJobs;
    @FXML
    private TextField inputJobs;
    @FXML
    private HBox Jobs_stats;
    @FXML
    private ImageView showHistory11;
    @FXML
    private Pane pnlLabels;
    @FXML
    private HBox Labels_stats;
    @FXML
    private ImageView showHistory111;
    @FXML
    private Pane pnlFeedback;
    @FXML
    private HBox Feedback_stats;
    @FXML
    private ImageView showHistory1111;
    @FXML
    private Pane pnlCategorie;
    @FXML
    private HBox Categorie_stats;
    @FXML
    private ImageView showHistory11111;
    @FXML
    private Pane pnlPosts;
    @FXML
    private HBox Posts_stats;
    @FXML
    private ImageView showHistory111111;
    @FXML
    private VBox itemsLabels;
    @FXML
    private VBox itemsEvents;
    @FXML
    private VBox itemsUsers;
    @FXML
    private VBox itemsJobs;
    @FXML
    private VBox itemsFeedback;
    @FXML
    private VBox ItemsCategorie;
    @FXML
    private VBox ItemsPosts;
    @FXML
    private ImageView addEvent;
    @FXML
    private Label events_this_month;
    @FXML
    private Label Total_events;
    @FXML
    private Label Total_participants;
    @FXML
    private ImageView archive;
    @FXML
    private ImageView SwitchFront;
    

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
          LabelCRUD ps = new LabelCRUD();
        // id table view
        JFXTreeTableColumn<Labell, String> id = new JFXTreeTableColumn<>("id");
        id.setPrefWidth(150);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Labell, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Labell, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId()));
            }
        });
        
         // name table view
        JFXTreeTableColumn<Labell, String> name = new JFXTreeTableColumn<>("name");
        name.setPrefWidth(150);
        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Labell, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Labell, String> param) {
                return new SimpleStringProperty((param.getValue().getValue().getname()));
            }
        });
        //making the cell editable
        name.setCellFactory((TreeTableColumn<Labell, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable name text field
        name.setOnEditCommit((CellEditEvent<Labell, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setname(t.getNewValue());
            ps.modifierLabel(idd, "name", newValue);
        });
        
        
        
        
         // type table view
        JFXTreeTableColumn<Labell, String> type = new JFXTreeTableColumn<>("type");
        type.setPrefWidth(150);
        type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Labell, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Labell, String> param) {
                return new SimpleStringProperty((param.getValue().getValue().gettype()));
            }
        });
        //making the cell editable
        type.setCellFactory((TreeTableColumn<Labell, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable type text field
        type.setOnEditCommit((CellEditEvent<Labell, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().settype(t.getNewValue());
            ps.modifierLabel(idd, "type", newValue);
        });
        
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        
        List<Labell> myLst;
        myLst = ps.consulterLabel();
        ObservableList<Labell> Labels = FXCollections.observableArrayList();

        myLst.forEach(p -> Labels.add(p));
        JFXTreeTableView<Labell> treeview = new JFXTreeTableView<>();
        final TreeItem<Labell> root = new RecursiveTreeItem<Labell>(Labels, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id,name,type);
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
                Label l1 = new Label("Delete Label?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Labell>() {
                    @Override
                    public Labell call(ButtonType param) {
                        if (param == Confi) {
                            Labell p = treeview.getSelectionModel().getSelectedItem().getValue();
                            ps.supprimerLabel((Labell) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            ShowLabels();
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
                treeview.setPredicate(new Predicate<TreeItem<Label>>() {
                    @Override
                    public boolean test(TreeItem<Produits> t) {

                        boolean flag = t.getValue().getNom_event().getValue().contains(newValue);
                        return flag;
                    }
                });
            }
        });*/
          treeview.getStylesheets().add(getClass().getResource("treetableview.css").toExternalForm());
       treeview.setStyle("-fx-background-color:rgba(0,255,255,0.2);");
       itemsLabels.getChildren().addAll(treeview,DltBtn);
          Labels_stats.setVisible(true);
      }
     public void ShowFeeback()
      { 
            FeedbackCRUD ps = new FeedbackCRUD();
            
            itemsEvents.getChildren().clear();
        // id_feedback table view
        JFXTreeTableColumn<Feedback, String> id_feedback = new JFXTreeTableColumn<>("id_feedback");
        id_feedback.setPrefWidth(250);
        id_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_feedback()));
            }
        });
        
         //contenu_feedback table view
        JFXTreeTableColumn<Feedback, String> contenu_feedback = new JFXTreeTableColumn<>("contenu_feedback");
        contenu_feedback.setPrefWidth(250);
        contenu_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getContenu_feedback());
            }
        });
        
        // type_feedback table view
        JFXTreeTableColumn<Feedback, String> type_feedback = new JFXTreeTableColumn<>("type_feedback");
        type_feedback.setPrefWidth(250);
        type_feedback.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Feedback, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Feedback, String> param) {
               return new SimpleStringProperty(param.getValue().getValue().getType_feedback());
           }
        });
        
         // etat_feedback table view
        JFXTreeTableColumn<Feedback, String> etat_feedback = new JFXTreeTableColumn<>("etat_feedback");
        etat_feedback.setPrefWidth(250);
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
        //initialize(url, rb);
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
        treeview.getStylesheets().add(getClass().getResource("treetableview.css").toExternalForm());
       treeview.setStyle("-fx-background-color:rgba(0,255,255,0.2);");
        itemsFeedback.getChildren().addAll(treeview,DltBtn);
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
    
    
    
    
    //ShowEvents ahayka louta if u need guidance CSS etc
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void ShowEvents(){ 
        SwitchFront.setVisible(true);
   
    itemsEvents.getChildren().clear();
            EvenementCRUD ps = new EvenementCRUD();
            UserCRUD us = new UserCRUD();
           
       
        
         // id_org table view
        JFXTreeTableColumn<Evenement, String> id_org = new JFXTreeTableColumn<>("Orgranisateur");
        id_org.setPrefWidth(150);
        id_org.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                 int x =param.getValue().getValue().getId_org().getId_user();
                User user = us.FindUser(x);
                return new SimpleStringProperty(user.getUsername());
            }
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
               return new SimpleStringProperty(param.getValue().getValue().getCategorie().getCategorie_name());
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
            Categorie C = new Categorie();
           C.setCategorie_name(t.getNewValue());
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCategorie(C);
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
        int i=0; int x=0; int z = myLst.size();
        for (int j=0;j<myLst.size();j++){
        if (DAYS.between(LocalDate.now(), myLst.get(j).getDate_event()) <= 7 ) {i++;}
        if (DAYS.between(LocalDate.now(), myLst.get(j).getDate_event()) <= 30 ) {x++;}
        }
        JFXTreeTableView<Evenement> treeview = new JFXTreeTableView<>();
        final TreeItem<Evenement> root = new RecursiveTreeItem<Evenement>(Evenements, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll( id_org,date,nom_event,type_event,categorie,description,capacite_event);
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
                            
                            String name = treeview.getSelectionModel().getSelectedItem().getValue().getNom_event();
                            
                            Evenement p = ps.FindEvenementByName(name);
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
         events_this_month.setText(Integer.toString(x));
         Total_events.setText(Integer.toString(z));
        Eventsthisweek.setText("Events this week");
        treeview.setStyle("-fx-background-color:rgba(0,255,255,0.2);");
        itemsEvents.getChildren().addAll(treeview,DltBtn);
       
       ParticipantCRUD crud=new ParticipantCRUD();
       Participant inst = new Participant();
         List<Participant> myList ;
         myList= crud.consulterParticipant();
         Total_participants.setText(Integer.toString(myList.size()));
         
     }

    @FXML
    private void addEvent(MouseEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ADD_Event.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Host an event");
            
            stage.setScene(new Scene(root1));
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    @FXML
    private void refresh(MouseEvent event) {
        ShowEvents();
    }

    @FXML
    private void archive(MouseEvent event) { 
        
   
          itemsEvents.getChildren().clear();
            EvenementCRUD ps = new EvenementCRUD();
        UserCRUD us = new UserCRUD();
          
        
        
         // id_org table view
        JFXTreeTableColumn<Evenement, String> id_org = new JFXTreeTableColumn<>("Orgranisateur");
        id_org.setPrefWidth(50);
        id_org.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Evenement, String> param) {
                int x =param.getValue().getValue().getId_org().getId_user();
                User user = us.FindUser(x);
                return new SimpleStringProperty(user.getUsername());
            }
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
               return new SimpleStringProperty(param.getValue().getValue().getCategorie().getCategorie_name());
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
           Categorie C = new Categorie();
           C.setCategorie_name(t.getNewValue());
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setCategorie(C);
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
        myLst = ps.ArchiveEvenement();
        ObservableList<Evenement> Evenements = FXCollections.observableArrayList();
        
        myLst.forEach(p -> Evenements.add(p));
        
        
        JFXTreeTableView<Evenement> treeview = new JFXTreeTableView<>();
        final TreeItem<Evenement> root = new RecursiveTreeItem<Evenement>(Evenements, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll( id_org,date,nom_event,type_event,categorie,description,capacite_event);
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
                          String name = treeview.getSelectionModel().getSelectedItem().getValue().getNom_event();
                            Evenement p = ps.FindEvenementByName(name);
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
        
       
        treeview.setStyle("-fx-background-color:rgba(0,255,255,0.2);");
        itemsEvents.getChildren().addAll(treeview,DltBtn);
       
      
         
     }

    @FXML
    private void showParticipants(MouseEvent event) {
        ParticipantCRUD ps = new ParticipantCRUD();
        itemsEvents.getChildren().clear();
        // id_participation table view
        JFXTreeTableColumn<Participant, String> id_participation = new JFXTreeTableColumn<>("id_participation");
        id_participation.setPrefWidth(300);
        id_participation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_participation()));
            }
        });
        
         // id_user table view
        JFXTreeTableColumn<Participant, String> id_user = new JFXTreeTableColumn<>("id_user");
        id_user.setPrefWidth(300);
        id_user.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_user().getId_user()));
            }
        });
        // id_event table view
        JFXTreeTableColumn<Participant, String> id_event = new JFXTreeTableColumn<>("id_event");
        id_event.setPrefWidth(300);
        id_event.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Participant, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Participant, String> param) {
               return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_event().getId()));
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
        treeview.getStylesheets().add(getClass().getResource("treetableview.css").toExternalForm());
        
       
        
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
                            
                        }

                        return null;
                    }
                });
                confirmation.showAndWait();
            }
        }); 
        
        inputEvents.setPromptText("Rechercher ..");
        inputEvents.textProperty().addListener(new ChangeListener<String>() {
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
        
        
        itemsEvents.getChildren().addAll(treeview,DltBtn);
    } 

    @FXML
    private void SwitchFront(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FRONT_Event.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Host an event");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
      
    
}


