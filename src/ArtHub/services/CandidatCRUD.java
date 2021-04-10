
package ArtHub.services;
import ArtHub.entities.Candidat;
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
public class CandidatCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public CandidatCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterCandidat(Candidat p){
        String req ="INSERT INTO candidat (id_user,id_ann,cv)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_user());
            ste.setInt(2, p.getId_ann());
            ste.setString(3, p.getCv());
            ste.executeUpdate();
            System.out.println("Candidat ajouté.");
            
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Candidat> consulterCandidat() {

        List<Candidat> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from candidat");
            while (rs.next()) {

                int id_user = rs.getInt("id_user");
                int id_ann = rs.getInt("id_ann");
                String cv = rs.getString("cv");
                Candidat p = new Candidat(id_user,id_ann,cv);
                p.setId_cand(rs.getInt("id_cand"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     public void supprimerCandidat(Candidat p) {
         try {
            String requete = "DELETE FROM candidat WHERE id_cand=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_cand());
            pst.executeUpdate();
            System.out.println("Candidat supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierCandidat(int id, String object, Object obj) {
        try {
            String requete = "UPDATE candidat SET ? = ? WHERE id_cand = ?";
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
            System.out.println("Candidat modifié avec succés");

//            Notifications notifs = Notifications.create()
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/candidats/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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
