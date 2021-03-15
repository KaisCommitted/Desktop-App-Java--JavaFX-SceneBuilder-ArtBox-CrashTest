/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.User;
import static ArtHub.gui.ItemBoxController.id_part;
import ArtHub.services.ParticipantCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class ShowParticipantsController implements Initializable {

    @FXML
    private Label peoplegoing;
    @FXML
    private Label listPeopleGoing;
 ParticipantCRUD part = new ParticipantCRUD();
  User user = new User();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String usernames="";
        List<User> myLst;
        myLst = part.FindParticipants(id_part);
        for (int i = 0; i < myLst.size(); i++) {
            user = myLst.get(i);
            usernames += user.getUsername()+ "\n";
            
        }
        peoplegoing.setText(myLst.size()+" Participants");
        
        listPeopleGoing.setText(usernames);
        // TODO
    }    
    
}
