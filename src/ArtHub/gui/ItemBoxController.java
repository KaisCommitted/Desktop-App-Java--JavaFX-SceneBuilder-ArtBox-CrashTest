/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import ArtHub.services.ParticipantCRUD;
import ArtHub.entities.User;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class ItemBoxController implements Initializable {

    @FXML
    private HBox ItemBox;
    @FXML
    private ImageView BoxImage;
    @FXML
    private Label Event_name;
    @FXML
    private Button Btn_participer;
    @FXML
    private Label Event_spots;

    private String[] colors = {"B9E5FF", "BDB2FE", "FB9AA8", "F3F3F3", "4D4D4D", "E4E4E4", "FF5056"};

    @FXML
    private Label id_event;

    @FXML
    private Label Event_spots1;
    @FXML
    private Label Event_date;
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    User CurrentUser = new User(1);
    ParticipantCRUD ppt = new ParticipantCRUD();

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setData(Evenement p) {
        Event_name.setText(p.getNom_event());
        Event_date.setText(p.getDate_event().format(formatters));
        Event_spots.setText(Integer.toString(p.getCapacite_event()) + " Remaining spots");
        Event_spots1.setText(Integer.toString(p.getNb_max() - p.getCapacite_event()) + " People going");
        Image image = new Image(getClass().getResourceAsStream("event_pics/testing.jpg"));
        BoxImage.setImage(image);
        id_event.setText(Integer.toString(p.getId()));
        ItemBox.setStyle("-fx-background-color: #" + colors[(int) (Math.random() * colors.length)] + ";"
                + "-fx-background-radius: 15;"
                + "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0), 10 , 0 , 0 ,10);");
        Evenement CurrentEvent = new Evenement(Integer.parseInt(id_event.getText()));
        if (ppt.CheckUserExists(CurrentUser.getId_user(), CurrentEvent.getId())) {
            Btn_participer.setText("Going");
        }

    }

    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
    final StringBuilder sb = new StringBuilder(
            input.length() /* also inspired by seh's comment */);
    for(int i = 0; i < input.length(); i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
    return sb.toString();
}
    @FXML
    private void JoinEvent(ActionEvent event) {
        Evenement CurrentEvent = new Evenement(Integer.parseInt(id_event.getText()));
        Participant p = new Participant(CurrentUser, CurrentEvent);
        ParticipantCRUD ppt = new ParticipantCRUD();
        String aux = Event_spots.getText();
        String aux1 = Event_spots1.getText();   
        aux = stripNonDigits(aux);
        aux1 = stripNonDigits(aux1);
           
        if (ppt.CheckUserExists(p.getId_user().getId_user(), p.getId_event().getId())) {
            ppt.supprimerParticipant(p);
            
           
           
            Event_spots.setText(Integer.toString(Integer.parseInt(aux) +1)+ " Remaining spots");
            Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) -1)+ " Participants");
            Btn_participer.setText("Join");
        } else {
            {
                ppt.ajouterParticipant(p);
                Btn_participer.setText("Going");
              Event_spots.setText(Integer.toString(Integer.parseInt(aux) -1)+ " Remaining spots");
            Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) +1)+ " Participants");
            }
        }

    }

}
