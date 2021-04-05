/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;


import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import static ArtHub.gui.FRONT_EventController.userHomeFolder;
import static ArtHub.gui.ItemBoxController.id_clicked;
import static ArtHub.gui.LoginController.CurrentUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import ArtHub.services.EvenementCRUD;
import ArtHub.services.ParticipantCRUD;
import ArtHub.services.UserCRUD;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Kais
 */

public class EventTicketController implements Initializable {
EvenementCRUD ec= new EvenementCRUD();
ParticipantCRUD pc = new ParticipantCRUD();
Evenement E = new Evenement();
Participant P = new Participant();
 UserCRUD u = new UserCRUD();
  DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  String str = "data eli bech t5rajhom";
    @FXML
    private ImageView event_img;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label location;
    @FXML
    private Label username;
    @FXML
    private ImageView QR;
    @FXML
    private ImageView QR_code;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (id_clicked != 0) {
           
             try {
                 String org = "";
                 qrrcode();
                P = pc.FindParticipant(CurrentUser.getId_user(), id_clicked);
                 
                 E = ec.FindEvenement(id_clicked);
                 org = u.FindUser(E.getId_org().getId_user()).getUsername();
                 String pat = E.getImage_event();
                  String path = userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\QR code\\EventTicket"+P.getTicket()+".png";
                 Image img6 = new Image(new FileInputStream(pat));
                Image img = new Image(new FileInputStream(path));
                 event_img.setImage(img6);
                 name.setText(E.getNom_event());
                 QR.setImage(img);
                 username.setText("Organized by: " + org); 
                 
                 date.setText(" " + E.getDate_event().format(formatters));
                 location.setText(" " + E.getLocation_event());
               
                
                 
                 } catch (FileNotFoundException ex) {
                 Logger.getLogger(EventTicketController.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(EventTicketController.class.getName()).log(Level.SEVERE, null, ex);
             }
           

        }
    }    

    @FXML
    private void FindThem(MouseEvent event) {
    }
    
  
    
    
    public void qrrcode() throws IOException {
 EvenementCRUD ec= new EvenementCRUD();
ParticipantCRUD pc = new ParticipantCRUD();
Evenement E = new Evenement();
Participant P = new Participant();
 UserCRUD u = new UserCRUD();
 E=ec.FindEvenement(id_clicked);
 
       P= pc.FindParticipant(CurrentUser.getId_user(), id_clicked);
       System.out.println("TICKTICK   "+P.getTicket()); 
       String str =  P.getTicket();
       String content = "Ticket code: " +P.getTicket()   + "\n" + "Participant Full Name: " + u.FindUser(CurrentUser.getId_user()).getNom() + " " + u.FindUser(CurrentUser.getId_user()).getPrenom() + "\n" +"Event name: " +E.getNom_event()  + "\n" + "Event date: " +E.getDate_event()  + "\n";
          
        
        try {
            String imageFormat = "png";
            String outputFileName =  userHomeFolder+"\\Documents\\GitHub\\ArtBox-CrashTest\\src\\ArtHub\\images\\QR code\\EventTicket"+str+"." + imageFormat;
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
            MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get(outputFileName));
        } catch (WriterException ex) {
            Logger.getLogger(EventTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}

    @FXML
    private void close(MouseEvent event) {
         Stage stage = (Stage) date.getScene().getWindow();
                       stage.close();
    }
    
}
