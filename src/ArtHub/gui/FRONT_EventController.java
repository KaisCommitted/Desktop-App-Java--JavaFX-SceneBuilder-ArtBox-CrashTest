/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.Partenaire;
import ArtHub.entities.Participant;
import ArtHub.entities.Post;
import ArtHub.entities.Whatsapp;
import static ArtHub.gui.CategoriePickerController.clicked_cat;
import static ArtHub.gui.ItemBoxController.highlight;
import static ArtHub.gui.ItemBoxController.highlightBtn;
import static ArtHub.gui.LoginController.CurrentUser;
import static ArtHub.gui.ItemBoxController.id_clicked;
import static ArtHub.gui.ItemBoxController.style;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.EvenementCRUD;
import ArtHub.services.PartenaireCRUD;
import ArtHub.services.ParticipantCRUD;
import ArtHub.services.UserCRUD;
import ArtHub.services.postCRUD;
import ArtHub.services.postCRUD;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
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
import com.kieferlam.javafxblur.Blur;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

import javax.swing.filechooser.FileNameExtensionFilter;
import org.controlsfx.control.Notifications;
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
    private Button feed_button;

    EvenementCRUD ps;

    @FXML
    private JFXButton Btn_AddEvent;

    @FXML
    private HBox event_mostPop;
    @FXML
    private ScrollPane scroll1;

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
    private AnchorPane MoreDetails;
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
    private ScrollPane scroll21;
    @FXML
    private HBox recommended_layout;
    @FXML
    private Label label_layout1;
    @FXML
    private ScrollPane scroll22;
    @FXML
    private ImageView BtnClose;
    @FXML
    private ImageView ratedImg;
    @FXML
    private Label ratedLbl;
    @FXML
    private Label ticketlbl;
    @FXML
    private ImageView ticketimg;
    @FXML
    private ImageView imgspots;
    @FXML
    private ImageView imgdate;
    @FXML
    private ImageView imglocation;
    @FXML
    private ImageView imgcat;
    @FXML
    private ImageView imgorg;
public static String userHomeFolder = System.getProperty("user.home");
    @FXML
    private ImageView catshow;
    @FXML
    private ImageView btnSearch;
    @FXML
    private JFXButton Btn_partner;
    @FXML
    private ScrollPane scrollPartner;
    @FXML
    private HBox PartnerHbox;
    Partenaire P = new Partenaire();
    @FXML
    private ImageView user_image;
    @FXML
    private Label usernameCurrent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sendWhatsapp();
        try {
            usernameCurrent.setText(CurrentUser.getUsername());
             PartenaireCRUD pt = new PartenaireCRUD();
        if (!pt.checkPartenaire(CurrentUser.getId_user())) {
            Btn_partner.setVisible(true);  
          Btn_AddEvent.setVisible(false); 
        }else if(pt.FindByPartenaire(CurrentUser.getId_user()).getStatus()==0 ){
          Btn_partner.setVisible(false);  
          Btn_AddEvent.setVisible(false);  
          
        }
        else if(pt.FindByPartenaire(CurrentUser.getId_user()).getStatus()==1 ){
            Btn_partner.setVisible(false);
            
              Btn_AddEvent.setVisible(true);
        } 
        
        List<Partenaire> myLest;
        myLest = pt.consulterPartenaire();
          PartnerHbox.getChildren().clear();
       for (int i = 0; i < myLest.size(); i++) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemPartner.fxml"));
                AnchorPane EventBox = fxmlLoader.load();
                ItemPartnerController controller = fxmlLoader.getController();
                controller.setData(myLest.get(i));
                PartnerHbox.getChildren().add(EventBox);
            } catch (IOException ex) {
                Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }   }
       
            //////////////////////////////////WHATSAPPP MAKE 24H window + check credentials//////////////////////////////////////////
            
            ///////////////////////////////////WHATSAAAAAP////////////////////////////////////////////
           setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\icons8_Search_52px.png",btnSearch);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\close.png",BtnClose);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\icons8_Person_32px.png", imgspots);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\calendar.png", imgdate);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\location.png", imglocation);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\choice.png", imgcat);
            setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\event-planner.png", imgorg);
              setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\ticket.png",ticketimg);
              setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\choice.png", imgcat);
            setImage(CurrentUser.getImage(), user_image);
            scroll21.setFitToHeight(true);
            scroll21.setFitToWidth(true);
            scroll21.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll21.setVbarPolicy(ScrollBarPolicy.NEVER);
            scroll22.setFitToHeight(true);
            scroll22.setFitToWidth(true);
            scroll22.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll22.setVbarPolicy(ScrollBarPolicy.NEVER);

            label_layout.setText("All upcoming Events");
            comboDate.setVisible(true);
            comboTrend.setVisible(true);
            MoreDetails.setVisible(false);
            comboDate.getItems().clear();
            comboTrend.getItems().clear();

            comboDate.getItems().addAll("All Events", "Upcoming", "This Week", "This Month", "Today");
            comboDate.setValue("Upcoming");
            comboTrend.getItems().addAll("Default", "Most Popular", "Most Recent", "Alphabetical");
            comboTrend.setPromptText("Sort By..");
            comboTrend.setValue("Default");

            scroll1.setFitToHeight(true);
            scroll1.setFitToWidth(true);
            scroll1.setHbarPolicy(ScrollBarPolicy.NEVER);
            scroll1.setVbarPolicy(ScrollBarPolicy.NEVER);
notifyme();
            EvenementCRUD ps = new EvenementCRUD();
            List<Evenement> myLst;

            Participant aux = new Participant();
            ParticipantCRUD par = new ParticipantCRUD();
           String max = par.RecommendParticip(CurrentUser.getId_user());

            myLst = ps.RecommendEvenement(max);
            ParticipantCRUD pc = new ParticipantCRUD();
            for(int i=0 ; i<myLst.size() ; i++ ) {
            if ((pc.CheckUserExists(CurrentUser.getId_user(),myLst.get(i).getId())))
                     {
                myLst.remove(i);
               }
            }
            recommended_layout.getChildren().clear();
            FillHbox1(myLst, recommended_layout);

            myLst = ps.consulterEvenement();
            FillHbox1(myLst, event_mostPop);
            MoreDetails.setVisible(true);
            MoreDetails.setStyle("-fx-background-color: #b0ffa7;" + "-fx-background-radius: 15;" + "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 ,10.0);");
            EvenementCRUD p = new EvenementCRUD();
            Evenement Evenement = new Evenement();
            Evenement = p.consulterEvenement().get(5);
            UserCRUD u = new UserCRUD();
            event_description.setText("Description :" + Evenement.getDescription());
            String pat = Evenement.getImage_event();
            String org = u.FindUser(Evenement.getId_org().getId_user()).getUsername();
            Image img6 = new Image(new FileInputStream(pat));
            event_img.setImage(img6);
            name.setText(Evenement.getNom_event());
            type.setText("Event Type: " + Evenement.getType_event());
            username.setText("Event organizer: " + org);
            categorie.setText("Event genre: " + Evenement.getCategorie().getCategorie_name());
            date.setText("Event date :" + Evenement.getDate_event().format(formatters));
            if (Evenement.getType_event() != "En ligne") {
                location.setText("Event location: " + Evenement.getLocation_event());
            } else {
                location.setText("Event link" + Evenement.getLocation_event());
            }
            spots.setText(Integer.toString(Evenement.getCapacite_event()) + " Remaining spots");
            participants.setText(Integer.toString(Evenement.getNb_max() - Evenement.getCapacite_event()) + " People going");
            if (Evenement.getRating() == 0) {
                ratedImg.setVisible(false);
                ratedLbl.setVisible(false);
            } else {
                ratedLbl.setText(Integer.toString(Evenement.getRating()));
            }

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
            String s = path;

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }

    }

    @FXML
    private void AddEvent(ActionEvent event) {
        try {
           
            
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ADD_event.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
          
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            //stage.setOpacity(0.2);
            stage.initStyle(StageStyle.TRANSPARENT);
           
            root1.setStyle(" -fx-background-color:rgba(	0, 0, 0,0.9);");
            Scene scene = new Scene(root1);
             scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @FXML
    private void filterEvent(KeyEvent event) {

        if (input.getText() == null || input.getText().trim().equals("")) {

            SortByTime(event1);

        } else {

            EvenementCRUD ps = new EvenementCRUD();
            List<Evenement> myLst;
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Default") {
                myLst = ps.AllFiltered(input.getText());
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.AllFiltered(input.getText());
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.AllFiltered(input.getText());
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.AllFiltered(input.getText());
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Default") {
                myLst = ps.consulterFiltered(input.getText());
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.consulterFiltered(input.getText());
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.consulterFiltered(input.getText());
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.consulterFiltered(input.getText());
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Default") {
                myLst = ps.TodayEvenementFiltered(input.getText());
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.TodayEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.TodayEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.TodayEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Default") {
                myLst = ps.ThisMonthEvenementFiltered(input.getText());
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.ThisMonthEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.ThisMonthEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.ThisMonthEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Default") {
                myLst = ps.ThisWeekEvenementFiltered(input.getText());
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.ThisWeekEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);
            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.ThisWeekEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);
            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.ThisWeekEvenementFiltered(input.getText());
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);
            }

        }
    }

    @FXML
    private void SortByTime(ActionEvent event) {

        EvenementCRUD ps = new EvenementCRUD();
        event_mostPop.getChildren().clear();
        List<Evenement> myLst;

        if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Default") {
            label_layout.setText("All Events");
            myLst = ps.AllEvenement();
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Popular") {
            label_layout.setText("All Events");
            myLst = ps.AllEvenement();
            Collections.sort(myLst, compareByParticipants);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Recent") {
            label_layout.setText("All Events");
            myLst = ps.AllEvenement();
            Collections.sort(myLst, compareByMostRecent);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Alphabetical") {
            label_layout.setText("All Events");
            myLst = ps.AllEvenement();
            Collections.sort(myLst, compareByAlphabetical);
            FillHbox1(myLst, event_mostPop);
        }

        if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Default") {
            label_layout.setText("All upcoming Events");
            myLst = ps.consulterEvenement();
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Popular") {
            label_layout.setText("All upcoming Events");
            myLst = ps.consulterEvenement();
            Collections.sort(myLst, compareByParticipants);
            FillHbox1(myLst, event_mostPop);
        }

        if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Recent") {
            label_layout.setText("All upcoming Events");
            myLst = ps.consulterEvenement();
            Collections.sort(myLst, compareByMostRecent);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Alphabetical") {
            label_layout.setText("All upcoming Events");
            myLst = ps.consulterEvenement();
            Collections.sort(myLst, compareByAlphabetical);
            FillHbox1(myLst, event_mostPop);
        }

        if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Default") {
            label_layout.setText("This month's Events");
            myLst = ps.ThisMonthEvenement();
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Popular") {
            label_layout.setText("This month's Events");
            myLst = ps.ThisMonthEvenement();
            Collections.sort(myLst, compareByParticipants);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Recent") {
            label_layout.setText("This month's Events");
            myLst = ps.ThisMonthEvenement();
            Collections.sort(myLst, compareByMostRecent);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Alphabetical") {
            label_layout.setText("This month's Events");
            myLst = ps.ThisMonthEvenement();
            Collections.sort(myLst, compareByAlphabetical);
            FillHbox1(myLst, event_mostPop);
        }

        if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Default") {
            label_layout.setText("This week's Events");
            myLst = ps.ThisWeekEvenement();
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Popular") {
            label_layout.setText("This week's Events");
            myLst = ps.ThisWeekEvenement();
            Collections.sort(myLst, compareByParticipants);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Recent") {
            myLst = ps.ThisWeekEvenement();
            Collections.sort(myLst, compareByMostRecent);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Alphabetical") {
            label_layout.setText("This week's Events");
            myLst = ps.ThisWeekEvenement();
            Collections.sort(myLst, compareByAlphabetical);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Default") {
            label_layout.setText("Happening Today");
            myLst = ps.TodayEvenement();
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Popular") {
            label_layout.setText("Happening Today");
            myLst = ps.TodayEvenement();
            Collections.sort(myLst, compareByParticipants);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Recent") {
            myLst = ps.TodayEvenement();
            Collections.sort(myLst, compareByMostRecent);
            FillHbox1(myLst, event_mostPop);
        }
        if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Alphabetical") {
            label_layout.setText("Happening Today");
            myLst = ps.TodayEvenement();
            Collections.sort(myLst, compareByAlphabetical);
            FillHbox1(myLst, event_mostPop);
        }
    }

    @FXML
    private void EventClicked(MouseEvent event) throws FileNotFoundException {
    
        ParticipantCRUD pc= new ParticipantCRUD();
        if (id_clicked != 0) {
            UserCRUD u = new UserCRUD();
            String org = "";

            MoreDetails.setVisible(true);
            MoreDetails.setStyle(style);
            EvenementCRUD p = new EvenementCRUD();
            Evenement Evenement = new Evenement();
            Evenement = p.FindEvenement(id_clicked);
            org = u.FindUser(Evenement.getId_org().getId_user()).getUsername();
            event_description.setText("Description :" + Evenement.getDescription());
            String pat = Evenement.getImage_event();
            System.out.println(pat);
            Image img6 = new Image(new FileInputStream(pat));
            event_img.setImage(img6);
            name.setText(Evenement.getNom_event());
            type.setText("Event Type: " + Evenement.getType_event());
            username.setText("Event organizer: " + org); //LezmLouay yekhdem find User by ID
            categorie.setText("Event genre: " + Evenement.getCategorie().getCategorie_name());
            date.setText("Event date :" + Evenement.getDate_event().format(formatters));
            if (Evenement.getType_event() != "En ligne") {
                location.setText("Event location: " + Evenement.getLocation_event());
            } else {
                location.setText("Event link" + Evenement.getLocation_event());
            }
            spots.setText(Integer.toString(Evenement.getCapacite_event()) + " Remaining spots");
            participants.setText(Integer.toString(Evenement.getNb_max() - Evenement.getCapacite_event()) + " People going");
            if (Evenement.getRating() == 0) {
                ratedImg.setVisible(false);
                ratedLbl.setVisible(false);
            } else {
                ratedLbl.setText(Integer.toString(Evenement.getRating()));
                ratedImg.setVisible(true);
                ratedLbl.setVisible(true);
            } 
            System.out.println("IDDDDDD clicked  "+id_clicked +"CUrreeent USER ID    "+CurrentUser.getId_user());
             if(pc.CheckUserExists(CurrentUser.getId_user(), id_clicked))
            {
                ticketimg.setVisible(true);
              ticketlbl.setVisible(true);
            } else { ticketimg.setVisible(false);
              ticketlbl.setVisible(false);}
           

        }

    }

    

    @FXML
    private void refresh2(MouseEvent event) {
        initialize(url, b);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage CurrentStage = (Stage) BtnClose.getScene().getWindow();
        CurrentStage.close();
    }

    Comparator<Evenement> compareByParticipants = new Comparator<Evenement>() {
        @Override
        public int compare(Evenement o1, Evenement o2) {
            //return o1.getId().compareTo(o2.getId());
            return (o2.getNb_max() - o2.getCapacite_event()) - (o1.getNb_max() - o1.getCapacite_event());
        }
    };

    Comparator<Evenement> compareByMostRecent = new Comparator<Evenement>() {
        @Override
        public int compare(Evenement o1, Evenement o2) {
            //return o1.getId().compareTo(o2.getId());
            return o1.getDate_event().compareTo(o2.getDate_event());
        }
    };

    Comparator<Evenement> compareByAlphabetical = new Comparator<Evenement>() {
        @Override
        public int compare(Evenement o1, Evenement o2) {
            return o1.getNom_event().compareTo(o2.getNom_event());

        }
    };

    private void FillHbox1(List<Evenement> myLst, HBox DisplayInMe) {
        event_mostPop.getChildren().clear();
        for (int i = 0; i < myLst.size(); i++) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemBox.fxml"));
                AnchorPane EventBox = fxmlLoader.load();
                ItemBoxController eventController = fxmlLoader.getController();
                eventController.setData(myLst.get(i));
                DisplayInMe.getChildren().add(EventBox);
            } catch (IOException ex) {
                Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void offEffectBtn(MouseEvent event) {
        Btn_AddEvent111.setEffect(null);
    }

    @FXML
    private void onEffectBtn(MouseEvent event) {
        Btn_AddEvent111.setEffect(highlightBtn);
        Btn_AddEvent111.setCursor(Cursor.HAND);
    }

    @FXML
    private void offEffectBtnHost(MouseEvent event) {
        Btn_AddEvent.setEffect(null);
    }

    @FXML
    private void onEffectBtnHost(MouseEvent event) {
        Btn_AddEvent.setEffect(highlightBtn);
        Btn_AddEvent.setCursor(Cursor.HAND);
    }

    @FXML
    private void offEffectBtnGoing(MouseEvent event) {
        Btn_AddEvent11.setEffect(null);
    }

    @FXML
    private void onEffectBtnGoing(MouseEvent event) {
        Btn_AddEvent11.setEffect(highlightBtn);
        Btn_AddEvent11.setCursor(Cursor.HAND);
    }

    @FXML
    private void offEffectSearch(MouseEvent event) {
        input.setEffect(null);
    }

    @FXML
    private void onEffectSearch(MouseEvent event) {
        Btn_AddEvent11.setEffect(highlightBtn);
        Btn_AddEvent11.setCursor(Cursor.TEXT);
    }

    
    private void sendWhatsapp() {
       List<Evenement> myLiist;
           EvenementCRUD ec = new EvenementCRUD();
            ParticipantCRUD pc = new ParticipantCRUD();
            myLiist = ec.TodayEvenement();
            if (!myLiist.isEmpty()) {

                for (int i = 0; i < myLiist.size(); i++) {
                    if (pc.CheckUserExists(CurrentUser.getId_user(), myLiist.get(i).getId())) {
                        
                        String content = "";
                        content = "Don't forget to show up today," + myLiist.get(i).getNom_event() + " is happening TODAY and we have a spot reserved especially for you, find us in " + myLiist.get(i).getLocation_event();
                        System.out.println(content);
                        Whatsapp.send(content);
                   }
                }
            }

    }
    
     private void notifyme() {
       List<Evenement> myLiist;
           EvenementCRUD ec = new EvenementCRUD();
            ParticipantCRUD pc = new ParticipantCRUD();
            myLiist = ec.TodayEvenement();
            if (!myLiist.isEmpty()) {

                for (int i = 0; i < myLiist.size(); i++) {
                    if (pc.CheckUserExists(CurrentUser.getId_user(), myLiist.get(i).getId())) {
                        
                        String content = "";
                        content =  myLiist.get(i).getNom_event() + " is happening TODAY and we have a spot reserved especially for you, find us in " + myLiist.get(i).getLocation_event();
                        notificationShow("Don't forget to show up today!", content);
                   }
                }
            }

    }

    
    
    @FXML
    private void GetYourTicket(MouseEvent event) {
              
            
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventTicket.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Host an event");
           
            stage.setScene(new Scene(root1));
            
            stage.show();
            String userHomeFolder = System.getProperty("user.home");
            
          
            WritableImage image = root1.snapshot(new SnapshotParameters(), null);
           File file1 = new File(userHomeFolder+"\\Downloads\\ArtHub Tickets");
           file1.mkdir();
            File file = new File(userHomeFolder+"\\Downloads\\ArtHub Tickets\\Ticket"+CurrentUser.getId_user()+id_clicked+".png");
          
              ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
    @FXML
    private void AddFeedback(MouseEvent event) {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddFeedback.fxml"));
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
     
      public void notificationShow(String title,String message) {
    Notifications notificationBuilder = Notifications.create()
               .title(title).text(message).graphic(null).hideAfter(javafx.util.Duration.seconds(20))
               .position(Pos.BASELINE_RIGHT)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {    
                       
                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();}
      
    public static void setImage(String from,ImageView image) {
        try {
            Image img3 = new Image(new FileInputStream(from));
            image.setImage(img3);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void filterCat(String toCompare) {

       
            EvenementCRUD ps = new EvenementCRUD();
            List<Evenement> myLst;
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Default") {
                myLst = ps.AllFiltered(toCompare);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.AllFiltered(toCompare);
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.AllFiltered(toCompare);
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "All Events" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.AllFiltered(toCompare);
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Default") {
                myLst = ps.consulterFiltered(toCompare);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.consulterFiltered(toCompare);
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.consulterFiltered(toCompare);
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Upcoming" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.consulterFiltered(toCompare);
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Default") {
                myLst = ps.TodayEvenementFiltered(toCompare);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.TodayEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.TodayEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "Today" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.TodayEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Default") {
                myLst = ps.ThisMonthEvenementFiltered(toCompare);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.ThisMonthEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.ThisMonthEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Month" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.ThisMonthEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);

            }

            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Default") {
                myLst = ps.ThisWeekEvenementFiltered(toCompare);
                FillHbox1(myLst, event_mostPop);

            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Popular") {
                myLst = ps.ThisWeekEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByParticipants);
                FillHbox1(myLst, event_mostPop);
            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Most Recent") {
                myLst = ps.ThisWeekEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByMostRecent);
                FillHbox1(myLst, event_mostPop);
            }
            if (comboDate.getValue() == "This Week" && comboTrend.getValue() == "Alphabetical") {
                myLst = ps.ThisWeekEvenementFiltered(toCompare);
                Collections.sort(myLst, compareByAlphabetical);
                FillHbox1(myLst, event_mostPop);
            }

        
    }

    
    @FXML
    private void catshow(MouseEvent event) {
        
        try {
           
            if(clicked_cat!="") {filterCat(clicked_cat);
           clicked_cat="";
          //catshow(event);
           
           }
           else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CategoriePicker.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Host an event");
          
            stage.setScene(new Scene(root1));

            stage.show();
               
            }
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
   
}

    @FXML
    private void load_jobs(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FRONT_annonce.fxml"));
            Scene scene = feed_button.getScene();
            
            root.translateXProperty().set(scene.getHeight());
            parentContainer1.getChildren().add(root);
            
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            
            timeline.play();
            //parentContainer.getChildren().remove(anchorRoot);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @FXML
    private void closeOFF(MouseEvent event) {
         setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\close.png",BtnClose);
    }

    @FXML
    private void closeON(MouseEvent event) {
         setImage(userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\closeON.png",BtnClose);
    }

     
    @FXML
    private void showComments(MouseEvent event) { 
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventComments.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
          
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            //stage.setOpacity(0.2);
            stage.initStyle(StageStyle.TRANSPARENT);
            //Blur.applyBlur(stage, Blur.ACRYLIC);
            root1.setStyle(" -fx-background-color:rgba(	0, 0, 0,0.7);");
            Scene scene = new Scene(root1);
             scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
              stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event1) -> {
        if (KeyCode.ESCAPE == event1.getCode()) {
            stage.close();
        }
    });
            

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void AddPartner(ActionEvent event) {
          try {
           
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MakePartner.fxml"));
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
    private void showUserProfile(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
            Scene scene = feed_button.getScene();
            
            root.translateXProperty().set(scene.getHeight());
            parentContainer1.getChildren().add(root);
            
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            
            timeline.play();
            //parentContainer.getChildren().remove(anchorRoot);
        } catch (IOException ex) {
            Logger.getLogger(FRONT_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void GoingTo(ActionEvent event) {
         label_layout.setText("Going To..");
        comboDate.setVisible(false);
        comboTrend.setVisible(false);
        MoreDetails.setVisible(false);
        comboDate.getItems().clear();
        comboTrend.getItems().clear();

        EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
        myLst = ps.GoingTo(CurrentUser.getId_user());
        FillHbox1(myLst, event_mostPop);

        MoreDetails.setVisible(true);
    }

    @FXML
    private void WentTo(ActionEvent event) {
          label_layout.setText("Went To..");
        comboDate.setVisible(false);
        comboTrend.setVisible(false);
        MoreDetails.setVisible(false);
        comboDate.getItems().clear();
        comboTrend.getItems().clear();

        EvenementCRUD ps = new EvenementCRUD();
        List<Evenement> myLst;
        myLst = ps.WentTo(CurrentUser.getId_user());
        FillHbox1(myLst, event_mostPop);

        MoreDetails.setVisible(true);

    }
    



}

   

    