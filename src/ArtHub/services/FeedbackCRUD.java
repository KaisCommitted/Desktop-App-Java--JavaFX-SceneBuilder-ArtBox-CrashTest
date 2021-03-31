
package ArtHub.services;
import ArtHub.entities.Feedback;
import ArtHub.entities.Feedback;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackCRUD {
    private final Connection cnx;
    private PreparedStatement ste;

    public FeedbackCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterFeedback(Feedback f){
        String req ="INSERT INTO Feedback ( id_feedback,contenu_feedback,type_feedback,etat_feedback,date_feedback)"+"values (?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, f.getId_feedback());
            ste.setString(2, f.getContenu_feedback());
            ste.setString(3, f.getType_feedback());
            ste.setString(4, f.getEtat_feedback());
            ste.setDate(5, f.getDate_feedback());

            ste.executeUpdate();
            System.out.println("Feedback ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Problème");
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
                String contenu_feedback = rs.getString("contenu_feedback");
                String type_feedback = rs.getString("type_feedback");
                String etat_feedback = rs.getString("etat_feedback");
                Date date_feedback = rs.getDate("date_feedback");
                
                
                
                Feedback f = new Feedback(id_feedback, contenu_feedback, type_feedback,etat_feedback,date_feedback);
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
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/Feedbacks/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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
