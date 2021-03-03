
package ArtHub.services;
import ArtHub.entities.Evenement;
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
public class EvenementCRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public EvenementCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterEvenement(Evenement p){
        String req ="INSERT INTO evenement ( id_org,date,nom_event,type_event,categorie,description)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_org());
            ste.setString(2, p.getDate_event());
            ste.setString(3, p.getNom_event());
            ste.setInt(4, p.getType_event());
            ste.setInt(5, p.getCategorie());
            ste.setString(6, p.getDescription());
            ste.executeUpdate();
            System.out.println("Evenement ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Evenement> consulterEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement");
            while (rs.next()) {

               
                int id_org = rs.getInt("id_org");
                String date = rs.getString("date");
                String nom_event = rs.getString("nom_event");
                int type_event = rs.getInt("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                
                Evenement p = new Evenement(id_org, date, nom_event,type_event,categorie,description);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     public void supprimerEvenement(Evenement p) {
         try {
            String requete = "DELETE FROM evenement WHERE id=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Evenement supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierEvenement(int id, String object, Object obj) {
        try {
            String requete = "UPDATE evenement SET ? = ? WHERE id = ?";
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
            System.out.println("Evenement modifié avec succées");

//            Notifications notifs = Notifications.create()
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/evenements/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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
