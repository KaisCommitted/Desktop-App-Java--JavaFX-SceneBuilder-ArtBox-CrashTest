
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
                
                
                Participant p = new Participant(id_participation,id_user,id_event);
                p.setId_participation(rs.getInt("id_participation"));
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


   
    
}
