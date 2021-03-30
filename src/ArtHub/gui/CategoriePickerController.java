/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import static java.awt.Color.white;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import ArtHub.gui.FRONT_EventController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class CategoriePickerController implements Initializable {

   ToggleGroup group = new ToggleGroup();
    @FXML
    private AnchorPane anchor;
    static String clicked_cat="";
    
  
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
         

RadioButton rb1 = new RadioButton("Dancing");
rb1.setToggleGroup(group);
rb1.setSelected(true);
rb1.setLayoutY(50);
rb1.setLayoutX(100);
rb1.setTextFill(Paint.valueOf("#00FFFF"));
RadioButton rb2 = new RadioButton("Theatre");
rb2.setToggleGroup(group);
rb2.setLayoutY(100);
rb2.setLayoutX(100);
rb2.setTextFill(Paint.valueOf("#00FFFF"));
RadioButton rb3 = new RadioButton("Slam");
rb3.setToggleGroup(group);
rb3.setLayoutY(150);
rb3.setLayoutX(100);
rb3.setTextFill(Paint.valueOf("#00FFFF"));
RadioButton rb4 = new RadioButton("Singing");
rb4.setToggleGroup(group);
rb4.setLayoutY(200);
rb4.setLayoutX(100);
rb4.setTextFill(Paint.valueOf("#00FFFF"));
RadioButton rb5 = new RadioButton("Street Art");
rb5.setToggleGroup(group);
rb5.setLayoutY(250);
rb5.setLayoutX(100);
rb5.setTextFill(Paint.valueOf("#00FFFF"));
anchor.getChildren().addAll(rb1,rb2,rb3,rb4,rb5);
clicked_cat="";
   
    }    

    @FXML
    private void Filter(ActionEvent event) throws IOException {
 
            
        Stage stage1 ;
      stage1 = (Stage) anchor.getScene().getWindow();
     clicked_cat = ((RadioButton)group.getSelectedToggle()).getText();
     
      
      
      stage1.close();
      
    }
    
}
