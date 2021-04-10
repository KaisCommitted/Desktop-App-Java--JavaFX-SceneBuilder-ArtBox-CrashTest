/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.services;

import ArtHub.entities.interactions;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adam Khalfaoui
 */
public class InteractionsCrud {
     private Connection cnx;
    private PreparedStatement ste;
   
    public InteractionsCrud(){
        cnx = MyConnection.getInstance().getConnection();
        }

    
    
   public void ajouterInteraction(interactions p){
        String req ="INSERT INTO interactions (id_user,id_post,like_check)"+"values (?,?,1)";
        try {
           
             ste = cnx.prepareStatement(req);
             ste.setInt(1, p.getId_user().getId_user());
             ste.setInt(2, p.getId_post().getId_post());
            
            ste.executeUpdate();
            System.out.println("Interaction ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());
            
        }
       String requete = "UPDATE postes SET Likes = likes+1 WHERE id_post = ?";
        try {
            ste = cnx.prepareStatement(requete);
             ste.setInt(1, p.getId_post().getId_post());
            
            ste.executeUpdate();
            System.out.println("Likes added");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    } 
   
    public void supprimerInteraction(interactions p){
        String req ="DELETE FROM interactions WHERE id_user=? AND id_post=?";
        try {
           
             ste = cnx.prepareStatement(req);
             ste.setInt(1, p.getId_user().getId_user());
             ste.setInt(2, p.getId_post().getId_post());
            
            ste.executeUpdate();
            System.out.println("Interaction supprimer");
            
        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());
            
        }
       String requete = "UPDATE postes SET Likes = likes-1 WHERE id_post = ?";
        try {
            ste = cnx.prepareStatement(requete);
             ste.setInt(1, p.getId_post().getId_post());
            
            ste.executeUpdate();
            System.out.println("Likes deleted");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    } 
   
    public boolean Checklike(int id_user,int id_post){

    boolean likeExists = false;
    try{
        PreparedStatement st = cnx.prepareStatement("select like_check from interactions where id_user = ? AND id_post = ? ");
        st.setInt(1,id_user);
        st.setInt(2,id_post);
        ResultSet r1=st.executeQuery();
        if(r1.next()){
           likeExists = true;
        }
    }catch (Exception e) {
        System.out.println("SQL Exception: "+ e.toString());
    }
    return likeExists;
}


   
   


}


