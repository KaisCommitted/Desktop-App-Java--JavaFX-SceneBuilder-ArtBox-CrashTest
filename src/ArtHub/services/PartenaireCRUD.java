
package ArtHub.services;
import ArtHub.entities.Partenaire;
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
public class PartenaireCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public PartenaireCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterPartenaire(Partenaire p){
        String req ="INSERT INTO partenaire (id_part,nom,adresse,logo,RIB,tel)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_part());
            ste.setString(2, p.getNom());
            ste.setString(3, p.getAdresse());
            ste.setString(4, p.getLogo());
            ste.setString(5, p.getRib());
            ste.setString(6, p.getTel());
            ste.executeUpdate();
            System.out.println("Partenaire ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Partenaire> consulterPartenaire() {

        List<Partenaire> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from partenaire");
            while (rs.next()) {

               
               
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String logo = rs.getString("logo");
                String RIB = rs.getString("RIB");
                String tel = rs.getString("tel");
                
                
                Partenaire p = new Partenaire(nom, adresse,logo,RIB,tel);
                p.setId_part(rs.getInt("id_part"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void supprimerPartenaire(Partenaire p) {
         try {
            String requete = "DELETE FROM partenaire WHERE id_part=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_part());
            pst.executeUpdate();
            System.out.println("Partenairel supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
      
    public void modifierPartenaire(int id_part, String object, Object obj) {
        try {
            String requete = "UPDATE partenaire SET ? = ? WHERE id_part = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id_part);
            String ch = pst.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3 = ch2.substring(pos, ch2.length());
            System.out.println(ch3);
            pst = cnx.prepareStatement(ch3);
            pst.executeUpdate();
            System.out.println("Partenaire modifié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
