package ArtHub.services;

import ArtHub.entities.User;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


/**
 *
 * @author louay
 */
public class UserCRUD {
    
    
     private Connection cnx;
    private PreparedStatement ste;

    public UserCRUD() {
        
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterUser(User u){
        String req ="INSERT INTO user (nom,prenom,username,mail,date_naissance,pwd_user,ref_admin)"+"values (?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, u.getNom());
            ste.setString(2, u.getPrenom());
            ste.setString(3, u.getUsername());
            ste.setString(4, u.getMail());
            ste.setDate(5, u.getDate_naissance());
            ste.setString(6, u.getPwd_user());
            ste.setString(7, u.getRef_admin());
            
            
            ste.executeUpdate();
            System.out.println("User ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    
     public List<User> afficherUser() 
    {
        List<User> myList = new ArrayList<>();
        
        String requete = "SELECT * FROM user";
        try {
            
            
            Statement ste = cnx.createStatement();

            ResultSet rs = ste.executeQuery("SELECT * from User");
            while (rs.next()) {
                
                int id_user = rs.getInt("id_user");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String username = rs.getString("username");
                String mail = rs.getString("mail");
                Date date_naissance = rs.getDate("date_naissance");
                String pwd_user = rs.getString("pwd_user");
                String ref_admin = rs.getString("ref_admin");
            
                User u = new User(id_user,nom,prenom,username,mail,date_naissance,pwd_user,ref_admin);
                myList.add(u);
                
            }
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

     public void supprimerUser(User u) {
         try {
            String requete = "DELETE FROM User WHERE id_user=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, u.getId_user());
            pst.executeUpdate();
            System.out.println("User supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void modifierUser(int id, String object, Object obj) {
        try {
            String requete = "UPDATE User SET ? = ? WHERE id_user = ?";
            PreparedStatement set = cnx.prepareStatement(requete);
            set.setString(1, object);
            set.setObject(2, obj);
            set.setInt(3, id);
            String ch = set.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3 = ch2.substring(pos, ch2.length());
            System.out.println(ch3);
            set = cnx.prepareStatement(ch3);
            set.executeUpdate();
            System.out.println("User modifié avec succées");} catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
}
