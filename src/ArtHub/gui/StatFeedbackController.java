/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.gui;

import ArtHub.tools.MyConnection;
import static ArtHub.tools.MyConnection.getInstance;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StatFeedbackController implements Initializable {

    @FXML
    private VBox content_area;
    @FXML
    private HBox menubar;
         boolean flag = false;
    @FXML
    private BarChart<?, ?> stat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection cnx;
        cnx =MyConnection.getInstance().cnx;
        Statement st = null;
        try {
            st = cnx.createStatement();
            String req = "SELECT COUNT(id_feedback), type_feedback FROM feedback GROUP BY type_feedback"  ;
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                int id_feedback = rs.getInt("COUNT(id_feedback)");
                String id = rs.getString("type_feedback");


                System.out.println("wsolt");
                XYChart.Series se1 = new XYChart.Series<>();
                se1.getData().add(new XYChart.Data(id, id_feedback));

                stat.getData().addAll(se1);



            }


            } catch (SQLException e) {
        }
        // TODO
    }    

    @FXML
    private void open_sidebar(ActionEvent event) throws IOException {
          BorderPane border_pane = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
        if (flag == true) {
            Parent sidebar = FXMLLoader.load(getClass().getResource("/app/views/Sidebar.fxml"));
            border_pane.setLeft(sidebar);
            flag = false;
        } else {
            border_pane.setLeft(null);
            flag = true;
        }
    }
    
}