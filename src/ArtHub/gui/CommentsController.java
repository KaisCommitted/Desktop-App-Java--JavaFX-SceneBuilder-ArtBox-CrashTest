/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.entities.Comment;
import ArtHub.entities.User;
import static ArtHub.gui.LoginController.CurrentUser;
import ArtHub.services.UserCRUD;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Adam Khalfaoui
 */
public class CommentsController implements Initializable {

    @FXML
    private Label cmnt;
    @FXML
    private Label time_cmnt;
    @FXML
    private Label user_cmnt;

    UserCRUD uc = new UserCRUD();
    User u = new User();
    Comment c = new Comment();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setData(Comment C) {

        String i = uc.FindUser(C.getId_user().getId_user()).getUsername();
        int x = uc.FindUser(C.getId_user().getId_user()).getId_user();
        user_cmnt.setText(i);
        System.out.println("IIIIIIIIIIIIIIII "+i+" CURRRRENT "+CurrentUser.getUsername());

        time_cmnt.setText(C.getDate_comment());
        cmnt.setText(C.getComment());
    }

}
