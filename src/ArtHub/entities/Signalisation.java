
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.sql.Date;




public class Signalisation extends RecursiveTreeObject<Signalisation> implements Serializable {
    private int id_signal;
    private User id_user;
    private Post id_post;
    private String contenu_signal;
    private String type_signal;
    private String etat_signal;
    private Date date_signal;

    public Signalisation(String contenu_signal, String type_signal) {
        this.contenu_signal = contenu_signal;
        this.type_signal = type_signal;
        this.etat_signal="non traité";
    }
     
    

    public Signalisation(int id_signal, User id_user,Post id_post, String contenu_signal, String type_signal, String etat_signal, Date date_signal) {
        this.id_signal = id_signal;
        this.id_user = id_user;
        this.id_post = id_post;
        this.contenu_signal =contenu_signal;
        this.type_signal = type_signal;
        this.etat_signal = etat_signal;
        this.date_signal = date_signal;
    }

  


    public int getId_signal() {
        return id_signal;
    }
    
    public User getId_user() {
        return id_user;
    }
    
    public Post getId_post() {
        return id_post;
    }

    public String getContenu_signal() {
        return contenu_signal;
    }

    public String getType_signal() {
        return type_signal;
    }

    public String getEtat_signal() {
        return etat_signal;
    }

    public Date getDate_signal() {
        return date_signal;
    }

    public void setId_signal(int id_signal) {
        this.id_signal = id_signal;
    }
    
    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public void setId_post(Post id_post) {
        this.id_post = id_post;
    }

    public void setContenu_signal(String contenu_signal) {
        this.contenu_signal = contenu_signal;
    }

    public void setType_signal(String type_signal) {
        this.type_signal = type_signal;
    }

    public void setEtat_signal(String etat_signal) {
        this.etat_signal = etat_signal;
    }

    public void setDate_signal(Date date_signal) {
        this.date_signal = date_signal;
    }

    @Override
    public String toString() {
        return "Signalement{" + "id_signal=" + id_signal + ", id_user=" + id_user +", id_post=" + id_post + ", type_signal=" + type_signal + ", contenu_signal=" + contenu_signal + ", etat_signal" + etat_signal + ", date_signal" + date_signal +'}';
    }

    

  

  
    
    
}


