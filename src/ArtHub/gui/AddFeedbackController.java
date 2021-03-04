package ArtHub.gui;

import ArtHub.entities.Feedback;
import ArtHub.services.FeedbackCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddFeedbackController implements Initializable {

    @FXML
    private TextField txtTypeFeedback;
    @FXML
    private TextArea txtContenuFeedback;
    @FXML
    private Button btnEnvoyerFeedback;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    @FXML
    private void addFeedback(ActionEvent event) {
        try {
            // Ajouter Feedback
            String rtypefeedback = txtTypeFeedback.getText();
            String rcontenufeedback = txtContenuFeedback.getText();
         
           
            Feedback f = new Feedback(rcontenufeedback,rtypefeedback);
            FeedbackCRUD feed = new FeedbackCRUD();
            feed.ajouterFeedback(f);
            
            
        }catch (Exception ex) {
        Logger.getLogger(AddFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
