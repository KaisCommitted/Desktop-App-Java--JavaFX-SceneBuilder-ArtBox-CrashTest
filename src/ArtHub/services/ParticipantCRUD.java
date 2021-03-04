
package ArtHub.services;
import ArtHub.entities.Participant;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * wadup
 * @author Fayechi
 */
public class ParticipantCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public ParticipantCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    
      public List<Participant> consulterParticipant() {

        List<Participant> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from participant");
            while (rs.next()) {

               
                int id_participation= rs.getInt("id_participation");
                int id_user = rs.getInt("id_user");
                int id_event = rs.getInt("id_event");
                String name_user = rs.getString("name_user");
                String name_event = rs.getString("name_event");
                
                Participant p = new Participant(id_participation, id_user, id_event,name_user,name_event);
                p.setId_participation(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     public void supprimerParticipant(Participant p) {
         try {
            String requete = "DELETE FROM participant WHERE id_particiaption=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_participation());
            pst.executeUpdate();
            System.out.println("Participant supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierParticipant(int id, String object, Object obj) {
        try {
            String requete = "UPDATE participant SET ? = ? WHERE id = ?";
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
            System.out.println("Participant modifié avec succées");

//            Notifications notifs = Notifications.create()
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/participants/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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
