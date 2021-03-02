
package ArtHub.services;
import ArtHub.entities.Evenement;
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
public class EvenementCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public EvenementCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterEvenement(Evenement p){
        String req ="INSERT INTO evenement ( id_org,date,nom_event,type_event,categorie,description)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_org());
            ste.setString(2, p.getDate_event());
            ste.setString(3, p.getNom_event());
            ste.setInt(4, p.getType_event());
            ste.setInt(5, p.getCategorie());
            ste.setString(6, p.getDescription());
            ste.executeUpdate();
            System.out.println("Evenement ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Evenement> consulterEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement");
            while (rs.next()) {

               
                int id_org = rs.getInt("id_org");
                String date = rs.getString("date");
                String nom_event = rs.getString("nom_event");
                int type_event = rs.getInt("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                
                Evenement p = new Evenement(id_org, date, nom_event,type_event,categorie,description);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    
}
