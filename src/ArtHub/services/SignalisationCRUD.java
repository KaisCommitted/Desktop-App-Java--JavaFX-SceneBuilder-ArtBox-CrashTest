
package ArtHub.services;
import ArtHub.entities.Signalisation;
import ArtHub.tools.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SignalisationCRUD {
    private final Connection cnx;
    private PreparedStatement ste;

    public SignalisationCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterSignalisation(Signalisation s){
        String req ="INSERT INTO signalisation ( id_signal,id_user,id_post,contenu_signal,type_signal,etat_signal,date_signal)"+"values (?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, s.getId_signal());
            ste.setInt(2, s.getId_user().getId_user());
            ste.setInt(3, s.getId_post().getId_post());
            ste.setString(4, s.getContenu_signal());
            ste.setString(5, s.getType_signal());
            ste.setString(6, s.getEtat_signal());
            ste.setDate(7, s.getDate_signal());

            ste.executeUpdate();
            System.out.println("Signalisation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Problème");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
      public List<Signalisation> consulterSignalisation() {

        List<Signalisation> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from signalisation");
            while (rs.next()) {

               
                int id_signal = rs.getInt("id_signal");
                int id_user = rs.getInt("id_user");
                int id_post = rs.getInt("id_post");
                String contenu_signal = rs.getString("contenu_signal");
                String type_signal = rs.getString("type_signal");
                String etat_signal = rs.getString("etat_signal");
                Date date_signal = rs.getDate("date_signal");
                
                
                
              //  Signalisation s = new Signalisation(id_signal,id_user,id_post, contenu_signal, type_signal,etat_signal,date_signal);
              //  s.setId_signal(rs.getInt("id_signal"));
               // myList.add(s);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    public void supprimerSignalisation(Signalisation s) {
         try {
            String requete = "DELETE FROM signalisation WHERE id_signal=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, s.getId_signal());
            pst.executeUpdate();
            System.out.println("Signalisation supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifierSignalisation(int id, String object, Object obj) {
        try {
            String requete = "UPDATE signalisation SET ? = ? WHERE id_signal = ?";
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
            System.out.println("Signalisation modifié avec succées");

//            Notifications notifs = Notifications.create()
//                            .title("Produit ajouté")
//                            .text("Le produit a été ajouter avec succées!")
//                            .graphic(new ImageView("file:C:/Signalisations/samia/Documents/NetBeansProjects/PIDEV/Images/Tick.png"))
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
