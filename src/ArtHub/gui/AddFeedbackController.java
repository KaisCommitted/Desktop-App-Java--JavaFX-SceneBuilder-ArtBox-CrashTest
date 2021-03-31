package ArtHub.gui;

import ArtHub.entities.Feedback;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.FeedbackCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddFeedbackController implements Initializable {

    
    @FXML
    private TextArea txtContenuFeedback;
    @FXML
    private Button btnEnvoyerFeedback;
    @FXML
    private ComboBox<String> cmboTypeFeedback;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     cmboTypeFeedback.getItems().add("Feed");
     cmboTypeFeedback.getItems().add("Discover");
     cmboTypeFeedback.getItems().add("Events");
     cmboTypeFeedback.getItems().add("Jobs");
    }    
    @FXML
    private void addFeedback(ActionEvent event) {
        try {
            // Ajouter Feedback
            String rtypefeedback = cmboTypeFeedback.getValue();
            String rcontenufeedback = txtContenuFeedback.getText();
         
           
            Feedback f = new Feedback(CurrentUser.getId_user(),rcontenufeedback,rtypefeedback,"Not treated");
            FeedbackCRUD feed = new FeedbackCRUD();
            feed.ajouterFeedback(f);
            Stage stage;
           stage= (Stage) btnEnvoyerFeedback.getScene().getWindow();
           stage.close();
           
        }catch (Exception ex) {
        Logger.getLogger(AddFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
}
