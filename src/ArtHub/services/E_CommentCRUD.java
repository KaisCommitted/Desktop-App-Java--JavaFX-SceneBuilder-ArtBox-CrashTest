package ArtHub.services;

import ArtHub.entities.Evenement;
import ArtHub.entities.E_Comment;
import ArtHub.entities.User;
import ArtHub.tools.MyConnection;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * wadup
 *
 * @author Fayechi
 */
public class E_CommentCRUD extends RecursiveTreeObject<E_CommentCRUD> implements Serializable{

    private Connection cnx;
    private PreparedStatement ste;

    public E_CommentCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterE_Comment(E_Comment C) {
        String req = "";

        req = "INSERT INTO comment_event (id_user,id_event,content)" + "values (?,?,?)";
        try {

            ste = cnx.prepareStatement(req);
            ste.setInt(1, C.getId_user().getId_user());
            ste.setInt(2, C.getId_event().getId());
            ste.setString(3, C.getContent());

            ste.executeUpdate();
            System.out.println("E_Comment ajoutée");

        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());

        }

    }
    
    public void UpdateContent(int id,String obj) {
        String req = "";

        req = "UPDATE comment_event SET content = ? WHERE id=?" ;
        try {

            ste = cnx.prepareStatement(req);
             
            ste.setString(2, obj);
            ste.setInt(1, id);
            
            
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("Comment updated");

            ste.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());

        }

    }
    
     public void UpdateE_Comment(int id,String object, Object obj) {
        String req = "";

        req = "UPDATE comment_event SET ? = ? WHERE id=?" ;
        try {

            ste = cnx.prepareStatement(req);
             ste.setString(1, object);
            ste.setObject(2, obj);
            ste.setInt(3, id);
            
            String ch = ste.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3 = ch2.substring(pos, ch2.length());
            System.out.println(ch3);
            ste = cnx.prepareStatement(ch3);
            ste.executeUpdate();
            System.out.println("Comment updated");

            ste.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Problémeeee");
            System.out.println(ex.getMessage());

        }

    }

    public List<E_Comment> consulterE_Comment() {

        List<E_Comment> myList = new ArrayList<>();
        try {

            Statement ste = cnx.createStatement();

            ResultSet rs = ste.executeQuery("SELECT * from comment_event");
            while (rs.next()) {

                E_Comment C = new E_Comment();
                C = FindUserExists(rs.getInt("id_user"), rs.getInt("id_event"));
                myList.add(C);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void DeleteE_Comment(E_Comment C) {
        try {
            String requete = "DELETE FROM comment_event WHERE id=?";

            PreparedStatement ste = cnx.prepareStatement(requete);
            ste.setInt(1, C.getId());
            
            ste.executeUpdate();
            System.out.println("E_Comment supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Checks if user commented a specific events
    public boolean CheckUserExists(int id_user, int id_event) {

        boolean UserExists = false;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from comment_event where id_user = ? AND id_event = ? ");
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

    //Returns Users that commented a specific event
    public List<User> FindE_Comments(int id) {

        List<User> myList = new ArrayList<>();
        try {

            Statement stmt = cnx.createStatement();

            String sql = "SELECT * from comment_event " + " WHERE id_event=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (rs.getInt("id_event") != 0) {
                    UserCRUD aux = new UserCRUD();
                    User C = aux.FindUser(rs.getInt("id_user"));
                    myList.add(C);
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

    public E_Comment FindUserExists(int id_user, int id_event) {

        E_Comment C = new E_Comment();
        User U = new User();
        Evenement E = new Evenement();
        try {
            PreparedStatement st = cnx.prepareStatement("select * from comment_event where id_user = ? AND id_event = ? ");
            st.setInt(1, id_user);
            st.setInt(2, id_event);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                U.setId_user(r1.getInt("id_user"));
                E.setId(r1.getInt("id_event"));
                C.setId(r1.getInt("id"));
                C.setId_user(U);
                C.setId_event(E);
                C.setContent(r1.getString("content"));
                Date D = r1.getDate("commentDate");
                LocalDate date = D.toLocalDate();
                C.setCommentDate(date);

            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return C;
    }
    
    public E_Comment FindUserExistsByID(int id) {

        E_Comment C = new E_Comment();
        User U = new User();
        Evenement E = new Evenement();
        try {
            PreparedStatement st = cnx.prepareStatement("select * from comment_event where id=? ");
            st.setInt(1, id);
          
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                U.setId_user(r1.getInt("id_user"));
                E.setId(r1.getInt("id_event"));
                C.setId(r1.getInt("id"));
                C.setId_user(U);
                C.setId_event(E);
                C.setContent(r1.getString("content"));
                Date D = r1.getDate("commentDate");
                LocalDate date = D.toLocalDate();
                C.setCommentDate(date);

            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return C;
    }
    

    public List<E_Comment> FindComments(int id) {
       
       
        List<E_Comment> myList = new ArrayList<>();
         
        try {

            Statement stmt = cnx.createStatement();

            String sql = "SELECT * from comment_event " + " WHERE id_event=" + id + " order by commentDate";
            ResultSet rs = stmt.executeQuery(sql);
             int i = 0;
            while (rs.next()) {

                if (rs.getInt("id_event") != 0) {
 E_Comment C = new E_Comment();
  User U = new User();
        Evenement E = new Evenement();
                    U.setId_user(rs.getInt("id_user"));
                    E.setId(rs.getInt("id_event"));
                    C.setId(rs.getInt("id"));
                    C.setId_user(U);
                    C.setId_event(E);
                    C.setContent(rs.getString("content"));
                    Date D = rs.getDate("commentDate");
                    LocalDate date = D.toLocalDate();
                    C.setCommentDate(date);
                  
                    System.out.println(C.getId_user());
                    myList.add(C);

                   
                }
             
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

       
       
       
 return myList;
    }

}