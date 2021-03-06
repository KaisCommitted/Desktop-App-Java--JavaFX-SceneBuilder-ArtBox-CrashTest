package ArtHub.services;

import ArtHub.entities.Post;
import ArtHub.gui.Ajout_PostController;
import ArtHub.tools.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * wadup
 * @author Adam
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
            
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getNom_post());
            ste.setString(2, p.getDescription());
            ste.setString(3, c);
            ste.setString(4,s);
            ste.executeUpdate();
            System.out.println("Post Added");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

    
    
        public List<Post> consulterPost() {

        List<Post> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from postes");
            while (rs.next()) {

               
                int id_post = rs.getInt("id_post");
                String nom_post = rs.getString("nom_post");
                String Description = rs.getString("Description");
                String categorie = rs.getString("categorie");
                String post_date = rs.getString("post_date");
                
                Post p = new Post(id_post,nom_post,Description,categorie,post_date);  
                p.setId_post(rs.getInt("id_post"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     public void supprimerPost(Post p) {
         try {
            String requete = "DELETE FROM postes WHERE id_post=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_post());
            pst.executeUpdate();
            System.out.println("Postes supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierPost(int id, String object, Object obj) {
        try {
            String requete = "UPDATE postes SET ? = ? WHERE id_post = ?";
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
            System.out.println("Poste modifié avec succées");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    
    
}