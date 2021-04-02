
package ArtHub.services;
import ArtHub.entities.Feedback;
import ArtHub.entities.Feedback;
import ArtHub.entities.User;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class FeedbackCRUD {
    private final Connection cnx;
    private PreparedStatement ste;

    public FeedbackCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterFeedback(Feedback f){
        String req ="INSERT INTO Feedback ( id_feedback,id_user,contenu_feedback,type_feedback,etat_feedback)"+"values (?,?,?,?,?)";
        try {
            User u = new User();
            ste = cnx.prepareStatement(req);
            ste.setInt(1, f.getId_feedback());
            ste.setInt(2, f.getId_user().getId_user());
            ste.setString(3, f.getContenu_feedback());
            ste.setString(4, f.getType_feedback());
            ste.setString(5, f.getEtat_feedback());
            

            ste.executeUpdate();
            
            
            
            
            
            System.out.println("Feedback ajouté");
            Notifications notificationBuilder = Notifications.create()
               .title("Feedback sent!").text("Your feedback has been successfully processed.").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
               .position(Pos.CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event)
                   {
                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();
       Parent root;
            
        } catch (SQLException ex) {
            System.out.println("Problème d'ajout feedback");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Feedback> consulterFeedback() {

        List<Feedback> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from feedback");
            while (rs.next()) {
               
                int id_feedback = rs.getInt("id_feedback");
                UserCRUD uc = new UserCRUD();
                User u = new User();
               
                u = uc.FindUser(rs.getInt("id_user"));
                
                
                String contenu_feedback = rs.getString("contenu_feedback");
                String type_feedback = rs.getString("type_feedback");
                String etat_feedback = rs.getString("etat_feedback");
                Date date_feedback = rs.getDate("date_feedback");
                
                
                
                Feedback f = new Feedback(id_feedback,u, contenu_feedback, type_feedback,etat_feedback,date_feedback);
                f.setId_feedback(rs.getInt("id_feedback"));
                myList.add(f);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    public void supprimerFeedback(Feedback f) {
         try {
            String requete = "DELETE FROM Feedback WHERE id_feedback=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, f.getId_feedback());
            pst.executeUpdate();
            System.out.println("Feedback supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierFeedback(int id, String object, Object obj) {
        try {
            String requete = "UPDATE Feedback SET ? = ? WHERE id_feedback = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id);
            String ch = pst.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3 = ch2.substring(pos, ch2.length());
            System.out.println(ch3);
            pst = cnx.prepareStatement(ch3);
            pst.executeUpdate();
            System.out.println("Feedback modifié avec succées");

//            Notifications notifs = Notifications.create()
//                            .title("Feedback added")
//                            .text("Your feedback has been sent successfully!")
//                            
//                            .hideAfter(Duration.seconds(5))
//                            .position(Pos.BOTTOM_RIGHT);
//
//                    notifs.darkStyle();
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            notifs.show();
//                        }
//                    });


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
