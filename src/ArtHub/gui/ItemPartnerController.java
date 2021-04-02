/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Partenaire;
import static ArtHub.gui.FRONT_EventController.setImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class ItemPartnerController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void setData(Partenaire p) {
        System.out.println("PAAAAAAAAAAAAATH "+p.getLogo());    
setImage(p.getLogo(),image);
    id.setText(Integer.toString(p.getId_part()));
    }
}
