
package ArtHub.services;
import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import ArtHub.entities.User;
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
    
    
     public void ajouterParticipant(Participant p){
        String req ="INSERT INTO participant (id_user,id_event)"+"values (?,?)";
        try {
           
             ste = cnx.prepareStatement(req);
             ste.setInt(1, p.getId_user().getId_user());
             ste.setInt(2, p.getId_event().getId());
            
            ste.executeUpdate();
            System.out.println("Participant ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
       String requete = "UPDATE evenement SET capacite_event = capacite_event-1 WHERE id = ?";
        try {
           
             ste.setInt(1, p.getId_event().getId());
            
            ste.executeUpdate();
            System.out.println("Participant ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    } 
    
    public List<Participant> consulterParticipant() {

        List<Participant> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from participant");
            while (rs.next()) {
                
                Participant p = new Participant();
                User auxU = new User();
                auxU.setId_user((rs.getInt("id_user")));
                p.setId_user(auxU);
                Evenement auxE = new Evenement();
                auxE.setId((rs.getInt("id_event")));
                p.setId_event(auxE);
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
