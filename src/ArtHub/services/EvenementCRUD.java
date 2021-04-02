package ArtHub.services;

import ArtHub.entities.Categorie;
import ArtHub.entities.Evenement;
import ArtHub.entities.User;
import ArtHub.gui.ADD_EventController;
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
import static ArtHub.gui.LoginController.CurrentUser;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * wadup
 *
 * @author Fayechi
 */
public class EvenementCRUD {

    private Connection cnx;
    private PreparedStatement ste;

    public EvenementCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterEvenement(Evenement p) {
        String req = "INSERT INTO evenement ( id_org,date,nom_event,type_event,categorie,description,capacite_event,nb_max,image_event,location_event)" + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            String path = ADD_EventController.path;
            Date Date_event = Date.valueOf(p.getDate_event());
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_org().getId_user());
            ste.setDate(2, Date_event);
            ste.setString(3, p.getNom_event());
            ste.setString(4, p.getType_event());
            ste.setString(5, p.getCategorie().getCategorie_name());
            ste.setString(6, p.getDescription());
            ste.setInt(7, p.getCapacite_event());
            ste.setInt(8, p.getCapacite_event());
            ste.setString(9, path);
            ste.setString(10, p.getLocation_event());
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
                
                     
                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {
                  Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                    
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 System.out.println(myList.size());
        return myList;

    }

    public Evenement FindEvenement(int id) {

        Evenement p = new Evenement();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE id=" + id + "");

            while (rs.next()) {
                 Categorie categorie = new Categorie();
                 categorie.setCategorie_name(rs.getString("categorie"));
                User id_user = new User();
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                String image_event = rs.getString("image_event");
                String location_event = rs.getString("location_event");
                int rating = rs.getInt("rating_event");
                p.setId(id);
                p.setId_org(id_user);
                p.setDate_event(date);
                p.setCategorie(categorie);
                p.setCapacite_event(capacite_event);
                p.setDescription(description);
                p.setImage_event(image_event);
                p.setNb_max(nb_max);
                p.setNom_event(nom_event);
                p.setType_event(type_event);
                p.setLocation_event(location_event);
                p.setRating(rating);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return p;

    }
  public Evenement FindEvenementByName(String name) {

        Evenement p = new Evenement();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE nom_event='" + name + "'");

            while (rs.next()) {
                 Categorie categorie = new Categorie();
                 categorie.setCategorie_name(rs.getString("categorie"));
                User id_user = new User();
                int id = rs.getInt("id");
                id_user.setId_user(rs.getInt("id_org"));
                Date dateaux = rs.getDate("date");
                LocalDate date = dateaux.toLocalDate();
                String nom_event = rs.getString("nom_event");
                String type_event = rs.getString("type_event");
                
                String description = rs.getString("description");
                int capacite_event = rs.getInt("capacite_event");
                int nb_max = rs.getInt("nb_max");
                String image_event = rs.getString("image_event");
                String location_event = rs.getString("location_event");
                p.setId(id);
                p.setId_org(id_user);
                p.setDate_event(date);
                p.setCategorie(categorie);
                p.setCapacite_event(capacite_event);
                p.setDescription(description);
                p.setImage_event(image_event);
                p.setNb_max(nb_max);
                p.setNom_event(nom_event);
                p.setType_event(type_event);
                p.setLocation_event(location_event);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;

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
//                            .graphic(new ImageView("file:categorie:/evenements/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }

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

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
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
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            sql += " INTERSECT SELECT * from evenement" + " WHERE DATEDIFF(date,NOW()) = 7";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    if (p.getDate_event().compareTo(LocalDate.now().plusDays(8))<0) { myList.add(p);}
                   
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 System.out.println("WEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEK");
        return myList;

    }

    public List<Evenement> MostPopularFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            sql += " order by nb_max-capacite_event desc";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

               if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> MostRecentEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement order by DATEDIFF(date,NOW()) asc");
            while (rs.next()) {
if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> MostRecentFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            sql += " order by DATEDIFF(date,NOW()) asc";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> AlphabeticalEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement order by nom_event asc");
            while (rs.next()) {

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> AlphabeticalFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            sql += " order by nom_event asc";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> ThisMonthEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE DATEDIFF(date,NOW()) <= 30");
            while (rs.next()) {

                if (rs.getInt("id") != 0  ) {
                     
                    Evenement p = FindEvenement(rs.getInt("id"));
                    System.out.println("LOCAAAL DATE "+LocalDate.now());
                    System.out.println("EVENT DAATE "+p.getDate_event());
                    if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {
                    myList.add(p); }
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public List<Evenement> ThisMonthEvenementFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            sql += " INTERSECT SELECT * from evenement" + " WHERE DATEDIFF(date,NOW()) <= 30";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {
                    

                    Evenement p = FindEvenement(rs.getInt("id"));
                     if (p.getDate_event().compareTo(LocalDate.now().plusMonths(1))<0) { myList.add(p);}
                   
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

     public List<Evenement> TodayEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE DATEDIFF(date,NOW()) = 0");
            while (rs.next()) {

                if (rs.getInt("id") != 0  ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return myList;

    }

    public List<Evenement> TodayEvenementFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            
            sql += " INTERSECT SELECT * from evenement" + " WHERE DATEDIFF(date,NOW()) = 0";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id") != 0 ) {
                          
                    Evenement p = FindEvenement(rs.getInt("id"));
                    if (p.getDate_event().isEqual(LocalDate.now())) { myList.add(p);}
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }

    public List<Evenement> consulterFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

               if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        

        return myList;

    }

    public List<Evenement> WentTo(int id) {

  List<Evenement> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from participant " + " WHERE id_user=" + id;

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_event") != 0 && FindEvenement(rs.getInt("id_event")).getDate_event().isBefore(LocalDate.now()) ) {
                   
                    Evenement p = FindEvenement(rs.getInt("id_event"));
                     System.out.println("EVENT "+ p);
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

   




public List<Evenement> GoingTo(int id) {

        List<Evenement> myList = new ArrayList<>();
        try {

             Statement stmt = cnx.createStatement();
            String sql = "SELECT * from participant " + " WHERE id_user=" + id;

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_event") != 0 && FindEvenement(rs.getInt("id_event")).getDate_event().isAfter(LocalDate.now()) ) {
                   
                    Evenement p = FindEvenement(rs.getInt("id_event"));
                     System.out.println("EVENT "+ p);
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

        

    }

 public List<Evenement> RecommendEvenement(String cat) {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();
                ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE categorie='"+cat+"'");
                
              
            
                while (rs.next()) {
                  
                if (rs.getInt("id") != 0 && FindEvenement(rs.getInt("id")).getDate_event().isAfter(LocalDate.now()) ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                     System.out.println("Recom event");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
 
  public List<Evenement> ArchiveEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE DATEDIFF(date,NOW()) < 0");
            while (rs.next()) {

                if (rs.getInt("id") != 0  ) {
                   
                    
                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
  
   public List<Evenement> AllEvenement() {

        List<Evenement> myList = new ArrayList<>();
        try {
             
            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement");
            while (rs.next()) {
                
                     
                if (rs.getInt("id") != 0  ) {
                  Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                    
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 System.out.println(myList.size());
        return myList;

    }

 public List<Evenement> AllFiltered(String toCompare) {

        List<Evenement> myList = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * from evenement" + " WHERE nom_event LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE categorie LIKE '%" + toCompare + "%'";
            sql += " UNION SELECT * from evenement" + " WHERE date LIKE '%" + toCompare + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

               if (rs.getInt("id") != 0  ) {

                    Evenement p = FindEvenement(rs.getInt("id"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        

        return myList;

    }
  
     public boolean CheckEvenementByName(String name) {

        boolean p = false;
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from evenement WHERE nom_event='" + name + "'");

            while (rs.next()) {
                 p=true;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;

    }

}
