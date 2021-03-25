/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import ArtHub.entities.Rating;
import ArtHub.services.ParticipantCRUD;
import ArtHub.services.EvenementCRUD;
import ArtHub.entities.User;
import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import ArtHub.gui.FRONT_EventController;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.RatingCRUD;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class ItemBoxController implements Initializable {

    @FXML
    private AnchorPane ItemBox;
    @FXML
    private ImageView BoxImage;
    @FXML
    private Label Event_name;
    @FXML
    private Button Btn_participer;
    @FXML
    private Label Event_spots;
public static final DropShadow highlight = new DropShadow(80, Color.web("#11042e"));
public static final DropShadow highlightBtn = new DropShadow(40, Color.web("#11042e"));
    private String[] colors = {"c992d6", "b0ffa7", "e2aa8e", "f9ffac", "ffecc5", "a0c7c2", "aec6cf"};

    @FXML
    private Label id_event;
    static int id_clicked;
    static String style;
    static int id_part;
    
    @FXML
    private Label Event_spots1;
    @FXML
    private Label Event_date;
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    ParticipantCRUD ppt = new ParticipantCRUD();
    @FXML
    private Label Event_location;
    @FXML
    private ImageView rate1;
    @FXML
    private ImageView rate2;
    @FXML
    private ImageView rate3;
    @FXML
    private ImageView rate4;
    @FXML
    private ImageView rate5;
    String Empty;
    String Full;
    String AVG;
    RatingCRUD rc = new RatingCRUD();
    EvenementCRUD ec = new EvenementCRUD();
    @FXML
    private HBox rateStars;
    @FXML
    private ImageView ratedImg;
    @FXML
    private Label ratedLbl;
    
    /**
     * Initializes the controller class.
     *
     * @ param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Empty = "C:\\Users\\21698\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\1024px-Empty_Star.svg.png";
        Full = "C:\\Users\\21698\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\Star_.svg.png";
        AVG = "C:\\Users\\21698\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\peach.png";
        

    }

    public void setData(Evenement p) throws IOException {
        Image emptyStar = new Image(new FileInputStream(Empty));
        Image coloredStar = new Image(new FileInputStream(Full));
        if (p.getDate_event().isBefore(LocalDate.now())) {
            Btn_participer.setVisible(false);
        }
        Event_name.setText(p.getNom_event());
        Event_date.setText(p.getDate_event().format(formatters));
        Event_spots.setText(Integer.toString(p.getCapacite_event()) + " Remaining spots");
        if (p.getDate_event().isBefore(LocalDate.now())) {
            Event_spots1.setText(Integer.toString(p.getNb_max() - p.getCapacite_event()) + " People attended");
        } else {
            Event_spots1.setText(Integer.toString(p.getNb_max() - p.getCapacite_event()) + " People going");
        }
        String pat = p.getImage_event();
        Event_location.setText(p.getLocation_event());

        Image img6 = new Image(new FileInputStream(pat));
        BoxImage.setImage(img6);
        id_event.setText(Integer.toString(p.getId()));
        ItemBox.setStyle("-fx-background-color: #" + colors[(int) (Math.random() * colors.length)] + ";"
                + "-fx-background-radius: 15;"
                + "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 ,10.0);");
        Evenement CurrentEvent = new Evenement(Integer.parseInt(id_event.getText()));
        if (ppt.CheckUserExists(CurrentUser.getId_user(), CurrentEvent.getId())) {
            Btn_participer.setText("Going");
        } else {rateStars.setVisible(false);}
            
        
        if(p.getDate_event().isBefore(LocalDate.now())){
        if (rc.CheckUserExists(CurrentUser.getId_user(), p.getId())) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), p.getId());
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}} else {
           rateStars.setVisible(false);
        }
    
    if(p.getRating() == 0) {
        ratedImg.setVisible(false);
        ratedLbl.setVisible(false);
    } else {ratedLbl.setText(Integer.toString(p.getRating()));}
    }
    
    
    

    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */) {
        final StringBuilder sb = new StringBuilder(
                input.length() /* also inspired by seh's comment */);
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c > 47 && c < 58) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @FXML
    private void JoinEvent(ActionEvent event) {
        EvenementCRUD ec = new EvenementCRUD();
        Evenement CurrentEvent = ec.FindEvenement(Integer.parseInt(id_event.getText()));

        Participant p = new Participant(CurrentUser, CurrentEvent);
        ParticipantCRUD ppt = new ParticipantCRUD();
        String aux = Event_spots.getText();
        String aux1 = Event_spots1.getText();
        aux = stripNonDigits(aux);
        aux1 = stripNonDigits(aux1);

        if (ppt.CheckUserExists(p.getId_user().getId_user(), p.getId_event().getId())) {
            ppt.supprimerParticipant(p);
            ec.modifierEvenement(CurrentEvent.getId(), "capacite_event", CurrentEvent.getCapacite_event() + 1);

            Event_spots.setText(Integer.toString(Integer.parseInt(aux) + 1) + " Remaining spots");
            Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) - 1) + " Participants");
            Btn_participer.setText("Join");
        } else {
            {
                ppt.ajouterParticipant(p);
                ec.modifierEvenement(CurrentEvent.getId(), "capacite_event", CurrentEvent.getCapacite_event() - 1);
                Btn_participer.setText("Going");
                Event_spots.setText(Integer.toString(Integer.parseInt(aux) - 1) + " Remaining spots");
                Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) + 1) + " Participants");
            }
        }

    }

    @FXML
    public void setDataChosen(MouseEvent event) throws FileNotFoundException {
        id_clicked = Integer.parseInt(id_event.getText());
        System.out.println(id_clicked);
        style = ItemBox.getStyle();
        Evenement p = ec.FindEvenement(id_clicked);
        if(p.getRating() == 0) {
        ratedImg.setVisible(false);
        ratedLbl.setVisible(false);
    } else {ratedLbl.setText(Integer.toString(p.getRating()));}
        
        /* FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FRONT_Event.fxml"));
                FRONT_EventController eventController = fxmlLoader.getController();
                Event_name.getText();
                EvenementCRUD p = new EvenementCRUD();
                Evenement Evenement= new Evenement();
                Evenement = p.FindEvenement(Integer.parseInt(id_event.getText()));
               eventController.setChosenEvenement(Evenement);*/
    }

    @FXML
    private void FindThem(MouseEvent event) {

        try {
            id_part = Integer.parseInt(id_event.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showParticipants.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Participants");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void offhover1(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            if (rc.CheckUserExists(CurrentUser.getId_user(),Integer.parseInt(id_event.getText()))) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), Integer.parseInt(id_event.getText()));
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onhover1(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rate1action(MouseEvent event) {
        try {
            System.out.println("rate 1");
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

            Evenement e = ec.FindEvenement(Integer.parseInt(id_event.getText()));
            Rating R = new Rating(CurrentUser, e, 1);
            rc.ajouterRating(R);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void offhover2(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            if (rc.CheckUserExists(CurrentUser.getId_user(),Integer.parseInt(id_event.getText()))) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), Integer.parseInt(id_event.getText()));
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onhover2(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rate2action(MouseEvent event) {

        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

            Evenement e = ec.FindEvenement(Integer.parseInt(id_event.getText()));
            Rating R = new Rating(CurrentUser, e, 2);
            rc.ajouterRating(R);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void offhover3(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            if (rc.CheckUserExists(CurrentUser.getId_user(),Integer.parseInt(id_event.getText()))) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), Integer.parseInt(id_event.getText()));
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onhover3(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rate3action(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);

            Evenement e = ec.FindEvenement(Integer.parseInt(id_event.getText()));
            Rating R = new Rating(CurrentUser, e, 3);
            rc.ajouterRating(R);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void offhover4(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            if (rc.CheckUserExists(CurrentUser.getId_user(),Integer.parseInt(id_event.getText()))) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), Integer.parseInt(id_event.getText()));
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onhover4(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(coloredStar);
            rate5.setImage(emptyStar);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rate4action(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(coloredStar);
            rate5.setImage(emptyStar);

            Evenement e = ec.FindEvenement(Integer.parseInt(id_event.getText()));
            Rating R = new Rating(CurrentUser, e, 4);
            rc.ajouterRating(R);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void offhover5(MouseEvent event) {

        try {
            
                Image emptyStar = new Image(new FileInputStream(Empty));
                Image coloredStar = new Image(new FileInputStream(Full));
                if (rc.CheckUserExists(CurrentUser.getId_user(),Integer.parseInt(id_event.getText()))) {
                Rating R = rc.FindUserExists(CurrentUser.getId_user(), Integer.parseInt(id_event.getText()));
                defaultRating(R);
        } else {rate1.setImage(emptyStar);
            rate2.setImage(emptyStar);
            rate3.setImage(emptyStar);
            rate4.setImage(emptyStar);
            rate5.setImage(emptyStar);}
                

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onhover5(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(coloredStar);
            rate5.setImage(coloredStar);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rate5action(MouseEvent event) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            rate1.setImage(coloredStar);
            rate2.setImage(coloredStar);
            rate3.setImage(coloredStar);
            rate4.setImage(coloredStar);
            rate5.setImage(coloredStar);

            Evenement e = ec.FindEvenement(Integer.parseInt(id_event.getText()));
            Rating R = new Rating(CurrentUser, e, 5);
            rc.ajouterRating(R);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void defaultRating(Rating R) {
        try {
            Image emptyStar = new Image(new FileInputStream(Empty));
            Image coloredStar = new Image(new FileInputStream(Full));
            switch (R.getRating()) {
                case 1:
                    rate1.setImage(coloredStar);
                    rate2.setImage(emptyStar);
                    rate3.setImage(emptyStar);
                    rate4.setImage(emptyStar);
                    rate5.setImage(emptyStar);
                    break;
                case 2:
                    rate1.setImage(coloredStar);
                    rate2.setImage(coloredStar);
                    rate3.setImage(emptyStar);
                    rate4.setImage(emptyStar);
                    rate5.setImage(emptyStar);
                    break;
                case 3:
                    rate1.setImage(coloredStar);
                    rate2.setImage(coloredStar);
                    rate3.setImage(coloredStar);
                    rate4.setImage(emptyStar);
                    rate5.setImage(emptyStar);
                    break;
                case 4:
                    rate1.setImage(coloredStar);
                    rate2.setImage(coloredStar);
                    rate3.setImage(coloredStar);
                    rate4.setImage(coloredStar);
                    rate5.setImage(emptyStar);
                    break;
                case 5:
                    rate1.setImage(coloredStar);
                    rate2.setImage(coloredStar);
                    rate3.setImage(coloredStar);
                    rate4.setImage(coloredStar);
                    rate5.setImage(coloredStar);
                    break;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void effectOn(MouseEvent event) {
         ItemBox.setEffect(null);
    }

    @FXML
    private void effectOff(MouseEvent event) {
        
         ItemBox.setEffect(highlight);
        ItemBox.setCursor(Cursor.HAND);
    }
}
