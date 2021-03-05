
package ArtHub.services;
import ArtHub.entities.Post;
import ArtHub.gui.Ajout_PostController;
import ArtHub.tools.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * wadup
 * @author Fayechi
 */
public class postCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public postCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterPost(Post p)throws Exception{
    String c;
    if (Ajout_PostController.tindex == 0){
     c = "photography"; }
    else if (Ajout_PostController.tindex == 1){
          c = "video";}
    else { c  = "music";}
        
    
    
        String req ="INSERT INTO postes (Nom_post,Description,categorie,file,post_date)"+"values (?,?,?,?,CURRENT_TIMESTAMP)";
        try {
            String s=Ajout_PostController.s;
            InputStream is = new FileInputStream(new File(s));
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getNom_post());
            ste.setString(2, p.getDescription());
            ste.setString(3, c);
            ste.setBlob(4,is);
            ste.executeUpdate();
            System.out.println("Post Added");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

    
    
    
    
    
    
    
}