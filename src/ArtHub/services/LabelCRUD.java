
package ArtHub.services;
import ArtHub.entities.Label;
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
    
    public void ajouterLabel(Label p){
        String req ="INSERT INTO evenement (id,name,type)"+"values (?,?,?)";
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
    
      public List<Label> consulterLabel() {

        List<Label> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from label");
            while (rs.next()) {

               
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                
                Label p = new Label(id, name, type);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    
}
