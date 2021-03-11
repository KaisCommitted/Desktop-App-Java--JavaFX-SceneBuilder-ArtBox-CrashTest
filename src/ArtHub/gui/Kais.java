/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.RestAPI.SentimentAnalysis;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import static java.awt.Color.blue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 */
public class Kais extends Application {

    @Override
    public void start(Stage primaryStage) {
        
       /*SentimentAnalysis sa = new SentimentAnalysis();
        sa.getSent("Kais is a filthy faggot");
        */

        try {
            // Color c = Color.rgb(10,30,255,1.200);
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            // Parent root = FXMLLoader.load(getClass().getResource("ADD-Event.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("FRONT_Event.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("CRUDParticipant.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("CRUDEvent.fxml"));
            Scene scene = new Scene(root, 1920, 1080);
            scene.setFill(Color.LIGHTGRAY);
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());
            //primaryStage.initModality(Modality.APPLICATION_MODAL);
            
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("ArtBox");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(Kais.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
