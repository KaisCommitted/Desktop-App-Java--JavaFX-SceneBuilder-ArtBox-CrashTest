package ArtHub.services;

import ArtHub.entities.User;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




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
    
    
}
