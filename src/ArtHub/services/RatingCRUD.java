package ArtHub.services;

import ArtHub.entities.Evenement;
import ArtHub.entities.Rating;
import ArtHub.entities.User;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * wadup
 *
 * @author Fayechi
 */
public class RatingCRUD {

    private Connection cnx;
    private PreparedStatement ste;

    public RatingCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterRating(Rating R) {
        String req = "";
        if (CheckUserExists(R.getId_user().getId_user(), R.getId_event().getId())) {
            try {
                req = "UPDATE rating_event SET rating = ? WHERE id_user = ? AND id_event=?";
                ste = cnx.prepareStatement(req);
                ste.setInt(1, R.getRating());
                ste.setInt(2, R.getId_user().getId_user());
                ste.setInt(3, R.getId_event().getId());
                ste.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            req = "INSERT INTO rating_event (id_user,id_event,rating)" + "values (?,?,?)";
            try {
       
                ste = cnx.prepareStatement(req);
                ste.setInt(1, R.getId_user().getId_user());
                ste.setInt(2, R.getId_event().getId());
                ste.setInt(3, R.getRating());

                ste.executeUpdate();
                System.out.println("Rating ajoutée");

            } catch (SQLException ex) {
                System.out.println("Problémeeee");
                System.out.println(ex.getMessage());

            }
        }
        String requete = "UPDATE evenement SET rating_event = ? WHERE id = ?";
        try {
            int avg=getAvgRating(R.getId_event().getId());
            ste = cnx.prepareStatement(requete);
            ste.setInt(1,avg);
            ste.setInt(2, R.getId_event().getId());

            ste.executeUpdate();
            System.out.println("New Rating::"+avg);
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }
        
        
        

    }
    
     public int getAvgRating(int id_event) throws SQLException {
        int avg = 0;
        String requete = "SELECT AVG(rating) AS nb FROM rating_event Where id_event= ?";
        PreparedStatement st = cnx.prepareStatement(requete);
        st.setInt(1, id_event);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            avg = rs.getInt("nb");
        }

        System.out.println(avg);
        return avg;
    }

    public List<Rating> consulterRating() {

        List<Rating> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from rating_event");
            while (rs.next()) {

                Rating R = new Rating();
                User auxU = new User();
                auxU.setId_user((rs.getInt("id_user")));
                R.setId_user(auxU);
                Evenement auxE = new Evenement();
                auxE.setId((rs.getInt("id_event")));
                R.setId_event(auxE);
                R.setId_rating(rs.getInt("id_rating"));
                myList.add(R);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void supprimerRating(Rating R) {
        try {
            String requete = "DELETE FROM rating_event WHERE id_user=? AND id_event=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, R.getId_user().getId_user());
            pst.setInt(2, R.getId_event().getId());
            pst.executeUpdate();
            System.out.println("Rating supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean CheckUserExists(int id_user, int id_event) {

        boolean UserExists = false;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rating_event where id_user = ? AND id_event = ? ");
            st.setInt(1, id_user);
            st.setInt(2, id_event);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                UserExists = true;
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return UserExists;
    }

    public List<User> FindRatings(int id) {

        List<User> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();

            String sql = "SELECT * from rating_event " + " WHERE id_event=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_event") != 0) {
                    UserCRUD aux = new UserCRUD();
                    User R = aux.FindUser(rs.getInt("id_user"));
                    myList.add(R);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
     public Rating FindUserExists(int id_user, int id_event) {

         Rating R = new Rating();
         User U = new User();
         Evenement E = new Evenement();
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rating_event where id_user = ? AND id_event = ? ");
            st.setInt(1, id_user);
            st.setInt(2, id_event);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                 U.setId_user(r1.getInt("id_user"))  ;  
                E.setId(r1.getInt("id_event"))  ;
                R.setId_rating(r1.getInt("id_rating"))  ;    
                R.setId_user(U)  ;
                R.setId_event(E)  ;
                R.setRating(r1.getInt("rating"));
               
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return R;
    }
    

}
