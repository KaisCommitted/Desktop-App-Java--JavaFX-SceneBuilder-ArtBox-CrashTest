package ArtHub.services;

import ArtHub.entities.Evenement;
import ArtHub.entities.Categorie;
import ArtHub.entities.Categorie;
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
 *
 * @author Fayechi
 */
public class CategorieCRUD {

    private Connection cnx;
    private PreparedStatement ste;

    public CategorieCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterCategorie(Categorie C) {
        String req = "INSERT INTO categorie (categorie_name)" + "values (?)";
        try {

            ste = cnx.prepareStatement(req);
           
            ste.setString(1, C.getCategorie_name());

            ste.executeUpdate();
            System.out.println("Categorie ajoutée");

        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());

        }
    }

    public List<Categorie> consulterCategorie() {

        List<Categorie> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from categorie order by categorie_name asc");
            while (rs.next()) {

                Categorie C = new Categorie();
           
               
                C.setCategorie_name(rs.getString("categorie_name"));
                myList.add(C);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void supprimerCategorie(Categorie C) {
        try {
            String requete = "DELETE FROM categorie WHERE categorie_name=? ";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, C.getId());
            
            pst.executeUpdate();
            System.out.println("Categorie supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    

    public List<Categorie> FindCategories(String id) {

        List<Categorie> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();
            
String sql = "SELECT * from categorie " + " WHERE categorie_name=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("id") != "") {
                    CategorieCRUD aux = new CategorieCRUD();
                    Categorie C = aux.FindCategories(rs.getString("id")).get(0);
                    myList.add(C);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

   
    
    
    
       
       

}
