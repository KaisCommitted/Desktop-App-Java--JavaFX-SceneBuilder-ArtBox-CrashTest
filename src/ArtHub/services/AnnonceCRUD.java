
package ArtHub.services;
import ArtHub.entities.Annonce;
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
 * wadup
 * @author Fayechi
 */
public class AnnonceCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public AnnonceCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterAnnonce(Annonce p){
        String req ="INSERT INTO annonce (id_user,titre_ann,desc_ann,pay,categorie,ddl_ann)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_user());
            ste.setString(2, p.getTitre_ann());
            ste.setString(3, p.getDesc_ann());
            ste.setInt(4, p.getPay());
            ste.setString(5, p.getCategorie());
            ste.setDate(6, p.getDdl_ann());
            ste.executeUpdate();
            System.out.println("Annonce ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Annonce> consulterAnnonce() {

        List<Annonce> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from annonce");
            while (rs.next()) {

                int id_user = rs.getInt("id_user");
                String titre_ann = rs.getString("titre_ann");
                String desc_ann = rs.getString("desc_ann");
                int pay = rs.getInt("pay");
                String categorie = rs.getString("categorie");
                Date ddl_ann = rs.getDate("ddl_ann");
                
                Annonce p = new Annonce(id_user,titre_ann, desc_ann, pay,categorie,ddl_ann);
                p.setId_ann(rs.getInt("id_ann"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     public void supprimerAnnonce(Annonce p) {
         try {
            String requete = "DELETE FROM annonce WHERE id_ann=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_ann());
            pst.executeUpdate();
            System.out.println("Annonce supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierAnnonce(int id, String object, Object obj) {
        try {
            String requete = "UPDATE annonce SET ? = ? WHERE id_ann = ?";
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
            System.out.println("Annonce modifié avec succées");

//            Notifications notifs = Notifications.create()
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/annonces/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
//                            .hideAfter(Duration.seconds(5))
//                            .position(Pos.BOTTOM_RIGHT);
//
//                    notifs.darkStyle();
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            notifs.show();
//                        }
//                    });


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
