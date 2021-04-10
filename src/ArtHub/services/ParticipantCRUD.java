package ArtHub.services;

import ArtHub.entities.Categorie;
import ArtHub.entities.Evenement;
import ArtHub.entities.Participant;
import ArtHub.entities.User;
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
public class ParticipantCRUD {

    private Connection cnx;
    private PreparedStatement ste;

    public ParticipantCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterParticipant(Participant p) {
        String req = "INSERT INTO participant (id_user,id_event,ticket)" + "values (?,?,?)";
        try {
 String ticket= "" + p.getId_participation()+  p.getId_user().getId_user()+ p.getId_event().getId() ;
 
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_user().getId_user());
            ste.setInt(2, p.getId_event().getId());
            ste.setString(3,ticket); 
          
            ste.executeUpdate();
            System.out.println("Participant ajoutée");

        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());

        }
        String requete = "UPDATE evenement SET capacite_event = capacite_event-1 WHERE id = ?";
        try {
            ste = cnx.prepareStatement(requete);
            ste.setInt(1, p.getId_event().getId());

            ste.executeUpdate();
            System.out.println("Capacité --");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }

    }

    public List<Participant> consulterParticipant() {

        List<Participant> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from participant");
            while (rs.next()) {

                Participant p = new Participant();
                User auxU = new User();
                auxU.setId_user((rs.getInt("id_user")));
                p.setId_user(auxU);
                Evenement auxE = new Evenement();
                auxE.setId((rs.getInt("id_event")));
                p.setId_event(auxE);
                p.setId_participation(rs.getInt("id_participation"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void supprimerParticipant(Participant p) {
        try {
            String requete = "DELETE FROM participant WHERE id_user=? AND id_event=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId_user().getId_user());
            pst.setInt(2, p.getId_event().getId());
            pst.executeUpdate();
            System.out.println("Participant supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean CheckUserExists(int id_user, int id_event) {

        boolean UserExists = false;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from participant where id_user = ? AND id_event = ? ");
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

    
     public Participant FindParticipant(int id_user, int id_event) {

       Participant P = new Participant();
        try {
            PreparedStatement st = cnx.prepareStatement("select * from participant where id_user = ? AND id_event = ? ");
            st.setInt(1, id_user);
            st.setInt(2, id_event);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                P.setTicket(r1.getString("ticket"));
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return P;
    }
    public List<User> FindParticipants(int id) {

        List<User> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();

            String sql = "SELECT * from participant " + " WHERE id_event=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_event") != 0) {
                    UserCRUD aux = new UserCRUD();
                    User p = aux.FindUser(rs.getInt("id_user"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public String RecommendParticip(int id) {
        String AllCats = "";
        String toReturn = "";
        List<Evenement> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();

            String sql = "SELECT * from participant " + " WHERE id_user=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_user") != 0) {
                    EvenementCRUD aux = new EvenementCRUD();
                    Evenement evt = new Evenement();
                    evt = aux.FindEvenement(rs.getInt("id_event"));

                    myList.add(evt);
                    AllCats += evt.getCategorie().getCategorie_name();

                }

            }
            int x = 0;
            List<Categorie> myLst;
            CategorieCRUD CC = new CategorieCRUD();
            myLst = CC.consulterCategorie();
            for (int i = 0; i < myLst.size(); i++) {

                String categorie = "";
                categorie = myLst.get(i).getCategorie_name();

                if (count(AllCats, categorie) > x) {

                    x = count(AllCats, categorie);
                    toReturn = myLst.get(i).getCategorie_name();

                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return toReturn;

    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

}
