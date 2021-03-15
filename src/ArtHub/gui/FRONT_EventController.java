/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import ArtHub.entities.Post;
import static ArtHub.gui.LoginController.CurrentUser;
import static ArtHub.gui.ItemBoxController.id_clicked;
import static ArtHub.gui.ItemBoxController.style;
import ArtHub.services.EvenementCRUD;
import ArtHub.services.ParticipantCRUD;
import ArtHub.services.UserCRUD;
import ArtHub.services.postCRUD;
import ArtHub.services.postCRUD;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JFileChooser;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.filechooser.FileNameExtensionFilter;
//import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author Kais Lamine
 */
public class FRONT_EventController implements Initializable {

    @FXML
    private StackPane parentContainer1;

    @FXML
    private AnchorPane anchorRoot1;

    @FXML
    private Button feed_button;

   

    EvenementCRUD ps;
   

    
    @FXML
    private JFXButton Btn_AddEvent;
    @FXML
    private HBox event_layout;
    @FXML
    private HBox event_mostPop;
    @FXML
    private ScrollPane scroll1;
    @FXML
    private ScrollPane scroll2;
    
    private ResourceBundle b;
    private URL url;
    private ActionEvent event1;
    
    @FXML
    private JFXTextField input;
    @FXML
    private ComboBox<String> comboDate = new ComboBox<>();
    @FXML
    private ComboBox<String> comboTrend = new ComboBox<>();
    @FXML
    private ImageView event_img;
    @FXML
    private Label event_description;
    @FXML
    private VBox MoreDetails;
    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label type;
    @FXML
    private Label categorie;
    @FXML
    private Label date;
    @FXML
    private Label location;
    @FXML
    private Label spots;
    @FXML
    private Label participants;
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @FXML
    private JFXButton Btn_AddEvent11;
    @FXML
    private JFXButton Btn_AddEvent111;
    @FXML
    private Label label_layout;
    @FXML
    private Label label_trend;
    @FXML
    private ScrollPane scroll21;
    @FXML
    private HBox recommended_layout;
    @FXML
    private Label label_layout1;
    @FXML
    private ScrollPane scroll22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            scroll21.setFitToHeight(true);
            scroll21.setFitToWidth(true);
            scroll21.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll21.setVbarPolicy(ScrollBarPolicy.NEVER);
            scroll22.setFitToHeight(true);
            scroll22.setFitToWidth(true);
            scroll22.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll22.setVbarPolicy(ScrollBarPolicy.NEVER);
            label_trend.setText("Filter By..");
            label_layout.setText("All upcoming Events");
            comboDate.setVisible(true);
            comboTrend.setVisible(true);
            MoreDetails.setVisible(false);
            comboDate.getItems().clear();
            comboTrend.getItems().clear();
            
            comboDate.getItems().addAll("This Week", "This Month", "Today");
            comboDate.setValue("This Week");
            comboTrend.getItems().addAll("Default","Most Popular", "Most Recent", "Alphabetical");
            comboTrend.setPromptText("Sort By..");
            comboTrend.setValue("Default");
            
			scroll1.setFitToHeight(true);
            scroll1.setFitToWidth(true);
            scroll1.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll1.setVbarPolicy(ScrollBarPolicy.NEVER);scroll2.setHbarPolicy(ScrollBarPolicy.NEVER);
            

			scroll2.setFitToHeight(true);
            scroll2.setFitToWidth(true);
            scroll2.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll2.setVbarPolicy(ScrollBarPolicy.NEVER);
            
            EvenementCRUD ps = new EvenementCRUD();
            List<Evenement> myLst;
            if (comboDate.getValue()=="This Week") {
                myLst = ps.ThisWeekEvenement();
                event_layout.getChildren().clear();
                event_mostPop.getChildren().clear();
                try {
                    for (int i = 0; i < myLst.size(); i++) {
                        
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                        HBox EventBox = fxmlLoader.load();
                        ItemBoxController eventController = fxmlLoader.getController();
                        eventController.setData(myLst.get(i));
                        event_layout.getChildren().add(EventBox);
                        
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
                }}
             
            
            
             Participant aux = new Participant();
        ParticipantCRUD par = new ParticipantCRUD();
            String max = par.RecommendParticip(CurrentUser.getId_user());
        
       
        
           
        myLst = ps.RecommendEvenement(max);
        
        recommended_layout.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                recommended_layout.getChildren().add(EventBox);
               

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            myLst = ps.consulterEvenement();
            try {
                for (int i = 0; i < myLst.size(); i++) {
                  
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                    HBox EventBox = fxmlLoader.load();
                    ItemBoxController eventController = fxmlLoader.getController();
                    eventController.setData(myLst.get(i));
                    event_mostPop.getChildren().add(EventBox);

                }
            } catch (IOException ex) {
                Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
            MoreDetails.setVisible(true);
            MoreDetails.setStyle("-fx-background-color: #b0ffa7;" + "-fx-background-radius: 15;" + "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 ,10.0);");
            EvenementCRUD p = new EvenementCRUD();
            Evenement Evenement = new Evenement();
            Evenement = p.consulterEvenement().get(1);
            UserCRUD u = new UserCRUD();
            event_description.setText("Description :"+Evenement.getDescription());
            String pat = Evenement.getImage_event();
            String org= u.FindUser(Evenement.getId_org().getId_user()).getUsername();
            Image img6 = new Image(new FileInputStream(pat));
            event_img.setImage(img6);
            name.setText(Evenement.getNom_event());
            type.setText("Event Type: "+Evenement.getType_event());
            username.setText("Event organizer: "+org); 
            categorie.setText("Event genre: "+Evenement.getCategorie());
            date.setText("Event date :"+Evenement.getDate_event().format(formatters));
            if(Evenement.getType_event() != "En ligne")
            {location.setText("Event location: "+Evenement.getLocation_event());} else {location.setText("Event link"+Evenement.getLocation_event());}
            spots.setText(Integer.toString(Evenement.getCapacite_event()) + " Remaining spots");
            participants.setText(Integer.toString(Evenement.getNb_max() - Evenement.getCapacite_event()) + " People going");
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
       

    }

    @FXML
    private void load_feed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("feed gui.fxml"));
        Scene scene = feed_button.getScene();

        root.translateXProperty().set(scene.getHeight());
        parentContainer1.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
        timeline.getKeyFrames().add(kf);

        timeline.play();
        //parentContainer.getChildren().remove(anchorRoot);

    }


    private void image_file(ActionEvent event) {

        JFileChooser fileChooser = new JFileChooser();

        

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

  FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
            fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
           String  s = path;

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }

     

    }



    @FXML
    private void AddEvent(ActionEvent event) {
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
    private void filterEvent(KeyEvent event) {
       
            
       if (input.getText() == null || input.getText().trim().equals("")) {
           
           SortByTime(event1);
           SortByTrend(event1);
       }
       else {
      EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
       event_layout.getChildren().clear();
        event_mostPop.getChildren().clear();
        if (comboTrend.getValue()=="Most Recent") {
        myLst = ps.MostRecentFiltered(input.getText());
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
         if (comboTrend.getValue()=="Most Popular") {
        myLst = ps.MostPopularFiltered(input.getText());
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
          if (comboTrend.getValue()=="Alphabetical") {
        myLst = ps.AlphabeticalFiltered(input.getText());
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
          
           if (comboTrend.getValue()=="Default") {
        myLst = ps.consulterFiltered(input.getText());
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboDate.getValue()=="Today") {
        myLst = ps.TodayEvenementFiltered(input.getText());
        event_layout.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboDate.getValue()=="This Month") {
        myLst = ps.ThisMonthEvenementFiltered(input.getText());
        event_layout.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
        if (comboDate.getValue()=="This Week") {
        myLst = ps.ThisWeekEvenementFiltered(input.getText());
        event_layout.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
       }
    }

    @FXML
    private void SortByTime(ActionEvent event) {
         EvenementCRUD ps = new EvenementCRUD();
        event_layout.getChildren().clear();
        List<Evenement> myLst;
        if (comboDate.getValue()=="Today") {
        myLst = ps.TodayEvenement();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboDate.getValue()=="This Month") {
        myLst = ps.ThisMonthEvenement();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboDate.getValue()=="This Week") {
        myLst = ps.ThisWeekEvenement();
        event_layout.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }

    @FXML
    private void SortByTrend(ActionEvent event) {
        EvenementCRUD ps = new EvenementCRUD();
        event_mostPop.getChildren().clear();
        List<Evenement> myLst;
        if (comboTrend.getValue()=="Default") {
        myLst = ps.consulterEvenement();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboTrend.getValue()=="Most Popular") {
        myLst = ps.MostPopularEvenement();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        if (comboTrend.getValue()=="Most Recent") {
        myLst = ps.MostRecentEvenement();
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
        if (comboTrend.getValue()=="Alphabetical") {
        myLst = ps.AlphabeticalEvenement();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
    
    

    @FXML
    private void EventClicked(MouseEvent event) throws FileNotFoundException {
        if (id_clicked != 0) {
            UserCRUD u = new UserCRUD();
            String org="";
            
            MoreDetails.setVisible(true);
            MoreDetails.setStyle(style);
            EvenementCRUD p = new EvenementCRUD();
            Evenement Evenement = new Evenement();
            Evenement = p.FindEvenement(id_clicked);
            org= u.FindUser(Evenement.getId_org().getId_user()).getUsername();
            event_description.setText("Description :"+Evenement.getDescription());
            String pat = Evenement.getImage_event();
            System.out.println(pat);
            Image img6 = new Image(new FileInputStream(pat));
            event_img.setImage(img6);
            name.setText(Evenement.getNom_event());
            type.setText("Event Type: "+Evenement.getType_event());
            username.setText("Event organizer: "+org); //LezmLouay yekhdem find User by ID
            categorie.setText("Event genre: "+Evenement.getCategorie());
            date.setText("Event date :"+Evenement.getDate_event().format(formatters));
            if(Evenement.getType_event() != "En ligne")
            {location.setText("Event location: "+Evenement.getLocation_event());} else {location.setText("Event link"+Evenement.getLocation_event());}
            spots.setText(Integer.toString(Evenement.getCapacite_event()) + " Remaining spots");
            participants.setText(Integer.toString(Evenement.getNb_max() - Evenement.getCapacite_event()) + " People going");

           
           
            
    
  
        }
        
    }


    @FXML
    private void GoingTo(ActionEvent event) {
       label_trend.setText("Going To..");
        label_layout.setText("Went To..");
        comboDate.setVisible(false);
        comboTrend.setVisible(false);
        MoreDetails.setVisible(false);
        comboDate.getItems().clear();
        comboTrend.getItems().clear();
       
        
      

        EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
        myLst = ps.GoingTo(CurrentUser.getId_user());
        event_layout.getChildren().clear();
        
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_layout.getChildren().add(EventBox);
               

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void WentTo(ActionEvent event) {
        label_trend.setText("Going To..");
        label_layout.setText("Went To..");
        comboDate.setVisible(false);
        comboTrend.setVisible(false);
        MoreDetails.setVisible(false);
        comboDate.getItems().clear();
        comboTrend.getItems().clear();
                
      

        EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
        myLst = ps.WentTo(CurrentUser.getId_user());
       
        event_mostPop.getChildren().clear();
        try {
            for (int i = 0; i < myLst.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                HBox EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                event_mostPop.getChildren().add(EventBox);
               

            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refresh2(MouseEvent event) {
        initialize(url, b);
    }

    

   
    



}
