
package ArtHub.services;
import ArtHub.entities.Evenement;
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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String req ="INSERT INTO evenement ( id_org,date,nom_event,type_event,categorie,description,capacite_event,nb_max)"+"values (?,?,?,?,?,?,?,?)";
        try {
           
            Date Date_event = Date.valueOf(p.getDate_event());
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_org().getId_user());
            ste.setDate(2,Date_event);
            ste.setString(3, p.getNom_event());
            ste.setString(4, p.getType_event());
            ste.setInt(5, p.getCategorie());
            ste.setString(6, p.getDescription());
            ste.setInt(7, p.getCapacite_event());
            ste.setInt(8,p.getCapacite_event());
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

               
                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                
                Evenement p = new Evenement(id_user, date, nom_event,type_event,categorie,description,capacite_event,nb_max);
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
    
    public List<Evenement> MostPopularEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement order by nb_max-capacite_event desc");
            while (rs.next()) {

               
                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                Evenement p = new Evenement(id_user, date, nom_event,type_event,categorie,description,capacite_event,nb_max);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    
     public List<Evenement> ThisWeekEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE DATEDIFF(date,NOW()) <= 7");
            while (rs.next()) {

               
                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                
                Evenement p = new Evenement(id_user, date, nom_event,type_event,categorie,description,capacite_event,nb_max);
                p.setId(rs.getInt("id"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
     
    public List<Evenement> ThisWeekEvenementFiltered(String toCompare) { 

        List<Evenement> myList = new ArrayList<>();
        try {
           Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%"+toCompare+"%'";
             sql += " INTERSECT SELECT * from evenement"+ " WHERE DATEDIFF(date,NOW()) <= 7";
             sql += " UNION SELECT * from evenement"+ " WHERE categorie LIKE '%"+toCompare+"%'";
             sql += " UNION SELECT * from evenement"+ " WHERE date LIKE '%"+toCompare+"%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                
                Evenement p = new Evenement(id_user, date, nom_event,type_event,categorie,description,capacite_event,nb_max);
                p.setId(rs.getInt("id"));
                myList.add(p);
                for (int i=0 ; i < myList.size() ; i++)
                {
                System.out.println(myList.get(i));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return myList;

    }
 public List<Evenement> MostPopularFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%"+toCompare+"%'";
            sql += " UNION SELECT * from evenement"+ " WHERE categorie LIKE '%"+toCompare+"%'";
             sql += " UNION SELECT * from evenement"+ " WHERE date LIKE '%"+toCompare+"%'";
             sql += " order by nb_max-capacite_event desc";
           
            ResultSet rs = stmt.executeQuery(sql);
            

          
            while (rs.next()) {

                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                int categorie = rs.getInt("categorie");
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                
                Evenement p = new Evenement(id_user, date, nom_event,type_event,categorie,description,capacite_event,nb_max);
                p.setId(rs.getInt("id"));
                myList.add(p);
                for (int i=0 ; i < myList.size() ; i++)
                {
                System.out.println(myList.get(i));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return myList;

    }
    

    
}
