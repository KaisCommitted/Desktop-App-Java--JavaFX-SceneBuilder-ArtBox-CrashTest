
package ArtHub.services;
import ArtHub.entities.Labell;
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
public class LabelCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public LabelCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterLabel(Labell p){
        String req ="INSERT INTO label (id,name,type)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getid());
            ste.setString(2, p.getname());
            ste.setString(3, p.gettype());
            ste.executeUpdate();
            System.out.println("Label ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Labell> consulterLabel() {

        List<Labell> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from label");
            while (rs.next()) {

               
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                
                Labell p = new Labell(id, name, type);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void supprimerLabel(Labell p) {
         try {
            String requete = "DELETE FROM label WHERE id=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getid());
            pst.executeUpdate();
            System.out.println("Labell supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
      
    public void modifierLabel(int id, String object, Object obj) {
        try {
            String requete = "UPDATE label SET ? = ? WHERE id = ?";
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
            System.out.println("Label modifié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
