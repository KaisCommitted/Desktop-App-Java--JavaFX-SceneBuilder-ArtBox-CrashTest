/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
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
import java.io.FileNotFoundException;

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

    private String[] colors = {"c992d6", "b0ffa7", "e2aa8e", "f9ffac", "ffecc5", "a0c7c2", "aec6cf"};

    @FXML
    private Label id_event;
    static int id_clicked;
    static String style;
    @FXML
    private Label Event_spots1;
    @FXML
    private Label Event_date;
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    User CurrentUser = new User(1);
    ParticipantCRUD ppt = new ParticipantCRUD();
    @FXML
    private Label Event_location;

    /**
     * Initializes the controller class.
     *
     * @    param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    

    public void setData(Evenement p) throws IOException {
       
            Event_name.setText(p.getNom_event());
            Event_date.setText(p.getDate_event().format(formatters));
            Event_spots.setText(Integer.toString(p.getCapacite_event()) + " Remaining spots");
            Event_spots1.setText(Integer.toString(p.getNb_max() - p.getCapacite_event()) + " People going");
            String pat=p.getImage_event();
            Event_location.setText(p.getLocation_event());
            System.out.println(pat);
            Image img6 = new Image(new FileInputStream(pat));
           // Image image = new Image(getClass().getResourceAsStream(pat));
            //URL urll;
            
           /* urll = new URL("https://image.shutterstock.com/image-photo/black-steel-large-anchor-chain-600w-1081708619.jpg");
            
            BufferedImage c = ImageIO.read(urll);
            WritableImage img=null;
            Image image = SwingFXUtils.toFXImage(c,img);*/
            BoxImage.setImage(img6);
            id_event.setText(Integer.toString(p.getId()));
            ItemBox.setStyle("-fx-background-color: #" + colors[(int) (Math.random() * colors.length)] + ";"
                    + "-fx-background-radius: 15;"
                    + "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 ,10.0);");
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
       EvenementCRUD ec= new EvenementCRUD();
        Evenement CurrentEvent = ec.FindEvenement(Integer.parseInt(id_event.getText()));
        
        
        
        Participant p = new Participant(CurrentUser, CurrentEvent);
        ParticipantCRUD ppt = new ParticipantCRUD();
        String aux = Event_spots.getText();
        String aux1 = Event_spots1.getText();   
        aux = stripNonDigits(aux);
        aux1 = stripNonDigits(aux1);
           
        if (ppt.CheckUserExists(p.getId_user().getId_user(), p.getId_event().getId())) {
            ppt.supprimerParticipant(p);
            ec.modifierEvenement(CurrentEvent.getId(), "capacite_event", CurrentEvent.getCapacite_event()+1);
            
            
            
           
           
            Event_spots.setText(Integer.toString(Integer.parseInt(aux) +1)+ " Remaining spots");
            Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) -1)+ " Participants");
            Btn_participer.setText("Join");
        } else {
            {
                ppt.ajouterParticipant(p);
                 ec.modifierEvenement(CurrentEvent.getId(), "capacite_event", CurrentEvent.getCapacite_event()-1);
                Btn_participer.setText("Going");
              Event_spots.setText(Integer.toString(Integer.parseInt(aux) -1)+ " Remaining spots");
            Event_spots1.setText(Integer.toString(Integer.parseInt(aux1) +1)+ " Participants");
            }
        }

    }

    @FXML
    public void setDataChosen(MouseEvent event) throws FileNotFoundException {
      id_clicked = Integer.parseInt(id_event.getText());
      System.out.println(id_clicked);
       style = ItemBox.getStyle();
        /* FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FRONT_Event.fxml"));
                FRONT_EventController eventController = fxmlLoader.getController();
                Event_name.getText();
                EvenementCRUD p = new EvenementCRUD();
                Evenement Evenement= new Evenement();
                Evenement = p.FindEvenement(Integer.parseInt(id_event.getText()));
               eventController.setChosenEvenement(Evenement);*/
    }

}
