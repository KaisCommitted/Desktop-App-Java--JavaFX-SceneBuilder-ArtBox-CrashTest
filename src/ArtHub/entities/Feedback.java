
package ArtHub.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.sql.Date;




public class Feedback extends RecursiveTreeObject<Evenement> implements Serializable {
    private int id_feedback;
    private String contenu_feedback;
    private String type_feedback;
    private String etat_feedback;
    private Date date_feedback;
     
    public Feedback() {
    }

    public Feedback(int id_feedback, String contenu_feedback, String type_feedback, String etat_feedback, Date date_feedback) {
        this.id_feedback = id_feedback;
        this.contenu_feedback =contenu_feedback;
        this.type_feedback = type_feedback;
        this.etat_feedback = etat_feedback;
        this.date_feedback = date_feedback;
    }

    public Feedback(String contenu_feedback, String type_feedback) {
        this.contenu_feedback = contenu_feedback;
        this.type_feedback = type_feedback;
        this.etat_feedback = "non traité";
    }

   
    

    public int getId_feedback() {
        return id_feedback;
    }

    public String getContenu_feedback() {
        return contenu_feedback;
    }

    public String getType_feedback() {
        return type_feedback;
    }

    public String getEtat_feedback() {
        return etat_feedback;
    }

    public Date getDate_feedback() {
        return date_feedback;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public void setContenu_feedback(String contenu_feedback) {
        this.contenu_feedback = contenu_feedback;
    }

    public void setType_feedback(String type_feedback) {
        this.type_feedback = type_feedback;
    }

    public void setEtat_feedback(String etat_feedback) {
        this.etat_feedback = etat_feedback;
    }

    public void setDate_feedback(Date date_feedback) {
        this.date_feedback = date_feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id_feedback=" + id_feedback + ", contenu_feedback=" + contenu_feedback + ", type_feedback=" + type_feedback + ", etat_feedback=" + etat_feedback + ", date_feedback=" + date_feedback + '}';
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

  
    
    
}
